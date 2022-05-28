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

    ProductRepository productRepository;
    ProductRepository productRepositorySpy;
    Product productTest;

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
        this.productTest = new Product();
        this.productTest.setNameproduct("nameproduct");
        this.productTest.setCategory_id(1);
        this.productTest.setPrice(100);
        this.productTest.setQuantity(50);
        this.productTest.setUnit("unit");
        this.productTest.setImage("test.jpg");
    }

    @After
    public void tearDown() {
    }

    @Test()
    public void testInsertWithVali() {
        Product newProduct = productRepository.insertReturn(productTest); // không thể chèn dữ liệu no vào trong dữ liệu

        assertEquals(this.productTest.getNameproduct(), newProduct.getNameproduct());
    }

    @Test()
    public void testUpdateWithVali() {
        Product newProduct = productRepository.insertReturn(productTest); // không thể chèn dữ liệu no vào trong dữ liệu

        Product updateProduct = this.productTest;
        updateProduct.setNameproduct("Update 2");

        updateProduct = productRepository.updateReturn(newProduct.getId(), updateProduct);

        assertEquals("Update 2", updateProduct.getNameproduct());
    }

    @Test()
    public void testDeleteWithValiID() {
        Product newProduct = productRepository.insertReturn(productTest); // không thể chèn dữ liệu no vào trong dữ liệu

        productRepository.delete(newProduct.getId());

        Product product = productRepository.findById(newProduct.getId());

        assertNull(product);
    }

    @Test()
    public void testSearchByName() {
        List<Product> list = new ArrayList<>();
        Product newProduct = productRepository.insertReturn(productTest); // không thể chèn dữ liệu no vào trong dữ liệu

        list = productRepository.searchName(newProduct.getNameproduct());
        
        assertNotEquals(0, list.size());
        
        list = productRepository.searchName("test test test test");
        
        assertEquals(0, list.size());
    }

}
