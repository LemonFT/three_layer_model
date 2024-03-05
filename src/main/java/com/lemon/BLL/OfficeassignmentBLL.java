/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.BLL;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lemon.DAL.OfficeassignmentDAL;
import com.lemon.DAL.DTO.Officeassignment;

/**
 *
 * @author LAM
 */
public class OfficeassignmentBLL {
    public Officeassignment getOfficeAssignment(int teacherID) {
        try {
            return OfficeassignmentDAL.getAllOfficeAssignmentByTeacherID(teacherID);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OfficeassignmentBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkDataIsEmpty(String data) {
        return data.length() <= 0 || data.equals(" ");
    }

    public String updateOfficeAssignment(Officeassignment o) {
        if (checkDataIsEmpty(o.getLocation()) || checkDataIsEmpty(String.valueOf(o.getTimestamp()))) {
            return "Vui lòng kiểm tra lại thông tin";
        }
        try {
            boolean rs_update = OfficeassignmentDAL.updateOfficeAssignment(o);
            if (!rs_update) {
                return "Cập nhật thất bại";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OfficeassignmentBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Cập nhật thành công";
    }
}
