package day1218;

import java.util.Random;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

//18.12.18	-13�� �ڷ�- ( throw )  
/**
 * ���ܸ� ������ �߻�
 * 
 * @author owner
 */
public class TestThrow {

	/**
	 * �ü��� ���� ���ٰ� ��踦 �ǿ�� �л��� ���� ���ǻ�ȸ�� �����Ѵ�.
	 */
	public void teacksung() throws Exception {
		String[] grade = { "�ʵ��л�", "���л�", "����л�" };
		String randomGd = grade[new Random().nextInt(grade.length)];
		if (randomGd.equals("�ʵ��л�")) {
//		try {
			throw new Exception(randomGd + "��Ե� �ݿ��ؾ� �ϴ� �κ� �ƴϰڽ��ϱ�?");
//		}catch(Exception e) {
//			e.printStackTrace();
		} else {
			System.out.println(randomGd + "��ô ��������.");
		} // end else

	}// teacksung

	
	
	
	public void teacksung2() throws TobaccoException{
		String[] grade = { "�ʵ��л�", "���л�", "����л�" };
		String randomGd = grade[new Random().nextInt(grade.length)];
		
		if (randomGd.equals("�ʵ��л�")) {
			throw new TobaccoException();
		} else {
			System.out.println(randomGd + "��ô ��������.");
		} // end else

	}// teacksung2

	
	
	
	
	
	
	public static void main(String[] args) {
		TestThrow tt = new TestThrow();
		try {
			tt.teacksung2();
		} catch (TobaccoException e) {
			e.printStackTrace();
		} // end catch
		System.out.println("--------------");
		
//		try {
//		tt.teacksung2();
//		}catch	(TobaccoException e) {
//			tt.teacksung2();
//		}//end catch
		
	}// main

}// class
