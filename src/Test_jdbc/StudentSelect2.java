package Test_jdbc;
import java.sql.*;
public class StudentSelect2 {

	public static void main(String[] args)throws SQLException {
		String url="jdbc:mysql://localhost:3306/schooldb";
		String id="root",pw="multi123";
		
		Connection con=DriverManager.getConnection(url, id, pw);
		String sql="Select name,grd from student101";
		PreparedStatement pt=con.prepareStatement(sql);
		ResultSet rs = pt.executeQuery(); 
		while(rs.next()) {
			String name=rs.getString("name");
			int grd=rs.getInt("grd");
			System.out.println("이름 : "+name+"\n학년 : "+grd
								+"\n------------");
		
		}
		rs.close();
		pt.close();
		con.close();
		
	}

}
