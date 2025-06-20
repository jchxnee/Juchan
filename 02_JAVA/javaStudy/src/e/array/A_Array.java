package e.array;

public class A_Array {
	/*
	  변수 : 하나의 공간에 하나의 값을 담을 수 있다.
	  배열 : 하나의 공간에 여러개의 값을 담을 수 있는 개념
	  		"같은 자료형의 값"으로만 담을 수 있음
	  		정확하게 얘기하자면 배열의 각 인덱스 자리에 실제 값이 담긴다(index는 0부터)
	  
	  배열을 왜 사용할까?
	  - 변수만을 사용하게 되면 -> 대량의 데이터를 보관하고자할 때 각각의 변수를 만들어서 따로 관리해야한다.
	 */
	
	public static void main(String[] args) {
		//int형 변수 5개 만들어서 0~4의 값을 각각 할당해보자
		/*
		int num1 = 0; //1유형
		int num2 = 1;
		int num3 = 2;
		int num4 = 3;
		int num5 = 4;
		
		int[] arr1 = new int[5]; //2유형
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		arr1[3] = 3;
		arr1[4] = 4;
		
		int[] arr2 = {0,1,2,3,4};  //3유형
		*/
		
		/*
		  1. 배열선언(여러개의 값들을 보관할 배열을 만든다. -> 참조변수 선언)
		  자료형[] 배열이름;
		  자료형 배열이름 [];
		 */
		int [] arr;
		
		/*
		  2. 배열 할당(해당 배열에 몇개의 값들을 보관할 것인지, 메모리 크기를 지정하는 과정)
		  배열명 = new 자료형[크기(길이)];
		 */
		arr = new int[5];
		
		/*
		  3. 값을 대입하고 가져와서 사용
		  -> index를 이용해서 접근하면 된다.
		 */
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		//for loop
		for(int num : arr) {
			System.out.println(num);
		}
	}
}
