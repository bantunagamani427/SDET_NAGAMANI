package JDBC_Practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryTest {
@Test
public void executeQueryTest() throws Throwable {
//step1=Register the driver
	Driver dref=new Driver();
	DriverManager.registerDriver(dref);
//step2= connect to database
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
//step3=create statement
Statement stmt = con.createStatement();
//step4=Execute Query
ResultSet result = stmt.executeQuery("select * from students_info");
while(result.next()){
System.out.println(result.getString(1)+" "+result.getString(2));
//step5=close the connection
//con.close();
}
}}

	


