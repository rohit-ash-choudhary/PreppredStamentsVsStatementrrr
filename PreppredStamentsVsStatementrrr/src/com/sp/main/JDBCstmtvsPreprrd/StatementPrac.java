package com.sp.main.JDBCstmtvsPreprrd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class StatementPrac {

    public static void main(String[] args) throws SQLException {
        String Driver_class="com.mysql.cj.jdbc.Driver";
        String db_url="jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String db_name="root";
        String db_password="Rooh@#2001";
        Connection connection = null;
        Statement st=null;

        try {


            Class.forName(Driver_class);

            connection = DriverManager.getConnection(db_url, db_name, db_password);

            st= (Statement) connection.createStatement();

            int count = st.executeUpdate("insert into account values (34, 'Ashh', 'Choudhary', 345345);");





            System.out.println("No of rows affected "+count);
            if(count>0)
            {
                System.out.println(" Data Inserted and No of rows affected "+count);
            }
            else {
                System.out.println("Issue in Data Insert");
            }
        }
        catch ( ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            if(st!=null )
            {
                st.close();
            }
            if (connection!=null) {
                connection.close();
            }
        }




    }



}
