/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lemon.GUI.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.lemon.BLL.StudentgradeBLL;
import com.lemon.DAL.CourseDAL;
import com.lemon.DAL.PersonDAL;
import com.lemon.DTO.Course;
import com.lemon.DTO.Person;
import com.lemon.GUI.TestGraphics;

/**
 *
 * @author LAM
 */
public class StudentGradePL extends javax.swing.JPanel {

    /**
     * Creates new form PersonPL
     */
    public StudentGradePL() {
        initComponents();
        try {
            List<Course> courses = CourseDAL.getAllCourse();
            List<Person> students = PersonDAL.getAllPersonIsStudent();
            renderCbb_Course(courses);
            renderCbb_Student(students);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectedRowBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        studentCbb = new javax.swing.JComboBox<>();
        resultField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CourseCbb = new javax.swing.JComboBox<>();
        StudentField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nameCourseField = new javax.swing.JTextField();
        idStudentField = new javax.swing.JTextField();
        nameStudentField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idCourseField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        resultFieldConfirm = new javax.swing.JTextField();
        CourseField = new javax.swing.JTextField();
        insertBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(969, 322));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã sinh viên");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 32));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Kết quả");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 122, 32));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KẾT QUẢ SINH VIÊN");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 969, -1));

        selectedRowBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        selectedRowBtn.setText("XEM DÒNG ĐÃ CHỌN");
        selectedRowBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedRowBtnMouseClicked(evt);
            }
        });
        add(selectedRowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 160, 36));

        updateBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        updateBtn.setText("CHỈNH SỬA");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 100, 36));

        deleteBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        deleteBtn.setText("XÓA");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 100, 36));

        studentCbb.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studentCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentCbbActionPerformed(evt);
            }
        });
        add(studentCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 220, 30));

        resultField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultFieldActionPerformed(evt);
            }
        });
        resultField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                resultFieldKeyReleased(evt);
            }
        });
        add(resultField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, 32));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tên khóa học");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 32));

        CourseCbb.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CourseCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseCbbActionPerformed(evt);
            }
        });
        add(CourseCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 220, 30));

        StudentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentFieldActionPerformed(evt);
            }
        });
        StudentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StudentFieldKeyReleased(evt);
            }
        });
        add(StudentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, 32));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameCourseField.setEnabled(false);
        nameCourseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCourseFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameCourseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 160, 32));

        idStudentField.setEnabled(false);
        idStudentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idStudentFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idStudentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 160, 32));

        nameStudentField.setEnabled(false);
        nameStudentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameStudentFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameStudentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 160, 32));

        jLabel1.setText("Tên khóa học");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        idCourseField.setEnabled(false);
        idCourseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCourseFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idCourseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, 32));

        jLabel6.setText("Mã sinh viên");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setText("Tên sinh viên");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel8.setText("Mã khóa học");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("KIỂM TRA THÔNG TIN TẠI ĐÂY");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 20, 340, -1));

        jLabel10.setText("Kết quả");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        resultFieldConfirm.setText("-1");
        resultFieldConfirm.setEnabled(false);
        resultFieldConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultFieldConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(resultFieldConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 160, 32));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 280, 300));

        CourseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseFieldActionPerformed(evt);
            }
        });
        CourseField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CourseFieldKeyReleased(evt);
            }
        });
        add(CourseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, 32));

        insertBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        insertBtn.setText("THÊM");
        insertBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertBtnMouseClicked(evt);
            }
        });
        add(insertBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 100, 36));
    }// </editor-fold>//GEN-END:initComponents

    private void renderCbb_Course(List<Course> courses) {
        CourseCbb.removeAllItems();
        for (Course course : courses) {
            CourseCbb.addItem(String.valueOf(course.getCourseID()) + " - " + String.valueOf(course.getTitle()));
        }

    }

    private void renderCbb_Student(List<Person> students) {
        studentCbb.removeAllItems();
        for (Person student : students) {
            studentCbb.addItem(String.valueOf(student.getPersonID()) + " - " + String.valueOf(student.getLastName())
                    + " " + String.valueOf(student.getFirstName()));
        }
    }

    private void nameCourseFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nameCourseFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_nameCourseFieldActionPerformed

    private void resultFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_resultFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_resultFieldActionPerformed

    private void StudentFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_StudentFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_StudentFieldActionPerformed

    private void CourseFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CourseFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_CourseFieldActionPerformed

    private void idStudentFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idStudentFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_idStudentFieldActionPerformed

    private void nameStudentFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nameStudentFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_nameStudentFieldActionPerformed

    private void idCourseFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idCourseFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_idCourseFieldActionPerformed

    private void CourseFieldKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_CourseFieldKeyReleased
        List<Course> courses = new StudentgradeBLL().searchCourse(CourseField.getText());
        if (!courses.isEmpty()) {
            renderCbb_Course(courses);
        } else {
            CourseCbb.removeAllItems();
            CourseCbb.addItem("Không có");
        }

    }// GEN-LAST:event_CourseFieldKeyReleased

    private void StudentFieldKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_StudentFieldKeyReleased
        List<Person> students = new StudentgradeBLL().searchStudent(StudentField.getText());
        if (!students.isEmpty()) {
            renderCbb_Student(students);
        } else {
            studentCbb.removeAllItems();
            studentCbb.addItem("Không có");
        }
    }// GEN-LAST:event_StudentFieldKeyReleased

    private int getID_FromCbb(String str) {
        int indexFirstSpace = str.indexOf(" - ");
        return Integer.parseInt(str.substring(0, indexFirstSpace));
    }

    private String getName_FromCbb(String str) {
        int indexFirstSpace = str.indexOf(" - ");
        return String.valueOf(str.substring(indexFirstSpace + 3));
    }

    private void CourseCbbActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CourseCbbActionPerformed
        try {
            String selectedCourse = String.valueOf(CourseCbb.getSelectedItem());
            idCourseField.setText(String.valueOf(getID_FromCbb(selectedCourse)));
            nameCourseField.setText(getName_FromCbb(selectedCourse));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }// GEN-LAST:event_CourseCbbActionPerformed

    private void resultFieldConfirmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_resultFieldConfirmActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_resultFieldConfirmActionPerformed

    private void studentCbbActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_studentCbbActionPerformed
        try {
            String selectedStudent = String.valueOf(studentCbb.getSelectedItem());
            idStudentField.setText(String.valueOf(getID_FromCbb(selectedStudent)));
            nameStudentField.setText(getName_FromCbb(selectedStudent));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }// GEN-LAST:event_studentCbbActionPerformed

    private void resultFieldKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_resultFieldKeyReleased
        try {
            double rs = Double.parseDouble(resultField.getText());
            resultFieldConfirm.setText(String.valueOf(rs));
        } catch (NumberFormatException ex) {
            resultFieldConfirm.setText("-1");
        }
    }// GEN-LAST:event_resultFieldKeyReleased

    private void selectedRowBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_selectedRowBtnMouseClicked
        List<String> data = MyTable.data;
        if (!data.isEmpty()) {
            String courseID = data.get(1);
            String studentID = data.get(2);
            String result = String.valueOf(data.get(3));
            for (int i = 0; i < CourseCbb.getItemCount(); i++) {
                if (courseID.equals(String.valueOf(CourseCbb.getItemAt(i)))) {
                    CourseCbb.setSelectedItem(CourseCbb.getItemAt(i));
                }
            }
            for (int i = 0; i < studentCbb.getItemCount(); i++) {
                if (studentID.equals(String.valueOf(studentCbb.getItemAt(i)))) {
                    studentCbb.setSelectedItem(studentCbb.getItemAt(i));
                }
            }
            resultFieldConfirm.setText(result.equals("Chưa có kết quả") ? "-1" : result);
        } else {
            JOptionPane.showConfirmDialog(null, data, "Chưa có dòng được chọn", JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_selectedRowBtnMouseClicked

    private void insertBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_insertBtnMouseClicked
        String courseID = idCourseField.getText();
        String studentID = idStudentField.getText();
        String result = resultFieldConfirm.getText();
        String rs_insertStudentGrade = new StudentgradeBLL().insertStudentGrade(courseID, studentID, result);
        JOptionPane.showConfirmDialog(null, rs_insertStudentGrade, "Kết quả",
                rs_insertStudentGrade.equals("Thêm thành công") ? JOptionPane.INFORMATION_MESSAGE
                        : JOptionPane.ERROR_MESSAGE);
        if (rs_insertStudentGrade.equals("Thêm thành công")) {
            TestGraphics.search();
        }
    }// GEN-LAST:event_insertBtnMouseClicked

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_updateBtnMouseClicked
        String courseID = idCourseField.getText();
        String studentID = idStudentField.getText();
        String result = resultFieldConfirm.getText();
        List<String> data = MyTable.data;
        String courseIDnow = String.valueOf(getID_FromCbb(data.get(1)));
        String studentIDnow = String.valueOf(getID_FromCbb(data.get(2)));
        if (data.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Chưa có dòng được chọn", "Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int enrollmentID = Integer.parseInt(data.get(0));
        int rs_Confirm = JOptionPane.showConfirmDialog(null,
                "Bạn đang thực hiện cập nhật trên dòng có mã đăng kí: " + enrollmentID, "", JOptionPane.YES_NO_OPTION);
        if (rs_Confirm != 0) {
            return;
        }
        String rs_updateStudentGrade = new StudentgradeBLL().updateStudentGrade(courseIDnow, studentIDnow,
                Integer.parseInt(data.get(0)), courseID, studentID, result);
        JOptionPane.showConfirmDialog(null, rs_updateStudentGrade, "Kết quả",
                rs_updateStudentGrade.equals("Cập nhật thành công") ? JOptionPane.INFORMATION_MESSAGE
                        : JOptionPane.ERROR_MESSAGE);
        if (rs_updateStudentGrade.equals("Cập nhật thành công")) {
            TestGraphics.search();
        }
    }// GEN-LAST:event_updateBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteBtnMouseClicked
        List<String> data = MyTable.data;
        if (data.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Chưa có dòng được chọn", "Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int enrollmentID = Integer.parseInt(data.get(0));
        double result;
        try {
            result = Double.parseDouble(data.get(3));
        } catch (NumberFormatException ex) {
            result = -1;
        }
        int rs_Confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa dòng có mã đăng kí: " + enrollmentID,
                "", JOptionPane.YES_NO_OPTION);
        if (rs_Confirm != 0) {
            return;
        }
        String rs_deleteStudentGrade = new StudentgradeBLL().deleteStudentGrade(enrollmentID, result);
        JOptionPane.showConfirmDialog(null, rs_deleteStudentGrade, "Kết quả",
                rs_deleteStudentGrade.equals("Xóa thành công") ? JOptionPane.INFORMATION_MESSAGE
                        : JOptionPane.ERROR_MESSAGE);
        if (rs_deleteStudentGrade.equals("Xóa thành công")) {
            TestGraphics.search();
        }
    }// GEN-LAST:event_deleteBtnMouseClicked

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CourseCbb;
    private javax.swing.JTextField CourseField;
    private javax.swing.JTextField StudentField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField idCourseField;
    private javax.swing.JTextField idStudentField;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameCourseField;
    private javax.swing.JTextField nameStudentField;
    private javax.swing.JTextField resultField;
    private javax.swing.JTextField resultFieldConfirm;
    private javax.swing.JButton selectedRowBtn;
    private javax.swing.JComboBox<String> studentCbb;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
