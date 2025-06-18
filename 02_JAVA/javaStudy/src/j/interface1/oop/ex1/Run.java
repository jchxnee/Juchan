package j.interface1.oop.ex1;
public class Run {

	public static void main(String[] args) {
		PhoneController phc = new PhoneController();
		String [] result = phc.method();
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
			System.out.println();
		}

	}

}
