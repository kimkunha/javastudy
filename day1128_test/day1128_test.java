package day1128_test;

public class day1128_test {

	/**
	 * 배열 연습하기
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
/*	
  		int[] arr = new int[5]; // 참조형 배열
		int totalscore = 0;
		int	maxscore=0;
		int minscore=0;
		arr[0] = 0;
		arr[1] = 10;
		arr[2] = 20;
		arr[3] = 30;
		arr[4] = 40;
		for (int yang = 0; yang < arr.length; yang++) {
			totalscore = totalscore + arr[yang];
			System.out.println(arr[yang]);
			
			// 제일 높은 점수 구하는 방법
			if (maxscore < arr[yang]) {
				maxscore = arr[yang];
			} // end if
			// 제일 낮은 점수 구하는 방법
			if(minscore>arr[yang]) {
				minscore=arr[yang];
			}

		} // endfor
		System.out.println("제일 높은 점수"+maxscore);
		System.out.println("제일 낮은 점수"+minscore);
		System.out.println("Maxscore의 값" + totalscore); // 최고값 구하는법
		
		*/
		
		int [][]arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("arr[%d][%d]=%-4d",i,j,arr[i][j]);
			}
		System.out.println();
		}
		
		
		
		
		
	}// main

}// class
