package b.operator;

public class Operator3 {
	/*
	   산술연산자
	   + - * / %
	   
	   [우선순위]
	   * / % > + -
	   
	   복합대입연산자
	   산술연산자와 대입연산자를 결합해서 사용할 수 있다.
	   
	   += /= -= *= %=
	   
	   a = a+3; -> a += 3;
	 */
	 public static void main(String[] args) {
		   int a = 5; //7
		   int b = 10; //9
		   int c = (++a) + b; //15
		   int d = 16/6; //1
		   int e = c%a; //6
		   int f = e++; //4
		   int g = (--b) + (d--); // 10
		   int h = 2; // 2		   
		   int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); 
                    // 12
		//최종적으로 각 변수에 값이 얼마나 들어있는지 예측해보기	 
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);

 	   }
}
