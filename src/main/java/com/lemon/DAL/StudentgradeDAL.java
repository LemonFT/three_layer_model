/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lemon.DTO.Studentgrade;

public class StudentgradeDAL extends ConnectDB {
    public static List<Studentgrade> getAllStudentGrades() throws ClassNotFoundException, SQLException {
        List<Studentgrade> studentGrades = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM studentgrade";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int enrollmentID = rs.getInt("EnrollmentID");
                    int courseID = rs.getInt("CourseID");
                    int studentID = rs.getInt("StudentID");
                    double grade = rs.getDouble("Grade");
                    Studentgrade studentgrade = new Studentgrade(enrollmentID, courseID, studentID, grade);
                    studentGrades.add(studentgrade);
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
        return studentGrades;
    }

    public static List<Studentgrade> searchStudentGrades(String sql) throws ClassNotFoundException, SQLException {
        List<Studentgrade> studentGrades = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int enrollmentID = rs.getInt("EnrollmentID");
                    int courseID = rs.getInt("CourseID");
                    int studentID = rs.getInt("StudentID");
                    double grade = rs.getDouble("Grade");
                    Studentgrade studentgrade = new Studentgrade(enrollmentID, courseID, studentID, grade);
                    studentGrades.add(studentgrade);
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
        return studentGrades;
    }

    public static List<Studentgrade> getStudentgradesByCourseID(int course_ID)
            throws ClassNotFoundException, SQLException {
        List<Studentgrade> studentGrades = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "select * from studentgrade where CourseID = ? and Grade != -1";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, course_ID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int enrollmentID = rs.getInt("EnrollmentID");
                    int courseID = rs.getInt("CourseID");
                    int studentID = rs.getInt("StudentID");
                    double grade = rs.getDouble("Grade");
                    Studentgrade studentgrade = new Studentgrade(enrollmentID, courseID, studentID, grade);
                    studentGrades.add(studentgrade);
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
        return studentGrades;
    }

    public static boolean insertStudentGrade(Studentgrade studentgrade) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "INSERT INTO studentgrade (CourseID, StudentID, Grade) VALUES (?, ?, ?)";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, studentgrade.getCourseID());
                stm.setInt(2, studentgrade.getStudentID());
                stm.setDouble(3, studentgrade.getGrade());
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

    public static boolean updateStudentGrade(Studentgrade studentgrade) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "UPDATE studentgrade SET Grade = ?, CourseID = ?, StudentID = ? WHERE EnrollmentID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setDouble(1, studentgrade.getGrade());
                stm.setInt(2, studentgrade.getCourseID());
                stm.setInt(3, studentgrade.getStudentID());
                stm.setInt(4, studentgrade.getEnrollmentID());
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

    public static boolean deleteStudentGrade(int enrollmentID) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "DELETE FROM studentgrade WHERE EnrollmentID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, enrollmentID);
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
