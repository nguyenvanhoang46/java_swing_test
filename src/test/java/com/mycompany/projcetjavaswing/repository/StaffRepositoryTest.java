/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projcetjavaswing.repository;

import com.mycompany.projcetjavaswing.model.Staff;
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
public class StaffRepositoryTest {
    Staff staffTest;
    
    public StaffRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.staffTest= new Staff();
        this.staffTest.setName("staffname");
        this.staffTest.setGender("nam");
        this.staffTest.setPhone(123123123);
    }
    
    @After
    public void tearDown() {
    }



    @Test
    public void testInsertStaff() {
        Staff newStaff = StaffRepository.insertReturn(staffTest);
        assertEquals(this.staffTest.getName(), newStaff.getName());
    }

    @Test
    public void testUpdateStaff() {
        Staff newStaff = StaffRepository.insertReturn(staffTest);
        
        Staff updateStaff = this.staffTest;
        updateStaff.setName("Updata 2");
        
        updateStaff = StaffRepository.updateReturn(newStaff.getId(), updateStaff);
        
        assertEquals("Updata 2", updateStaff.getName());

    }

    @Test
    public void testDeleteStaff() {
        Staff newStaff = StaffRepository.insertReturn(staffTest);
        
        StaffRepository.delete(newStaff.getId());
        
        Staff staff = StaffRepository.findById(newStaff.getId());
        
        assertNull(staff);
    }

    

    @Test
    public void testSearchNameStaff() {
        List<Staff> list = new ArrayList<>();
        Staff newStaff = StaffRepository.insertReturn(staffTest);
        
        list = StaffRepository.searchName(newStaff.getName());
        
        assertNotEquals(0, list.size());
        
        list = StaffRepository.searchName("tim");
        
        assertEquals(0, list.size());
    }
    
}
