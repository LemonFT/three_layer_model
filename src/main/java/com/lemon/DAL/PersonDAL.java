/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemon.DAL;

import com.lemon.DTO.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LAM
 */
public class PersonDAL extends ConnectDB {

    public static List<Person> getAllPerson() throws ClassNotFoundException, SQLException {
        List<Person> persons = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "select * from person";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int personID = rs.getInt("PersonID");
                    String lastName = rs.getString("Lastname");
                    String firstName = rs.getString("Firstname");
                    Date hireDate = rs.getDate("HireDate");
                    Date enrollmentDate = rs.getDate("EnrollmentDate");
                    Person person = new Person(personID, lastName, firstName, hireDate, enrollmentDate);
                    persons.add(person);
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
        return persons;
    }

    
    public static List<Person> getAllPersonIsStudent() throws ClassNotFoundException, SQLException {
        List<Person> persons = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "select * from person where HireDate is ?";
                stm = getConnection().prepareStatement(sql);
                stm.setDate(1, null);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int personID = rs.getInt("PersonID");
                    String lastName = rs.getString("Lastname");
                    String firstName = rs.getString("Firstname");
                    Date hireDate = rs.getDate("HireDate");
                    Date enrollmentDate = rs.getDate("EnrollmentDate");
                    Person person = new Person(personID, lastName, firstName, hireDate, enrollmentDate);
                    persons.add(person);
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
        return persons;
    }
    
    public static List<Person> getPersonIsTeacher() throws ClassNotFoundException, SQLException {
        List<Person> persons = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "select * from person where hiredate is not null";
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int personID = rs.getInt("PersonID");
                    String lastName = rs.getString("Lastname");
                    String firstName = rs.getString("Firstname");
                    Date hireDate = rs.getDate("HireDate");
                    Date enrollmentDate = rs.getDate("EnrollmentDate");
                    Person person = new Person(personID, lastName, firstName, hireDate, enrollmentDate);
                    persons.add(person);
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
        return persons;
    }
    
    public static List<Person> getStudentBySearch(String sql) throws ClassNotFoundException, SQLException {
        List<Person> persons = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int personID = rs.getInt("PersonID");
                    String lastName = rs.getString("Lastname");
                    String firstName = rs.getString("Firstname");
                    Date hireDate = rs.getDate("HireDate");
                    Date enrollmentDate = rs.getDate("EnrollmentDate");
                    Person person = new Person(personID, lastName, firstName, hireDate, enrollmentDate);
                    persons.add(person);
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
        return persons;
    }
    
    public static List<Person> getStudentsInCourse(int courseID) throws ClassNotFoundException, SQLException{
        List<Person> persons = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                String sql = "select * from course join studentgrade on course.courseID = studentgrade.courseID "
                        + "join person on person.PersonID = studentgrade.StudentID where course.CourseID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, courseID);
                System.out.println(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int personID = rs.getInt("PersonID");
                    String lastName = rs.getString("Lastname");
                    String firstName = rs.getString("Firstname");
                    Date hireDate = rs.getDate("HireDate");
                    Date enrollmentDate = rs.getDate("EnrollmentDate");
                    Person person = new Person(personID, lastName, firstName, hireDate, enrollmentDate);
                    persons.add(person);
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
        return persons;
    }
    
    public static List<Person> getTeacherBySearch(String sql) throws ClassNotFoundException, SQLException {
        List<Person> persons = new ArrayList<>();
        if (open()) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                stm = getConnection().prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int personID = rs.getInt("PersonID");
                    String lastName = rs.getString("Lastname");
                    String firstName = rs.getString("Firstname");
                    Date hireDate = rs.getDate("HireDate");
                    Date enrollmentDate = rs.getDate("EnrollmentDate");
                    Person person = new Person(personID, lastName, firstName, hireDate, enrollmentDate);
                    persons.add(person);
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
        return persons;
    }
    
    public static boolean insertPerson(Person person) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "insert into person (Lastname, Firstname, HireDate, EnrollmentDate) values (?,?,?,?)";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, person.getLastName());
                stm.setString(2, person.getFirstName());
                stm.setDate(3, (java.sql.Date) person.getHireDate());
                stm.setDate(4, (java.sql.Date) person.getEnrollmentDate());
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

    public static boolean updatePerson(Person person) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "update person set Lastname = ?, Firstname = ?, HireDate = ?, EnrollmentDate where PersonID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setString(1, person.getLastName());
                stm.setString(2, person.getFirstName());
                stm.setDate(3, (java.sql.Date) person.getHireDate());
                stm.setDate(4, (java.sql.Date) person.getEnrollmentDate());
                stm.setInt(5, person.getPersonID());
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

    public static boolean deletePerson(Person person) throws SQLException, ClassNotFoundException {
        if (open()) {
            PreparedStatement stm = null;
            try {
                String sql = "delete from person where PersonID = ?";
                stm = getConnection().prepareStatement(sql);
                stm.setInt(1, person.getPersonID());
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
