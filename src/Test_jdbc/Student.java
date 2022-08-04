package Test_jdbc;
import java.sql.*;
import java.util.*;
public class Student {
//
	public static void main(String[] args) throws SQLException{
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/schooldb";
		String user="root",pw="multi123";
		
		//mySQL 과 eclipse연결
		Connection con = DriverManager.getConnection(url,user,pw);
		
		// table 만들수있게 ..
		Statement st= con.createStatement(); 
		
		
		st.executeUpdate("create table student101 (name varchar(30),grd int)");// table 만들기, 혹시
		

		
		con.close();
	}

}
