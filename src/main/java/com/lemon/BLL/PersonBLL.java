/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.BLL;

import com.lemon.DAL.PersonDAL;
import com.lemon.DTO.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAM
 */
public class PersonBLL {
    
    public List<Person> getAllPersonIsStudent(){
        try {
            return PersonDAL.getAllPersonIsStudent();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PersonBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Person> getAllPersonIsTeacher(){
        try {
            return PersonDAL.getPersonIsTeacher();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PersonBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String convertField(int filter) {
        return filter == 1 ? "PersonID"
                : filter == 2 ? "CONCAT(Lastname, ' ',Firstname)"
                        : filter == 3 ? "HireDate" : "";
    }

    public List<Person> searchTeacher(String searchField, int sortOption, int filter) {
        List<Person> teachers = new ArrayList<>();
        String sort = sortOption == 0 ? "ASC" : "DESC";
        String sql = "select * from person ";
        String columnFilter = convertField(filter);
        if (columnFilter.equals("")) {
            sql
                    += "where HireDate is not null and (PersonID like '%" + searchField + "%' or "
                    + " CONCAT(Lastname, ' ',Firstname) like '%" + searchField + "%' or "
                    + " HireDate like '%" + searchField + "%') order by PersonID " + sort;
        } else {
            sql += "where HireDate is not null and (" + columnFilter + " like '%" + searchField + "%') order by " + columnFilter + " " + sort;
        }
        System.err.println(sql);
        try {
            teachers = PersonDAL.getTeacherBySearch(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PersonBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teachers;
    }
}
