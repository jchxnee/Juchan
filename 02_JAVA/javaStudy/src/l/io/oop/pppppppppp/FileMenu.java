package l.io.oop.pppppppppp;

import java.util.Scanner;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	
	private FileController fc = new FileController();
	
	public void mainMenu() {
		while(true) {
		System.out.println("***** My Note *****");
		System.out.println("1. 노트 새로 만들기");
		System.out.println("2. 노트 열기");
		System.out.println("3. 노트 열어서 수정하기");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			fileSave();
			break;
		case 2:
			fileOpen();
			break;
		case 3:
			fileEdit();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			return;
		default :
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			
		}
		}
	}
	
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		sc.nextLine();
		while(true) {
		System.out.println("파일에 저장할 내용을 입력하세요");
		System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
		System.out.print("내용 : ");
		
		String str = sc.nextLine();
		
		if(str.equals("ex끝it")) {
			break;
		} else {
			sb.append(str).append("\n");
		}
		}
		
		while(true) {
		System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
		String name = sc.nextLine();
		if(fc.checkName(name)) {
			System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) : ");
			char c = sc.nextLine().charAt(0);
			if(c=='y') {
				fc.fileSave(name, sb);
				return;
			} 
				
		} else {
			fc.fileSave(name, sb);
			return;
		}
		}
	}

	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String name = sc.next();
		sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		if(fc.checkName(name)) {
			sb = fc.fileOpen(name);
			System.out.println(sb.toString());
		} else {
		System.out.println("없는 파일입니다.");
		}
		return;
	}
	
	public void fileEdit() {
		System.out.print("수정할 파일 명 : " );
		String name = sc.next();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		if(fc.checkName(name)) {
	
			while(true) {
	
				System.out.println("파일에 저장할 내용을 입력하세요");
				System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
				System.out.print("내용 : ");
				String str = sc.nextLine();
				if(str.equals("ex끝it")) {
					break;
				}
				sb = new StringBuilder(str);
			}
			fc.fileEdit(name, sb);
		} else {
		System.out.println("없는 파일입니다.");
		return;
		}
	}
}
