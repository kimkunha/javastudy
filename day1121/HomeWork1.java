/*1.while�� ����Ͽ� ������ ��ü���� ����ϴ� instance method�� �ۼ��ϰ�, ȣ���ϼ���.
 * 
 */
package day1121;

public class HomeWork1 {
	int i = 2;
	int j = 1;

	public void gugudan() {
		HomeWork1 uiv = new HomeWork1();

		while (uiv.i < 10) {
			System.out.println(uiv.i + "�� ����!");
			uiv.j = 1;
			while (uiv.j < 10) {
				System.out.println(uiv.i + " * " + uiv.j + " = " + (uiv.i * uiv.j));
				uiv.j++;
			}
			uiv.i++;
		}
	}

	public static void staticStar() {
		int j = 1;
		do {
			int k = 0;
			while (k < j) {
				System.out.print("*");
				k++;
			}
			System.out.println(" ");
			j++;
		} while (j < 5);
	}

	public static void main(String[] args) {
		HomeWork1 w1 = new HomeWork1();
		w1.gugudan();
		HomeWork1.staticStar();
		
		
		
		
	}// main

}// class
