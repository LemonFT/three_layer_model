/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.BLL;

import com.lemon.DAL.CourseinstructorDAL;
import com.lemon.DAL.PersonDAL;
import com.lemon.DTO.Courseinstructor;
import com.lemon.DTO.Person;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAM
 */
public class CourseinstructorBLL {
    public List<Courseinstructor> getAllCourseInstructors(){
        try {
            return CourseinstructorDAL.getAllCourseInstructors();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CourseinstructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Person> getStudentsInCourse(int courseID){
        try {
            return PersonDAL.getStudentsInCourse(courseID);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentgradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
