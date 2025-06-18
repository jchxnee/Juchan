package z.practice;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("고등학교 이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("평균 점수 기준을 입력하세요: ");
		double average = sc.nextDouble();
		System.out.println("영어 점수 기준을 입력하세요 : ");
		double english = sc.nextDouble();
		System.out.println("수학 점수 기준을 입력하세요 : ");
		double math = sc.nextDouble();
		System.out.println("국어 점수 기준을 입력하세요 : ");
		double korean = sc.nextDouble();
		
		HighSchool dard = new HighSchool(name, average, math, korean, english);
		
		System.out.println("학생 이름을 입력하세요 : ");
		String stname = sc.next();
		System.out.println("학생 나이를 입력하세요 : ");
		int stage = sc.nextInt();
		System.out.println("수학 점수를 입력하세요 : ");
		double stmath = sc.nextInt();
		System.out.println("국어 점수를 입력하세요 : ");
		double stkorean = sc.nextInt();
		System.out.println("영어 점수를 입력하세요 : ");
		double steng = sc.nextDouble();
		double avg = (stmath + stkorean + steng) / 3.0;
		
		HighSchool kim = new HighSchool(stname, avg, stmath, stkorean, steng);
		
		kim.apply(stname, avg, stmath, stkorean, steng);
		
		
	}

}
