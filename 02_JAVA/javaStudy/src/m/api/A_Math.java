package m.api;
import java.lang.*; //내가 직접 import하지 않아도 무조건 import
public class A_Math {
	//java.lang.Math
	//모든 필드 상수필드, 모든 메소드가 static메소드이다. 	
	public void method01() {
		System.out.println("PI : " + Math.PI);
		
		//랜덤수
		System.out.println("랜덤(0.0~0.99) : " + Math.random());
		
		//절대값
		double num1 = -10.45;
		System.out.println("절대값 : " + Math.abs(num1));
		
		//올림
		double nume2 = 10.49;
		System.out.println("올림 : " + Math.ceil(nume2));
		
		//반올림
		System.out.println("반올림 : " + Math.round(nume2));
		
		//버림
		System.out.println("버림 : " + Math.floor(nume2));
		
		//제곱
		System.out.println("2의 10제곱 : " + Math.pow(2,10));
	}

}
