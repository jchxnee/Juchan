package kh.jdbc.project.jdbc.view;

import java.util.Scanner;

import kh.jdbc.project.controller.FoodController;

public class FoodMenu {
	Scanner sc = new Scanner(System.in);
	FoodController fc = new FoodController();
	
	public void mainMenu() {
		while (true) {
            System.out.println("======== 식당 예약 관리 프로그램 ========");
            System.out.println("1. 예약 추가");
            System.out.println("2. 전체 예약 조회");
            System.out.println("3. 예약 정보 수정");
            System.out.println("4. 예약 삭제");
            System.out.println("5. 예약 검색");
            System.out.println("9. 프로그램 종료");

            System.out.print("메뉴를 선택하세요: ");
            int num = sc.nextInt();
            sc.nextLine(); 
            
            switch(num) {
            case 1: 
            	loginCheck();
            	break;
            
            }
		}
	}
		
		public void insertMember() {
			System.out.println("=========== 회원 가입 ============");
			
			  System.out.print("아이디 : ");			  
		      String userId = sc.nextLine();

		      System.out.print("비밀번호 : ");
		      String userPwd = sc.nextLine();

		      System.out.print("이름 : ");
		      String userName = sc.nextLine();

		      System.out.print("나이 : ");
		      String age = sc.nextLine();

		      System.out.print("이메일 : ");
		      String email = sc.nextLine();

		      System.out.print("전화번호(-빼고입력) : ");
		      String phone = sc.nextLine();

		      System.out.print("주소 : ");
		      String address = sc.nextLine();
		      fc.insertMember(userId, userPwd, userName, Integer.parseInt(age), email, phone, address);
		}
		
		public void loginCheck() {
			while(true) {
			System.out.print("회원이시면 1번 비회원이시면 2번을 눌러주세요");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1:
				System.out.print("아이디를 입력해주세요 : ");
				String id = sc.nextLine();
				boolean isMember = fc.checkLogin(id);
				if(isMember) {
					insertReser();
					return;
				} else {
					System.out.println("입력하신 아이디가 없습니다. 다시입력해주세요.");
					
				}
			case 2:
				System.out.println("회원가입으로 이동합니다.");
				insertMember();
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		}
		public void insertReser() {
			
		}
	
	
}
