/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Category;
import com.mycompany.projcetjavaswing.model.Product;
import com.mycompany.projcetjavaswing.repository.CategoryRepository;
import com.mycompany.projcetjavaswing.repository.ProductRepository;
import com.mycompany.projcetjavaswing.view.CategoryPanel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CategoryController {

    DefaultTableModel tabbleModel;
    private CategoryPanel view;
    List<Category> categoryList = new ArrayList<>();

    public CategoryController(CategoryPanel view) {
        this.view = view;
        this.view.setVisible(true);
        setUpListener();

    }

    public CategoryPanel index() {
        return this.view;
    }

    public void setUpListener() {
        showCategory();
        insert();
        search();
        delete();
        update();
        tblStaff();
    }

    private void showCategory() {
        categoryList = CategoryRepository.findAll();
        tabbleModel = (DefaultTableModel) this.view.getTableCategory().getModel();
        tabbleModel.setRowCount(0);

        categoryList.forEach(c -> {
            tabbleModel.addRow(new Object[]{
                c.getId(),
                c.getName()
            });
        });
    }

    public void insert() {
        this.view.getBtnSave().addActionListener((ActionEvent e) -> {

            String name = view.getNameCategory().getText();

            Category categr = new Category(name);
            CategoryRepository.insert(categr);
            showCategory();
        });
    }

    public void delete() {
        this.view.getBtnDelete().addActionListener((ActionEvent e) -> {
            categoryList = CategoryRepository.findAll();
            int index = view.getTableCategory().getSelectedRow();

            if (index >= 0) {
                Category categr = categoryList.get(index);
                int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa mục này");
                if (option == JOptionPane.YES_OPTION) {
                    CategoryRepository.delete(categr.getId());
                    showCategory();
                }
            }
        });
    }

    private void search() {
        this.view.getBtnFind().addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog(this, "Nhập tên đầy đủ để tìm kiếm");
            if (input != null && input.length() > 0) {
                categoryList = CategoryRepository.findCategory(input);
                tabbleModel.setRowCount(0);
                categoryList.forEach(category -> {
                    tabbleModel.addRow(new Object[]{tabbleModel.getRowCount() + 1, category.getName()});
                });
            } else {
                showCategory();
            }

        });
    }

    public void update() {
        this.view.getBtnUpdate().addActionListener((ActionEvent e) -> {
            int index = view.getTableCategory().getSelectedRow();

            if (index >= 0) {
                Category category = categoryList.get(index);
                String name = view.getNameCategory().getText();

                Category newCategory = new Category();
                newCategory.setName(name);

                CategoryRepository.update(category.getId(), newCategory);
//                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                showCategory();
            }
        });
    }
    
    
    public void reset() {
        view.getBtnReset().addActionListener((ActionEvent e) -> {
            view.getNameCategory().setText("");
        });
    }
    

    private void tblStaff() {
        this.view.getTableCategory().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int index = -1;
                index = view.getTableCategory().getSelectedRow();
                Category cate = categoryList.get(index);
                if (index >= 0) {
                    Category category = categoryList.get(index);
                    view.getIdCategory().setText(String.valueOf(category.getId()));
                    view.getNameCategory().setText(cate.getName());
                }

            }

        });
    }

}
