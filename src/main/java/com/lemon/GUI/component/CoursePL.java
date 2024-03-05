package com.lemon.GUI.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.lemon.BLL.CourseBLL;
import com.lemon.DAL.CourseDAL;
import com.lemon.DAL.DTO.Department;
import com.lemon.DAL.DTO.Onlinecourse;
import com.lemon.DAL.DTO.Onsitecourse;
import com.lemon.DAL.DepartmentDAL;
import com.lemon.DAL.OnlinecourseDAL;
import com.lemon.DAL.OnsitecourseDAL;
import com.lemon.DAL.PersonDAL;
import com.lemon.DAL.DTO.Person;

import com.lemon.GUI.TestGraphics;

/**
 *
 * @author LAM
 */
public class CoursePL extends javax.swing.JPanel {

    private boolean initialized = false;
    private List<String> listTeachers = new ArrayList<>();

    public CoursePL() {
        initComponents();
        try {
            renderCbb_Teacher();
            renderCbb_Department();
            initialized = true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CoursePL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameCourseField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        insertCourseBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        departmentCbb = new javax.swing.JComboBox<>();
        updateCourseBtn = new javax.swing.JButton();
        typeCourse_Cbb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        url = new javax.swing.JLabel();
        urlOrLocationField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        days = new javax.swing.JLabel();
        daysField = new javax.swing.JTextField();
        startTime = new javax.swing.JLabel();
        timePL = new javax.swing.JPanel();
        hourField = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        minuteField = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        creditsField = new javax.swing.JTextField();
        teachersCbb = new javax.swing.JComboBox<>();
        selectedRow = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        selectedTeachers = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1179, 758));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(nameCourseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 230, 32));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Onsite/Online");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 100, 32));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã phòng ban");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 32));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giảng viên");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 32));

        insertCourseBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        insertCourseBtn.setText("THÊM KHÓA HỌC MỚI");
        insertCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertCourseBtnMouseClicked(evt);
            }
        });
        add(insertCourseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 190, 36));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("THÊM KHÓA HỌC");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 969, -1));

        departmentCbb.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(departmentCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 230, 32));

        updateCourseBtn.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        updateCourseBtn.setText("CẬP NHẬT DÒNG ĐÃ CHỌN");
        updateCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateCourseBtnMouseClicked(evt);
            }
        });
        add(updateCourseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 190, 36));

        typeCourse_Cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Onsite", "Online" }));
        typeCourse_Cbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCourse_CbbActionPerformed(evt);
            }
        });
        add(typeCourse_Cbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 230, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tên khóa học");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 32));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        url.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        url.setText("Vị trí");
        jPanel1.add(url, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 80, 32));
        jPanel1.add(urlOrLocationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 230, 32));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CHI TIẾT KHÓA HỌC");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 320, -1));

        days.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        days.setText("Ngày học");
        jPanel1.add(days, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 80, 32));
        jPanel1.add(daysField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 230, 32));

        startTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        startTime.setText("Giờ bắt đầu");
        jPanel1.add(startTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 90, 32));

        timePL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hourField.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
                        "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "23" }));
        timePL.add(hourField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 30));

        jLabel1.setText("HH");
        timePL.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 30));

        minuteField.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
                        "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                        "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
                        "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        timePL.add(minuteField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 70, 30));

        jLabel9.setText("MM");
        timePL.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 30));

        jPanel1.add(timePL, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 230, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 350, 190));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Số tín chỉ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 81, 32));
        add(creditsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 230, 32));

        teachersCbb.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        teachersCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teachersCbbActionPerformed(evt);
            }
        });
        add(teachersCbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 230, 32));

        selectedRow.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        selectedRow.setText("XEM DÒNG  ĐÃ CHỌN");
        selectedRow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedRowMouseClicked(evt);
            }
        });
        selectedRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedRowActionPerformed(evt);
            }
        });
        add(selectedRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, -1, 36));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel10.setText("DANH SÁCH GIẢNG VIÊN CHO KHÓA HỌC");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        selectedTeachers.setEnabled(false);
        add(selectedTeachers, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 230, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jButton1.setText("LÀM MỚI ");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 190, 30));

        btnDelete.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        btnDelete.setText("XÓA DÒNG ĐÃ CHỌN");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 190, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnDeleteMouseClicked
        List<String> data = MyTable.data;
        int courseID = Integer.parseInt(data.get(0));
        int rs_Confirm = JOptionPane.showConfirmDialog(null, "Bạn đang thực hiện xóa khóa học có ID: " + courseID, "",
                JOptionPane.YES_NO_OPTION);
        if (rs_Confirm != 0) {
            return;
        }
        String result = new CourseBLL().deleteCourse(courseID);
        JOptionPane.showConfirmDialog(null, result, "Message",
                result.equals("Xóa thành công") ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        if (result.equals("Xóa thành công")) {
            TestGraphics.search();
        }
    }// GEN-LAST:event_btnDeleteMouseClicked

    private void renderCbb_Teacher() throws ClassNotFoundException, SQLException {
        List<Person> teachers = PersonDAL.getPersonIsTeacher();
        teachersCbb.removeAllItems();
        for (Person teacher : teachers) {
            teachersCbb.addItem(String
                    .valueOf(teacher.getPersonID() + " - " + teacher.getLastName() + " " + teacher.getFirstName()));
        }
    }

    private void renderCbb_Department() throws ClassNotFoundException, SQLException {
        List<Department> departments = DepartmentDAL.getAllDepartment();
        departmentCbb.removeAllItems();
        for (Department department : departments) {
            departmentCbb.addItem(String.valueOf(department.getDepartmentID() + " - " + department.getName()));
        }
    }

    private int getID_FromCbb(String str) {
        int indexFirstSpace = str.indexOf(" - ");
        return Integer.parseInt(str.substring(0, indexFirstSpace));
    }

    private void selectCbb_Departmemt(String value) {
        List<Department> departments = new ArrayList<>();
        try {
            departments = DepartmentDAL.getAllDepartment();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CoursePL.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Department department : departments) {
            if (department.getDepartmentID() == Integer.parseInt(value)) {
                teachersCbb
                        .setSelectedItem(String.valueOf(department.getDepartmentID() + " - " + department.getName()));
                return;
            }
        }
    }

    private void typeCourse_CbbActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_typeCourse_CbbActionPerformed
        String itemSelected = String.valueOf(typeCourse_Cbb.getSelectedItem());
        if (itemSelected.equals("Online")) {
            url.setText("Đường dẫn");
            days.setVisible(false);
            daysField.setVisible(false);
            startTime.setVisible(false);
            timePL.setVisible(false);
        } else {
            url.setText("Vị trí");
            days.setVisible(true);
            daysField.setVisible(true);
            startTime.setVisible(true);
            timePL.setVisible(true);
        }
    }// GEN-LAST:event_typeCourse_CbbActionPerformed

    private void insertCourse_Option_OnsiteCourse() {
        String nameCourse = nameCourseField.getText();
        String credits = creditsField.getText();
        String urlCourse = urlOrLocationField.getText();
        String dayStr = daysField.getText();
        String hour = String.valueOf(hourField.getSelectedItem());
        String minute = String.valueOf(minuteField.getSelectedItem());
        int departmentID = getID_FromCbb(String.valueOf(departmentCbb.getSelectedItem()));
        String result = new CourseBLL().insertCourse(nameCourse, credits, departmentID, getValueSelectedTeachers(),
                urlCourse, dayStr, hour, minute);
        JOptionPane.showMessageDialog(null, result, "Message",
                result.equals("Thêm thành công") ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

    private void insertCourse_Option_OnlineCourse() {
        String nameCourse = nameCourseField.getText();
        String credits = creditsField.getText();
        String urlCourse = urlOrLocationField.getText();
        int departmentID = getID_FromCbb(String.valueOf(departmentCbb.getSelectedItem()));
        String result = new CourseBLL().insertCourse(nameCourse, credits, departmentID, getValueSelectedTeachers(),
                urlCourse);
        JOptionPane.showMessageDialog(null, result, "Message",
                result.equals("Thêm thành công") ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        if (result.equals("Thêm thành công")) {
            try {
                MyTable.loadCourseToTable(CourseDAL.getAllCourse());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CoursePL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void insertCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {
        if (typeCourse_Cbb.getSelectedIndex() == 0) {
            insertCourse_Option_OnsiteCourse();
        } else {
            insertCourse_Option_OnlineCourse();
        }
        TestGraphics.search();
    }

    private void updateListTeacher(String str) {
        listTeachers.clear();
        listTeachers = convertStringToList(str);
    }

    private void selectedRowMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_selectedRowMouseClicked
        List<String> data = MyTable.data;
        updateListTeacher(data.get(5));
        if (data != null) {
            int courseID = Integer.parseInt(data.get(0));
            nameCourseField.setText(data.get(1));
            creditsField.setText(data.get(2));
            typeCourse_Cbb.setSelectedItem(data.get(3));
            selectCbb_Departmemt(data.get(4));
            selectedTeachers.setText(data.get(5));
            if ("Online".equals(data.get(3))) {
                try {
                    Onlinecourse onlineCourse = OnlinecourseDAL.getOnlineCourseByID(courseID);
                    if (onlineCourse != null) {
                        urlOrLocationField.setText(onlineCourse.getUrl());

                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(CoursePL.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Onsitecourse onsiteCourse = OnsitecourseDAL.getOnsiteCourseByID(courseID);
                    if (onsiteCourse != null) {
                        urlOrLocationField.setText(onsiteCourse.getLocation());
                        daysField.setText(onsiteCourse.getDays());
                        hourField.setSelectedItem(
                                onsiteCourse.getTime().getHours() < 10 ? "0" + onsiteCourse.getTime().getHours()
                                        : "" + onsiteCourse.getTime().getHours());
                        minuteField.setSelectedItem(
                                onsiteCourse.getTime().getMinutes() < 10 ? "0" + onsiteCourse.getTime().getMinutes()
                                        : "" + onsiteCourse.getTime().getMinutes());
                    } else {
                        System.err.println("Không tìm thấy khóa onsite");

                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(CoursePL.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showConfirmDialog(null, data, "Chưa có dòng được chọn", JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_selectedRowMouseClicked

    private void selectedRowActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selectedRowActionPerformed

    }// GEN-LAST:event_selectedRowActionPerformed

    private void updateCourse_Option_OnsiteCourse(int CourseID) {
        String nameCourse = nameCourseField.getText();
        String credits = creditsField.getText();
        String urlCourse = urlOrLocationField.getText();
        String dayStr = daysField.getText();
        String hour = String.valueOf(hourField.getSelectedItem());
        String minute = String.valueOf(minuteField.getSelectedItem());
        int departmentID = getID_FromCbb(String.valueOf(departmentCbb.getSelectedItem()));
        String result = new CourseBLL().updateCourse(CourseID, nameCourse, credits, departmentID,
                getValueSelectedTeachers(), urlCourse, dayStr, hour, minute);
        JOptionPane.showConfirmDialog(null, result, "Message",
                result.equals("Cập nhật thành công") ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

    private void updateCourse_Option_OnlineCourse(int CourseID) {
        String nameCourse = nameCourseField.getText();
        String credits = creditsField.getText();
        String urlCourse = urlOrLocationField.getText();
        int departmentID = getID_FromCbb(String.valueOf(departmentCbb.getSelectedItem()));
        String result = new CourseBLL().updateCourse(CourseID, nameCourse, credits, departmentID,
                getValueSelectedTeachers(), urlCourse);
        JOptionPane.showConfirmDialog(null, result, "Message",
                result.equals("Cập nhật thành công") ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

    private void updateCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_updateCourseBtnMouseClicked
        List<String> data = MyTable.data;
        if (data.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Chưa có dòng được chọn", "Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int CourseID = Integer.parseInt(data.get(0));
        int rs_Confirm = JOptionPane.showConfirmDialog(null,
                "Bạn đang thực hiện cập nhật trên mã khóa học có ID: " + CourseID, "", JOptionPane.YES_NO_OPTION);
        if (rs_Confirm != 0) {
            return;
        }
        if (typeCourse_Cbb.getSelectedIndex() == 0) {
            updateCourse_Option_OnsiteCourse(CourseID);
        } else {
            updateCourse_Option_OnlineCourse(CourseID);
        }
        TestGraphics.search();
    }// GEN-LAST:event_updateCourseBtnMouseClicked

    // Chuyển list teacher thành chuỗi thêm kí tự - setText cho lable
    // selectedTeachers
    // `1 - NguyenVanA` --> 1
    private void setValueSelectedTeachers() {
        String teacherIDs = "";
        if (listTeachers.isEmpty()) {
            selectedTeachers.setText("");
            return;
        }
        for (int i = 0; i < listTeachers.size() - 1; i++) {
            teacherIDs += getID_FromCbb(listTeachers.get(i)) + " - ";
        }
        teacherIDs += getID_FromCbb(listTeachers.get(listTeachers.size() - 1));
        selectedTeachers.setText(teacherIDs);
    }

    // Chuyển list teacher dạng string sang list teacher id dạng int
    private List<Integer> getValueSelectedTeachers() {
        List<Integer> teacherIDs = new ArrayList<>();
        for (String t : listTeachers) {
            teacherIDs.add(getID_FromCbb(t));
        }
        return teacherIDs;
    }

    // Chuyển list teacher dạng string - List<String>
    // 1 - 2 - 3 ---> 1 - | 2 - | 3 -
    private static List<String> convertStringToList(String input) {
        List<String> resultList = new ArrayList<>();
        String[] parts = input.split(" - ");
        for (String part : parts) {
            resultList.add(part.trim() + " - ");
        }
        return resultList;
    }

    private void teachersCbbActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_teachersCbbActionPerformed
        if (initialized) {
            JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
            String selectedTeacher = (String) comboBox.getSelectedItem();
            int index = -1, count = -1;
            for (String teacher : listTeachers) {
                count++;
                if (teacher.equals(selectedTeacher) || teacher.equals(getID_FromCbb(selectedTeacher) + " - ")) {
                    int rs_Delete = JOptionPane.showConfirmDialog(null, "Giảng viên tồn tại, Chọn Yes để xóa", "",
                            JOptionPane.YES_NO_OPTION);
                    if (rs_Delete == 0) {
                        index = count;
                        System.err.println("index " + index);
                        break;
                    } else {
                        return;
                    }
                }
            }
            if (index != -1) {
                listTeachers.remove(index);
                setValueSelectedTeachers();
                return;
            }
            int rs_Confirm = JOptionPane.showConfirmDialog(null, "Xác nhận thêm giảng viên", "",
                    JOptionPane.YES_NO_OPTION);
            if (rs_Confirm == 0) {
                listTeachers.add(selectedTeacher);
                setValueSelectedTeachers();
            }
        }
    }// GEN-LAST:event_teachersCbbActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton1MouseClicked
        initialized = false;
        nameCourseField.setText("");
        creditsField.setText("");
        departmentCbb.setSelectedIndex(0);
        teachersCbb.setSelectedIndex(0);
        selectedTeachers.setText("");
        typeCourse_Cbb.setSelectedIndex(0);
        urlOrLocationField.setText("");
        daysField.setText("");
        hourField.setSelectedIndex(0);
        minuteField.setSelectedIndex(0);
        listTeachers.clear();
        MyTable.data.clear();
        initialized = true;
    }// GEN-LAST:event_jButton1MouseClicked

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField creditsField;
    private javax.swing.JLabel days;
    private javax.swing.JTextField daysField;
    private static javax.swing.JComboBox<String> departmentCbb;
    private javax.swing.JComboBox<String> hourField;
    private javax.swing.JButton insertCourseBtn;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JComboBox<String> minuteField;
    private javax.swing.JTextField nameCourseField;
    private javax.swing.JButton selectedRow;
    private javax.swing.JTextField selectedTeachers;
    private javax.swing.JLabel startTime;
    private static javax.swing.JComboBox<String> teachersCbb;
    private javax.swing.JPanel timePL;
    private javax.swing.JComboBox<String> typeCourse_Cbb;
    private javax.swing.JButton updateCourseBtn;
    private javax.swing.JLabel url;
    private javax.swing.JTextField urlOrLocationField;
    // End of variables declaration//GEN-END:variables
}
