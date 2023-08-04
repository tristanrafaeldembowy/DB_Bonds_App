package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Bonds;
import com.db.grad.javaapi.service.DogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:8080/h2-console")

public class BondsController {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/h2:mem:testdb";
        private static final String DB_USER = "sa";
        private static final String DB_PASSWORD = "password";

        // Implement methods for connecting to the database and performing CRUD operations for Bonds, Clients, and Operations

        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

        // Methods to perform CRUD operations for Bonds, Clients, and Operations
        // You can use PreparedStatement to prevent SQL injection
    }

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://your_database_url";
        String username = "your_username";
        String password = "your_password";

        // Establishing the connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Creating a statement
            try (Statement statement = connection.createStatement()) {
                // Executing a query
                String query = "SELECT * FROM your_table_name";
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    // Processing query results
                    while (resultSet.next()) {
                        String column1Value = resultSet.getString("column1");
                        int column2Value = resultSet.getInt("column2");
                        // Process other columns if needed
                        System.out.println("Column 1: " + column1Value + ", Column 2: " + column2Value);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}