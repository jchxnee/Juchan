package z.practice;

public class HighSchool {
	String name;
	double avgCut;
	double mathCut;
	double koCut;
	double enCut;
	
	public HighSchool() {
		super();
	}
	
	public HighSchool(String name, double avgCut, double mathCut, double koCut, double enCut) {
		this.name = name;
		this.avgCut = avgCut;
		this.mathCut = mathCut;
		this.koCut = koCut;
		this.enCut = enCut;
	}

	public void apply(String name, double avg, double mathScore, double koScore, double enScore) {
		if(avg >= this.avgCut &&
		   mathScore >= this.mathCut &&
		   koScore >= this.koCut &&
		   enScore >= this.enCut) {
			System.out.println(name + "님 합격입니다.");
		}else {
			System.out.println(name + "님 불합격입니다.");
		}
	}
}
