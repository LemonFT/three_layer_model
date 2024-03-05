/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lemon.GUI.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import com.lemon.GUI.TestGraphics;

public class SideBar extends javax.swing.JPanel {

    int menuItemFocus = 1;

    public SideBar() {
        initComponents();
        setOpaque(false);
        menuItem1.setForeground(Color.BLACK);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogo = new javax.swing.JPanel();
        lg = new javax.swing.JLabel();
        menuItem1 = new javax.swing.JLabel();
        menuItem2 = new javax.swing.JLabel();
        menuItem3 = new javax.swing.JLabel();
        lg9 = new javax.swing.JLabel();
        lg10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));
        panelLogo.setOpaque(false);
        panelLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lg.setBackground(new java.awt.Color(255, 255, 255));
        lg.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lg.setForeground(new java.awt.Color(255, 204, 204));
        lg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lg.setText("MANAGEMENT");
        lg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelLogo.add(lg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 210, 69));

        menuItem1.setBackground(new java.awt.Color(255, 255, 255));
        menuItem1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        menuItem1.setForeground(new java.awt.Color(255, 255, 255));
        menuItem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuItem1.setText("Khóa học");
        menuItem1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 204, 204)));
        menuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItem1MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuItem1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuItem1MouseExited(evt);
            }
        });

        menuItem2.setBackground(new java.awt.Color(255, 255, 255));
        menuItem2.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        menuItem2.setForeground(new java.awt.Color(255, 255, 255));
        menuItem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuItem2.setText("Giảng dạy");
        menuItem2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 204)));
        menuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItem2MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuItem2MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuItem2MouseExited(evt);
            }
        });

        menuItem3.setBackground(new java.awt.Color(255, 255, 255));
        menuItem3.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        menuItem3.setForeground(new java.awt.Color(255, 255, 255));
        menuItem3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuItem3.setText("Kết quả");
        menuItem3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 204)));
        menuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItem3MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuItem3MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuItem3MouseExited(evt);
            }
        });

        lg9.setBackground(new java.awt.Color(255, 255, 255));
        lg9.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lg9.setForeground(new java.awt.Color(255, 255, 255));
        lg9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lg9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lg10.setBackground(new java.awt.Color(255, 255, 255));
        lg10.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lg10.setForeground(new java.awt.Color(255, 255, 255));
        lg10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lg10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelLogo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuItem1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuItem2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuItem3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lg10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(lg9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(menuItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(menuItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(menuItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lg10, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lg9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(158, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void focusMenuItem(JLabel lbFocus, int index) {
        menuItem1.setForeground(new Color(255, 255, 255));
        menuItem2.setForeground(new Color(255, 255, 255));
        menuItem3.setForeground(new Color(255, 255, 255));
        this.menuItemFocus = index;
        lbFocus.setForeground(Color.BLACK);
    }

    private void menuItem1MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem1MouseEntered
        menuItem1.setForeground(Color.BLACK);
    }// GEN-LAST:event_menuItem1MouseEntered

    private void menuItem1MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem1MouseExited
        if (menuItemFocus != 1) {
            menuItem1.setForeground(new Color(255, 255, 255));
        }
    }// GEN-LAST:event_menuItem1MouseExited

    private void menuItem3MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem3MouseEntered
        menuItem3.setForeground(Color.BLACK);
    }// GEN-LAST:event_menuItem3MouseEntered

    private void menuItem3MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem3MouseExited
        if (menuItemFocus != 3) {
            menuItem3.setForeground(new Color(255, 255, 255));
        }
    }// GEN-LAST:event_menuItem3MouseExited

    private void menuItem2MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem2MouseEntered
        menuItem2.setForeground(Color.BLACK);
    }// GEN-LAST:event_menuItem2MouseEntered

    private void menuItem2MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem2MouseExited
        if (menuItemFocus != 2) {
            menuItem2.setForeground(new Color(255, 255, 255));
        }
    }// GEN-LAST:event_menuItem2MouseExited

    private void menuItem1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem1MouseClicked
        TestGraphics.addComponentCourse();
        focusMenuItem(menuItem1, 1);
    }// GEN-LAST:event_menuItem1MouseClicked

    private void menuItem2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem2MouseClicked
        TestGraphics.addComponentCourseInstructor();
        focusMenuItem(menuItem2, 2);
    }// GEN-LAST:event_menuItem2MouseClicked

    private void menuItem3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItem3MouseClicked
        TestGraphics.addComponentStudentGrade();
        focusMenuItem(menuItem3, 3);
    }// GEN-LAST:event_menuItem3MouseClicked

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#4568DC"), 0, getHeight(),
                Color.decode("#B06AB3"));
        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        // g2.fillRect(getWidth() - 20, 0, 20, getHeight());
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lg;
    private javax.swing.JLabel lg10;
    private javax.swing.JLabel lg9;
    private javax.swing.JLabel menuItem1;
    private javax.swing.JLabel menuItem2;
    private javax.swing.JLabel menuItem3;
    private javax.swing.JPanel panelLogo;
    // End of variables declaration//GEN-END:variables

    private void resetTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
