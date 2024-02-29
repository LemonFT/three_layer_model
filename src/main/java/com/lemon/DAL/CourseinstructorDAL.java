/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import com.lemon.DTO.Courseinstructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseinstructorDAL extends ConnectDB {

    public static boolean insertCourseInstructor(Courseinstructor courseInstructor) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "INSERT INTO courseinstructor (CourseID, PersonID) VALUES (?, ?)";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, courseInstructor.getCourseID());
                stm.setInt(2, courseInstructor.getPersonID());
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

    public static boolean deleteCourseInstructor(int courseID, int personID) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, courseID);
                stm.setInt(2, personID);
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

    public static boolean deleteCourseInstructorByCourseID(int courseID) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "DELETE FROM courseinstructor WHERE CourseID = ?";
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

    public static boolean updateCourseInstructor(Courseinstructor courseInstructor) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "UPDATE courseinstructor SET PersonID = ? WHERE CourseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, courseInstructor.getPersonID());
                stm.setInt(2, courseInstructor.getCourseID());
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

    public static List<Courseinstructor> getAllCourseInstructors() throws ClassNotFoundException, SQLException {
        List<Courseinstructor> courseInstructors = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM courseinstructor";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("CourseID");
                    int personID = rs.getInt("PersonID");
                    Courseinstructor courseInstructor = new Courseinstructor(courseID, personID);
                    courseInstructors.add(courseInstructor);
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
        return courseInstructors;
    }
}
