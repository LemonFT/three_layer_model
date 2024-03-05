package com.lemon.BLL;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lemon.DAL.CourseDAL;
import com.lemon.DAL.CourseinstructorDAL;
import com.lemon.DAL.OnlinecourseDAL;
import com.lemon.DAL.OnsitecourseDAL;
import com.lemon.DAL.StudentgradeDAL;
import com.lemon.DAL.DTO.Course;
import com.lemon.DAL.DTO.Courseinstructor;
import com.lemon.DAL.DTO.Onlinecourse;
import com.lemon.DAL.DTO.Onsitecourse;
import com.lemon.DAL.DTO.Studentgrade;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LAM
 */
public class CourseBLL {

    public List<Course> getAllCourse() {
        try {
            return CourseDAL.getAllCourse();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // search
    public String convertField(int filter) {
        return filter == 1 ? "CourseID"
                : filter == 2 ? "Title"
                        : filter == 3 ? "Credits"
                                : filter == 4 ? "DepartmentID"
                                        : filter == 5 ? "PersonID" : "";
    }

    public List<Course> searchCourse(String searchField, int sortOption, int filter, int typeCourse) {
        List<Course> listCourse = null;
        String sort = sortOption == 0 ? "ASC" : "DESC";
        String sql = "SELECT course.CourseID AS courseID, course.Title AS Title, course.Credits AS Credits, course.DepartmentID AS DepartmentID "
                + "FROM course "
                + "JOIN courseinstructor ON course.CourseID = courseinstructor.CourseID ";
        String columnFilter = convertField(filter);
        if (columnFilter.equals("")) {
            sql += "WHERE course.CourseID LIKE '%" + searchField + "%' OR "
                    + "course.Title LIKE '%" + searchField + "%' OR "
                    + "course.Credits LIKE '%" + searchField + "%' OR "
                    + "course.DepartmentID LIKE '%" + searchField + "%' OR "
                    + "courseinstructor.PersonID LIKE '%" + searchField + "%'"
                    + " GROUP BY CourseID "
                    + "ORDER BY course.CourseID " + sort;
        } else {
            if (filter == 5) {
                sql += "WHERE courseinstructor." + columnFilter + " LIKE '%" + searchField
                        + "%' GROUP BY CourseID ORDER BY courseinstructor." + columnFilter + " " + sort;
            } else {
                sql += "WHERE course." + columnFilter + " LIKE '%" + searchField
                        + "%' GROUP BY CourseID ORDER BY course." + columnFilter + " " + sort;
            }
        }
        try {
            listCourse = CourseDAL.getCourseBySearch(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCourse;
    }

    // insert course
    public boolean checkDataIsEmpty(String data) {
        return data.length() <= 0 || data.equals(" ");
    }

    // insert online course
    public String insertCourse(String title, String credits, int departmentID, List<Integer> teacherIDs, String url) {
        int creditsInt;
        if (checkDataIsEmpty(title) || checkDataIsEmpty(credits) || checkDataIsEmpty(url)) {
            return "Vui lòng nhập đầy đủ thông tin!";
        }
        try {
            creditsInt = Integer.parseInt(credits);
        } catch (NumberFormatException ex) {
            return "Tín chỉ phải ở dạng số nguyên";
        }
        if (teacherIDs.isEmpty()) {
            return "Chưa thêm giảng viên cho khóa học";
        }
        try {
            int rs_insertCourse = CourseDAL.insertCourse_ReturnID_AI(new Course(title, creditsInt, departmentID));
            if (rs_insertCourse != -1) {
                boolean rs_insertOnlineCourse = OnlinecourseDAL
                        .insertOnlineCourse(new Onlinecourse(rs_insertCourse, url));
                boolean rs_insertConrseInstructor = true;
                for (Integer id : teacherIDs) {
                    rs_insertConrseInstructor = CourseinstructorDAL
                            .insertCourseInstructor(new Courseinstructor(rs_insertCourse, id));
                    if (!rs_insertConrseInstructor) {
                        break;
                    }
                }
                if (!rs_insertOnlineCourse || !rs_insertConrseInstructor) {
                    return "Thêm khóa học thất bại";
                }
            } else {
                return "Thêm khóa học thất bại";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thêm thành công";
    }

    // insert onsite course
    public String insertCourse(String title, String credits, int departmentID, List<Integer> teacherIDs,
            String location, String days, String hour, String minute) {
        int creditsInt;
        Time startTime = null;
        if (checkDataIsEmpty(title) || checkDataIsEmpty(credits) || checkDataIsEmpty(location)
                || checkDataIsEmpty(days)) {
            return "Vui lòng nhập đầy đủ thông tin!";
        }
        try {
            creditsInt = Integer.parseInt(credits);
        } catch (NumberFormatException ex) {
            return "Tín chỉ phải ở dạng số nguyên";
        }
        try {
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(minute);
            startTime = new Time(h, m, 0);
        } catch (NumberFormatException ex) {
            System.err.println(ex);
        }
        if (teacherIDs.isEmpty()) {
            return "Chưa thêm giảng viên cho khóa học";
        }
        try {
            int rs_insertCourse = CourseDAL.insertCourse_ReturnID_AI(new Course(title, creditsInt, departmentID));
            boolean rs_insertOnsiteCourse = OnsitecourseDAL
                    .insertOnsiteCourse(new Onsitecourse(rs_insertCourse, location, days, startTime));
            boolean rs_insertConrseInstructor = true;
            for (Integer id : teacherIDs) {
                rs_insertConrseInstructor = CourseinstructorDAL
                        .insertCourseInstructor(new Courseinstructor(rs_insertCourse, id));
                if (!rs_insertConrseInstructor) {
                    break;
                }
            }
            if (rs_insertCourse == -1 || !rs_insertOnsiteCourse || !rs_insertConrseInstructor) {
                return "Thêm khóa học thất bại";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Thêm thành công";
    }

    // update online course
    public String updateCourse(int CourseID, String title, String credits, int departmentID, List<Integer> teacherIDs,
            String url) {
        int creditsInt;
        if (checkDataIsEmpty(title) || checkDataIsEmpty(credits) || checkDataIsEmpty(url)) {
            return "Vui lòng nhập đầy đủ thông tin!";
        }
        try {
            creditsInt = Integer.parseInt(credits);
        } catch (NumberFormatException ex) {
            return "Tín chỉ phải ở dạng số nguyên";
        }
        if (teacherIDs.isEmpty()) {
            return "Chưa thêm giảng viên cho khóa học";
        }
        try {
            boolean rs_updateCourse = CourseDAL.updateCourse(new Course(CourseID, title, creditsInt, departmentID));
            OnsitecourseDAL.deleteOnsiteCourse(CourseID);
            OnlinecourseDAL.deleteOnlineCourse(CourseID);
            boolean rs_insertOnlineCourse = OnlinecourseDAL.insertOnlineCourse(new Onlinecourse(CourseID, url));
            CourseinstructorDAL.deleteCourseInstructorByCourseID(CourseID);
            boolean rs_insertConrseInstructor = true;
            for (Integer id : teacherIDs) {
                rs_insertConrseInstructor = CourseinstructorDAL
                        .insertCourseInstructor(new Courseinstructor(CourseID, id));
                if (!rs_insertConrseInstructor) {
                    break;
                }
            }
            if (!rs_updateCourse || !rs_insertOnlineCourse || !rs_insertConrseInstructor) {
                return "Thêm khóa học thất bại";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return "Cập nhật thành công";
    }

    // update onsite course
    public String updateCourse(int CourseID, String title, String credits, int departmentID, List<Integer> teacherIDs,
            String location, String days, String hour, String minute) {
        int creditsInt;
        Time startTime = null;
        if (checkDataIsEmpty(title) || checkDataIsEmpty(credits) || checkDataIsEmpty(location)
                || checkDataIsEmpty(days)) {
            return "Vui lòng nhập đầy đủ thông tin!";
        }
        try {
            creditsInt = Integer.parseInt(credits);
        } catch (NumberFormatException ex) {
            return "Tín chỉ phải ở dạng số nguyên";
        }
        try {
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(minute);
            startTime = new Time(h, m, 0);
        } catch (NumberFormatException ex) {
            System.err.println(ex);
        }
        if (teacherIDs.isEmpty()) {
            return "Chưa thêm giảng viên cho khóa học";
        }
        try {
            boolean rs_updateCourse = CourseDAL.updateCourse(new Course(CourseID, title, creditsInt, departmentID));
            OnsitecourseDAL.deleteOnsiteCourse(CourseID);
            OnlinecourseDAL.deleteOnlineCourse(CourseID);
            boolean rs_insertOnsiteCourse = OnsitecourseDAL
                    .insertOnsiteCourse(new Onsitecourse(CourseID, location, days, startTime));
            CourseinstructorDAL.deleteCourseInstructorByCourseID(CourseID);
            boolean rs_insertConrseInstructor = true;
            for (Integer id : teacherIDs) {
                rs_insertConrseInstructor = CourseinstructorDAL
                        .insertCourseInstructor(new Courseinstructor(CourseID, id));
                if (!rs_insertConrseInstructor) {
                    break;
                }
            }
            if (!rs_updateCourse || !rs_insertOnsiteCourse || !rs_insertConrseInstructor) {
                return "Cập nhật thất bại";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
        }

        return "Cập nhật thành công";
    }

    public List<HashMap<String, String>> getInfoCourseByIdTeacher(int teacherID) {
        List<HashMap<String, String>> infoCourse = new ArrayList<>();
        try {
            infoCourse = CourseDAL.getCourseByTeacherID(teacherID);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OfficeassignmentBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoCourse;
    }

    public String deleteCourse(int courseID) {
        try {
            List<Studentgrade> studentgrades = StudentgradeDAL.getStudentgradesByCourseID(courseID);
            if (!studentgrades.isEmpty()) {
                return "Khóa học đã tồn tại kết quả sinh viên, không được xóa";
            }
            OnlinecourseDAL.deleteOnlineCourse(courseID);
            OnsitecourseDAL.deleteOnsiteCourse(courseID);
            CourseinstructorDAL.deleteCourseInstructorByCourseID(courseID);
            boolean rs_deleteCourse = CourseDAL.deleteCourse(courseID);
            if (!rs_deleteCourse) {
                return "Xóa thất bại";
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Xóa thành công";
    }
}
