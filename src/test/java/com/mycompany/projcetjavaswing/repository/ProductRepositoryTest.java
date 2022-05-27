/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.repository;

import com.mycompany.projcetjavaswing.model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatcher;
import org.powermock.api.mockito.PowerMockito;

/**
 *
 * @author Admin
 */
public class ProductRepositoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    ProductRepository productRepository;
    ProductRepository productRepositorySpy;
    public ProductRepositoryTest() {
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

//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        List<Product> expResult = null;
//        List<Product> result = ProductRepository.findAll();
//        assertEquals(expResult, result);
//    }

    @Test(expected = Exception.class)
    public void testInsertWithNull() {
        System.out.println("insert");
        Product product = null;
        productRepository.insert(product); // không thể chèn dữ liệu no vào trong dữ liệu
    }
    

    @Test()
    public void testInsertWithVali() {
        System.out.println("insert");
        Product product = new Product();
        product.setNameproduct("nameproduct");
        product.setCategory_id(1);
        product.setPrice(100);
        product.setQuantity(50);
        product.setUnit("unit");
        product.setImage("test.jpg");
        productRepository.insert(product); // không thể chèn dữ liệu no vào trong dữ liệu
    }
    
    @Test(expected = Exception.class)
    public void testUpdateWithNull() {
        System.out.println("update");
        int id = 0;
        Product pt = null;
        productRepository.update(id, pt); // test trường hợp null
    }

    @Test()
    public void testUpdateWithVali() {
        System.out.println("update");
        int id = 3;
        Product product = new Product();
        product.setNameproduct("nameproduct");
        product.setCategory_id(1);
        product.setPrice(100);
        product.setQuantity(50);
        product.setUnit("unit");
        product.setImage("test.jpg");
        productRepository.update(id, product);
    }
    @Test()
    public void testDeleteWithValiID() {
        System.out.println("delete");
        int id = 3;
        productRepository.delete(id);
    }
    
    
    @Test(expected = Exception.class)
    public void testDeleteWithNullID() {
        System.out.println("delete");
        int id = 0;
        productRepository.delete(id);
    }


    
}
