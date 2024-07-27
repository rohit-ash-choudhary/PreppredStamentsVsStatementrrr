package com.sp.main.JDBCstmtvsPreprrd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class PrepprdStatment {

    public static void main(String[] args) throws SQLException {
        String Driver_class="com.mysql.cj.jdbc.Driver";
        String db_url="jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String db_name="root";
        String db_password="Rooh@#2001";
        Connection connection = null;
        PreparedStatement pt=null;
        try {


            Class.forName(Driver_class);

            connection = DriverManager.getConnection(db_url, db_name, db_password);

            String sql_query="insert into account values(?,?,?,?);";
            pt= connection.prepareStatement(sql_query);
            pt.setInt(1,45);
            pt.setString(2,"Kalehs");
            pt.setString(3,"Choudhary");
            pt.setInt(4,6565);

            int count= pt.executeUpdate();
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
            if(pt!=null )
            {
                pt.close();
            }
            if (connection!=null) {
                connection.close();
            }
        }




    }
}
