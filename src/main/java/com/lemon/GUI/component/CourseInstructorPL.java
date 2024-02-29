/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lemon.GUI.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.lemon.BLL.CourseBLL;
import com.lemon.BLL.CourseinstructorBLL;
import com.lemon.BLL.OfficeassignmentBLL;
import com.lemon.DTO.Officeassignment;
import com.lemon.DTO.Person;
import com.lemon.GUI.TestGraphics;

/**
 *
 * @author LAM
 */
public class CourseInstructorPL extends javax.swing.JPanel {

    private boolean evClickTable = true;

    public CourseInstructorPL() {
        initComponents();
        locationDepartment.setEnabled(false);
        setUpDate.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        saveUpdate = new javax.swing.JButton();
        locationDepartment = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        setUpDate = new com.toedter.calendar.JDateChooser();
        selectedTeacher = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInfoCourse = new javax.swing.JTable();
        lbCourseTitle = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(969, 322));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("THÔNG TIN PHÒNG BAN VÀ CÁC KHÓA HỌC CỦA GIẢNG VIÊN");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 969, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveUpdate.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        saveUpdate.setText("LƯU CẬP NHẬT");
        saveUpdate.setEnabled(false);
        saveUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveUpdateMouseClicked(evt);
            }
        });
        jPanel1.add(saveUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 130, 36));

        locationDepartment.setEnabled(false);
        jPanel1.add(locationDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ngày thành lập");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 32));

        setUpDate.setDateFormatString("yyyy-MM-dd");
        setUpDate.setEnabled(false);
        jPanel1.add(setUpDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 180, 30));

        selectedTeacher.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        selectedTeacher.setText("XEM DÒNG ĐÃ CHỌN");
        selectedTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedTeacherMouseClicked(evt);
            }
        });
        jPanel1.add(selectedTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 170, 36));

        update.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        update.setText("CẬP NHẬT");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 100, 36));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Địa điểm phòng ban");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 32));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 980, 120));

        tableInfoCourse.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null }
                },
                new String[] {
                        "Mã khóa học", "Tên khóa học", "Số tín chỉ", "Phòng ban", "Online/Onsite", "Đường dẫn/Địa điểm",
                        "Ngày học", "Giờ học"
                }));
        tableInfoCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInfoCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableInfoCourse);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 980, 170));

        lbCourseTitle.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbCourseTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lbCourseTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 980, 40));
    }// </editor-fold>//GEN-END:initComponents

    public void resetTable(DefaultTableModel model) {
        evClickTable = true;
        lbCourseTitle.setVisible(false);
        model.setRowCount(0);
        model.setColumnCount(0);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }

    private void selectedTeacherMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_selectedTeacherMouseClicked
        List<String> data = MyTable.data;
        if (data.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Chưa có dòng được chọn", "Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int teacherID = Integer.parseInt(data.get(0));

        Officeassignment officeassignment = new OfficeassignmentBLL().getOfficeAssignment(teacherID);
        if (officeassignment != null) {
            locationDepartment.setText(officeassignment.getLocation());
            setUpDate.setDate(officeassignment.getTimestamp());
        }
        List<HashMap<String, String>> infoCourses = new CourseBLL().getInfoCourseByIdTeacher(teacherID);
        if (infoCourses != null) {
            DefaultTableModel model = (DefaultTableModel) tableInfoCourse.getModel();
            resetTable(model);
            model.addColumn("Mã khóa học");
            model.addColumn("Tên khóa học");
            model.addColumn("Số tín chỉ");
            model.addColumn("Phòng ban");
            model.addColumn("Onsite/Online");
            model.addColumn("Đường dẫn/Địa điểm");
            model.addColumn("Ngày học");
            model.addColumn("Giờ học");
            for (HashMap<String, String> course : infoCourses) {
                String url = course.get("url");
                if (url.equals("null")) {
                    model.addRow(new Object[] { course.get("CourseID"), course.get("Title"), course.get("Credits"),
                            course.get("Department"),
                            "Onsite", course.get("Location"), course.get("Days"), course.get("Time") });
                } else {
                    model.addRow(new Object[] { course.get("CourseID"), course.get("Title"), course.get("Credits"),
                            course.get("Department"), "Online", course.get("url"), "Không có", "Không có" });
                }
            }
        }
    }// GEN-LAST:event_selectedTeacherMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_updateMouseClicked
        locationDepartment.setEnabled(true);
        setUpDate.setEnabled(true);
        saveUpdate.setEnabled(true);
    }// GEN-LAST:event_updateMouseClicked

    private void saveUpdateMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_saveUpdateMouseClicked
        saveUpdate.setEnabled(false);
        List<String> data = MyTable.data;
        if (data.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Chưa có dòng được chọn", "Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int teacherID = Integer.parseInt(data.get(0));
        int rs_Confirm = JOptionPane.showConfirmDialog(null,
                "Bạn đang thực hiện cập nhật thông tin đối với giảng viên có ID: " + teacherID, "",
                JOptionPane.YES_NO_OPTION);
        if (rs_Confirm != 0) {
            return;
        }
        String rs_saveUpdate = new OfficeassignmentBLL().updateOfficeAssignment(
                new Officeassignment(teacherID, locationDepartment.getText(), setUpDate.getDate()));
        JOptionPane.showMessageDialog(null, rs_saveUpdate, "Kết quả",
                rs_saveUpdate.equals("Cập nhật thành công") ? JOptionPane.INFORMATION_MESSAGE
                        : JOptionPane.ERROR_MESSAGE);
        if (!rs_saveUpdate.equals("Cập nhật thành công")) {
            return;
        }
        Officeassignment officeassignment = new OfficeassignmentBLL().getOfficeAssignment(teacherID);
        if (officeassignment != null) {
            locationDepartment.setText(officeassignment.getLocation());
            setUpDate.setDate(officeassignment.getTimestamp());
        }
        locationDepartment.setEnabled(false);
        setUpDate.setEnabled(false);
        TestGraphics.search();
    }// GEN-LAST:event_saveUpdateMouseClicked

    private void loadListStudentInCourse(int courseID) {
        lbCourseTitle.setVisible(true);
        lbCourseTitle.setText("Mã khóa học: " + courseID);
        DefaultTableModel model = (DefaultTableModel) tableInfoCourse.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.addColumn("Mã sinh viên");
        model.addColumn("Họ tên sinh viên");
        model.addColumn("Ngày đăng kí");
        List<Person> students = new CourseinstructorBLL().getStudentsInCourse(courseID);
        if (students.isEmpty()) {
            model.addRow(new Object[] { "", "Chưa có sinh viên nào", "" });
        } else {
            for (Person student : students) {
                model.addRow(new Object[] { student.getPersonID(),
                        student.getLastName() + " - " + student.getFirstName(), student.getEnrollmentDate() });
            }
        }
        evClickTable = false;
    }

    private void tableInfoCourseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableInfoCourseMouseClicked
        if (!evClickTable) {
            return;
        }
        int selectedRow = tableInfoCourse.getSelectedRow();
        if (selectedRow >= 0) {
            loadListStudentInCourse(Integer.parseInt((String) tableInfoCourse.getValueAt(selectedRow, 0)));
        }
    }// GEN-LAST:event_tableInfoCourseMouseClicked

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCourseTitle;
    private javax.swing.JTextField locationDepartment;
    private javax.swing.JButton saveUpdate;
    private javax.swing.JButton selectedTeacher;
    private com.toedter.calendar.JDateChooser setUpDate;
    private javax.swing.JTable tableInfoCourse;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
