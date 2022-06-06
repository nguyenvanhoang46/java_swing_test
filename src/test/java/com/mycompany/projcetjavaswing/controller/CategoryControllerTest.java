/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Category;
import com.mycompany.projcetjavaswing.repository.CategoryRepository;
import com.mycompany.projcetjavaswing.view.CategoryPanel;
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
public class CategoryControllerTest {
    
    public CategoryControllerTest() {
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
        CategoryPanel categoryPanelTest = new CategoryPanel();
        categoryPanelTest.getNameCategory().setText("namecategory");
        
        CategoryController categoryController = new CategoryController(categoryPanelTest);
        
        categoryController.insert();
        categoryPanelTest.getBtnSave().doClick();
        List<Category> result = CategoryRepository.findCategory("nameCategory");
        boolean expResult = false;
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).getName().equals("nameCategory")){
                expResult = true;
            }
        }
        assertTrue(expResult);
    }

    @Test
    public void testUpdate() {
        CategoryPanel categoryPanelTest = new CategoryPanel();
        categoryPanelTest.getNameCategory().setText("namecategory");
        
        CategoryController categoryController = new CategoryController(categoryPanelTest);
        
        List<Category> listCategory = CategoryRepository.findAll();
        int index = 0;
        
        Category currentCategory = listCategory.get(index);
        
        categoryController.update();
        categoryPanelTest.getTableCategory().setRowSelectionInterval(index, 0);
        categoryPanelTest.getBtnUpdate().doClick();
        
        assertNotEquals(currentCategory, "namecategory");
        
    }
    
    @Test
    public void testReset() {
        CategoryPanel categoryPanelTest = new CategoryPanel();
        categoryPanelTest.getNameCategory().setText("namecategory");
        
        CategoryController categoryController = new CategoryController(categoryPanelTest);
        categoryController.reset();
        categoryPanelTest.getBtnReset().doClick();
        assertEquals(categoryPanelTest.getNameCategory().getText(), "");
    }
    
}
