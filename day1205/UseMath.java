package day1205;

//18.12.05 3�� �ڷ� (Math ����)			//�����ڸ� ��������� ����static�̴� Ŭ������.method�� ����Ѵ�.
/**
 * Math : ��ü�� �������� �ʰ� ����ϴ� Ŭ����.(�����ڰ� ����) //���߿� � �� �ִ�
 * 
 * @author owner
 */
public class UseMath {
	public UseMath() {
//		Math m= new Math(); //�Ұ���
		int i = -12;
		System.out.println(i + "�� ���방 : " + Math.abs(i)); // math.abs(����) : ���밪
		System.out.println(Math.ceil(10.0)); // 0�� ���Ѵ� .1���� �ø��� //Math.ceil
		System.out.println(Math.round(10.5));// �ݿø� 0.5���� �ø��� //Math.round
		System.out.println(Math.floor(10.9));// �Ҽ��� ���� ù �ڸ����� ������ //Math.round

		double d = Math.random();
		System.out.println("�߻��� ���� : " + d);
		System.out.println("������ ������ ���� : " + d * 5);
		System.out.println("������ ������ ��������  ����: " + (int) (d * 10)); // ĳ������ ���� ���Ǳ⶧���� ��ȣ�� ���� �������ش�.

		// A(65)-Z(90)�� �ϳ��� ���ڸ� ��ȯ�ϴ� ��
		System.out.println((char) ((int) (d * 26) + 65));

	}// UseMath

	public char[] createPassword() {
		char[] tempPass = new char[8];
		// �����ڴ빮��, �ҹ���, ���ڷ� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ� ��
		String flag="ABCDEFGHIJKLMNOPQRSTUVXXYZabcdefghijklmnopqrstuvwxyz0123456789";
			for(int i=0; i<tempPass.length; i++) {
				tempPass[i]=flag.charAt((int)(Math.random()*flag.length()));
				System.out.print( tempPass[i]);
			}//end for
		return tempPass;
	}// createPassword

	
	
	
	public static void main(String[] args) {
		new UseMath().createPassword();

	}// main

	
	
	
}// class
