package day1205;


//18.12.05 1�� �ڷ� (StringBuffer,StringBuilder ����)
/**
 * 	StringBuffer, StringBuilder(JDK1.5���� ����)		//�ӵ� ������ StringBuilder�� ���� ���
 *	���ڿ��� heap�� ���� �����ϰ� ����ϴ� Ŭ����
 *	//����  �� sb�� ������ ��üȭ�� ���� �ϴ���?
 * @author owner
 */
public class UseStringBuilder {
																							//����Ʈ �� �����ε����� �� �ε����� �����
	public void userStringBuffer() {
		//1. Ŭ���� ����
		StringBuffer sb=new StringBuffer();
		//2. ��( )�߰� ( append)			//���� �������� �𸥴�(����,�Ǽ�,����,�Ҹ�,���ڿ�..�Է°����ϱ⶧��)
		sb.append("������ ");//���ڿ�
		sb.append(12);//����
		sb.append("�� 5��").append("������ �Դϴ�.");//���ڿ�    methodü������ ����
		System.out.println(sb);
		//3. �� ����
		//������ 12�� 5�ϼ����� �Դϴ�. 
		//0 1 2 34
		sb.insert(4, "2018��");
		
		//4. �� ���� : delete(�����ε���, ���ε���+1) //+1������ ���ڸ��� �ΰ��� ������ �־ +1����� �Ѵ�.
		//������ 2018��12�� 5�ϼ����� �Դϴ�. 
		sb.delete(0, 3);			//��ü�� �����ҰŸ� ����0 sb.length�� ����ϸ� �ȴ�.
		System.out.println(sb); 	
		sb.reverse();	//�Ųٷ� ����� ���
		System.out.println(sb);
	}//useStringBuffer
	
	//String�� �� �Ⱦ��� ���� ª�����ڿ��� �ٷ궧 ���
	public void userStringBuilder() {
		//1. Ŭ���� ����
		StringBuilder sb=new StringBuilder();
		//2. ��( )�߰� ( append)			//���� �������� �𸥴�(����,�Ǽ�,����,�Ҹ�,���ڿ�..�Է°����ϱ⶧��)
		sb.append("������ ");//���ڿ�
		sb.append(12);//����
		sb.append("�� 5��").append("������ �Դϴ�.");
		System.out.println(sb);//���ڿ�    methodü������ ����
		//3. �� ����
		//������ 12�� 5�ϼ����� �Դϴ�. 
		//0 1 2 34
		sb.insert(4, "2018��");
		
		//4. �� ���� : delete(�����ε���, ���ε���+1) //+1������ ���ڸ��� �ΰ��� ������ �־ +1����� �Ѵ�.
		//������ 2018��12�� 5�ϼ����� �Դϴ�. 
		sb.delete(0, 3);			//��ü�� �����ҰŸ� ����0 sb.length�� ����ϸ� �ȴ�.
		System.out.println(sb); 	
		sb.reverse();	//�Ųٷ� ����� ���
		System.out.println(sb);
	}//UseStringBuilder
	
	
	public static void main(String[] args) {
		//��ü����
	UseStringBuilder usb= new UseStringBuilder();
	usb.userStringBuffer();
	System.out.println("--------------------------------------------------------------------------------------");
	usb.userStringBuilder();
		
	String str= "�ȳ��ϼ���?";	//ª�� ���ڿ��� �׳� string�� ����
		System.out.println(str);
		
		//���ڿ��� +(���ϱ�)�� �پ �� ���ڿ�
	String str1="��";	
		System.out.println(str1+"��"+"��"+"��"+"��");
		//new StringBuilder(String.valueOf(str1))).append(str1).append("��").append("��").append("��").append("��").toString());
				//valueOf���� ������ �⺻�������͸� ���ڿ��� �����ؼ�
		
		
	}//main

}//class
