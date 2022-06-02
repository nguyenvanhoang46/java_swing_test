/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.Main;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.projcetjavaswing.controller.CategoryController;
import com.mycompany.projcetjavaswing.controller.ChartController;
import com.mycompany.projcetjavaswing.controller.HomeController;
import com.mycompany.projcetjavaswing.controller.LoginController;
import com.mycompany.projcetjavaswing.controller.ProductController;
import com.mycompany.projcetjavaswing.controller.SellController;
import com.mycompany.projcetjavaswing.controller.StaffController;
import com.mycompany.projcetjavaswing.controller.UserController;
import com.mycompany.projcetjavaswing.controller.UserHomeController;
import com.mycompany.projcetjavaswing.view.HomeView;
import com.mycompany.projcetjavaswing.view.LoginView;
import com.mycompany.projcetjavaswing.view.ProductPanel;
import com.mycompany.projcetjavaswing.view.StaffPanel;
import com.mycompany.projcetjavaswing.view.UserViewHome;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
            

        }
//        HomeController homeController = new HomeController( new HomeView());
//                UserHomeController userhomeController = new UserHomeController( new UserViewHome());

            new LoginController(new LoginView());
//        new ChartController(new ChartView());
//        new SellController(new SellView());
//        new StaffController(new StaffPanel());
//        new StaffController(new StaffView());
//        new ProductController(new ProductPanel());
//        new LoginController(new LoginView());
//        new CustomerController(new CustomerView());
//        new UserController(new UserView());
//        new CategoryController(new CategoryView());
    }

}
