/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DTO;

import java.util.Date;

/**
 *
 * @author LAM
 */
public class Department {
    private int departmentID;
    private String name;
    private double budget;
    private Date startDate;
    private int administrator;

    public Department(int departmentID, String name, double budget, Date startDate, int administrator) {
        this.departmentID = departmentID;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.administrator = administrator;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getAdministrator() {
        return administrator;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }
    
}
