package JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;



public class ExecuteUpdateTest {
@Test
public void executeUpdateTest() throws Throwable{
	Connection con = null;
try {
	
	//step1=Register driver
	Driver dref=new Driver();
	//step2=connect to database
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	//step3=create statement
	 Statement stmt = con.createStatement();
	//step4=Execute update 
	int result=stmt.executeUpdate("insert into students_info (regno, firstname, middlename,lastname) values('4','bam','bramin','h');");
	if(result==1) {
	System.out.println("data is added");	
	}
} 
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
finally {
	con.close();
	
}
}
}
