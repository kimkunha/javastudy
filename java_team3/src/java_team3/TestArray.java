package java_team3;

import java.util.Random;

/**
 * 	같은 타입의 변수를 하나의 묶음으로 다루는것을 배열이라 한다. 고정길이형 다른타입의 변수는 넣을 수 없다.
 * 	배열은 for문에 적합하다.
 * 
 * @author KIM
 */
public class TestArray {

	public TestArray() {
	
	//1. 배열 선언 
		//데이터형 [] 배열명
		int [] intArr;
	//2. 배열 생성
		//배열명 = new 데이터형 길이
		intArr = new int [6];
	//3. 선언과 생성 동시에
		int[] arr=new int[6];
	//4. 값 할당
		intArr[1]=10;
		intArr[2]=20;
	//5. 한번에 값할당 까지 할 경우
		int [] arrInt=new int[] {10,20,30};
		//생성된 배열의 각 저장공간을 '배열의 요소' 라고 한다 배열의 인덱스는 0번부터 시작
		//배열의 길이를 모를 경우 배열명.length로 구할수 있다
		
	}//생성자
	
	public void TestLotto() {
		Random r = new Random();
//		System.out.println(r.nextInt(45));

		int[] arrInt = new int[6];
//		Arrays.sort(arrInt);
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = (int) (r.nextInt(45) + 1);
			for (int j = 0; j < i; j++) {
				if (arrInt[i] == arrInt[j]) {
					j--;
					break;

				} // end if
			} // end for
			System.out.print("[" + arrInt[i] + "] ");
		} // end for
		System.out.println();
	}// TestLotto

	public static void main(String[] args) {
		TestArray ta=new TestArray();
		ta.TestLotto();
	}// main

}// class
