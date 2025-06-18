package z.practice.object;

public class Run {

	public static void main(String[] args) {
		Member m1 = new Member("intae" , "123456", "황인태");
		Member m2 = new Member("dongki" , "234567" , "김동기");
		Member m3 = new Member("sanghyun" , "578901", "유상현");
		
		m1.setInfo("292929", "qwejjb@naver.com", 25, '남');
		m2.setInfo("393939", "asd@naver.com", 27, '남');
		m3.setInfo("494949", "qwer@naver.com", 28, '남');
		
		m1.toInfo();
		m2.toInfo();
		m3.toInfo();
		
		
	}

}
