package day1126_test;

public class Array {

	/**
	 * 	배열이란 ? : 같은 타입의 여러 변수를 하나의 묶음로 다루는것을 배열(Array)라고 한다. 하는이유?<br>
	 * 	많은 양을 저장하기 위해서는 그 데이터의 숫자만큼 변수를 선언하려면 매우 혼란스러우니 배열을 사용하면 많은양의 데이터를 손 쉽게 다룰 수 있다.<br>
	 * 	중요한 점은 같은 타입이여야 하고 다른 타입의 변수들로는 구성할 수 없다.
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] arr1 = new int[5];
		int tmp= arr1.length;
		System.out.println(tmp);
		
		
		
		int [] arr = new int[10];  //값을 넣지 않으면 int의 null값 0이 들어간다.
		arr[0]=0;
		arr[1]=10;
		arr[2]=20;
		arr[3]=30;
		arr[4]=40;
		arr[5]=50;
		arr[6]=60;
		arr[7]=70;
		arr[8]=80;
		arr[9]=90;
		
		for(int i =0; i<arr.length; i++) {
			System.out.println(arr[i]);
			
		}
			
		
		
		Array ar =new Array();
		System.out.println(ar);
	}//main
}//class
