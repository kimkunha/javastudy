package day1119;

/**
 * switch~case : ������ ���Ҷ�.(JDK1.7���� ���ʹ� ���ڿ��� �� ����)<br>
 * ����)<br>
 * switch(������){<br>
 * case ��� : ���๮��;<br>
 * case ��� : ���๮��;<br>
 * case ��� : ���๮��;<br>
 * case ��� : ���๮��;<br>
 * default : ��ġ�ϴ»���������� ���๮��; <br>
 * }
 * 
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
//		String i = "1"; //jdk1.7+���� ���� ����
		int i=0;
		switch (i) {// switch�� �ԷµǴ� ������ ���������� byte, short, int, char, String long(x)
		// case�� �ԷµǴ� ������ ���� �ٸ� ������ ������.
		case 0:
			System.out.println("����");
		case 1:
			System.out.println("��ħ"); // break;
		case 2:
			System.out.println("����");
		default:
			System.out.println("����");
		}// end switch
	}// main

}// class
