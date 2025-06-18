package e.array;

import java.util.Scanner;

public class C_Array {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		//1. 크기가 10인 정수형 배열 생성
		int [] arr = new int[10];
		
		//2. 반복문을 통해서 0번 인덱스부터 마지막 인덱스까지 모든값을 1로 초기화
		for(int i=0; i<arr.length; i++) {
			arr[i] = 1;
		}
		
		//3. 반복문을 통해서 0~마지막인덱스까지 모두 출력
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+ "." + arr[i]);
		}
		*/
		
		/*
		//4. 사용자에게 배열의 길이를 입력받아 해당크기의 문자열 배열을 생성해라(strArr)
		System.out.println("배열크기 입력 : ");
		int size = sc.nextInt();
		String [] strArr = new String[size];
		
		
		//5. 반복문을 활용해서 매번 사용자에게 과일명을 입력받아 그 값을 strArr에 대입해라(0~마지막인덱스까지)
		//좋아하는 과일 : xxx -> 반복
		String f;
		for(int i=0; i<strArr.length; i++) {
			System.out.println("과일명 입력 : ");
			f = sc.next();
			strArr[i] = f;
			
		}
		
		//6. 반복문을 통해 strArr에 있는 모든 값을 출력
		for(int i=0; i<strArr.length; i++) {
			System.out.println("입력하신 과일명은 " + strArr[i]);
		}
		*/
		
		//사용자에게 문자열 하나 입력받은 후
		//각각의 인덱스에 있는 문자들을 char배열에 옮겨담기
		
		/*
		//1. 사용자에게 문자열 하나 입력받기
		System.out.println("문자열 입력 : ");
		String str = sc.next();
		
		//2. char배열을 생성(크기 -> 문자열의 길이)
		char [] charArr = new char[str.length()];
		
		//3. 반복문을 활용하여 해당 문자열에서 각각의 인덱스별 문자를 char배열에 각 인덱스값에 담기
		for(int i=0; i<charArr.length; i++) {
			charArr[i] = str.charAt(i);
		}
		//4. char배열의 모든 index값을 출력
		for(int i=0; i<charArr.length; i++) {
			System.out.println(charArr[i]);
		}
		*/
		
		//사용자에게 배열의 길이를 입력받아 해당 길이의 정수형 배열 arr을 생성한다.
		//arr에 모든 인덱스값에 1~100사이의 랜덤값을 할당해주고
		//arr의 모든 값을 출력한 후
		//이중 짝수인 값의 총 합을 구해서 출력
		
		//정수 입력 : 3
		//4 7 15
		// 짝수의 총 합 : 4
		
		System.out.println("정수 입력 : ");
		int n = sc.nextInt();
		int [] arr = new int[n];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;		
			System.out.println(i + "번째 정수 : " + arr[i]);
			if(arr[i] % 2 == 0) {
				sum = sum + arr[i];
			}
		}System.out.println("짝수의 총 합은 : " + sum);
	
		
	
		
	}

}
