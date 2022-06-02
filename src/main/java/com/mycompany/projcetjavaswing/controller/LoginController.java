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
import java.util.regex.Pattern;
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
            Pattern p = Pattern.compile("^.*[A-Z]+.*$");
            String username = loginView.getUsername().getText();
            String password = new String(loginView.getPassword().getPassword());
            userList = userRepositoty.findAll();
            userList.forEach(u -> {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    if (u.getRole().equals(String.valueOf(User.ROLE.ROLE_ADMIN))) {
//                        System.out.println(u.getRole());
                        // Show View ADMIN
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                        this.loginView.dispose();
                        HomeController homeController = new HomeController(new HomeView());
                      
                    } else if (u.getRole().equals(String.valueOf(User.ROLE.ROLE_USER))) {
                        // Show View User
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                        this.loginView.dispose();
                        new UserHomeController(view);
                    }
                    return;
                }             
                  if (u.getPassword().equals(password)) {
                        JOptionPane.showMessageDialog(null, "Sai tài khoản vui lòng nhập lại");
                       
                 } else if(u.getUsername().equals(username)) {
                     JOptionPane.showMessageDialog(null, "Sai mật khẩu vui lòng nhập lại");
                     
                 } else if(u.getUsername() != (username) && u.getPassword() != (password)) {
                     JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng tên tài khoản và mật khẩu");
                    
                 } 
            });
                                                   


        });
    }

}
