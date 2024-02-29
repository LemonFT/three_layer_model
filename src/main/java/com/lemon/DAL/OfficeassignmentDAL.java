/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import com.lemon.DTO.Officeassignment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfficeassignmentDAL extends ConnectDB{
    public static boolean insertOfficeAssignment(Officeassignment officeAssignment) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "INSERT INTO officeassignment (InstructorID, Location, Timestamp) VALUES (?, ?, ?)";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, officeAssignment.getInstructorID());
                stm.setString(2, officeAssignment.getLocation());
                stm.setDate(3, new java.sql.Date(officeAssignment.getTimestamp().getTime()));
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

    public static boolean updateOfficeAssignment(Officeassignment officeAssignment) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "UPDATE officeassignment SET Location = ?, Timestamp = ? WHERE InstructorID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, officeAssignment.getLocation());
                stm.setDate(2, new java.sql.Date(officeAssignment.getTimestamp().getTime()));
                stm.setInt(3, officeAssignment.getInstructorID());
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

    public static boolean deleteOfficeAssignment(int instructorID) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "DELETE FROM officeassignment WHERE InstructorID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, instructorID);
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

    public static List<Officeassignment> getAllOfficeAssignments() throws ClassNotFoundException, SQLException {
        List<Officeassignment> officeAssignments = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM officeassignment";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int instructorID = rs.getInt("InstructorID");
                    String location = rs.getString("Location");
                    Date timestamp = rs.getDate("Timestamp");
                    Officeassignment officeAssignment = new Officeassignment(instructorID, location, timestamp);
                    officeAssignments.add(officeAssignment);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
        return officeAssignments;
    }
    
    public static Officeassignment getAllOfficeAssignmentByTeacherID(int teacherID) throws ClassNotFoundException, SQLException {
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM officeassignment where InstructorID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, teacherID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int instructorID = rs.getInt("InstructorID");
                    String location = rs.getString("Location");
                    Date timestamp = rs.getDate("Timestamp");
                    Officeassignment officeAssignment = new Officeassignment(instructorID, location, timestamp);
                    return officeAssignment;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
        return null;
    }
}
