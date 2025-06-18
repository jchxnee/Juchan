package z.practice.oop.ex2;

import java.util.Scanner;

public class SnackMenu {
   private Scanner sc = new Scanner(System.in);
   private SnackController scr = new SnackController();
   
   public void menu() {
      
      
      System.out.println("스낵류를 입력하세요.");
      System.out.print("종류 : ");
      String kind = sc.nextLine();
      
      System.out.print("이름 : ");      
      String name = sc.nextLine();

      System.out.print("맛 : ");
      String flavor = sc.nextLine();

      System.out.print("개수 : ");
      int num = sc.nextInt();
      sc.nextLine();

      System.out.print("가격 : ");
      int price = sc.nextInt();
      sc.nextLine();
      System.out.println(scr.savaData(kind, name, flavor, num, price));
      
      
      System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
      char check = sc.next().charAt(0);
      if(check == 'y') {
         System.out.println(this.scr.confirmData());   
         
      }else if(check =='n') {
         return;
      }else {
         System.out.println("잘못입력하셨습니다.");
      }
      
   }
   
}
