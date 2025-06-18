package k.exception.oop.practice1;

import java.util.Scanner;

public class CharacterMenu {
	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		CharacterController cc = new CharacterController();
		int num = 0;
		try {
		 num = cc.countAlpha(str);
		 System.out.println(str+ "에 포함된 영문자 개수 : " + num);
		} catch(CharCheckException e) {
			e.printStackTrace();
		}
		
		
}
}
