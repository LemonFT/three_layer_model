/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DTO;

/**
 *
 * @author LAM
 */
public class Studentgrade {

    private int enrollmentID;
    private int courseID;
    private int studentID;
    private double grade;

    public Studentgrade(int enrollmentID, int courseID, int studentID, double grade) {
        this.enrollmentID = enrollmentID;
        this.courseID = courseID;
        this.studentID = studentID;
        this.grade = grade;
    }

    public Studentgrade(int courseID, int studentID, double grade) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.grade = grade;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Studentgrade{" + "enrollmentID=" + enrollmentID + ", courseID=" + courseID + ", studentID=" + studentID + ", grade=" + grade + '}';
    }

}
