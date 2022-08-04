package com.my.jdbc;
import java.sql.*;
import java.util.*;

import com.mysql.cj.protocol.Resultset;
public class MemoDelete {

	public static void main(String[] args) throws Exception{
		// [1] 스캐너로 삭제할 글 번호를 입력받는다.
		//[2] DB에 연결해서 해당 글을 삭제하는 프로그램을 작성하기.
		//DELETE문 작성해서 실행하기
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8";
		String user="root",pwd="multi123";
		Connection con=DriverManager.getConnection(url, user,pwd);
		//또는 Connection con = DriverManager.getConnection(url, "root","multi123")
		//----------------------------------------------------
		//String sql="delete from memo where idx=?"
		//pt.setInt(1,Integer.parseInt(idx));// 문자열을 정수로 만듦.
		String sql="DELETE FROM memo WHERE name=(?)";
		PreparedStatement pt=con.prepareStatement(sql);
		System.out.println("삭제할 이름을 입력하세요.");
		String name=(new Scanner(System.in)).next();
		pt.setString(1,name);
		//pt.executeUpdate();//dml 문장 실행시키기
		int n=pt.executeUpdate();//dml문장을 업데이트하고, 업데이트 된 정보를 n에 담아준다.
		System.out.println(n+"개의 레코드가 삭제되었습니다.\n정보 : "+name);
		//-----------------------------------------------------
		
		
		pt.close();
		con.close();
	}

}
