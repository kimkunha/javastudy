/*¼÷Á¦2.
0 0
 1 0 1 1
   2 0 2 1 2 2
     3 0 3 1 3 2 3 3 
 */
package day1120;

public class HomeWork2 {

	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < i; k++) {
				System.out.println(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}




	}//main
}//class
