/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.repository;

import com.mycompany.projcetjavaswing.model.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class UserRepositoryTest {
    
    User userTest;
    
    public UserRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.userTest = new User();
        this.userTest.setUsername("username");
        this.userTest.setEmail("email.com");
        this.userTest.setPassword("123123");
        this.userTest.setRole("role");
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testInsertUser() {
        User newUser = UserRepository.insertReturn(userTest);
        assertEquals(this.userTest.getUsername(), newUser.getUsername());
    }

    @Test
    public void testUpdateUser() {
        User newUser = UserRepository.insertReturn(userTest);
        
        User updateUser = this.userTest;
        updateUser.setUsername("Update 2");
        
        updateUser = UserRepository.updateReturn((int) newUser.getId(), updateUser);
        
        assertEquals("Update 2", updateUser.getUsername());

        
    }

    @Test
    public void testDeleteUser() {
        User newUser = UserRepository.insertReturn(userTest);
        
        UserRepository.delete((int) newUser.getId());
        
        User user = UserRepository.findById((int) newUser.getId());
        
        assertNull(user);
    }

    @Test
    public void testSearchName() {
        List<User> list = new ArrayList<>();
        User newUser = UserRepository.insertReturn(userTest);
         list = UserRepository.searchName(newUser.getUsername());
         
         assertEquals(0, list.size());
    }
    
}
