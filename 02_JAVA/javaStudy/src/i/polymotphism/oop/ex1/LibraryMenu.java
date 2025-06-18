package i.polymotphism.oop.ex1;

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
	   Book [] bList = lc.selectAll();
	   for(int i=0; i<bList.length && bList[i] !=null; i++) {
		   System.out.println(i + "번도서 : " + bList[i].toString());
	   }
   }

   public void searchBook() {
	   System.out.print("검색할 제목 키워드 : ");
	   String str = sc.next();
	  
	   Book [] bk =  lc.searchBook(str);
	   for(int i=0; i<bk.length && bk[i] != null; i++) {
		   if(bk[i] == null) {
			   break;
		   }
		   System.out.println(bk[i]);
	   }
	   
	   
			   
   }

   public void rentBook() {
	   selectAll();
	   
	   System.out.print("대여할 도서 번호 선택 : ");
	   int index = sc.nextInt();
	   int result = lc.rentBook(index);
	   switch(result) {
	   case 0:
		   System.out.println("성공적으로 대여되었습니다.");
		   break;
	   case 1:
		   System.out.println("나이 제한으로 대여 불가능입니다.");
		   break;
	   case 2:
		   System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
		   break;
	   }
   }
   
   public void addBook() {
	   while(true) {
	   System.out.println("==========도서추가==========");
	   System.out.println("어떤 도서를 추가하시겠습니까?");
	   System.out.println("1. 만화책 2. 요리책");
	   System.out.print("번호 입력 : ");
	   int type = sc.nextInt();
	   sc.nextLine();
	   
	   if(!(type ==1 || type == 2)) {
		   System.out.println("잘못입력하셨습니다.");
		   continue;
	   }
		  System.out.print("제목을 입력하세요 : ");
		  String title = sc.nextLine();
		  
		  System.out.print("저자를 입력하세요 : ");
		  String author = sc.nextLine();
		  
		  System.out.print("출판사를 입력하세요 : ");
		  String publisher = sc.nextLine();
		  
		  int index = 0;
		  switch(type) {
		  case 1:
			  System.out.print("연령제한 나이를 입력하세요 : ");
			  int accessAge = sc.nextInt();
			  index = lc.insertBook(new AniBook(title,author,publisher,accessAge));
			  break;
		  case 2:
			  System.out.print("쿠폰 여부(y/n) : ");
			  boolean isCoupon = (sc.next().toLowerCase().charAt(0) == 'y');
			  index = lc.insertBook(new CookBook(title,author,publisher,isCoupon));
			  break;
		  }
		  System.out.println(index + "번째에 성공적으로 추가하였습니다.");
		  break;
	   }
	   }
   

   public void removeBook() {
	   selectAll();
	   
	   System.out.print("삭제하실 도서번호 : ");
	   int index = sc.nextInt();
	   lc.removeBook(index);
	   System.out.println("성공적으로 삭제를 완료하였습니다.");
   }
}