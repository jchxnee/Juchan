package kh.jdbc.project.service;

public class FoodService {
	//1) JDBC driver등록
	//2) Connection객체 생성
	//3) Connection객체 처리
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public ArrayList<Member> selectList() {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectList(conn);
		close(conn);
		
		return list;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(userId, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public ArrayList<Member> selectByUserName(String keyword){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectByUserName(keyword, conn);
		
		close(conn);
		return list;
	}
}
