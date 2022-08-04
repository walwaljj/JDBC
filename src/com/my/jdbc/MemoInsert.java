package com.my.jdbc;

import java.sql.DriverManager;
import java.sql.*;
public class MemoInsert {

	public static void main(String[] args) 
	throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8"; 
		//jdbc : 프로토콜
		//mysql : dbms유형
		//localhost:3306 : 호스트 
		//schooldb : 데이터베이스
		

		//로그인
		String user="root",pwd="multi123";
		
		//db연결
		Connection con=DriverManager.getConnection(url, user,pwd);// 하려면 spl* import해야함
		
		String sql="insert into memo(name,msg,wdate) values('이상해','오늘 하루도 무사히..',now())";
		//varchar는 홑따옴표가꼭 와야하고, 자바에서는 문장끝에 ;를 하면안됨
		Statement stmt=con.createStatement();
		//stmt.execute(sql);==> 모든 wql문을 실행시키는 메서드
		stmt.execute(sql);
		
		
		//DML 문장(insert/update/delete)==>int executeUpdate(String sql)
		//n:sql 문에 의해 영향받은 레코드 수를 반환한다.
		int n=stmt.executeUpdate(sql);
		
		System.out.println(n+"개의 메모를 등록했습니다.");
		
		
		stmt.close();
		con.close();
				
	}

}
