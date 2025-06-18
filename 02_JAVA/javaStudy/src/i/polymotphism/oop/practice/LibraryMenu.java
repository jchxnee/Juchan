package i.polymotphism.oop.practice;

import java.util.Scanner;

public class LibraryMenu {
   private LibraryController lc = new LibraryController();
   private Scanner sc = new Scanner(System.in);

   public void mainMenu() {
	   System.out.print("이름 : ");
	   String name = sc.next();
	   System.out.print("나이 : ");
	   int age = sc.nextInt();
	   System.out.print("성별 : ");
	   char gender = sc.next().charAt(0);
	   Member mem = new Member(name, age, gender);
	   lc.insertMember(mem);
	   
	   while(true) {
		   System.out.println();
		   System.out.println("==== 메뉴 ====");
		   System.out.println("1. 마이페이지");
		   System.out.println("2. 도서 전체 조회");
		   System.out.println("3. 도서 검색");
		   System.out.println("4. 도서 대여하기");
		   System.out.println("5. 도서 추가하기"); // 추가가능한지?
		   System.out.println("6. 도서 삭제하기"); //어떤 도서를 삭제할지?
		   System.out.println("9. 프로그램 종료하기");
		   System.out.print("메뉴 번호 : ");
		   int num = sc.nextInt();
		   switch(num) {
		   case 1:
			   Member m = lc.myInfo();
			   System.out.println(m);
			   break;
		   case 2:
			   selectAll();
			   break;
		   case 3:
			   searchBook();
			   break;
		   case 4:
			   rentBook();
			   break;
		   case 5:			   
			   if(lc.checkInsertBook()) {
				   addBook();
			   } else {
				   System.out.println("추가가능한 도서의 수를 초과하였습니다.");
			   }
			   break;
		   case 6:
			   removeBook();
			   break;		   
		   case 9:
			   return;
		   default:
			  System.out.println("다시 입력해주세요."); 
		   }
	   }
   }

   public void selectAll() {
	  Book [] bk = lc.selectAll();
	  
	  for(int i=0; i<bk.length; i++) {
		  if(bk[i] != null) {
		  System.out.println(i + "번째 도서 : " + bk[i]);
	  } else
		  System.out.println("출력할 도서가 없습니다.");
	  }
   }

   public void searchBook() {
	   System.out.print("검색할 제목 키워드 : ");
	   String title = sc.next();
	   Book [] searchList = lc.searchBook(title);
	   for(int i =0; i<searchList.length; i++) {
		   if(searchList[i] != null) {
		   System.out.println(searchList[i]);
	   }
	   }
   }

   public void rentBook() {
	   selectAll();
	   
	   System.out.print("대여할 도서 번호 선택 : ");
	   int index = sc.nextInt();
	   int result = lc.rentBook(index);
	   switch(result) {
	   case 1:
		   System.out.println("나이제한으로 대여 불가");
		   break;
	   case 2:
		   System.out.println("성공적으로 대여 완료, 요리학원 쿠폰 발급");
		   break;
	   }
   }
   
   public void addBook() {
	   
	   }
   

   public void removeBook() {
	  
}
}