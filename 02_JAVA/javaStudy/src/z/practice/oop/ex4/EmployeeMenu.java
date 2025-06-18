package z.practice.oop.ex4;

import java.util.Scanner;

public class EmployeeMenu {
    Scanner sc = new Scanner(System.in);
    EmployeeController ec = new EmployeeController();

    public EmployeeMenu() {
        while (true) {
            System.out.println("1. 사원 추가");
            System.out.println("2. 사원 수정");
            System.out.println("3. 사원 삭제");
            System.out.println("4. 사원 출력");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 번호를 누르세요 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    insertEmp();
                    break;
                case 2:
                    updateEmp();
                    break;
                case 3:
                    deleteEmp();
                    break;
                case 4:
                    printEmp();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하였습니다.");
            }
        }
    }

    public void insertEmp() {
        while (true) {
            System.out.print("사원 번호 : ");
            int empNo = sc.nextInt();
            System.out.print("사원 이름 : ");
            String name = sc.next();
            System.out.print("사원 성별 : ");
            char gender = sc.next().charAt(0);
            System.out.print("전화 번호 : ");
            String phone = sc.next();

            System.out.println("추가 정보를 더 입력하시겠습니까?(y/n)");


            if (sc.next().toUpperCase().charAt(0) == 'Y') {
                System.out.print("사원 부서 : ");
                String dept = sc.next();
                System.out.print("사원 연봉 : ");
                int salary = sc.nextInt();
                System.out.print("보너스 율 : ");
                double bonus = sc.nextDouble();
                ec.add(empNo, name, gender, phone, dept, salary, bonus);
                System.out.println("모든 정보가 추가되었습니다.");
                return;

            } else if (sc.next().toLowerCase().charAt(0) == 'N') {
                ec.add(empNo, name, gender, phone);
                System.out.println("일부 정보가 추가되었습니다.");
                return;
            } else {
                System.out.println("y/n중에 입력해주세요.");
            }
        }
    }

    public void updateEmp() {
       
            System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
            System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
            System.out.println("1. 전화번호");
            System.out.println("2. 사원 연봉");
            System.out.println("3. 보너스 율");
            System.out.println("9. 돌아가기");
            System.out.print("메뉴 번호를 누르세요 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.print("수정할 전화번호 : ");
                    String phone = sc.next();
                    ec.modify(phone);                    
                    break;
                    
                case 2:
                    System.out.print("수정할 사원 연봉 : ");
                    int salary = sc.nextInt();
                    ec.modify(salary);                   
                    break;
                    
                case 3:
                    System.out.print("수정할 보너스율 : ");
                    double bonus = sc.nextDouble();
                    ec.modify(bonus);                   
                    break;
                    
                case 9:
                    return; // 수정 작업 종료 후 메인 메뉴로 돌아감
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    

    public void deleteEmp() {
        System.out.print("정말 삭제하시겠습니까(y/n) : ");
        char answer = sc.next().charAt(0);
        if (answer == 'y') {
        	if(ec.remove() == null) {
        		System.out.println("삭제에 성공하였습니다.");
        	} else {
        		System.out.println("삭제에 실패했다");
        	}
                      
        } else if (answer == 'n') {
            return;
        } else {
            System.out.println("y/n 중에 입력해주세요.");
        }
    }

    public void printEmp() {
        System.out.println(ec.inform());
    }
}
