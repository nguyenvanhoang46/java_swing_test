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
        this.userTest.setEmail("nguyenvanhoang@gmail.com");
        this.userTest.setPassword("123123123");
        this.userTest.setRole("role");
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testInsert() {
        User newUser = UserRepository.insertReturn(userTest);
        assertEquals(this.userTest.getUsername(), newUser.getUsername());
    }

    @Test
    public void testUpdate() {
        User newUser = UserRepository.insertReturn(userTest);
        
        User updateUser = this.userTest;
        updateUser.setUsername("Update 2");
        
        updateUser = UserRepository.updateReturn((int) newUser.getId(), updateUser);
        
        assertEquals("update 2", updateUser.getUsername());

        
    }

    @Test
    public void testDelete() {
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
