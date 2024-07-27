package com.sp.main.JDBCstmtvsPreprrd;

import java.sql.*;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username:");
        String user = sc.nextLine();

        System.out.println("Enter the password:");
        String password = sc.nextLine();

        String driverClass = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "Rooh@#2001";
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            st = connection.createStatement();
            String sqlQuery = "SELECT * FROM login WHERE username='" + user + "' AND password='" + password + "'";
            System.out.println(sqlQuery);
            rs = st.executeQuery(sqlQuery);

            if (rs.next()) {
                System.out.println("Welcome "+rs.getString("username"));
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
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
