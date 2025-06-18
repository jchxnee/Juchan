package kh.jdbc.service;

// static으로 import시 static메서드를 직접 가져올 수 있음
import static kh.jdbc.common.JDBCTemplate.close;
import static kh.jdbc.common.JDBCTemplate.commit;
import static kh.jdbc.common.JDBCTemplate.getConnection;
import static kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import kh.jdbc.model.dao.MemberDao;
import kh.jdbc.model.dao.ReservationDao;
import kh.jdbc.model.vo.CancelReason;
import kh.jdbc.model.vo.Member;
import kh.jdbc.model.vo.Reservation;

public class ReservationService {
    //1) JDBC driver 등록
    //2) Connection 객체 생성
    //3) Connection 객체 처리
    public String login(Member m) {
    	Connection conn = getConnection();
    	String rset = new MemberDao().login(m, conn);
    	if(rset != null) {
    		commit(conn);
    	} else {
    		rollback(conn);
    	}
    	close(conn);
    	return rset;
    }
    
    public ArrayList<Reservation> getMyReservations(String userId) {
    	Connection conn = getConnection();
    	ArrayList<Reservation> list = new ReservationDao().mylist(userId,conn);
        return list;
    }
    
    public int changePassword(String id, String pwd, String newPwd) {
    	Connection conn = getConnection();
    	int result = new MemberDao().changeMember(id, pwd, newPwd, conn);
    	if(result > 0) {
    		commit(conn);
    	} else {
    		rollback(conn);
    	}
    	close(conn);
    	return result;
    }
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
    
    public int deleteMember(String id, String pwd) {
    	Connection conn = getConnection();
    	int result = new MemberDao().deleteMember(id, pwd, conn);
    	if(result > 0) {
    		commit(conn);
    	} else {
    		rollback(conn);
    	}
    	close(conn);
    	return result;
    }
    
    public int insertReservation(Reservation r) {
        Connection conn = getConnection();
        int result = new ReservationDao().insertReservation(r, conn);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
    
    public ArrayList<Reservation> selectList() {
        Connection conn = getConnection();
        ArrayList<Reservation> list = new ReservationDao().selectList(conn);
        close(conn);
        
        return list;
    }
    
    public ArrayList<Reservation> selectId(String id) {
        Connection conn = getConnection();
        ArrayList<Reservation> list = new ReservationDao().isReservation(id,conn);
        close(conn);
        
        return list;
    }
    

    public int cancelReservation(String reservationID, String cancelReason) {
        Connection conn = getConnection();
        int result = new ReservationDao().cancelReservation(reservationID, conn);
        
        if (result > 0) {
            new ReservationDao().saveCancelReason(reservationID, cancelReason, conn);
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
    
    
    public int updateReservation(Reservation r) {
        Connection conn = getConnection();
        int result = new ReservationDao().updateReservation(r, conn);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
    
    public int updateLess(Reservation r) {
        Connection conn = getConnection();
        int result = new ReservationDao().updateLess(r, conn);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
    
    public ArrayList<Reservation> selectByTime(String date, String time, String ctime) {
        Connection conn = getConnection();
        ArrayList<Reservation> list = new ReservationDao().selectByTime(date, time, ctime, conn);
        
        close(conn);
        return list;
    }
    
    public boolean isReservationExist(String reservationId) {
    	Connection conn = getConnection();
    	boolean result = new ReservationDao().isReservationExist(reservationId, conn);
        return  result; 
    }
    
    public ArrayList<CancelReason> selectCancelReasons() {
    	Connection conn = getConnection();
        return new ReservationDao().selectCancelReasons(conn);
    }
}
