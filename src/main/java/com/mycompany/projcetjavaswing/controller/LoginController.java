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
import com.mycompany.projcetjavaswing.view.UserViewHome;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class LoginController {

    private UserViewHome view = new UserViewHome();
    private LoginView loginView = new LoginView();
    private HomeView homeView = new HomeView();

    List<User> userList = new ArrayList<>();
    UserRepository userRepositoty = new UserRepository();

    public LoginController(LoginView view) {
        this.loginView = view;
        this.loginView.setVisible(true);
        event();
    }

    public void event() {
        handleLogin();
    }

    public void handleLogin() {
        this.loginView.getBtnLogin().addActionListener((e) -> {
            String username = loginView.getUsername().getText();
            String password = new String(loginView.getPassword().getPassword());
            if (username == null || username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản");
                return;
            }

            if (password == null || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
                return;
            }

            User user = userRepositoty.findUserByUsername(username);

            if (user == null) {
                JOptionPane.showMessageDialog(null, "Tài khoản chưa chính xác");
                return;
            }
            
             if (user.getUsername().equals(username) && !user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu chưa chính xác");
                return;
            } 

            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (user.getRole().equals("ROLE_ADMIN")) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");

                    this.loginView.dispose();
                    HomeController homeController = new HomeController(new HomeView());
                    return;
                }

                if (user.getRole().equals("ROLE_USER")) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                    this.loginView.dispose();
                    new UserHomeController(view);
                    return;
                }
            }

           
        });
    }

}
