package b.operator;

public class Operator1 {
	
	/*
	 *  1. 논리부정 연산자
	 *  논리값(true/false)을 반대로 바꾸는 연산자
	 * */
	public static void main(String[] args) {
		System.out.println("true의 부정 : " + (!true));
		System.out.println("false의 부정 : " + (!false));
		
		boolean b1 = !(5 > 3);
		System.out.println(b1);
	}
}
