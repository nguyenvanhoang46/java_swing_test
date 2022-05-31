/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Category;
import com.mycompany.projcetjavaswing.model.Product;
import com.mycompany.projcetjavaswing.repository.CategoryRepository;
import com.mycompany.projcetjavaswing.repository.ProductRepository;
import com.mycompany.projcetjavaswing.view.ProductPanel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class ProductController {

    DefaultTableModel tabbleModel;
    private ProductPanel view;
    List<Product> productList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();

    ArrayList<Product> arr = new ArrayList<>();

    public ProductController(ProductPanel productPanel) {
        this.view = productPanel;
        this.view.setVisible(true);
        setUpListener();
    }

    public ProductPanel index() {
        return this.view;
    }

    public void setUpListener() {
        showProduct();
        insert();
        delete();
        search();
        reset();
        update();
        tblProduct();
        selectImage();
        printExcel();
        showCombo();
    }

    private void showProduct() {
        productList = ProductRepository.findAll();
        tabbleModel = (DefaultTableModel) this.view.getTableProduct().getModel();
        tabbleModel.setRowCount(0);

        productList.forEach(p -> {
            Category category = CategoryRepository.findById(p.getCategory_id());
            tabbleModel.addRow(new Object[]{
                p.getId(),
                p.getNameproduct(),
                category.getName(),
                p.getPrice(),
                p.getQuantity(),
                p.getUnit(),
                p.getImage(),
                categoryFindById(p.getCategory_id()) != null ? categoryFindById(p.getCategory_id()).getName() : ""
            });
        });
    }

    private String selectImage() {
        this.view.getBtnBrowse().addActionListener((ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();

            filename = f.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(f.toString()).getImage().getScaledInstance(230, 155, Image.SCALE_DEFAULT));
//            view.getFileImg().setText(filename);
            view.getLblImage().setIcon(imageIcon);

            File image = new File(filename);
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(image);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            try {
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
            } catch (IOException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
            photo = bos.toByteArray();

        });
        return filename;
    }

    byte[] photo = null;
    String filename = null;

    private void showCombo() {
        categoryList = CategoryRepository.findAll();
        categoryList.forEach(category -> {
            view.getCategoryproduct().addItem(category);
        });
    }

    public void insert() {
        view.getBtnSave().addActionListener((ActionEvent e) -> {
            categoryList = CategoryRepository.findAll();
            if (view.getNameproduct().getText().isEmpty() || view.getPriceproduct().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nhập thông tin không đầy đủ");
                return;
            }
            int index = view.getCategoryproduct().getSelectedIndex();
            Category category = categoryList.get(index);
            int category_id = category.getId();
            String nameproduct = view.getNameproduct().getText();
            int price = Integer.parseInt(view.getPriceproduct().getText());
            int quantity = Integer.parseInt(view.getQuantytiproduct().getText());
            String unit = view.getUnitproduct().getText();
            String image = selectImage();
            Product pt = new Product(nameproduct, category_id, price, quantity, unit, image);
            ProductRepository.insert(pt);
            showProduct();
        });
    }

    public void delete() {
        view.getBtnDelete().addActionListener((ActionEvent e) -> {
            productList = ProductRepository.findAll();
            int index = view.getTableProduct().getSelectedRow();
            if (index >= 0) {
                Product pt = productList.get(index);
                int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa mục này");
                if (option == JOptionPane.YES_OPTION) {
                    ProductRepository.delete(pt.getId());
                    showProduct();
                }
            } else {
                System.out.println("x");
            }
        });
    }

    private void search() {
        view.getBtnFind().addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog(this, "Nhập tên đầy đủ để tìm kiếm");
            if (input != null && input.length() > 0) {
                productList = ProductRepository.searchName(input);
                tabbleModel.setRowCount(0);
                productList.forEach(product -> {
                    tabbleModel.addRow(new Object[]{tabbleModel.getRowCount() + 1, product.getNameproduct(), product.getCategory_id(), product.getPrice(), product.getQuantity(), product.getUnit(), product.getImage()});
                });
            } else {
                showProduct();
            }
        });
    }

    public void update() {
        view.getBtnUpdate().addActionListener((ActionEvent e) -> {
            int index = view.getTableProduct().getSelectedRow();

            if (index >= 0) {
                Product product = productList.get(index);
                String nameproduct = view.getNameproduct().getText();
                Category category = (Category) view.getCategoryproduct().getSelectedItem();
                System.out.println(category);
                System.out.println(category.getName());
                int price = Integer.parseInt(view.getPriceproduct().getText());
                int quantity = Integer.parseInt(view.getQuantytiproduct().getText());
                String unit = view.getUnitproduct().getText();
                String image = view.getBtnBrowse().getText();

                Product newProduct = new Product();
                newProduct.setNameproduct(nameproduct);
                newProduct.setCategory_id(category.getId());
                newProduct.setPrice(price);
                newProduct.setQuantity(quantity);
                newProduct.setUnit(unit);
                newProduct.setImage(image);

                ProductRepository.update(product.getId(), newProduct);
//                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                showProduct();
            }
        });
    }

    private void tblProduct() {
        view.getTableProduct().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int index = -1;
                index = view.getTableProduct().getSelectedRow();
                Product prt = productList.get(index);
                if (index >= 0) {
                    Product product = productList.get(index);
                    view.getNameproduct().setText(product.getNameproduct());
                    view.getPriceproduct().setText(String.valueOf(product.getPrice()));
                    view.getQuantytiproduct().setText(String.valueOf(product.getQuantity()));
                    view.getUnitproduct().setText(product.getUnit());
                    view.getCategoryproduct().getModel().setSelectedItem(categoryFindById(product.getCategory_id()));
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(product.getImage()).getImage().getScaledInstance(230, 155, Image.SCALE_DEFAULT));
                    view.getLblImage().setIcon(imageIcon);
                }
            }
        });
    }

    public Category categoryFindById(int id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public void reset() {
        view.getBtnReset().addActionListener((ActionEvent e) -> {
            view.getNameproduct().setText("");
            view.getPriceproduct().setText("");
            view.getQuantytiproduct().setText("");
            view.getUnitproduct().setText("");
            view.getLblImage().setText("");
        });
    }

    private void printExcel() {
        this.view.getBtnPrint().addActionListener((ActionEvent e) -> {
            arr = (ArrayList<Product>) ProductRepository.findAll();
            try {
                XSSFWorkbook wordkbook = new XSSFWorkbook();
                XSSFSheet sheet = wordkbook.createSheet("List");
                XSSFRow row = null;
                Cell cell = null;
                row = sheet.createRow(3);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("ID");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("NAME");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("CATEGORY_ID");

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("PRICE");

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("QUANTITY");

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("UNIT");

                for (int i = 0; i < arr.size(); i++) {

                    Product product = arr.get(i);
                    row = sheet.createRow(4 + i);

                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(i + 1);

                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getId());

                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(arr.get(i).getNameproduct());

                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(arr.get(i).getCategory_id());

                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue(arr.get(i).getPrice());

                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue(arr.get(i).getQuantity());

                    cell = row.createCell(6, CellType.STRING);
                    cell.setCellValue(arr.get(i).getUnit());

                }

                File f = new File("D://danhsach.xlxs");
                try {
                    FileOutputStream fis = new FileOutputStream(f);
                    wordkbook.write(fis);
                    fis.close();
                } catch (FileNotFoundException ex) {

                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();

                }

            } catch (Exception ex) {

            }

        });
    }

}
