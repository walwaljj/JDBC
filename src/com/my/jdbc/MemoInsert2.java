package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class MemoInsert2 {

	public static void main(String[] args)
		throws Exception{// throws나 try~catch 꼭해줘야함
		Scanner sc=new Scanner(System.in);
		System.out.println("작성자 : ");
		String name=sc.nextLine();
		System.out.println("메모 내용 : ");
		String msg=sc.nextLine();
		System.out.println(name+"/"+msg);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8"; 
		//jdbc : 프로토콜
		//mysql : dbms유형
		//localhost:3306 : 호스트 
		//schooldb : 데이터베이스
		
		// -----------------------------------------------------입력받을 준비-------------
		
		//로그인
		String user="root",pwd="multi123";
		
		//db연결
		Connection con=DriverManager.getConnection(url, user,pwd);// 하려면 spl* import해야함
		
		//PreparedStatement는 동적으로 바뀌는 값 부분을 인 파라미터(?)로 대치해서 sql문을 작성한다.
		//					=> in 파라미터를 제외한 sql문을 미리 컴파일해서 준비시켜놓는다.
		
		
		String sql="insert into memo(name,msg,wdate) values(?,?,now())";// insert 하겠다.
		//?를 제외한 나머지 문장을 컴파일해 준비시키고
		// 스캐너로 입력받은 내용을 차례로
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		
		//첫번째 ? 값을 입력받은 스케너의 String 값으로 set하겟다.
		pstmt.setString(1, name);
		
		//두번째 ? 값을 입력받은 스케너의 String 값으로 set하겟다.
		pstmt.setString(2, msg);
		
		int n=pstmt.executeUpdate();// 또는 stmt.execute(sql); 형식으로..!
		
		System.out.println(n+"개의 레코드를 등록했습니다.");
		
		pstmt.close();
		con.close();// 꼭해야함! 아니면 시스템이 에러남

	}

}
