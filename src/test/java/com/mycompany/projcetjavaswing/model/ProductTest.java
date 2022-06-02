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
public class ProductTest {
    
    public ProductTest() {
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
     * Test of getId method, of class Product.
     */
    @Test
    public void testGetId() {
        Product instance = new Product();
        instance.setId(1);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Product.
     */
    @Test
    public void testSetId() {
        int id = 0;
        Product instance = new Product();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getNameproduct method, of class Product.
     */
    @Test
    public void testGetNameproduct() {
        Product instance = new Product();
        instance.setNameproduct("nameproduct");
        String expResult = "nameproduct";
        String result = instance.getNameproduct();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNameproduct method, of class Product.
     */
    @Test
    public void testSetNameproduct() {
        String nameproduct = "nameproduct";
        Product instance = new Product();
        instance.setNameproduct(nameproduct);
        assertEquals(nameproduct, instance.getNameproduct());
    }

    /**
     * Test of getCategory_id method, of class Product.
     */
    @Test
    public void testGetCategory_id() {
        Product instance = new Product();
        instance.setCategory_id(2);
        int expResult = 2;
        int result = instance.getCategory_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategory_id method, of class Product.
     */
    @Test
    public void testSetCategory_id() {
        int category_id = 0;
        Product instance = new Product();
        instance.setCategory_id(category_id);
        assertEquals(category_id, instance.getCategory_id());
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice() {
        Product instance = new Product();
        instance.setPrice(30000);
        int expResult = 30000;
        int result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 0;
        Product instance = new Product();
        instance.setPrice(price);
        assertEquals(price, instance.getPrice());
    }

    /**
     * Test of getQuantity method, of class Product.
     */
    @Test
    public void testGetQuantity() {
        Product instance = new Product();
        instance.setQuantity(100);
        int expResult = 100;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantity method, of class Product.
     */
    @Test
    public void testSetQuantity() {
        int quantity = 50;
        Product instance = new Product();
        instance.setQuantity(quantity);
        assertEquals(quantity, instance.getQuantity());
    }

    /**
     * Test of getUnit method, of class Product.
     */
    @Test
    public void testGetUnit() {
        Product instance = new Product();
        instance.setUnit("Cai");
        String expResult = "Cai";
        String result = instance.getUnit();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnit method, of class Product.
     */
    @Test
    public void testSetUnit() {
        String unit = "Cai";
        Product instance = new Product();
        instance.setUnit(unit);
        assertEquals(unit, instance.getUnit());
    }




    
}
