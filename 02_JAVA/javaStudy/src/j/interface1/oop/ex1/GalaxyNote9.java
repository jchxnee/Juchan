package j.interface1.oop.ex1;

public class GalaxyNote9 extends SmartPhone implements NotePen{
	
	public GalaxyNote9() {
		super();
		this.setMaker("삼성");		
	}

	@Override
	public String printInformation() {
		String result = "";
		result += "갤럭시 노트9은 " + this.getMaker() + "에서 만들어졌고 제원은 다음과 같다.\n";
		result += this.makeCall() + "\n";
		result += this.takeCall() + "\n";
		result += this.picture() + "\n";
		result += this.charge() + "\n";
		result += this.touch() + "\n";
		result += "블루투스 펜 탑재 여부 : " + this.bluetoothPen();
		return result;
	   }

	@Override
	public boolean bluetoothPen() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String charge() {
		return "고속 충전, 고속 무선 충전";
	}

	@Override
	public String makeCall() {
		return "번호를 누르고 통화버튼을 누름";
	}

	@Override
	public String takeCall() {
		return "전화받기 버튼을 누름";
	}

	@Override
	public String picture() {
		return "1300만 듀얼카메라";
	}

	@Override
	public String touch() {
		return "정전식, 와콤펜 지원";
	}
	
	
}
