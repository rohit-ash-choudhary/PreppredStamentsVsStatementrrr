package com.sp.main.JDBCstmtvsPreprrd;

import java.sql.*;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class LoginWithPrdStmt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username:");
        String user = sc.nextLine();  //ashhh' or '1'='1  this user for SQL injection

        System.out.println("Enter the password:");
        String password = sc.nextLine();

        String driverClass = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "Rooh@#2001";
        Connection connection = null;
        PreparedStatement pt = null;
        ResultSet rs = null;

        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String sqlQuery = "SELECT * FROM login WHERE username=? AND password=?";

            pt =connection.prepareStatement(sqlQuery);
            System.out.println("Executing query: " + sqlQuery);

            pt.setString(1,user);

            pt.setString(2,password);
            System.out.println("Executing query: " + sqlQuery);


            // Escape single quotes in user inputs
            //  String userEscaped = user.replace("'", "''");
            // String passwordEscaped = password.replace("'", "''");




            // Debugging step: Print the SQL query


            pt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their opening
            try {
                if (rs != null) rs.close();
                if (pt != null) pt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


