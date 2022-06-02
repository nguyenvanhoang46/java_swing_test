/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.model;

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
public class StaffTest {
    
    public StaffTest() {
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

    /**
     * Test of getId method, of class Staff.
     */
    @Test
    public void testGetId() {
        Staff instance = new Staff();        
        instance.setId(1);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Staff.
     */
    @Test
    public void testSetId() {
        int id = 01;
        Staff instance = new Staff();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getName method, of class Staff.
     */
    @Test
    public void testGetName() {
        Staff instance = new Staff();
        instance.setName("staffname");
        String expResult = "staffname";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Staff.
     */
    @Test
    public void testSetName() {
        String name = "Pizza";
        Staff instance = new Staff();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getGender method, of class Staff.
     */
    @Test
    public void testGetGender() {
        Staff instance = new Staff();
        instance.setGender("nam");
        String expResult = "nam";
        String result = instance.getGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGender method, of class Staff.
     */
    @Test
    public void testSetGender() {
        String gender = "nam";
        Staff instance = new Staff();
        instance.setGender(gender);
        assertEquals(gender, instance.getGender());
    }

    /**
     * Test of getPhone method, of class Staff.
     */
    @Test
    public void testGetPhone() {
        Staff instance = new Staff();
        instance.setPhone(0335123123);
        int expResult = 0335123123;
        int result = instance.getPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhone method, of class Staff.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        int phone = 0;
        Staff instance = new Staff();
        instance.setPhone(phone);
        assertEquals(phone, instance.getPhone());
    }

    /**
     * Test of toString method, of class Staff.
     */
    
}
