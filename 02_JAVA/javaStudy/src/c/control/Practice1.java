package c.control;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 나이를 입력받아 13세이하면 : 어린이 13세 초과 19세이하 : 청소년 19세 초과 : 성인
		 * 
		 * [출력문] 나이를 입력 : xx xx세는 xxx에 속합니다.
		 */

//		System.out.println("나이를 입력 : ");
//		int a = sc.nextInt();
//		
//		if(a<=13) {
//			System.out.println(a + "세는 " + "어린이에 속합니다.");
//		}else if(a > 13 && a <= 19) {
//			System.out.println(a + "세는 " + "청소년에 속합니다.");
//		}else
//			System.out.println(a + "세는 " + "성인에 속합니다.");
//		
		/*
		 * 성별을 (m/f)(대소문자 상관x)로 입력받아 남학생인지 여학생인지 출력하는 프로그램을 작성하세요.
		 * 
		 * [출력문] 성별(m/f) : x 여학생입니다 / 남학생입니다 / 잘못입력하셨습니다.
		 * 
		 */
//		System.out.println("성별(m/f) : ");
//		String str = sc.next();
//		//char str = sc.next().charAt(0);
//		
//		if (str.equals("m")) {
//		//if (str == 'f' || str == 'F') {
//			
//			System.out.println("남학생입니다");
//		}else if (str.equals("f")) {			
//		//else if (str == 'm' || str =='M') {
//			
//			System.out.println("여학생입니다");
//		}else
//			System.out.println("잘못입력하셨습니다");

		/*
		 * 정수(양수)를 입력받아 짝수인지 홀수인지 출력하는 프로그램을 작성하라
		 * 
		 * [출력문] 정수 입력 : xx 짝수다 / 홀수다 / 양수가아니다.
		 */

		System.out.println("정수 입력 : ");
		int a = sc.nextInt();
		if (a % 2 == 0 && a > 0) {
			System.out.println("짝수다");

		} else if (a % 2 == 1 && a > 0) {
			System.out.println("홀수다");
		} else
			System.out.println("양수가아니다.");
	}

}
