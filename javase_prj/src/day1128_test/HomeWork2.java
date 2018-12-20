package day1128_test;

public class HomeWork2 {

	private int[][] arr;

	public HomeWork2(int[][] arr) {
		this.arr = arr;
	}

	public void work() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 || j == 0 || i == 5 || j == 8) {    
					arr[i][j] = 1;
				} // end if
				System.out.print(arr[i][j]);
			} // end for
			System.out.println();
		} // end for

	}

	public static void main(String[] args) {

//		HomeWork2 hw2 = new HomeWork2(arr[6][9]);

//		int[][] arr = new int[6][9]; 
		
	}// main

}// class
