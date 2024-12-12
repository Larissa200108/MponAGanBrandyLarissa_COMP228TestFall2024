package com.example.controllers;

import com.example.models.Student;
import com.example.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    //Retrieves a list of students by city.
    public static List<Student> getStudentsByCity(String city) {
        // Initialize an empty list to store students
        List<Student> students = new ArrayList<>();

        // SQL query to select students by city
        String query = "SELECT * FROM Students WHERE city = ?";

        try (// Establish a database connection
             Connection connection = DBConnection.getConnection();
             // Prepare the SQL query with a parameter for city
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the city parameter in the query
            statement.setString(1, city);

            // Execute the query and retrieve the results
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Create a new Student object from the query results
                students.add(new Student(
                        resultSet.getString("studentID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode")
                ));
            }
        } catch (Exception e) {
            // Log any exceptions that occur during database operations
            e.printStackTrace();
        }
        // Return the list of students
        return students;
    }
}