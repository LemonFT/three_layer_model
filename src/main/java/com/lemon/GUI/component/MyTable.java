/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lemon.GUI.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.lemon.BLL.CourseBLL;
import com.lemon.BLL.CourseinstructorBLL;
import com.lemon.BLL.OnlinecourseBLL;
import com.lemon.BLL.PersonBLL;
import com.lemon.DAL.DTO.Course;
import com.lemon.DAL.DTO.Courseinstructor;
import com.lemon.DAL.DTO.Onlinecourse;
import com.lemon.DAL.DTO.Person;
import com.lemon.DAL.DTO.Studentgrade;
import com.lemon.GUI.TestGraphics;
import com.lemon.GUI.tablecustom.TableCustom;

/**
 *
 * @author LAM
 */
public class MyTable extends javax.swing.JPanel {

    public static List<String> data = new ArrayList<>();

    public MyTable() {
        initComponents();
        setOpaque(false);
    }

    public static boolean check_Online_or_Onsite_Course(int id, List<Onlinecourse> listOnlineCourse) {
        for (Onlinecourse oC : listOnlineCourse) {
            if (id == oC.getCourseID()) {
                return true;
            }
        }
        return false;
    }

    public static String check_Id_Teacher(int id, List<Courseinstructor> listCourseInstructor) {
        StringBuilder IdStrBuilder = new StringBuilder();
        for (Courseinstructor cI : listCourseInstructor) {
            if (id == cI.getCourseID()) {
                IdStrBuilder.append(cI.getPersonID()).append(" - ");
            }
        }
        if (IdStrBuilder.length() > 0) {
            IdStrBuilder.setLength(IdStrBuilder.length() - 3);
        }
        return IdStrBuilder.toString();

    }

    public static void resetTable(DefaultTableModel model) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }

    public static void loadCourseToTable(List<Course> listCourse) throws ClassNotFoundException, SQLException {
        List<Onlinecourse> listOnlineCourse = new OnlinecourseBLL().getAllOnlineCourses();
        List<Courseinstructor> listCourseInstructor = new CourseinstructorBLL().getAllCourseInstructors();
        int typeCourse = TestGraphics.typeCourseCbb.getSelectedIndex();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        resetTable(model);
        model.addColumn("Mã khóa học");
        model.addColumn("Tên khóa học");
        model.addColumn("Số tín chỉ");
        model.addColumn("Onsite/Online");
        model.addColumn("Mã phòng ban");
        model.addColumn("Mã giảng viên");
        switch (typeCourse) {
            case 0 -> {
                for (Course course : listCourse) {
                    int idCourse = course.getCourseID();
                    boolean isOnlineCourse = check_Online_or_Onsite_Course(idCourse, listOnlineCourse);
                    String idTeachers = check_Id_Teacher(idCourse, listCourseInstructor);
                    if (!idTeachers.equals("")) {
                        model.addRow(new Object[] { idCourse, course.getTitle(), course.getCredits(),
                                isOnlineCourse ? "Online" : "Onsite", course.getDepartmentID(),
                                !idTeachers.equals("") ? idTeachers : "Chưa có" });
                    }
                }
            }
            case 1 -> {
                for (Course course : listCourse) {
                    System.err.println("case 1");
                    int idCourse = course.getCourseID();
                    boolean isOnlineCourse = check_Online_or_Onsite_Course(idCourse, listOnlineCourse);
                    String idTeachers = check_Id_Teacher(idCourse, listCourseInstructor);
                    if (!idTeachers.equals("") && !isOnlineCourse) {
                        model.addRow(new Object[] { idCourse, course.getTitle(), course.getCredits(),
                                isOnlineCourse ? "Online" : "Onsite", course.getDepartmentID(),
                                !idTeachers.equals("") ? idTeachers : "Chưa có" });
                    }
                }
            }
            default -> {
                for (Course course : listCourse) {
                    System.err.println("case 2");
                    int idCourse = course.getCourseID();
                    boolean isOnlineCourse = check_Online_or_Onsite_Course(idCourse, listOnlineCourse);
                    String idTeachers = check_Id_Teacher(idCourse, listCourseInstructor);
                    if (!idTeachers.equals("") && isOnlineCourse) {
                        model.addRow(new Object[] { idCourse, course.getTitle(), course.getCredits(),
                                isOnlineCourse ? "Online" : "Onsite", course.getDepartmentID(),
                                !idTeachers.equals("") ? idTeachers : "Chưa có" });
                    }
                }
            }
        }
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    public static void loadTeachersToTable(List<Person> teachers) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        resetTable(model);
        model.addColumn("Mã giảng viên");
        model.addColumn("Họ tên giảng viên");
        model.addColumn("Ngày bắt đầu làm việc");
        if (!teachers.isEmpty()) {
            for (Person teacher : teachers) {
                model.addRow(new Object[] { teacher.getPersonID(), teacher.getLastName() + " " + teacher.getFirstName(),
                        teacher.getHireDate() });
            }
        }
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    public static String getID_NameStudent(int studentID, List<Person> students) {

        for (Person student : students) {
            if (student.getPersonID() == studentID) {
                return studentID + " - " + student.getLastName() + " " + student.getFirstName();
            }
        }
        return "";
    }

    public static String getID_NameCourse(int courseID, List<Course> courses) {

        for (Course course : courses) {
            if (course.getCourseID() == courseID) {
                return courseID + " - " + course.getTitle();
            }
        }
        return "";
    }

    public static void loadStudentGradeToTable(List<Studentgrade> listStudentGrade)
            throws ClassNotFoundException, SQLException {
        List<Course> courses = new CourseBLL().getAllCourse();
        List<Person> students = new PersonBLL().getAllPersonIsStudent();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        resetTable(model);
        model.addColumn("Mã đăng kí");
        model.addColumn("Mã khóa học");
        model.addColumn("Mã sinh viên");
        model.addColumn("Kết quả");
        if (!listStudentGrade.isEmpty()) {
            for (Studentgrade studentgrade : listStudentGrade) {
                String infoCourse = getID_NameCourse(studentgrade.getCourseID(), courses);
                String infoStudent = getID_NameStudent(studentgrade.getStudentID(), students);
                if (!infoCourse.equals("") && !infoStudent.equals("")) {
                    model.addRow(new Object[] { studentgrade.getEnrollmentID(), infoCourse, infoStudent,
                            studentgrade.getGrade() == -1 ? "Chưa có kết quả" : studentgrade.getGrade() });
                }
            }
        }
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {

                }));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableMouseClicked
        int rowSelected = table.getSelectedRow();
        if (data != null) {
            data.clear();
        }
        if (rowSelected >= 0) {
            int columnCount = table.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                data.add(String.valueOf(table.getValueAt(rowSelected, i)));
            }
        }
    }// GEN-LAST:event_tableMouseClicked

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
