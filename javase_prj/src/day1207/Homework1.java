package day1207;

import java.util.HashMap;
import java.util.Map;

/**
 *���� 1.
main method�� arguments�� ��¥�� ������ �Է� �޾� �Է¹��� ��¥��
 ������ �����ϰ� ����ϴ� method �� �ۼ��ϼ���.

��) java Test 4 12 30 32 35 15 4   

���) 4 ȭ
        12 ��
        15 ��
        30 ��
 * @author owner
 */
public class Homework1 {
	public Homework1() {
		
		
	}//Homework1
	public void weather1() {
		Map<Integer,String> weather = new HashMap<Integer,String>();
			weather.put(4, "ȭ");
			weather.put(12, "��");
			weather.put(15, "��");
			weather.put(30, "��");
	}//weather1
	
	public static void main(String[] args) {
		new Homework1();
		
		
		
		
		
	}//main

}//class
