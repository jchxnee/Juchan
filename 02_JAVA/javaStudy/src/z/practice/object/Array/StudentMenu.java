package z.practice.object.Array;

public class StudentMenu {
	private StudentController ssm = new StudentController();

	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		for(Student student : ssm.printStudent()) {
			System.out.println(student.inform());
		}
		System.out.println();
		System.out.println("========== 학생 성적 출력 ==========");
		double [] grade = ssm.avgScore();
		System.out.println("학생 점수 평균 : " + grade[0]);
		System.out.println("학생 점수 평균 : " + grade[1]);
		System.out.println();
		System.out.println("========== 성적 결과 출력 ==========");
		for(Student student : ssm.printStudent()) {
			String res = student.getScore() >= ssm.CUT_LINE ? "통과" : "재시험";
			System.out.println(student.getName() + "학생은 " + res + "입니다.");
		}
		
	}
	
		
}
