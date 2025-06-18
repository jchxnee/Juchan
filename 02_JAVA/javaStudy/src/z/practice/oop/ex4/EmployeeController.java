package z.practice.oop.ex4;

public class EmployeeController {
	Employee e = new Employee();
	
	public void add(int empNo, String name, char gender, String phone) {
		this.e = new Employee(empNo, name, gender, phone);
		
	}
	
	public void add(int empNo, String name, char gender, String phone,
					String dept, int salary, double bonus) {
		this.e = new Employee(empNo, name, gender, phone,dept,salary,bonus);
	}
	
	public void modify(String phone) {
		this.e.setPhone(phone);
		System.out.println("전화번호가 수정되었습니다.");
	}
	
	public void modify(int salary) {
		this.e.setSalary(salary);
		 System.out.println("연봉이 수정되었습니다.");
	}
	
	public void modify(double bonus) {
		this.e.setBonus(bonus);
		System.out.println("보너스가 수정되었습니다.");
	}
	
	public Employee remove() {
		return e = null;
	}
	
	public String inform() {
		if(this.e==null) {
			return "사원데이터가 없습니다";
		} else
			return e.printEmployee();
	}
}
