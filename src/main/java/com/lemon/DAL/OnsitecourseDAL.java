/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import com.lemon.DTO.Onsitecourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OnsitecourseDAL extends ConnectDB{
    public static boolean insertOnsiteCourse(Onsitecourse onsiteCourse) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "INSERT INTO onsitecourse (CourseID, Location, Days, Time) VALUES (?, ?, ?, ?)";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, onsiteCourse.getCourseID());
                stm.setString(2, onsiteCourse.getLocation());
                stm.setString(3, onsiteCourse.getDays());
                stm.setTime(4, new java.sql.Time(onsiteCourse.getTime().getTime()));
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

    public static boolean updateOnsiteCourse(Onsitecourse onsiteCourse) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "UPDATE onsitecourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, onsiteCourse.getLocation());
                stm.setString(2, onsiteCourse.getDays());
                stm.setTime(4, new java.sql.Time(onsiteCourse.getTime().getTime()));
                stm.setInt(4, onsiteCourse.getCourseID());
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

    public static boolean deleteOnsiteCourse(int courseID) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "DELETE FROM onsitecourse WHERE CourseID = ?";
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

    public static List<Onsitecourse> getAllOnsiteCourses() throws ClassNotFoundException, SQLException {
        List<Onsitecourse> onsiteCourses = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM onsitecourse";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    String location = rs.getString("Location");
                    String days = rs.getString("Days");
                    Time time = rs.getTime("Time");
                    Onsitecourse onsiteCourse = new Onsitecourse(courseID, location, days, time);
                    onsiteCourses.add(onsiteCourse);
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
        return onsiteCourses;
    }
    
    public static Onsitecourse getOnsiteCourseByID(int id) throws ClassNotFoundException, SQLException {
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM onsitecourse WHERE CourseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    String location = rs.getString("Location");
                    String days = rs.getString("Days");
                    Time time = rs.getTime("Time");
                    Onsitecourse onsiteCourse = new Onsitecourse(courseID, location, days, time);
                    return onsiteCourse;
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
