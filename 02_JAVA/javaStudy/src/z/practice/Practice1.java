package z.practice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		  키보드로 1개의 정수형(int) 데이터를 입력 받아, 
		  1~100 사이의 값일 때만 2의 배수인지 아닌지 를 출력 처리한다.
		 */
		/*
		System.out.println("정수를 입력하세요 : ");
		int n = sc.nextInt();
		if (n >= 1 && n <= 100) {
			if (n % 2 == 0) {
				System.out.println("2의 배수입니다.");
			} else {
				System.out.println("2의 배수가 아닙니다.");
			}
		}else {
		System.out.println("1~100까지의 수를 입력하세요");
		}
		== System.out.println(n % 2 == 0 ? "2의 배수입니다." : "2의 배수가 아닙니다."); //삼항연산자
		*/
		
		/*
		 * 2단에서 5단까지의 구구단의 결과 중 홀수인 것만 출력한다. 단, for문을 이용한다.
		 */
		 
		/*
		 for(int i=2; i<6; i++) {
		   for(int j=1; j<10; j++) {
		   if((i*j) % 2 ==1) {
		   System.out.print(i + " * " + j + " = " + (i*j) + " ");
		   
		   }
		   }
		   System.out.println();
		 }
		 */
		
		/*
		 * 1부터 100까지의 모든 정수들의 합과 평균을 구하는 프로그램을 작성한다. 단, while문이나 do while문을 이용하여 작성한다.
		 */
		   /*
		   float sum=0;
		   int i = 1;
			while(i<101) {
				sum += i;
				i++;
			}
			float div = (float)(sum/100);
			System.out.println("1~100까지의 합 : " + sum);
			System.out.println("1~100까지의 평균 : " + div);
			*/
			
		/*
		 * 키보드로 2개의 정수형 데이터를 입력 받아, 두 수가 모두 1부터 9까지의 수일 때만 두 수의 곱 이 한자리 수인지 두자리 수인지를
		 * 출력한다.
		 */
		  /*
		System.out.println("두 수를 입력하세요.");
		 int a = sc.nextInt();
		 int b = sc.nextInt();
		 if(a>0 && a<10 && b>0 && b<10) {
			 if((a*b)>9) {
				 System.out.println("입력하신 두 수의 곱 " + a*b + "은 두 자리입니다.");
			 } else if((a*b)<10) {
				 System.out.println("입력하신 두 수의 곱 " + a*b + "은 한 자리입니다.");
			 }
			
		 } 
		 else {
			 System.out.println("1~9까지의 수를 입력하세요.");
		 }
		  */
		
		/*
		 * 키보드로 1개의 정수형(int) 데이터를 입력 받아 1부터 5까지 일때만 해당 숫자에 해당하는 결과 를 출력 한다. 단, switch문을
		 * 이용한다. 1 : ** 입력이 정상적으로 되었습니다! ** 2 : ** 조회가 시작되었습니다! ** 3 : ** 수정이 정상적으로
		 * 되었습니다! ** 4 : ** 삭제가 정상적으로 되었습니다! ** 5 : ** 정상적으로 종료 되었습니다! ** 1~5가 아닌 값이 입력
		 * 된 경우 : ** 다시 입력해 주세요! **
		 */
		
		/*
		System.out.println("정수를 입력해주세요 : ");
		  int n = sc.nextInt();
		  switch(n) {
		  case 1 :
			  System.out.println("1 : ** 입력이 정상적으로 되었습니다! **");
			  break;
		  case 2 :
			  System.out.println("2 : ** 조회가 시작되었습니다! **");
			  break;
		  case 3 :
			  System.out.println("3 : ** 수정이 정상적으로 되었습니다! **");
			  break;
		  case 4 :
			  System.out.println("4 : ** 삭제가 정상적으로 되었습니다! **");
			  break;
		  case 5 :
			  System.out.println("5 : ** 정상적으로 종료되었습니다! **");
			  break;
	      default : 
	    	  System.out.println(" ** 다시 입력해 주세요! ** ");
			  
		  }
		  */
		  
		/*
		 * 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을
		 * 구현하세요. (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우) 합격 했을 경우 과목 별 점수와 합계,
		 * 평균, “축하합니다, 합격입니다!”를 출력하고 불합격인 경우에는 “불합격입니다.”를 출력하세요.
		 *   ex 1.         ex 2.
               국어점수 : 88      국어점수 : 88
               수학점수 : 50      수학점수 : 50
               영어점수 : 40      영어점수 : 45
               불합격입니다.      국어 : 88
                               수학 : 50
                               영어 : 45
                               합계 : 183
                               평균 : 61.0
                              축하합니다, 합격입니다!

		 * 
		 * 
		 */
		
		/*
		int sum;
		float div;
		
		 System.out.println("국어 점수 : ");
		 int ko = sc.nextInt();
		 System.out.println("영어 점수 : ");
		 int en = sc.nextInt();
		 System.out.println("수학 점수 : ");
		 int ma = sc.nextInt();
		 
		 sum = ko + en + ma;
		 div = (float)(ko + en + ma) / 3 ;
		 
		 if(ko >40 && en >40 && ma > 40 && div > 59) {
			 System.out.println("국어 : " + ko);
			 System.out.println("수학 : " + ma);
			 System.out.println("영어 : " + en);
			 System.out.println("합계 : " + sum);
			 System.out.printf("평균 : %.2f \n" , div);
			 System.out.println("축하합니다, 합격입니다!");
 
		 }else {
			 System.out.println("불합격입니다!!!!!!");
		 }
		 */
	}

}
