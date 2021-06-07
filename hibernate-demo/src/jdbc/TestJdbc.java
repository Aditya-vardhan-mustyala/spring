package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcDB="jdbc:mysql://localhost:3306/college?useSSL=false";
		String user="aditya";
		String pass="aditya";

		try {
			System.out.println("connection");
			Connection conn=DriverManager.getConnection(jdbcDB,user,pass);
			System.out.println("success");	
			}
		catch(Exception e)
		{
			
		}
	}

}
