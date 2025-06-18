package z.practice.oop.ex2;

public class SnackController {
	private Snack s = new Snack();

	public SnackController() {
		
	}
	
	public String savaData(String kind, String name, String flavor, int numOf, int price) {

		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료되었습니다";
		
	}
	
	public String confirmData() {
		if(this.s==null) {
			return "저장된 데이터가 없다.";
		} else 
		return s.information();
	}
	
}
