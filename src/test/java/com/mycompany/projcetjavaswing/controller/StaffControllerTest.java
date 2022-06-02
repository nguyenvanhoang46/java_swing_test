/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Staff;
import com.mycompany.projcetjavaswing.repository.StaffRepository;
import com.mycompany.projcetjavaswing.view.StaffPanel;
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
public class StaffControllerTest {
    
    public StaffControllerTest() {
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
    public void testInsertStaff() {
        StaffPanel staffPanelTest = new StaffPanel();
        staffPanelTest.getStaffname().setText("staffname");
        staffPanelTest.getStaffGioitinh().setText("nam");
        staffPanelTest.getStaffPhone().setText("123123123");
        
        StaffController staffController = new StaffController(staffPanelTest);
        
        staffController.insert();
        staffPanelTest.getBtnSave().doClick();
        
        List<Staff> result = StaffRepository.searchName("namestaff");
        boolean expResult = false;
        for (int i = 0; i < result.size()-1; i++) {
            if (result.get(i).getName().equals("namestaff")) {
                expResult = true;
            }
        }        
        assertTrue(expResult);
    }

    @Test
    public void testUpdateStaff() {
        StaffPanel staffPanelTest = new StaffPanel();
        staffPanelTest.getStaffname().setText("staffname");
        staffPanelTest.getStaffGioitinh().setText("nam");
        staffPanelTest.getStaffPhone().setText("123123123");
        
        StaffController staffController = new StaffController(staffPanelTest);
        
        List<Staff> listStaff = StaffRepository.findAll();
        int index = 0;
        Staff currentStaff = listStaff.get(index);
        
        staffController.update();
        
        staffPanelTest.getTableStaff().setRowSelectionInterval(index, 0);
        
        staffPanelTest.getBtnUpdate().doClick();
        
        assertNotEquals(currentStaff, "staffname");
        assertEquals(listStaff.get(index).getName(), "staffname");
    }

    @Test
    public void testResetStaff() {
        StaffPanel staffPanelTest = new StaffPanel();
        staffPanelTest.getStaffname().setText("staffname");
        staffPanelTest.getStaffGioitinh().setText("nam");
        staffPanelTest.getStaffPhone().setText("123123123");
        
        StaffController staffController = new StaffController(staffPanelTest);
        
        staffController.reset();
        
        staffPanelTest.getBtnReset().doClick();
        
        assertEquals(staffPanelTest.getStaffname().getText(), "");
    }
    
    
   
}
