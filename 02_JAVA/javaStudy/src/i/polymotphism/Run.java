package i.polymotphism;

public class Run {

	public static void main(String[] args) {
		/*
		     클래스 참조변수        =        new 클래스 생성자;
		 (부모클래스가 올 수 있다)    /     (자식클래스로 생성할 수 있음)
		 실제로 어디까지 접근이 가능   /      실제로 어떤 형태의 메모리가 생성되는지
		 
		 */
		
		Cake c1 = new CheeseCake();
		//Cake까지 접근가능하며 메모리공간은 실제 CheeseCake의 공간까지 존재한다.
		c1.sweet();
		c1.yummy(); //오버라이딩시에는 실제 메모리에 있는 재정의된 메소드가 호출됨
		((CheeseCake)c1).milky();  // -> 다운캐스팅 : 자식의 참조변수로 타입을 변경(업캐스팅관계일 때 가능)
		
		//CheeseCake c2 = new Cake();
		//실제 메모리공간이 Cake이므로 CheeseCake 공간에 접근할 수 없음.
		//-> 접근범위가 실제 메모리의 크기보다 클 수 없다.
	}

}
