package kh.jdbc.model.dao;

import static kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import kh.jdbc.model.vo.CancelReason;
import kh.jdbc.model.vo.Member;
import kh.jdbc.model.vo.Reservation;
import kh.jdbc.view.RestaurantMenu;

public class ReservationDao {

    private Properties prop = new Properties();

    public ReservationDao() {
        super();
        try {
            prop.loadFromXML(new FileInputStream("resources/query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 예약 정보를 DB에 추가하는 메서드
     * Reservation r : 사용자가 입력한 예약 정보가 담긴 Reservation 객체
     * insert 실행 후 처리된 행 수 리턴(int)
     */
    
    public ArrayList<Reservation> mylist(String id, Connection conn) {
        ResultSet rset = null;
        ArrayList<Reservation> list = new ArrayList<>();

        PreparedStatement pstmt = null;
        
        Member m = new Member();
        String sql = prop.getProperty("myreservation");

        try {
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, id);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rset.getString("CID"));
                r.setCustomerName(rset.getString("CNAME"));
                r.setReservationDate(rset.getDate("CDATE"));
                r.setReservationTime(rset.getString("CTIME"));
                int count = rset.getInt("NUM_PEOPLE");
                r.setNumOfPeople(count);
                r.setContact(rset.getString("PHONE"));
                r.setSpecialRequests(rset.getString("CREQUEST"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;
    }
    
    public int insertReservation(Reservation r, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;

        String sql = prop.getProperty("insertReservation");

        try {
        	
        	 LocalDateTime now = LocalDateTime.now(); 

             // 예약 날짜와 시간을 합쳐서 LocalDateTime 객체로 변환
             String reservationDateTimeStr = r.getReservationDate() + " " + r.getReservationTime(); // "2025-02-04 18:50"
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
             LocalDateTime reservationDateTime = LocalDateTime.parse(reservationDateTimeStr, formatter);

             // 현재 시간보다 이전이면 예약 불가
             if (reservationDateTime.isBefore(now)) {
                 System.out.println("예약할 수 없는 시간입니다. 현재 시간 이후로 선택해주세요.");
                 return 0; // 예약 등록하지 않음
             }
             
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, r.getReservationId());
            pstmt.setString(2, r.getCustomerName());
            pstmt.setDate(3, r.getReservationDate());
            pstmt.setString(4, r.getReservationTime());
            pstmt.setInt(5, r.getNumOfPeople());
            pstmt.setString(6, r.getContact());
            pstmt.setString(7, r.getSpecialRequests());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

    /**
     * 모든 예약 목록을 반환하는 메서드
     * ArrayList<Reservation> : 예약 목록을 담은 리스트
     */
    public ArrayList<Reservation> selectList(Connection conn) {
        ResultSet rset = null;
        ArrayList<Reservation> list = new ArrayList<>();

        PreparedStatement pstmt = null;

        String sql = prop.getProperty("selectList");

        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rset.getString("CID"));
                r.setCustomerName(rset.getString("CNAME"));
                r.setReservationDate(rset.getDate("CDATE"));
                r.setReservationTime(rset.getString("CTIME"));
                int count = rset.getInt("NUM_PEOPLE");
                r.setNumOfPeople(count);
                r.setContact(rset.getString("PHONE"));
                r.setSpecialRequests(rset.getString("CREQUEST"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;
    }

    /**
     * 예약 ID를 받아 예약을 취소하는 메서드
     * delete문 실행 후 처리된 행 수 리턴(int)
     */
    public int cancelReservation(String reservationId, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;

        String sql = prop.getProperty("cancelReservation");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reservationId);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
    

    /**
     * Reservation 객체를 통해 예약 정보를 수정하는 메서드
     */
    public int updateLess(Reservation r, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;

        String sql = prop.getProperty("updateLess");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, r.getReservationDate());
            pstmt.setString(2, r.getReservationTime());
            pstmt.setInt(3, r.getNumOfPeople());
            pstmt.setString(4, r.getReservationId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
        	if(e.getErrorCode() == 20001) {
        		new RestaurantMenu().displayFail(e.getMessage());
        	} else {
            e.printStackTrace();
        	}
        } finally {
            close(pstmt);
        }

        return result;
    }
    
    public int updateReservation(Reservation r, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;

        String sql = prop.getProperty("updateReservation");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, r.getCustomerName());
            pstmt.setDate(2, r.getReservationDate());
            pstmt.setString(3, r.getReservationTime());
            pstmt.setInt(4, r.getNumOfPeople());
            pstmt.setString(5, r.getContact());
            pstmt.setString(6, r.getSpecialRequests());
            pstmt.setString(7, r.getReservationId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            if(e.getErrorCode() == 20001) {
                new RestaurantMenu().displayFail(e.getMessage());
            } else {
                e.printStackTrace();
            }	
        } finally {
            close(pstmt);
        }

        return result;
    }

    /**
     * 예약 시간을 기준으로 예약 목록을 반환하는 메서드
     * date와 time을 기준으로 예약 목록을 검색
     */
    public ArrayList<Reservation> selectByTime(String date, String startTime, String endTime, Connection conn) {
        ArrayList<Reservation> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("selectByTime");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, date);      // 날짜를 문자열로 바인딩
            pstmt.setString(2, startTime); // 시작 시간 문자열로 바인딩
            pstmt.setString(3, endTime);   // 종료 시간 문자열로 바인딩

            rset = pstmt.executeQuery();

            while (rset.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rset.getString("CID"));
                r.setCustomerName(rset.getString("CNAME"));
                r.setReservationDate(rset.getDate("CDATE"));
                r.setReservationTime(rset.getString("CTIME"));
                r.setNumOfPeople(rset.getInt("NUM_PEOPLE"));
                r.setContact(rset.getString("PHONE"));
                r.setSpecialRequests(rset.getString("CREQUEST"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;
    }
    
    public boolean isReservationExist(String reservationId, Connection conn) {
        String sql = "SELECT 1 FROM RESERVATION WHERE CID = ?"; //아이디는 기본키이므로 중복결과가 없으므로 모든 데이터를 검색할 필요없이 1만 검색
        try (
        	PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, reservationId);
            ResultSet rs = pstmt.executeQuery();
            
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Reservation> isReservation(String reservationId, Connection conn) {
        String sql = "SELECT * FROM RESERVATION WHERE CID = ?"; // 예약 ID로 조회
        
        ArrayList<Reservation> list = new ArrayList<>();
        
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reservationId); // 예약 ID를 매개변수로 사용
            ResultSet rs = pstmt.executeQuery();
            
            // 결과 처리 로직 추가
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationId(rs.getString("CID"));
                r.setCustomerName(rs.getString("CNAME"));
                r.setReservationDate(rs.getDate("CDATE"));
                r.setReservationTime(rs.getString("CTIME"));
                r.setNumOfPeople(rs.getInt("NUM_PEOPLE"));
                r.setContact(rs.getString("PHONE"));
                r.setSpecialRequests(rs.getString("CREQUEST"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return list;

    
    }
    
    public void saveCancelReason(String reservationId, String cancelReason, Connection conn) {
        String sql = "INSERT INTO cancel_reasons (reservation_id, cancel_date, cancel_reason) VALUES (?, SYSTIMESTAMP, ?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reservationId);
            pstmt.setString(2, cancelReason);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public ArrayList<CancelReason> selectCancelReasons(Connection conn) {
        String sql = "SELECT * FROM CANCEL_REASONS"; // 모든 취소 사유 조회
        
        ArrayList<CancelReason> list = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            // 결과 처리 로직 추가
            while (rs.next()) {
                CancelReason cr = new CancelReason();
                cr.setReservationId(rs.getString("reservation_id"));
                cr.setCancelDate(rs.getTimestamp("cancel_date"));
                cr.setCancelReason(rs.getString("cancel_reason"));
                list.add(cr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return list;
    }
}
