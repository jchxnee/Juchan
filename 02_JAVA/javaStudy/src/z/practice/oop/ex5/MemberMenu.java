package z.practice.oop.ex5;

import java.util.Scanner;

public class MemberMenu {
   private Scanner sc = new Scanner(System.in);
   private MemberController mc = new MemberController();

   public MemberMenu() {
	   super();
   }

   public void mainMenu() {
	   System.out.printf("최대 등록 가능한 회원 수는 %d명입니다.\n",mc.SIZE);
	   System.out.printf("현재 등록된 회원 수는 %d명입니다.\n",mc.existMemberNum());
	   while(true) {
	   if(mc.existMemberNum() < 10) {
		   System.out.println("1. 새 회원 등록");
		   System.out.println("2. 회원 검색");
		   System.out.println("3. 회원 정보 수정");
		   System.out.println("4. 회원 삭제");
		   System.out.println("5. 모두 출력");
		   System.out.println("9. 끝내기");
		   System.out.print("메뉴 번호 : ");
		   int num = sc.nextInt();
		   switch(num) {
		   case 1:
			   insertMember();
			   break;
		   case 2:
			   searchMember();
			   break;
		   case 3:
			   updateMember();
			   break;
		   case 4:
			   deleteMember();
			   break;
		   case 5:
			   printAll();
			   break;
		   case 9:
			   System.out.println("프로그램을 종료합니다.");
			   return;
		   default : 
			   System.out.println("메뉴번호를 제대로 입력해주세요.");
		   }

	   } else {
		   System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
		   System.out.println("2. 회원 검색");
		   System.out.println("3. 회원 정보 수정");
		   System.out.println("4. 회원 삭제");
		   System.out.println("5. 모두 출력");
		   System.out.println("9. 끝내기");
		   System.out.print("메뉴 번호 : ");
		   int num = sc.nextInt();
		   switch(num) {
		   case 2:
			   searchMember();
			   break;
		   case 3:
			   updateMember();
			   break;
		   case 4:
			   deleteMember();
			   break;
		   case 5:
			   printAll();
			   break;
		   case 9:
			   System.out.println("프로그램을 종료합니다");
			   return;
		   default : 
			   System.out.println("메뉴번호를 제대로 입력해주세요.");
		   }
	   }
   }
   }

   public void insertMember() {
	    System.out.println("새 회원을 등록합니다.");

	    String id; 
	    while (true) {
	        System.out.print("아이디: ");
	        id = sc.next();

	       
	        if (mc.checkId(id)) { 
	            System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
	        } else {
	            break; 
	        }
	    }
	   System.out.print("이름 : ");
	   String name = sc.next();
	   System.out.print("비밀번호 : ");
	   String pwd = sc.next();
	   System.out.print("이메일 : ");
	   String email = sc.next();
	    
	    
	   char gender;
	   while (true) {
	        System.out.print("성별(M/F): ");
	        gender = sc.next().charAt(0);	       
	        switch(gender) {
	        case 'm','M','f','F' :
	        	return;
	        default:
	        	System.out.println("성별을 다시 입력해주세요");
	        	break;
	        }
	        
	        break;
	  
	   		}
	   System.out.println("나이 : ");
	   int age = sc.nextInt();
	   String genders = Character.toString(gender);
	   		mc.insertMember(id, name, pwd, email, genders, age);
	    }

	

   public void searchMember() {
	   System.out.println("1. 아이디로 검색하기");
	   System.out.println("2. 이름으로 검색하기");
	   System.out.println("3. 이메일로 검색하기");
	   System.out.println("9. 메인으로 돌아가기");
	   System.out.print("메뉴 번호 : ");
	   int num = sc.nextInt();
	   switch(num) {
	   case 1:
		   searchId();
		   break;
	   case 2:
		   searchName();
		   break;
	   case 3:
		   searchEmail();
		   break;
	   case 9:
		   mainMenu();
		   break;
	   default : 
		   System.out.println("잘못 입력하셨습니다.");
		   mainMenu();
		   break;
	   }
   }

   public void searchId() {
	   System.out.print("검색할 아이디 : ");
	   String id = sc.next();
	   mc.searchId(id);
   }

   public void searchName() {
	   System.out.println("검색할 이름 : ");
	   String name = sc.next();
	   mc.searchName(name);
   }

   public void searchEmail() {
	   System.out.println("검색할 이메일 : ");
	   String email = sc.next();
	   mc.searchName(email);
	   
   }

   public void updateMember() {

   }

   public void updatePassword() {

   }

   public void updateName() {

   }

   public void updateEmail() {

   }

   public void deleteMember() {

   }

   public void deleteOne() {

   }

   public void deleteAll() {

   }

   public void printAll() {

   }

}
