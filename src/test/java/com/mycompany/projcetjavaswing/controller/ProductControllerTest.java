/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Category;
import com.mycompany.projcetjavaswing.model.Product;
import com.mycompany.projcetjavaswing.repository.ProductRepository;
import com.mycompany.projcetjavaswing.view.ProductPanel;
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
public class ProductControllerTest {

    Product productTest;

    public ProductControllerTest() {
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
     * Test of index method, of class ProductController.
     */
    @Test
    public void testIndex() {
        System.out.println("index");
        ProductController instance = null;
        ProductPanel expResult = null;
        ProductPanel result = instance.index();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUpListener method, of class ProductController.
     */

    @Test
    public void testInsert() {
        ProductPanel productPanelTest = new ProductPanel();
        productPanelTest.getNameproduct().setText("nameproduct");
        productPanelTest.getPriceproduct().setText("123123");
        productPanelTest.getQuantytiproduct().setText("12");
        productPanelTest.getUnitproduct().setText("Cai");
        productPanelTest.getLblImage().setText("test.jpg");
        ProductController prdController = new ProductController(productPanelTest);

        prdController.insert();
        productPanelTest.getBtnSave().doClick();
        List<Product> result = ProductRepository.searchName("nameproduct");
        boolean expResult = false;
        for(int i = 0; i < result.size()-1; i++){
            if(result.get(i).getNameproduct().equals("nameproduct")){
                expResult = true;
            }
        }
        System.out.println(expResult);
        assertTrue(expResult);
    }

    @Test
    public void testReset() {
        ProductPanel productPanelTest = new ProductPanel();
        productPanelTest.getNameproduct().setText("nameproduct");
        productPanelTest.getPriceproduct().setText("123123");
        productPanelTest.getQuantytiproduct().setText("12");
        productPanelTest.getUnitproduct().setText("Cai");
        productPanelTest.getLblImage().setText("test.jpg");
        ProductController prdController = new ProductController(productPanelTest);
        prdController.reset();
        productPanelTest.getBtnReset().doClick();
        System.out.println(productPanelTest.getNameproduct().getText());
        assertEquals(productPanelTest.getNameproduct().getText(), "");
    }

    /**
     * Test of categoryFindById method, of class ProductController.
     */
    
    @Test
    public void testProductUpdate() {
        ProductPanel productPanelTest = new ProductPanel();
        productPanelTest.getNameproduct().setText("nameupdate");
        productPanelTest.getPriceproduct().setText("123123");
        productPanelTest.getQuantytiproduct().setText("12");
        productPanelTest.getUnitproduct().setText("Cai");
        productPanelTest.getLblImage().setText("test.jpg");
        ProductController prdController = new ProductController(productPanelTest);
        List<Product> listProduct = ProductRepository.findAll();
        int index = 0;
        Product currentProduct = listProduct.get(index);
        
        prdController.update();
        productPanelTest.getTableProduct().setRowSelectionInterval(index, 0);
        productPanelTest.getBtnUpdate().doClick();
        
        assertNotEquals(currentProduct, "nameupdate");
        assertEquals(listProduct.get(index).getNameproduct(), "nameupdate");
    }
    
    
    @Test
    public void testProductDelete() {
        ProductPanel productPanelTest = new ProductPanel();
        ProductController prdController = new ProductController(productPanelTest);
        
        List<Product> listProduct = ProductRepository.findAll();
        
        
        Product currProduct = listProduct.get(0);
        
        prdController.delete();
        productPanelTest.getBtnDelete().doClick();
        
        
    }
}
