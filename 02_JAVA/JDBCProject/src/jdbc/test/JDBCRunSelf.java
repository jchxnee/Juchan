package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCRunSelf {

	public static void main(String[] args) {
		/*
		int result =0;
		Connection conn = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삽입할 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("삽입할 이름 : ");
		String name = sc.nextLine();
		
		String sql = "INSERT INTO SELF VALUES(" + num + ", '" + name + "',  + SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");
									
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			if(result >0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(result >0) {
			System.out.println("데이터 삽입 성공");
		} else {
			System.out.println("데이터 삽입 실패");
		}
		
		*/
		
		/*
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List <Self> list = new ArrayList<>();
		
		String sql = "SELECT * FROM SELF";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int tno = rs.getInt("TNO");
				String tname = rs.getString("TNAME");
				Date tdate = rs.getDate("TDATE");
				list.add(new Self(tno,tname,tdate));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(list.size() > 0) {
			System.out.println(list);
		} else {
			System.out.println("데이터를 찾을 수 없습니다.");
		}
		*/
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		
		System.out.print("수정할 TNO를 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 TNAME을 입력 : ");
		String newName = sc.nextLine();
		System.out.print("수정할 TDATE를 입력 : ");
		String newDate = sc.nextLine();
		
		String sql = "UPDATE SELF SET TNAME = ? , TDATE = TO_DATE(?,'YYYY-MM-DD') WHERE TNO = ?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setString(2, newDate);
			pstmt.setInt(3, num);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result >0 ) {
			System.out.println(num + "번째 행이 변경되었습니다.");
		} else {
			System.out.println("변경 실패");
		}
		}

}
