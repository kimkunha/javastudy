package day1119;

import java.util.concurrent.SynchronousQueue;

/**
 * else~if : ������ ���� ������ ���� ��.<br>
 * ����) if(���ǽ�){<br>
 * ���ǿ� ������ ���� ����;<br>
 * }else if(���ǽ�){ ���ǿ� ������ ���๮��;<br>
 * }else if(���ǽ�){ ���ǿ� ������ ���๮��;<br>
 * }else if(���ǽ�){ ���ǿ� ������ ���๮��;<br>
 * "<br>
 * "<br>
 * }else{ ��� ���ǿ� ���� ������ ���� ����; }
 * 
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {
//			int i=Integer.parseInt(args[0]);
/*		int i = Integer.parseInt(args[0]);

		System.out.println(i + "��(��)");
		if (i < 0) {
			System.out.println("0���� �۾Ƽ� ����");

		} else if (i > 100) {
			System.out.println("100���� Ŀ�� ����");

		} else {
			System.out.println("�Է¼���");
*/
		 // end if

		//�̸��� �Է� �޾� "������"�̸� ������ 
		//"�̺���, �ڿ���, ������, ������"�̸� ������
		//�׷��� ������ ����� �̸��տ� ����ϼ���.  "��å �̸�"

		if(args[1].equals("������")) {
		System.out.println("����");
		}else if(args[1].equals("�̺���")||args[1].equals("�ڿ���")||
				args[1].equals("������")||args[1].equals("������")){
				System.out.println("����");
		}else {
			System.out.println("���");
		}//end if
		System.out.println(args[1]+"�� �ȳ��ϼ���");
		
		
	
		//equals�� ���ڿ��� ���Ҷ� ���
		
		//�¾��(1995)�� �Է¹޾� ��(12) ���ϱ�
		//11-��, 10-��, 9-��, 8-��, 7-�䳢, 6-ȣ����, 5-��, 4-��, 
		//3-����, 2-��, 1-��, 0-������
		

	}// main

}// class
