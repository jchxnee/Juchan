package kh.jdbc.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import kh.jdbc.model.vo.CancelReason;
import kh.jdbc.model.vo.Member;
import kh.jdbc.model.vo.Reservation;
import kh.jdbc.service.ReservationService;
import kh.jdbc.view.RestaurantMenu;

/*
 * Controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 * 				해당 메서드로 전달된 데이터[가공처리후] Dao로 전달하여 호출
 * 				Dao로부터 반환받은 결과에 따라서 성공/실패 여부를 판단하여 응답화면 결정-> view메서드 호출
 */
public class ReservationController {
    private ReservationService rs = new ReservationService();
    Scanner sc = new Scanner(System.in);
    /**
     * 사용자의 예약 요청을 처리하는 메서드
     * customerName~contact : 사용자가 입력한 예약 정보를 매개변수로 받음
     */
    
    public void getMyReservations(String userId) {
        ArrayList<Reservation> list = rs.getMyReservations(userId);
        
        if (list.isEmpty()) {
            new RestaurantMenu().displayNoData("회원님의 예약 내역이 없습니다.");
        } else {
            new RestaurantMenu().displayReservationList(list);
        }
    }
    
    public void insertReservation(String customerId, String customerName, String date, String time, int peopleCount, 
    		 String contact,String request) {
        //view로부터 전달받은 값을 바로 dao쪽으로 전달하지 않고,
        //Reservation 객체에 담아서 service로 전달
        
        Reservation r = new Reservation(customerId, customerName, Date.valueOf(date), time, peopleCount, contact, request);
        
        int result = rs.insertReservation(r);
        if(result > 0) {
            new RestaurantMenu().displaySuccess("예약 추가 성공");
        } else {
            new RestaurantMenu().displayFail("예약 추가 실패");
        }
    }
    
    public void changePwd(String id, String pwd) {
    	System.out.print("기존 비밀번호를 입력해주세요 : ");
    	String password = sc.nextLine();
    	if(password.equals(pwd)) {
    	System.out.print("변경할 새로운 비밀번호를 입력해주세요 : ");
    	String newPwd = sc.nextLine();
    	int result = rs.changePassword(id, pwd, newPwd);
    	if (result > 0) {
            new RestaurantMenu().displaySuccess("비밀번호가 성공적으로 변경되었습니다.");
        } else {
            new RestaurantMenu().displayFail("비밀번호 변경에 실패했습니다. 기존 비밀번호를 확인해주세요.");
        }
    	}
    }
    
    public void cancelMember(String id, String pwd) {
        // 사용자에게 아이디와 비밀번호를 다시 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String confirmId = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String confirmPwd = scanner.nextLine();

        // 입력된 정보가 일치하는지 확인
        if (confirmId.equals(id) && confirmPwd.equals(pwd)) {
            int result = rs.deleteMember(id, pwd);
            if (result > 0) {
                System.out.println("회원탈퇴를 완료하였습니다.");
                return;
            } else {
                System.out.println("회원탈퇴를 실패하였습니다. 기존 아이디와 비밀번호를 확인해주세요");
                return;
            }
        } else {
            System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 시도해주세요.");
        }
    }

    /**
     * 모든 예약을 조회하는 메서드
     */
    public void selectList() {
        ArrayList<Reservation> list = rs.selectList();
        
        if(list.isEmpty()) { // 예약이 없을 경우
            new RestaurantMenu().displayNoData("전체 예약 조회 결과가 없습니다.");
        } else { // 예약이 있을 경우
            new RestaurantMenu().displayReservationList(list);
        }
    }
    
    
    /**
     * 예약 ID를 통해 예약을 취소하는 메서드
     */
    public void cancelReservation(String reservationID, String cancelReason) {
        int result = rs.cancelReservation(reservationID, cancelReason);
        
        if (result > 0) {
            new RestaurantMenu().displaySuccess("성공적으로 예약이 취소되었습니다.");
        } else {
            new RestaurantMenu().displayFail("예약 취소에 실패하였습니다.");
        }
    }
    
    
    /**
     * 예약 정보 수정
     * 예약 ID를 통해 예약을 수정하는 메서드
     */
    public String login(String id, String pwd) {
    	Member m = new Member();
    	m.setUserId(id);
    	m.setUserPwd(pwd);
    	String result = rs.login(m);
    	if(result != null ) {
    		System.out.println(m.getUserId() + "님 환영합니다.");
    	} else {
    		
    	}
    	return result;
    }
    
    public void insertMember(String id, String pwd, String name, char gender, String phone, String email) {
    	Member m = new Member();
    	m.setUserId(id);
    	m.setUserPwd(pwd);
    	m.setUserName(name);
    	m.setGender(gender);
    	m.setPhone(phone);
    	m.setEmail(email);
    	int rset = rs.insertMember(m);
    	
    	if(rset > 0 ) {
    		System.out.println(m.getUserName() + "님의 회원가입을 환영합니다.");
    	} else {
    		System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 시도해주세요.");
    	}
    }
    
    
    public void updateLess(String reserveId, String newDate, String newTime, int newPeopleCount) {
        Reservation r = new Reservation();
        r.setReservationId(reserveId);
        r.setReservationDate(Date.valueOf(newDate));
        r.setReservationTime(newTime);
        r.setNumOfPeople(newPeopleCount);
        
        int result = rs.updateLess(r);
        
        if (result > 0) {
            new RestaurantMenu().displaySuccess("성공적으로 예약이 변경되었습니다.");
        } else {
            new RestaurantMenu().displayFail("예약 변경에 실패하였습니다.");
        }
    }
    
	public void updateReservation(String reserveId, String newDate, String newTime, int newPeopleCount,
			String newName, String newPhone, String newRequest) {
		

		Reservation r = new Reservation();
		r.setReservationId(reserveId);
		r.setReservationDate(Date.valueOf(newDate));
		r.setReservationTime(newTime);
		r.setNumOfPeople(newPeopleCount);
		r.setCustomerName(newName);
		r.setContact(newPhone);
		r.setSpecialRequests(newRequest);

		int result = rs.updateReservation(r);

		if (result > 0) {
			new RestaurantMenu().displaySuccess("성공적으로 예약이 변경되었습니다.");
		} else {
			new RestaurantMenu().displayFail("예약 변경에 실패하였습니다.");
		}
	}
    
    /**
     * 특정 시간대 예약 조회 요청을 처리하는 메서드
     * 날짜와 시간에 따른 예약 목록을 조회
     */
    public void selectByTime(String date, String time, String ctime) {
        ArrayList<Reservation> list = rs.selectByTime(date, time, ctime);
        if(list.isEmpty()) {
            new RestaurantMenu().displayNoData(date + "날짜에 " + time + "과 " + ctime + "사이에 해당하는 예약 결과가 없습니다.");
        } else {
            new RestaurantMenu().displayReservationList(list);
        }
    }
    
    public boolean isReservationExist(String reservationId) {
        return rs.isReservationExist(reservationId);  
    }
    
    public void list(String id) {
    	 ArrayList<Reservation> list = rs.selectId(id);
    	 if(list.isEmpty()) {
             new RestaurantMenu().displayNoData("예약 내역이 없습니다.");
         } else {
             new RestaurantMenu().displayReservationList(list);
         }
    }
    
    public void displayCancelReasons() {
        ArrayList<CancelReason> cancelReasons = rs.selectCancelReasons();
        
        if (cancelReasons.isEmpty()) {
            new RestaurantMenu().displayNoData("취소 사유가 없습니다.");
        } else {
            for (CancelReason cr : cancelReasons) {
                System.out.println(cr);
            }
        }
    }
    

       
}
