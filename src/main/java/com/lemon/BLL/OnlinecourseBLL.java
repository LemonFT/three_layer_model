/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.BLL;

import com.lemon.DAL.OnlinecourseDAL;
import com.lemon.DTO.Onlinecourse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAM
 */
public class OnlinecourseBLL {
    public List<Onlinecourse> getAllOnlineCourses(){
        try {
            return OnlinecourseDAL.getAllOnlineCourses();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OnlinecourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
