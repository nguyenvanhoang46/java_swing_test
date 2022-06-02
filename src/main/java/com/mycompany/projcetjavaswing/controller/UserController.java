/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.User;
import com.mycompany.projcetjavaswing.repository.UserRepository;
import com.mycompany.projcetjavaswing.view.HomeView;
import com.mycompany.projcetjavaswing.view.LoginView;
import com.mycompany.projcetjavaswing.view.UserPanel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.management.relation.Role;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class UserController {

    DefaultTableModel tableModel;
    private UserPanel view;
    List<User> userList = new ArrayList<>();

    public UserController(UserPanel view) {
        this.view = view;
        this.view.setVisible(true);

        setUpListener();
    }

    public UserPanel index() {
        return this.view;
    }

    public void setUpListener() {
        showUser();
        delete();
        insert();
        tblUser();
    }

    public void user() {
    }

    private void showUser() {
        userList = UserRepository.findAll();
        tableModel = (DefaultTableModel) this.view.getTableUser().getModel();
        tableModel.setRowCount(0);

        userList.forEach(u -> {
            tableModel.addRow(new Object[]{
                u.getId(),
                u.getUsername(),
                u.getEmail(),
                u.getRole(),});
        });
    }

    public void insert() {
        view.getBtnSave().addActionListener((ActionEvent e) -> {
            if (view.getUsername().getText().isEmpty() || view.getPassword().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nhập thông tin không đầy đủ");
            }

            String username = view.getUsername().getText();
            String password = view.getPassword().getText();
            String email = view.getEmail().getText();

            Role role = (Role) view.getRole().getSelectedItem();
            User usr = new User(username, password, email, role);
            UserRepository.insert(usr);
            showUser();
        });
    }

    private void delete() {
        this.view.getBtnDelete().addActionListener((ActionEvent e) -> {
            userList = UserRepository.findAll();
            int index = view.getTableUser().getSelectedRow();
            if (index >= 0) {
                User use = userList.get(index);
                int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa mục này");
                if (option == JOptionPane.YES_OPTION) {
                    UserRepository.delete((int) use.getId());
                    showUser();
                }
            } else {
                System.out.println("x");

            }

        });
    }
    
    public void reset() {
        view.getBtnReset().addActionListener((ActionEvent e) -> {
            view.getUsername().setText("");
            view.getPassword().setText("");
            view.getEmail().setText("");
            view.getRole().setToolTipText("");
        });
    }

    private void tblUser() {
        view.getTableUser().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int index = -1;
                index = view.getTableUser().getSelectedRow();
                User sta = userList.get(index);
                if (index >= 0) {
                    User user = userList.get(index);
                    view.getUsername().setText(user.getUsername());
                    view.getPassword().setText(user.getPassword());
                    view.getEmail().setText(user.getEmail());
                }
            }
        });
    }

}
