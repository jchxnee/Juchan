package z.practice1;
import z.practice2.Student;
import z.practice3.Book;

public class Run {

	public static void main(String[] args) {
		Product p1 = new Product("케이스",18000,"케스티퐈");
		p1.information();
		
		Student s1 = new Student(4 , 3, "이주찬" , 140.0 , '남' );
		s1.information();
		
		Book b1 = new Book("어린왕자" , "어린아이들" , "생텍쥐페리" , 25000, 30.0);
		b1.inform();
		Book b2 = new Book("책먹는여우" , "파리바게트" , "황인태");
		b2.inform();
	}

}
