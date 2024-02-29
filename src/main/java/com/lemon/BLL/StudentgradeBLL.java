/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.BLL;

import com.lemon.DAL.CourseDAL;
import com.lemon.DAL.PersonDAL;
import com.lemon.DAL.StudentgradeDAL;
import com.lemon.DTO.Course;
import com.lemon.DTO.Person;
import com.lemon.DTO.Studentgrade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAM
 */
public class StudentgradeBLL {

    public List<Studentgrade> getAllStudentGrade() {
        try {
            return StudentgradeDAL.getAllStudentGrades();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentgradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //search 
    public String convertField(int filter) {
        return filter == 1 ? "EnrollmentID"
                : filter == 2 ? "CourseID"
                        : filter == 3 ? "StudentID"
                                : filter == 4 ? "Grade" : "";
    }

    public List<Studentgrade> searchStudentGrade(String searchField, int sortOption, int filter) {
        List<Studentgrade> listStudentGrade = new ArrayList<>();
        String sort = sortOption == 0 ? "ASC" : "DESC";
        String sql = "select * from studentgrade join course on course.courseID = studentgrade.CourseID"
                + " join person on person.PersonID = studentgrade.StudentID ";
        String columnFilter = convertField(filter);
        if (columnFilter.equals("")) {
            sql
                    += "where EnrollmentID like '%" + searchField + "%' or "
                    + " Concat(course.CourseID, ' - ', course.Title) like '%" + searchField + "%' or "
                    + " Concat(person.PersonID, ' - ', person.Lastname, person.Firstname) like '%" + searchField + "%' or "
                    + " Grade like '%" + searchField + "%' group by EnrollmentID order by EnrollmentID " + sort;
        } else {
            if (columnFilter.equals("CourseID")) {
                sql += "where Concat(course.CourseID, ' - ', course.Title) like '%" + searchField + "%' group by EnrollmentID order by " + columnFilter + " " + sort;
            } else if (columnFilter.equals("StudentID")) {
                sql += "where Concat(person.PersonID, ' - ', person.Lastname, person.Firstname) like '%" + searchField + "%' group by EnrollmentID order by " + columnFilter + " " + sort;
            } else {
                sql += "where " + columnFilter + " like '%" + searchField + "%' group by EnrollmentID order by " + columnFilter + " " + sort;
            }
        }
        try {
            listStudentGrade = StudentgradeDAL.searchStudentGrades(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentgradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);
        return listStudentGrade;
    }

    public List<Course> searchCourse(String keySearch) {
        String sql = "select * from course where Concat(CourseID, ' - ', Title) like '%" + keySearch + "%'" + " OR Title like '%" + keySearch + "%'";
        try {
            return CourseDAL.getCourseBySearch(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentgradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Person> searchStudent(String keySearch) {
        String sql = "select * from person where HireDate is null and (Concat(PersonID, ' - ', Lastname, Firstname) like '%" + keySearch + "%'" + " OR CONCAT(Lastname, ' ', Firstname) like '%" + keySearch + "%')";
        try {
            return PersonDAL.getStudentBySearch(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentgradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkDataIsEmpty(String data) {
        return data.length() <= 0 || data.equals(" ");
    }

    public String insertStudentGrade(String courseID, String studentID, String result) {
        int courseID_Int, studentID_Int;
        double result_Double;
        if (checkDataIsEmpty(courseID) || checkDataIsEmpty(studentID) || checkDataIsEmpty(result)) {
            return "Vui lòng kiểm tra lại thông tin";
        }
        try {
            courseID_Int = Integer.parseInt(courseID);
            studentID_Int = Integer.parseInt(studentID);
        } catch (NumberFormatException ex) {
            return "Mã khóa học, mã sinh viên phải là số nguyên";
        }
        try {
            result_Double = Double.parseDouble(result);
        } catch (NumberFormatException ex) {
            return "Kết quả phải ở dạng số";
        }
        if (courseID_Int <= 0 || studentID_Int <= 0) {
            return "Mã khóa học, mã sinh viên không được < 0";
        }
        if ((result_Double < 0 || result_Double > 10) && result_Double != -1) {
            return "Kết quả phải nằm trong khoảng từ 0 - 10, hoặc -1 (Giá trị khởi tạo)";
        }
        try {
            boolean rs_insertStudentGrade = StudentgradeDAL.insertStudentGrade(new Studentgrade(courseID_Int, studentID_Int, result_Double));
            if (!rs_insertStudentGrade) {
                return "Dữ liệu đã tồn tại, vui lòng chỉnh sửa";
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
        return "Thêm thành công";
    }

    public String updateStudentGrade(String courseIDnow, String studentIDnow, int enrollmentID, String courseID, String studentID, String result) {
        int courseID_Int, studentID_Int;
        double result_Double;
        if (checkDataIsEmpty(courseID) || checkDataIsEmpty(studentID) || checkDataIsEmpty(result)) {
            return "Vui lòng kiểm tra lại thông tin";
        }
        if(!courseIDnow.equals(courseID) || !studentIDnow.equals(studentID)){
            return "Bạn chỉ có thể cập nhật điểm của sinh viên";
        }
        try {
            courseID_Int = Integer.parseInt(courseID);
            studentID_Int = Integer.parseInt(studentID);
        } catch (NumberFormatException ex) {
            return "Mã khóa học, mã sinh viên phải là số nguyên";
        }
        try {
            result_Double = Double.parseDouble(result);
        } catch (NumberFormatException ex) {
            return "Kết quả phải ở dạng số";
        }
        if (courseID_Int <= 0 || studentID_Int <= 0) {
            return "Mã khóa học, mã sinh viên ";
        }
        if ((result_Double < 0 || result_Double > 10)) {
            return "Kết quả phải nằm trong khoảng từ 0 - 10";
        }
        try {
            boolean rs_updateStudentGrade = StudentgradeDAL.updateStudentGrade(new Studentgrade(enrollmentID, courseID_Int, studentID_Int, result_Double));
            if (!rs_updateStudentGrade) {
                return "Cập nhật thất bại";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentgradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Cập nhật thành công";
    }

    public String deleteStudentGrade(int enrollmentID, double result) {
        if(result != -1){
            return "Bạn không thể xóa sinh viên đã có kết quả";
        }
        try {
            boolean rs_deleteStudentGrade = StudentgradeDAL.deleteStudentGrade(enrollmentID);
            if (!rs_deleteStudentGrade) {
                return "Xóa thất bại";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentgradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Xóa thành công";
    }
}
