/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.repository;

import com.mycompany.projcetjavaswing.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductRepository {
    
    static final String URL = "jdbc:mysql://localhost:3306/pizza_manager";
    static final String PASSWORD = "";
    static final String USERNAME = "root";
   public static List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
               try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "select * from product";
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
//            System.out.println(resultSet.isBeforeFirst());
            while (rs.next()) {
                    Product product = new Product(rs.getInt("id"),
                        rs.getString("name"), 
                        rs.getInt("category_id"), 
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        rs.getString("unit"),
                        rs.getString("image")
                    );
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return productList;
        
        
    }
   
    public static void insert(Product product) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "insert into product(name,category_id,quantity,price,unit,image) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, product.getNameproduct());
            statement.setInt(2, product.getCategory_id());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getPrice());
            statement.setString(5, product.getUnit());
            statement.setString(6, product.getImage());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   
   
    public static void update(int id, Product pt) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
           
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "update product set name=?, category_id=?, quantity=?, price=?, unit=?, image =?  where id = ?";
            statement = connection.prepareCall(sql);
             statement.setString(1, pt.getNameproduct());
            statement.setInt(2, pt.getCategory_id());
            statement.setInt(3, pt.getQuantity());
            statement.setInt(4, pt.getPrice());
            statement.setString(5, pt.getUnit());
            statement.setString(6, pt.getImage());
            statement.setInt(7, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
           
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "delete from product where id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
           ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
         public static List<Product> searchName(String name) {
        
        
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "select * from product where name like ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+ name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),  
                        rs.getString("name"), 
                        rs.getInt("category_id"), 
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        rs.getString("unit"),
                        rs.getString("image"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return productList;

    }



 
  

   
}
