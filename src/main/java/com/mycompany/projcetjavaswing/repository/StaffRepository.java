/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.repository;

import com.mycompany.projcetjavaswing.model.Staff;
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
public class StaffRepository {
    static final String URL = "jdbc:mysql://localhost:3306/pizza_manager";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static List<Staff> findAll() {
        List<Staff> userList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "select * from staff";
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
//            System.out.println(resultSet.isBeforeFirst());
            while (rs.next()) {
                Staff staff = new Staff(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getInt("phone"));
//                System.out.println(staff.getEmail() + " - " + staff.getRole());
                userList.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return userList;

    }

    public static void insert(Staff staff) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "insert into staff(name, gender, phone) values(?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getGender());
            statement.setInt(3, staff.getPhone());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

        public static Staff insertReturn(Staff staff) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "insert into staff(name, gender, phone) values(?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getGender());
            statement.setInt(3, staff.getPhone());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieves any auto-generated keys created as a result of executing this Statement object
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    staff.setId(id);
                    return staff;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }
    
    public static void update(int id, Staff stff) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "update staff set name=?, gender=?, phone=? where id = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, stff.getName());
            statement.setString(2, stff.getGender());
            statement.setInt(3, stff.getPhone());

            statement.setInt(4, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
        public static Staff updateReturn(int id, Staff staff) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "update staff set name=?, gender=?, phone=? where id = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getGender());
            statement.setInt(3, staff.getPhone());

            statement.setInt(4, id);
            statement.execute();

            return staff;
        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }
    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //query
            String sql = "delete from staff where id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
        public static Staff findById(int id) {
        Staff staff = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //query 
            String sql = "select * from staff where ID=" + id + "";
            statement = connection.prepareStatement(sql);
            ResultSet rSet = statement.executeQuery();
            while (rSet.next()) {
                staff = new Staff(rSet.getInt("id"), 
                        rSet.getString("name"),
                        rSet.getString("gender"),
                        rSet.getInt("phone")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return staff;

    }
 
    public static List<Staff> searchName(String name) {

        List<Staff> staffList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "select * from staff where name like ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Staff user = new Staff(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getInt("phone"));
                staffList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffRepository.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return staffList;

    }

}
