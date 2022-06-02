/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Staff;
import com.mycompany.projcetjavaswing.repository.StaffRepository;
import com.mycompany.projcetjavaswing.view.StaffPanel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class StaffController {

    DefaultTableModel tabbleModel;
    private StaffPanel view;

    List<Staff> staffList = new ArrayList<>();

    public StaffController(StaffPanel view) {
        this.view = view;
        this.view.setVisible(true);
        setUpListener();
    }

    public StaffPanel index() {
        return this.view;
    }

    public void setUpListener() {
        showStaff();
        insert();
        detele();
        search();
        update();
        tblStaff();
    }

    private void showStaff() {
        staffList = StaffRepository.findAll();
        tabbleModel = (DefaultTableModel) this.view.getTableStaff().getModel();
        tabbleModel.setRowCount(0);

        staffList.forEach(s -> {
            tabbleModel.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getGender(),
                s.getPhone()
            });
        });

    }

    public void insert() {
        this.view.getBtnSave().addActionListener((ActionEvent e) -> {
            if (view.getStaffname().getText().isEmpty() || view.getStaffGioitinh().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nhập thông tin không đầy đủ");
                return;
            }

            String name = view.getStaffname().getText();
            String gender = view.getStaffGioitinh().getText();
            int phone = Integer.parseInt(view.getStaffPhone().getText());

            Staff staff = new Staff(name, gender, phone);
            StaffRepository.insert(staff);
            showStaff();

        });
    }

    private void search() {
        this.view.getBtnFind().addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog(this, "Nhập tên đầy đủ để tìm kiếm");
            if (input != null && input.length() > 0) {
                staffList = StaffRepository.searchName(input);
                tabbleModel.setRowCount(0);
                staffList.forEach(staff -> {
                    tabbleModel.addRow(new Object[]{
                        tabbleModel.getRowCount() + 1,
                        staff.getName(),
                        staff.getGender(),
                        staff.getPhone()
                    });
                });
            } else {
                showStaff();
            }
        });
    }

    public void detele() {
        this.view.getBtnDelete().addActionListener((ActionEvent e) -> {
            staffList = StaffRepository.findAll();
            int index = view.getTableStaff().getSelectedRow();
            if (index >= 0) {
                Staff staff = staffList.get(index);
                int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa mục này");
                if (option == JOptionPane.YES_OPTION) {
                    StaffRepository.delete(staff.getId());
                    showStaff();
                }
            }
        });
    }

    public void update() {
        this.view.getBtnUpdate().addActionListener((ActionEvent e) -> {
            int index = view.getTableStaff().getSelectedRow();

            if (index >= 0) {
                Staff staff = staffList.get(index);
                String name = view.getStaffname().getText();
                String gender = view.getStaffGioitinh().getText();
                int phone = Integer.parseInt(view.getStaffPhone().getText());

                Staff newStaff = new Staff();
                newStaff.setName(name);
                newStaff.setGender(gender);
                newStaff.setPhone(phone);

                StaffRepository.update(staff.getId(), newStaff);
//                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                showStaff();
            }
        });
    }
    public void reset() {
        view.getBtnReset().addActionListener((ActionEvent e) -> {
            view.getStaffname().setText("");
            view.getStaffGioitinh().setText("");
            view.getStaffPhone().setText("");
        });
    }
    private void tblStaff() {
        view.getTableStaff().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int index = -1;
                index = view.getTableStaff().getSelectedRow();
                Staff sta = staffList.get(index);
                if (index >= 0) {
                    Staff staff1 = staffList.get(index);
                    view.getStaffname().setText(staff1.getName());
                    view.getStaffGioitinh().setText(staff1.getGender());
                    view.getStaffPhone().setText(String.valueOf(staff1.getPhone()));
                }
            }
        });
    }

    
    
    
}
