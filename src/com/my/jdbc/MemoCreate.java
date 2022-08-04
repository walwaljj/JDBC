package com.my.jdbc;
import java.sql.*;
//jdbc : Java Datebase Connectivity
//java 언어 <====> Driver[통역]<====>db sql언어
//jdbc 드라이버 다운로드 ==> dbms마다 제공드라이버가 다르다.
//xxx.jar 파일로 제공.....
public class MemoCreate {

	public static void main(String[] args) {
		//1. 드라이버 로딩.
		//대문자 클래스는 그냥 클래스 소문자는 키워드임
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		//2.DB 연경
			String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8"; 
						//jdbc : 프로토콜
						//mysql : dbms유형
						//localhost:3306 : 호스트 
						//schooldb : 데이터베이스
			
			//로그인
			String user="root",pwd="multi123";
			
			
			Connection con=DriverManager.getConnection(url,user,pwd);
			System.out.println("DB연결 성공!");
			
			
			//3. 테이블 만들기. 쿼리문 작성 -- sql문이지만 자바 dyte타입으로 생성
			String sql="create table if not exists memo("
					  + "idx int auto_increment primary key,"
					  + "name varchar(20) not null,"
					  + "msg varchar(100),"
					  + "wdate datetime default now() )";
			
			// 4.Statement 객체 얻어오기
			// PreparedStatement
			Statement stmt = con.createStatement();
			//5. sql문 실행시키기 : execute : 실행하다.
			stmt.execute(sql);
			System.out.println("Memo테이블 생성 성공 (테이블은 한번만 생성가능)");
			
			//6. db 연결자원 해제
			stmt.close();
			con.close();
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"+e);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
