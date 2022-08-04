package Test_jdbc;
import java.sql.*;
import java.util.*;
public class StudentDelete {

	public static void main(String[] args)throws SQLException {
		String url = "jdbc:mysql://localhost:3306/schooldb";
		String id="root",pw="multi123";
		Connection con=DriverManager.getConnection(url,id,pw);
		//-------------------------------------------------
		Scanner sc = new Scanner(System.in);
		
		String sql="delete from student101 where name=(?)";
		PreparedStatement pt=con.prepareStatement(sql);
		
		System.out.println("삭제할 이름을 입력하세요.");
		String name=sc.nextLine();
		
		pt.setString(1,name);
		pt.executeUpdate();
		
		
		System.out.println("삭제완료");
		
		
		pt.close();
		con.close();
	}

}
