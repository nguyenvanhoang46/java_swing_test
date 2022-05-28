///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package com.mycompany.projcetjavaswing.model;
//
//import com.mycompany.projcetjavaswing.controller.ProductController;
//import com.mycompany.projcetjavaswing.repository.ProductRepository;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Admin
// */
//public class ProductTest {
//    
//    ProductRepository productRepository;
//    ProductRepository productRepositorySpy;
//
//    
//    
//    public ProductTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        productRepository = new ProductRepository();
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getId method, of class Product.
//     */
//
//    /**
//     * Test of setId method, of class Product.
//     */
//    @Test
//    public void testId() {
//        System.out.println("setId");
//        int id = 1;
//        Product instance = new Product();
//        instance.setId(id);
//        assertEquals(id, instance.getId());
//    }
//
//    /**
//     * Test of getNameproduct method, of class Product.
//     */
//
//
//    /**
//     * Test of setNameproduct method, of class Product.
//     */
//    @Test
//    public void testSetNameproduct() {
//        System.out.println("setNameproduct");
//        String nameproduct = "Pizz Hai San";
//        Product instance = new Product();
//        instance.setNameproduct(nameproduct);
//        assertEquals(nameproduct, instance.getNameproduct());
//    }
//
//    /**
//     * Test of getCategory_id method, of class Product.
//     */
//
//
//    /**
//     * Test of setCategory_id method, of class Product.
//     */
//    @Test
//    public void testCategory_id() {
//        System.out.println("setCategory_id");
//        int category_id = 211;
//        Product instance = new Product();
//        instance.setCategory_id(category_id);
//       assertEquals(category_id, instance.getCategory_id());
//    }
//
//    /**
//     * Test of getPrice method, of class Product.
//     */
//
//    /**
//     * Test of setPrice method, of class Product.
//     */
//    @Test
//    public void testPrice() {
//        System.out.println("setPrice");
//        int price = 100;
//        Product instance = new Product();
//        instance.setPrice(price);
//        assertEquals(price, instance.getPrice());
//        // TODO review the generated test code and remove the default call to fail.
//    }
//    
//    @Test
//    public void testPriceWithNegation() {
//        System.out.println("setPrice");
//        int price = -100;
//        Product instance = new Product();
//         instance.setPrice(price);
//        assertEquals(price, instance.getPrice());
//       
//    }
//
//    /**
//     * Test of getQuantity method, of class Product.
//     */
//
//
//    /**
//     * Test of setQuantity method, of class Product.
//     */
//    @Test
//    public void testQuantity() {
//        System.out.println("setQuantity");
//        int quantity = 12;
//        Product instance = new Product();
//        instance.setQuantity(quantity);
//        assertEquals(quantity, instance.getQuantity());
//
//    }
//
//    /**
//     * Test of getUnit method, of class Product.
//     */
//
//    /**
//     * Test of setUnit method, of class Product.
//     */
//    @Test
//    public void testSetUnit() {
//        System.out.println("setUnit");
//        String unit = "Cai";
//        Product instance = new Product();
//        instance.setUnit(unit);
//        assertEquals(unit, instance.getUnit());
//    }
//
//    /**
//     * Test of getImage method, of class Product.
//     */
//
//    
//}
