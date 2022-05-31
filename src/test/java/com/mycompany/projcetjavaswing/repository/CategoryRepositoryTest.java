/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.repository;

import com.mycompany.projcetjavaswing.model.Category;
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
public class CategoryRepositoryTest {
    
    Category categoryTest;
    
    public CategoryRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.categoryTest = new Category();
        this.categoryTest.setName("nameCategory");
    }
    
    @After
    public void tearDown() {
        
    }



    @Test
    public void testInsert() {
        Category newCategory = CategoryRepository.insertReturn(categoryTest);
        
        assertEquals(this.categoryTest.getName(), newCategory.getName());
    }

    @Test
    public void testDelete() {
        Category newCategory = CategoryRepository.insertReturn(categoryTest);
        
        CategoryRepository.delete(newCategory.getId());
        
        Category category = CategoryRepository.findById(newCategory.getId());
        
        assertNull(category);
    }

    @Test
    public void testUpdate() {
        Category newCategory = CategoryRepository.insertReturn(categoryTest);
        
        Category updateCategory = this.categoryTest;
        updateCategory.setName("Update 2");
        
        updateCategory = CategoryRepository.updateReturn(newCategory.getId(), updateCategory);
        
        assertEquals("Update 2", updateCategory.getName());
    }

    

    @Test
    public void testFindCategory() {
       List<Category> list = new ArrayList<>();
       
       Category newCategory = CategoryRepository.insertReturn(categoryTest);
       list = CategoryRepository.findCategory(newCategory.getName());
       
        assertNotEquals(0, list.size());
        
               list = CategoryRepository.findCategory("test Category");
               
               assertEquals(0, list.size());
        
    }
    
}
