package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection 
{
 public static Statement stmt=null;
 public static Statement createstmt()
 //The createstmt() method is designed to establish a connection to a MySQL database and create a Statement object that can be used to execute SQL commands like SELECT, INSERT, UPDATE, or DELETE.
 
 {

     // Try block to check if any exceptions occur
	 try
	 {
		 // Loading driver using forName() method
		 Class.forName("com.mysql.jdbc.Driver");
		 // Registering driver using DriverManager
		 Connection con=DriverManager.getConnection(  
		 "jdbc:mysql://localhost:3306/sms","root","Hasna@2002"); 
		 stmt=con.createStatement();
	 }
	 catch(Exception e)
	 {
	System.out.println(e);	 
	 }
	 finally
	 {
		 
	 }
	 return stmt;
 }
	 
}
