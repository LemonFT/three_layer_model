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

import com.lemon.DAL.DTO.Onlinecourse;

public class OnlinecourseDAL extends ConnectDB {
    public static boolean insertOnlineCourse(Onlinecourse onlineCourse) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "INSERT INTO onlinecourse (CourseID, Url) VALUES (?, ?)";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, onlineCourse.getCourseID());
                stm.setString(2, onlineCourse.getUrl());
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

    public static boolean updateOnlineCourse(Onlinecourse onlineCourse) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "UPDATE onlinecourse SET Url = ? WHERE CourseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, onlineCourse.getUrl());
                stm.setInt(2, onlineCourse.getCourseID());
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

    public static boolean deleteOnlineCourse(int courseID) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "DELETE FROM onlinecourse WHERE CourseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, courseID);
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

    public static List<Onlinecourse> getAllOnlineCourses() throws ClassNotFoundException, SQLException {
        List<Onlinecourse> onlineCourses = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM onlinecourse";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    String url = rs.getString("Url");
                    Onlinecourse onlineCourse = new Onlinecourse(courseID, url);
                    onlineCourses.add(onlineCourse);
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
        return onlineCourses;
    }

    public static Onlinecourse getOnlineCourseByID(int id) throws ClassNotFoundException, SQLException {
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM onlinecourse WHERE CourseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    String url = rs.getString("Url");
                    Onlinecourse onlineCourse = new Onlinecourse(courseID, url);
                    return onlineCourse;
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
