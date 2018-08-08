/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crms;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static Connection conn;
        public static Connection ConnectToDB() throws ClassNotFoundException, SQLException
        {
             String url="jdbc:mysql://127.0.0.1:3306/db_CRMS";
             String user="root";
             String pass="aho1234";
             Class.forName("com.mysql.jdbc.Driver");
             conn=(Connection) DriverManager.getConnection(url, user, pass);
             return conn;
          } 
   
}
