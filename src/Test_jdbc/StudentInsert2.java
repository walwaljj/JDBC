package Test_jdbc;

import java.sql.SQLException;
import java.sql.*;
import java.util.*;

public class StudentInsert2 {

	public static void main(String[] args)throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		String id="root",pw="multi123";
		
		String url="jdbc:mysql://localhost:3306/schooldb";
		
		Connection con= DriverManager.getConnection(url,id,pw);
		
		
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		
		System.out.println("학년을 입력하세요.");
		int grd = sc.nextInt();
		
		String sql="INSERT INTO student101 values(?,?)";
		PreparedStatement pt=con.prepareStatement(sql);
		
		pt.setString(1,name);
		pt.setInt(2,grd);
		pt.executeUpdate();//
		
		
		System.out.println("등록완료.");
		
		pt.close();
		con.close();
	}

}
