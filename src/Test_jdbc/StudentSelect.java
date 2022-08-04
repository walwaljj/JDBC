package Test_jdbc;


import java.sql.*;


public class StudentSelect {

	public static void main(String[] args)throws SQLException {
		String url="jdbc:mysql://localhost:3306/schooldb" ;
		String id="root",pw="multi123";
		Connection con=DriverManager.getConnection(url,id,pw);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from student101");
		
		while(rs.next()) {
			String name=rs.getString("name");
			int grd=rs.getInt("grd");
			System.out.println(name+"학생은 "+grd+" 학년 입니다.");
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
