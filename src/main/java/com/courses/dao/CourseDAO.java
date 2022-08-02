package com.courses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.courses.Course;
import com.courses.factory.ConnectionFactory;

public class CourseDAO {
    /*
     * CRUD operations
     * C: create
     * R: read
     * U: update
     * D: delete
     */

    // list all courses
    public void listCourses() {
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM courses");
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // create course
    public void createCourse(Course course) throws Exception {
        String sql = "INSERT INTO courses (name, category) VALUES (?, ?)";
        Connection connection = null;
        // prepare statement
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            // set parameters
            statement.setString(1, course.getName());
            statement.setString(2, course.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    // get course
    public Course getCourse(int id) throws Exception {
        Course course = null;
        String sql = "SELECT * FROM courses WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            // execute query
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setCategory(resultSet.getString("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return course;
    }

    // update course
    public void updateCourse(Course course) throws Exception {
        String sql = "UPDATE courses SET name = ?, category = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            // set parameters
            statement.setString(1, course.getName());
            statement.setString(2, course.getCategory());
            statement.setInt(3, course.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    // delete course by id
    public void deleteCourse(int id) throws Exception {
        String sql = "DELETE FROM courses WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
}
