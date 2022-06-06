/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.repository;

import com.mycompany.projcetjavaswing.model.User;
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
public class UserRepository {

    static final String URL = "jdbc:mysql://localhost:3306/pizza_manager";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "select * from users";
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
//            System.out.println(resultSet.isBeforeFirst());
            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role"));
                System.out.println(user.getEmail() + " - " + user.getRole());
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return userList;

    }

    public static void insert(User use) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "insert into users(username, password, email, role) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, use.getUsername());
            statement.setString(2, use.getPassword());
            statement.setString(3, use.getEmail());
            statement.setString(4, use.getRole());
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static User insertReturn(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "insert into users(username, password, email, role) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getRole());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieves any auto-generated keys created as a result of executing this Statement object
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setId(id);
                    return user;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }

    public static void update(int id, User us) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "update users set username=?, password=?, email=? role=? where id = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, us.getUsername());
            statement.setString(2, us.getPassword());
            statement.setString(3, us.getEmail());
            statement.setString(4, us.getRole());
            statement.setInt(5, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static User updateReturn(int id, User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "update users set username=?, password=?, email=? role=? where id = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getRole());
            statement.setInt(5, id);
            statement.execute();

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "delete from users where id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<User> searchName(String name) {

        List<User> userList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "select * from users where username like ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return userList;

    }

    public static User findUserByUsername(String name) {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //query
            String sql = "select * from users where username like ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role"));
                userList.add(user);
            }
            if (userList.size() > 0) {
                return userList.get(0);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return null;
    }

    public static User findById(int id) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //query 
            String sql = "select * from users where ID=" + id + "";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role")
                );

                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;

    }

}
