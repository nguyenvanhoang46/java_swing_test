/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.User;
import com.mycompany.projcetjavaswing.repository.UserRepository;
import com.mycompany.projcetjavaswing.view.UserPanel;
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
public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        UserPanel userPanelTest = new UserPanel();
        userPanelTest.getUsername().setText("username");
        userPanelTest.getPassword().setText("123123");
        userPanelTest.getEmail().setText("email.com");
        userPanelTest.getRole().setToolTipText("user");
        UserController userController = new UserController(userPanelTest);
        userController.insert();
//        userPanelTest.getBtnSave().doClick();
        List<User> result = UserRepository.searchName("username");
        
        boolean expResult = false;
        
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).getUsername().equals("username")){
                expResult = true;
            }
        }
        assertTrue(expResult);
    }



    @Test
    public void testReset() {
        UserPanel userPanelTest = new UserPanel();
        userPanelTest.getUsername().setText("username");
        userPanelTest.getPassword().setText("123123");
        userPanelTest.getEmail().setText("email.com");
        userPanelTest.getRole().setToolTipText("user");
        
        
        UserController userController = new UserController(userPanelTest);
        userController.reset();
        userPanelTest.getBtnReset().doClick();
        
        assertEquals(userPanelTest.getUsername().getText(), "");
    }
    
}
