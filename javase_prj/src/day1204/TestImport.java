package day1204;
//18.12.04 8�� �ڷ� (Import ����)

import java.util.ArrayList;
import java.util.Date;
//import java.awt.List;	// ��Ű���� �ٸ��� �̸��� ���� Ŭ������ �� �� �ϳ��� import ���� �� �ִ�. (1ȸ�� ���̾��� import������ �ȴ�)
import java.util.List;
import java.util.Random;


//import java.util.Random;			//�ϳ��� Ŭ������ �����ٰ� ���
//import java.util.Date;
//import java.util.*;					//��Ű�� ���� ��� class(interface)�� �ѹ��� ����� �� �ִ�.

/**
 *	import : �ٸ� ��Ű����  Ŭ������ �����Ͽ� ����� ��
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();													//import���� Ŭ������ ����̵� ����Ҽ� �ִ�.
		Random r1 = new Random();
		Random r2 = new Random();
		
		Date d=new Date();
		//���� �̸��� Ŭ���� �Ǵ� �������̽��� �� �� ���� ���Ǵ� ���� import�� ó���ϰ�, ���� ���Ǵ� ���� full path�� ó���Ѵ�.
		java.awt.List list = null; //awt.List
		List list1 = null;//util.List
		
	}//main

}//class
