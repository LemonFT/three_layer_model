/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lemon.DAL.DTO.Department;

public class DepartmentDAL extends ConnectDB {
    public static List<Department> getAllDepartment() throws ClassNotFoundException, SQLException {
        List<Department> departments = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "select * from department";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int departmentID = rs.getInt("DepartmentID");
                    String name = rs.getString("Name");
                    double budget = rs.getDouble("Budget");
                    Date startDate = rs.getDate("StartDate");
                    int administrator = rs.getInt("Administrator");
                    Department department = new Department(departmentID, name, budget, startDate, administrator);
                    departments.add(department);
                }
            } catch (SQLException e) {
                System.out.println("");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
        return departments;
    }

    public static boolean insertDepartment(Department department) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "insert into department (Name, Budget, StartDate, Administractor) values (?,?,?,?)";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, department.getName());
                stm.setDouble(2, department.getBudget());
                stm.setDate(3, (java.sql.Date) department.getStartDate());
                stm.setInt(4, department.getAdministrator());
                if (stm.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (stm != null) {
                    stm.close();
                }
            }
        }
        return false;
    }

    public static boolean updateDepartment(Department department) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "update department set Name = ?, Budget = ?, StartDate = ?, Administractor where DepartmentID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, department.getName());
                stm.setDouble(2, department.getBudget());
                stm.setDate(3, (java.sql.Date) department.getStartDate());
                stm.setInt(4, department.getAdministrator());
                stm.setInt(5, department.getDepartmentID());
                if (stm.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (stm != null) {
                    stm.close();
                }
            }
        }
        return false;
    }

    public static boolean deleteDepartment(Department department) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "delete from department where departmentID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, department.getDepartmentID());
                if (stm.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (stm != null) {
                    stm.close();
                }
            }
        }
        return false;
    }
}
