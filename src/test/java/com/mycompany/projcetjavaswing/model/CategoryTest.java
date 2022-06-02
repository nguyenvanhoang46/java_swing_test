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
public class CategoryTest {
    
    public CategoryTest() {
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
     * Test of getId method, of class Category.
     */
    @Test
    public void testGetId() {
        Category instance = new Category();
        instance.setId(1);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Category.
     */
    @Test
    public void testSetId() {
        int id = 0;
        Category instance = new Category();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getName method, of class Category.
     */
    @Test
    public void testGetName() {
        Category instance = new Category();
        instance.setName("namecategory");
        String expResult = "namecategory";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Category.
     */
    @Test
    public void testSetName() {
        String name = "namecategory";
        Category instance = new Category();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of toString method, of class Category.
     */
  
    
}
