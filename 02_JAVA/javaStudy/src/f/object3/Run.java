package f.object3;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		
	//choi객체 생성 최지원, 15살, 영어 : 60, 수학 : 80, 국어 : 90
	//kim객체 생성 김민수, 17살, 영어 : 75, 수학 : 60, 국어 : 70
	//park객체 생성 박지민, 19살, 영어 : 45, 수학 : 90, 국어 : 85
	  Student choi = new Student("최지원", 15, 60, 80, 90);
	  Student kim = new Student("김민수", 17, 75, 60, 70);
	  Student park = new Student("박지민", 19, 45, 90, 85);
	  
	  //각 학생의 평균을 구하세요.
//	  double choiAvg = (choi.enScore + choi.koScore + choi.mathScore) / 3.0;
//	  double kimAvg = (kim.enScore + kim.koScore + kim.mathScore) / 3.0;
//	  double parkAvg = (park.enScore + park.koScore + park.mathScore) / 3.0;
//
//	  System.out.println(choi.name + "의 평균 : " + choi.getAvg());
//	  System.out.println(kim.name + "의 평균 : " + kim.getAvg());
//	  System.out.println(park.name + "의 평균 : " + park.getAvg());
	  
	  //lee라는 객체를 만들 것이다.
	  //사용자로부터 이름, 나이, 영어점수, 수학점수, 국어점수를 입력받아
	  //평균을 구해서 출력하는 프로그램 작성
	  
	  Scanner sc = new Scanner(System.in);
	  String name;
	  int age;
	  double mathScore, enScore, koScore;
	  
	  System.out.println("이름을 입력하세요 : ");
	  name = sc.next();
	  System.out.println("나이를 입력하세요 : ");
	  age = sc.nextInt();
	  System.out.println("수학점수를 입력하세요 : ");
	  mathScore = sc.nextInt();
	  System.out.println("영어점수를 입력하세요 : ");
	  enScore = sc.nextInt();
	  System.out.println("국어점수를 입력하세요 : ");
	  koScore = sc.nextInt();
	  
	  Student lee = new Student(name, age, mathScore, enScore, koScore);
//	  System.out.println(lee.name + "의 평균 : " + lee.getAvg());
	  
	  //kh대학교 evgcut : 75, encut : 60, kocut : 60
	  University kh = new University("kh대학교", 75, 60, 60);
	  
	  kh.apply(lee.name, lee.getAvg(), lee.enScore, lee.koScore, lee.mathScore);
	  kh.apply(choi.name, choi.getAvg(), choi.enScore, choi.koScore, choi.mathScore);
	  kh.apply(kim.name, kim.getAvg(), kim.enScore, kim.koScore, kim.mathScore);
	  kh.apply(park.name, park.getAvg(), park.enScore, park.koScore, park.mathScore);
	}

}
