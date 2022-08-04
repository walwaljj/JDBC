package com.my.jdbc;
import java.sql.*;

public class MemoSelect {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8"; 	

		//로그인
		String user="root",pwd="multi123";
		
		//db연결
		Connection con=DriverManager.getConnection(url, user,pwd);// 하려면 spl* import해야함
		
		String sql="SELECT idx,name,msg,wdate FROM memo ORDER BY 1 DESC";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		// SELECT문일 경우 : ResultSet executeQuery() 메서드를 호출 
		//셀렉트문은 결과가 테이블형으로온다. resultset = queryset과 같고 결과를 내온다.
		
		ResultSet rs=pstmt.executeQuery();// 결과테이블을 rs가 참조한다.
		/*ResultSet의 주요 매서드

		*[1] boolean next() : 논리적인 커서의 위치를 다음 레코드로 이동시켜 레코드가 있으면 true ,없으면 false
		*					: 커서는 첫번째 행의 직전에 위치함. (before first)
		*[2] xxx getxxx("컬럼명")
		
		*/
		
		//rs는 반복문을 돌려야지 결과가 출력
		
		while(rs.next()) {// rs.next가 1씩 커지며 하나씩 꺼내옴
						// rs는 자료형에 맞게 꺼내오기때문에 get자료형 으로 해당 자료형을 맞춰주면된다.
			int idx=rs.getInt("idx"); 
			String name=rs.getString("name");
			String msg=rs.getString("msg");
			java.sql.Date wdate=rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		
		rs.close();
		pstmt.close();
		con.close();
	}

}
