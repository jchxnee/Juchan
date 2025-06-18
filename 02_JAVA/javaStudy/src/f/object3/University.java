package f.object3;

public class University {
	String name;
	int evgCut;
	int koCut;
	int enCut;
	
	public University() {
		super();
	}

	public University(String name, int evgCut, int koCut, int enCut) {
		super();
		this.name = name;
		this.evgCut = evgCut;
		this.koCut = koCut;
		this.enCut = enCut;
	}
	
	//지원한뒤 합격이면 true / 불합격이면 false 리턴
	public void apply(String name, double avg, double enScore, double koScore, double mathScore) {
		if(avg >= this.evgCut &&
				enScore >= this.enCut &&
				koScore >= this.koCut) {
			System.out.println(name + "님 합격입니다.");
		}else {
			System.out.println(name + "님 불합격입니다.");
		}
	}
}
