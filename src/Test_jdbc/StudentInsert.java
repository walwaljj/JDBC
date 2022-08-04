package Test_jdbc;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;
public class StudentInsert {

	public static void main(String[] args) throws SQLException{
		
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8";
		String id="root",pw="multi123";
		Connection con=DriverManager.getConnection(url,id,pw);
		//--------------------------------------------------
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("학년을 입력하세요");
		int grd = sc.nextInt();
		//스캐너로 insert문을 입력받음
		
		Statement st= con.createStatement();
		st.executeUpdate("insert into student101(name, grd) values('"+name+"',"+grd+")");
		//입력받은 정보를 database에 update함
		System.out.println("레코드를 저장했습니다.");
		
		st.close();
		con.close();
	}

}
