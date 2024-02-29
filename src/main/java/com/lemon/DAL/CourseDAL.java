/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import com.lemon.DTO.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LAM
 */
public class CourseDAL extends ConnectDB {

    public static List<Course> getAllCourse() throws ClassNotFoundException, SQLException {
        List<Course> courses = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "select * from course";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("courseID");
                    String title = rs.getString("Title");
                    int credits = rs.getInt("Credits");
                    int departmentID = rs.getInt("departmentID");
                    Course course = new Course(courseID, title, credits, departmentID);
                    courses.add(course);
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
        return courses;
    }

    public static List<HashMap<String, String>> getCourseByTeacherID(int teacherID) throws ClassNotFoundException, SQLException {
        List<HashMap<String, String>> infoCourses = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = 
                        "select course.CourseID as CourseID, course.Title as Title, course.Credits as Credits, course.DepartmentID as DepartmentID, " 
                        + "onlinecourse.url as url, onsitecourse.Location as Location, onsitecourse.Days as Days, onsitecourse.Time from course join courseinstructor on course.CourseID = courseinstructor.CourseID "
                        + "left join onlinecourse on course.CourseID = onlinecourse.CourseID "
                        + "left join onsitecourse on course.courseID = onsitecourse.CourseID "
                        + "where courseinstructor.PersonID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, teacherID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("courseID");
                    String title = rs.getString("Title");
                    int credits = rs.getInt("Credits");
                    int departmentID = rs.getInt("DepartmentID");
                    String url = rs.getString("url");
                    String location = rs.getString("Location");
                    String Days = rs.getString("Days");
                    Time time = rs.getTime("Time");
                    HashMap<String, String> infoCourse = new HashMap<>();
                    infoCourse.put("CourseID", String.valueOf(courseID));
                    infoCourse.put("Title", String.valueOf(title));
                    infoCourse.put("Credits", String.valueOf(credits));
                    infoCourse.put("DepartmentID", String.valueOf(departmentID));
                    infoCourse.put("url", String.valueOf(url));
                    infoCourse.put("Location", String.valueOf(location));
                    infoCourse.put("Days", String.valueOf(Days));
                    infoCourse.put("Time", String.valueOf(time));
                    infoCourses.add(infoCourse);
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
        return infoCourses;
    }

    public static List<Course> getCourseBySearch(String sql) throws ClassNotFoundException, SQLException {
        List<Course> courses = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int courseID = rs.getInt("courseID");
                    String title = rs.getString("Title");
                    int credits = rs.getInt("Credits");
                    int departmentID = rs.getInt("departmentID");
                    Course course = new Course(courseID, title, credits, departmentID);
                    courses.add(course);
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
        return courses;
    }

    public static boolean insertCourse(Course course) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "insert into course (Title, Credits, departmentID) values (?,?,?)";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, course.getTitle());
                stm.setInt(2, course.getCredits());
                stm.setInt(3, course.getDepartmentID());
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

    public static int insertCourse_ReturnID_AI(Course course) throws SQLException, ClassNotFoundException {
        int courseId = -1;
        if (open()) {
            PreparedStatement stm = null;
            ResultSet generatedKeys = null;
            try {
                String sql = "insert into course (Title, Credits, departmentID) values (?,?,?)";
                stm = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stm.setString(1, course.getTitle());
                stm.setInt(2, course.getCredits());
                stm.setInt(3, course.getDepartmentID());
                int affectedRows = stm.executeUpdate();
                if (affectedRows > 0) {
                    generatedKeys = stm.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        courseId = generatedKeys.getInt(1);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
            }
        }
        return courseId;
    }

    public static boolean updateCourse(Course course) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "update course set Title = ?, Credits = ?, departmentID = ? where courseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, course.getTitle());
                stm.setInt(2, course.getCredits());
                stm.setInt(3, course.getDepartmentID());
                stm.setInt(4, course.getCourseID());
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

    
    public static boolean deleteCourse(Course course) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "delete from course where courseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, course.getCourseID());
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
    
    public static boolean deleteCourse(int courseID) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "delete from course where courseID = ?";
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
}
