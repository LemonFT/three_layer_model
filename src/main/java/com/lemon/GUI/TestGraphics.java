package com.lemon.GUI;

import com.lemon.GUI.component.StudentGradePL;
import com.lemon.GUI.component.MyTable;
import com.lemon.GUI.component.CourseInstructorPL;
import com.lemon.GUI.component.CoursePL;
import com.lemon.BLL.CourseBLL;
import com.lemon.BLL.PersonBLL;
import com.lemon.BLL.StudentgradeBLL;
import com.lemon.DTO.Course;
import com.lemon.DTO.Person;
import com.lemon.DTO.Studentgrade;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class TestGraphics extends javax.swing.JFrame {

    private int x;
    private int y;
    public static int menuItemFocus = 1;

    public TestGraphics() throws ClassNotFoundException, SQLException {
        initComponents();
        addComponentCourse();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMoving(TestGraphics.this);
    }

    private void initMoving(JFrame fr) {
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });

        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                fr.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

    private static GridBagConstraints formatLayout() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }

    public static void addComponentCourse() {
        GridBagConstraints constraints = formatLayout();
        container.removeAll();
        container.add(new CoursePL(), constraints);
        filterBy.removeAllItems();
        filterBy.addItem("All");
        filterBy.addItem("Mã khóa học");
        filterBy.addItem("Tên khóa học");
        filterBy.addItem("Số tín chỉ");
        filterBy.addItem("Mã phòng ban");
        filterBy.addItem("Mã giảng viên");
        menuItemFocus = 1;
        typeCourseCbb.setVisible(true);
        title.setText("DANH SÁCH KHÓA HỌC");
        try {
            List<Course> listCourse = new CourseBLL().getAllCourse();
            MyTable.loadCourseToTable(listCourse);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addComponentCourseInstructor() {
        GridBagConstraints constraints = formatLayout();
        container.removeAll();
        container.add(new CourseInstructorPL(), constraints);
        filterBy.removeAllItems();
        filterBy.addItem("All");
        filterBy.addItem("Mã giảng viên");
        filterBy.addItem("Tên giảng viên");
        filterBy.addItem("Ngày bắt đầu");
        menuItemFocus = 2;
        typeCourseCbb.setVisible(false);
        typeCourse.setVisible(false);
        title.setText("DANH SÁCH GIẢNG VIÊN");
        List<Person> teachers = new PersonBLL().getAllPersonIsTeacher();
        MyTable.loadTeachersToTable(teachers);
    }

    public static void addComponentStudentGrade() {
        GridBagConstraints constraints = formatLayout();
        container.removeAll();
        container.add(new StudentGradePL(), constraints);
        filterBy.removeAllItems();
        filterBy.addItem("All");
        filterBy.addItem("Mã đăng kí");
        filterBy.addItem("Mã khóa học");
        filterBy.addItem("Mã sinh viên");
        filterBy.addItem("Kết quả");
        menuItemFocus = 3;
        typeCourseCbb.setVisible(false);
        typeCourse.setVisible(false);
        title.setText("KẾT QUẢ");
        try {
            List<Studentgrade> listStudentGrade = new StudentgradeBLL().getAllStudentGrade();
            MyTable.loadStudentGradeToTable(listStudentGrade);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar2 = new com.lemon.GUI.component.SideBar();
        mainFrame = new com.lemon.GUI.component.MainFrame();
        myTable1 = new com.lemon.GUI.component.MyTable();
        sideBar3 = new com.lemon.GUI.component.SideBar();
        container = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        miniBtn = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        sortCbb = new javax.swing.JComboBox<>();
        filterBy = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();
        typeCourse = new javax.swing.JLabel();
        typeCourseCbb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        myTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTable1MouseClicked(evt);
            }
        });

        container.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        container.setLayout(new java.awt.GridBagLayout());

        header.setBackground(new java.awt.Color(102, 0, 255));

        closeBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closeBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeBtn.setText("X");
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });

        miniBtn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        miniBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        miniBtn.setText("—");
        miniBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(miniBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeBtn)
                    .addComponent(miniBtn))
                .addContainerGap())
        );

        title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("DANH SÁCH KHÓA HỌC");

        sortCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-Z", "Z-A" }));
        sortCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortCbbActionPerformed(evt);
            }
        });

        filterBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "ID" }));
        filterBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByActionPerformed(evt);
            }
        });

        jLabel2.setText("Sắp xếp");

        jLabel3.setText("Tìm theo");

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        searchBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lemon/GUI/icon/search35.png"))); // NOI18N
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });

        refreshBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        refreshBtn.setText("Refresh Data");
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        typeCourse.setText("Onsite/Online");

        typeCourseCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Onsite", "Online" }));
        typeCourseCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCourseCbbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainFrameLayout = new javax.swing.GroupLayout(mainFrame);
        mainFrame.setLayout(mainFrameLayout);
        mainFrameLayout.setHorizontalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainFrameLayout.createSequentialGroup()
                .addComponent(sideBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378))
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(filterBy, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(sortCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(typeCourse)
                        .addGap(5, 5, 5)
                        .addComponent(typeCourseCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn)
                        .addContainerGap())))
        );
        mainFrameLayout.setVerticalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchField)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filterBy)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortCbb)
                            .addComponent(typeCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(mainFrameLayout.createSequentialGroup()
                                .addComponent(searchBtn)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addComponent(typeCourseCbb))
                        .addGap(18, 18, 18)
                        .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sideBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeBtnMouseClicked

    private void miniBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniBtnMouseClicked
        this.setState(TestGraphics.ICONIFIED);
    }//GEN-LAST:event_miniBtnMouseClicked

    public static void search_Course() {
        String searchText = searchField.getText();
        int sortOption = sortCbb.getSelectedIndex();
        int filter = filterBy.getSelectedIndex();
        int typeCourse = typeCourseCbb.getSelectedIndex();
        try {
            List<Course> listCourse = new CourseBLL().searchCourse(searchText, sortOption, filter, typeCourse);
            MyTable.loadCourseToTable(listCourse);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void search_CourseInstructor() {
        String searchText = searchField.getText();
        int sortOption = sortCbb.getSelectedIndex();
        int filter = filterBy.getSelectedIndex();
        List<Person> listTeachers = new PersonBLL().searchTeacher(searchText, sortOption, filter);
        MyTable.loadTeachersToTable(listTeachers);
    }

    public static void search_StudentGrade() {
        String searchText = searchField.getText();
        int sortOption = sortCbb.getSelectedIndex();
        int filter = filterBy.getSelectedIndex();
        try {
            List<Studentgrade> listStudentGrade = new StudentgradeBLL().searchStudentGrade(searchText, sortOption, filter);
            MyTable.loadStudentGradeToTable(listStudentGrade);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void search() {
        switch (menuItemFocus) {
            case 1 ->
                search_Course();
            case 2 ->
                search_CourseInstructor();
            case 3 ->
                search_StudentGrade();
            default -> {
            }
        }
    }
    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        search();
    }//GEN-LAST:event_searchBtnMouseClicked

    private void filterByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterByActionPerformed
        search();
    }//GEN-LAST:event_filterByActionPerformed

    private void sortCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortCbbActionPerformed
        search();
    }//GEN-LAST:event_sortCbbActionPerformed

    private void typeCourseCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCourseCbbActionPerformed
        search();
    }//GEN-LAST:event_typeCourseCbbActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        sortCbb.setSelectedIndex(0);
        filterBy.setSelectedIndex(0);
        typeCourseCbb.setSelectedIndex(0);
        searchField.setText("");
        search();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        search();
    }//GEN-LAST:event_searchFieldKeyReleased

    private void myTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTable1MouseClicked
        
    }//GEN-LAST:event_myTable1MouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TestGraphics().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TestGraphics.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TestGraphics.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeBtn;
    private static javax.swing.JPanel container;
    private static javax.swing.JComboBox<String> filterBy;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.lemon.GUI.component.MainFrame mainFrame;
    private javax.swing.JLabel miniBtn;
    private com.lemon.GUI.component.MyTable myTable1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel searchBtn;
    private static javax.swing.JTextField searchField;
    private com.lemon.GUI.component.SideBar sideBar2;
    private com.lemon.GUI.component.SideBar sideBar3;
    private static javax.swing.JComboBox<String> sortCbb;
    public static javax.swing.JLabel title;
    public static javax.swing.JLabel typeCourse;
    public static javax.swing.JComboBox<String> typeCourseCbb;
    // End of variables declaration//GEN-END:variables

}
