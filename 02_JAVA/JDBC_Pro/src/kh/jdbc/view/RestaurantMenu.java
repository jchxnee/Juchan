package kh.jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.jdbc.controller.ReservationController;
import kh.jdbc.model.vo.Member;
import kh.jdbc.model.vo.Reservation;

public class RestaurantMenu {
    private Scanner sc = new Scanner(System.in);
    private ReservationController rc = new ReservationController();

    // 메인 메뉴
    public void mainMenu() {
        while (true) {
            System.out.println("========== 식당 예약 프로그램 ==========");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 예약 조회");
            System.out.println("4. 특정 시간대 예약 조회");
            System.out.println("9. 프로그램 종료");

            System.out.print("메뉴 입력: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
            	case 1:
            		this.login();
            		break;
            	case 2:
            		this.createMember();
                case 3:
                    rc.selectList();
                    break;
                case 4:
                	this.searchReservationByTime();
                    break;
                case 6:
                	String reservationID = this.inputReservationID();
                    System.out.print("취소 이유를 입력해주세요: ");
                    String cancelReason = sc.nextLine();
                    rc.cancelReservation(reservationID, cancelReason);
                    break;
                case 7:
                    this.searchReservationByTime();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }
    
    public void login() {
    	while(true) {
    	System.out.print("아이디 : ");
    	String id = sc.nextLine();
    	
    	System.out.print("비밀번호 : ");
    	String pwd = sc.nextLine();
    	
    	String user = rc.login(id,pwd);
    	if(user != null) {
    	this.Member(id,pwd);
    	break;
    	} else {
    		System.out.println("회원 정보가 없습니다. 다시 입력해주세요");
    		break;
    	}
    	}
    }
    
    public void createMember() {
    	System.out.println("==========회원가입==========");
    	
    	System.out.print("아이디 : ");
    	String id = sc.nextLine();
    	
    	System.out.print("비밀번호 : ");
    	String pwd = sc.nextLine();
    	
    	System.out.print("이름 : ");
    	String name = sc.nextLine();
    	
    	System.out.print("성별(M/F) : ");
    	char gender = sc.nextLine().charAt(0);
    	
    	System.out.print("전화번호 : ");
    	String phone = sc.nextLine();
    	
    	System.out.print("이메일 : ");
    	String email = sc.nextLine();
    	
    	 rc.insertMember(id,pwd,name,gender,phone,email);
    	 System.out.print("회원가입이 완료되었습니다. 로그인하시겠습니까?(y/n) : ");
    	 String a = sc.nextLine();
    	 if(a.equals("y")) {
    		 this.login();
    	 } else if(a.equals("n")){
    		 this.mainMenu();
    	 } 
    	 
    }
    
    public void Member(String id, String pwd) {
    	while(true) {
    	System.out.println("========== 회원 페이지 ==========");
    	System.out.println("1. 내 예약 조회");
    	System.out.println("2. 내 예약 취소");
    	System.out.println("3. 내 예약 추가");
    	System.out.println("4. 내 예약 변경");
    	System.out.println("5. 비밀번호 변경");
    	System.out.println("6. 회원탈퇴");
    	System.out.println("7. 고객들의 취소사유 출력");
    	System.out.println("8. 로그아웃 후 메인으로");
    	System.out.print("메뉴 입력 : ");
    	int choice = sc.nextInt();
    	sc.nextLine();
    	switch(choice) {
    	case 1:
    		rc.getMyReservations(id);
    		break;
    	case 2:
    		 String reservationID = this.inputReservationID();
    		    System.out.print("취소 이유를 입력해주세요: ");
    		    String cancelReason = sc.nextLine();
    		    rc.cancelReservation(reservationID, cancelReason);
    		    break;
    	case 3:
            this.insertReservation();
            break;
    	case 4:
            this.updateReservation();
            break;
            
    	case 5:
        	rc.changePwd(id, pwd);
 
        	System.out.print("다시 로그인하시겠습니까? (y/n): ");
        	String a = sc.nextLine();
        	if(a.equals("y")) {
        		this.login();
        		break;
        	} else if(a.equals("n")){
        		System.out.println("회원페이지로 돌아갑니다.");
        		break;
        	} else {
        		System.out.println("y나 n으로 입력해주세요.");
        		continue;
        	}
        	
    	case 6:
    		rc.cancelMember(id, pwd);
    		this.mainMenu();
    		break;
    	case 7:
    		this.displayCancelReasons();
    	    break;
    	case 8:
    		System.out.println("로그아웃되었습니다.");
    		this.mainMenu();
    	default:
    		System.out.println("메뉴번호를 다시 입력해주세요.");
    	}
    }
    }
    // 예약 추가
    public void insertReservation() {
        System.out.println("========== 예약 추가 ==========");
        
        System.out.print("고객 아이디: ");
        String customerId = sc.nextLine();
        
        System.out.print("고객 이름: ");
        String customerName = sc.nextLine();

        System.out.print("예약 날짜 (yyyy-mm-dd): ");
        String date = sc.nextLine();

        System.out.print("예약 시간 (hh:mm): ");
        String time = sc.nextLine();

        System.out.print("인원 수: ");
        int peopleCount = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        System.out.print("연락처: ");
        String contact = sc.nextLine();
        
        System.out.print("추가 요청사항: ");
        String request = sc.nextLine();

        rc.insertReservation(customerId, customerName, date, time, peopleCount, contact, request);
    }

    // 예약 변경
    public void updateReservation() {
        System.out.println("========== 예약 변경 ==========");
        String reservationID = inputReservationID();
        
        // 예약 ID 유효성 확인
        while(true) {
            if (rc.isReservationExist(reservationID)) {
                System.out.println(reservationID + "님이 예약하신 목록입니다.");
                rc.list(reservationID);
                System.out.println("예약 변경을 시작합니다.");
                break;
            } else {
                System.out.println("해당 예약 ID는 존재하지 않습니다. 다시 입력해주세요");
                reservationID = inputReservationID();
            }
        }
        
        System.out.print("변경할 날짜 (yyyy-mm-dd) : ");
        String newDate = sc.nextLine();
        
        System.out.print("변경할 예약 시간 (hh:mm): ");
        String newTime = sc.nextLine();

        System.out.print("변경할 인원 수: ");
        int newPeopleCount = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        System.out.print("추가 정보를 변경하시겠습니까?(Y/N) : ");
        char choice = sc.next().charAt(0);
        
        // 추가 정보 변경 여부 확인 후 처리
        if(choice == 'Y') {
            sc.nextLine();  // 버퍼 비우기
            System.out.print("변경할 예약자명 : ");
            String newName = sc.nextLine();
            
            System.out.print("변경할 전화번호 : ");
            String newPhone = sc.nextLine();
            
            System.out.print("변경할 요청사항 : ");
            String newRequest = sc.nextLine();
            
            rc.updateReservation(reservationID, newDate, newTime, newPeopleCount, newName, newPhone, newRequest);
        } else if(choice == 'N') {
            rc.updateLess(reservationID, newDate, newTime, newPeopleCount);
        }
    }

    // 예약 조회
    public void searchReservationByTime() {
        System.out.println("========== 특정 시간대 예약 조회 ==========");
        System.out.print("조회할 날짜 (yyyy-mm-dd): ");
        String date = sc.nextLine();

        System.out.print("조회할 시작 시간 (hh:mm): ");
        String time = sc.nextLine();
        
        System.out.print("조회할 종료 시간 (hh:mm): ");
        String ctime = sc.nextLine();
        
        System.out.println("입력하신 시작시간에서 종료시간 사이에 예약이 출력됩니다.");
        rc.selectByTime(date, time, ctime);
    }

    // 예약 취소
    public String inputReservationID() {
        System.out.print("예약 ID: ");
        String id = sc.nextLine();
        return id;
    }

    // 성공 메시지 출력
    public void displaySuccess(String message) {
        System.out.println("서비스 요청 성공: " + message);
    }

    // 실패 메시지 출력
    public void displayFail(String message) {
        System.out.println("서비스 요청 실패: " + message);
    }

    // 조회결과가 없을 때
    public void displayNoData(String message) {
        System.out.println(message);
    }

    // 예약 목록 출력
    public void displayReservationList(ArrayList<Reservation> list) {
        for (Reservation r : list) {
            System.out.println(r);
        }
    }
    
    public void displayCancelReasons() {
        System.out.println("========== 취소 사유 목록 ==========");
        rc.displayCancelReasons();
    }
}
