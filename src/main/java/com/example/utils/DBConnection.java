package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Database connection
public class DBConnection {
    // Database connection URL
    private static final String URL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
    // Database username and password
    private static final String USERNAME = "COMP228_F24_soh_19";
    private static final String PASSWORD = "software";

     //Returns a connection to the database.
    public static Connection getConnection() throws SQLException {
        // Use the DriverManager to establish a connection to the database
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}