package day1127;

import java.util.concurrent.SynchronousQueue;

/**
 * ���ڿ� ������� �ּҸ� �����ϰ�, ���ڿ��� �ٷ�� ����� �����ϴ� String class�� ���<br>
 * java���� �����ϴ� Ŭ������ �̸��� ���� ���� Ŭ������ �̸��� ���ٸ� �������� Ŭ������ ���� ����ϰ� �ȴ�. java���� �����ϴ�
 * Ŭ������ ����� ������ "full path : ��Ű������ ��� ����Ͽ� Ŭ������ ����ϴ� ��"�� ����ؾ� �Ѵ�. ��Ű����.Ŭ������
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) {
		// �⺻�� ���� ���. String s="���ڿ�";
		String str = "Abcdefg";
		// ������ ���� ���. String s=new String("���ڿ�");
		String mail = new String("kimkh8455@gmail.com");
		System.out.println(str);
		System.out.println(mail);

		
		// length����
		System.out.println(str + "�� ���� " + str.length());
		System.out.println(mail + "�� ���� " + mail.length());

		// toUpperCase
		System.out.println(str + "�� ��� �빮�� " + str.toUpperCase());
		System.out.println(mail + "�� ��� �빮�� " + mail.toUpperCase());

		// toLowerCase
		System.out.println(str + "�� ��� �ҹ��� " + str.toLowerCase());
		System.out.println(mail + "�� ��� �ҹ��� " + mail.toLowerCase());

		
		// "AbcdEfg"
		// 0 123456
		// indexOf�� ���� ->������ �����ϸ� ���� ó�� ã������ ���ڿ��� �ε����� ��´�.
		System.out.println(str + "���� 'd'�� �ε��� : " + str.indexOf("d"));
		System.out.println(str + "���� 'd'�� �ε��� : " + str.indexOf("z"));

		
		// @�ε��� ã��
		System.out.println(mail + "���� \"@\"�� �ε��� : " + mail.indexOf("@"));
		
		
		//lastIndexOf�� �����ʿ��� �������� �����ϸ鼭 ���� ó�� ã������ ���ڿ��� �ε����� ��´�.
		str = "AbcdEfAg";
		System.out.println(str + "���ڿ� ���� �ڷκ��� 'A'�� �ε��� :" + str.lastIndexOf("A"));
		
		
		//Ư���ε����� ���ھ��
		char temp=str.charAt(2);
		System.out.println(str+"���� 2��° �ε����� �ش��ϴ� ����"+temp);
		
		
		//�ڽĹ��ڿ� �ڸ���
		//str = "AbcdEfAg";			2~5��°��� �ؼ� �׸��ϸ�ȵ� +1 �������
		//		   01234567
		System.out.println(str+"���� �ε����� 2~5��° �ش��ϴ� ���ڿ� "+ str.substring(2,6)); // ������ �ε����� null������ ó���Ǳ� ������ null�� ���ڸ��� �����ؼ� +1�� ����� �Ѵ�.		
		
		
		//kimkh8455   (�����ּ�)  @gmail.com  (�������ּ�)   �����ּҰ� 0~8�������� ���ڸ� null�� �����ؼ� +1���ش�.
		//0123456789 <- String index    
		System.out.println(mail+"���� ���� �ּҸ� ���"+mail.substring(0,9));
		System.out.println(mail+"���� ���� �ּҸ� ���"+mail.substring(0,mail.indexOf("@")));
		
		System.out.println(mail+"���� ���� �ּҸ� ���"+mail.substring(9,19));
		System.out.println(mail+"���� ������ �ּҸ� ���"+mail.substring(mail.indexOf("@")+1, mail.length()));
		//Substring�� ���� �ε����� ������ ������ �߶� ����.
		System.out.println(mail+"���� ������ �ּҸ� ���"+mail.substring(mail.indexOf("@")+1));
		
		
		//�յڰ����ڸ���
		str="   A BC   ";
		System.out.println("["+str+"]���� �յڰ������� ["+str.trim()+"]");  // �յڰ��鸸 ���� ���� ���̴� �Ұ���
		
		
		//���ڿ����̱�
		str="Abcd";
		String str1=str.concat("Efg");
		System.out.println(str1);		
		String str2=str+"Efg";
		System.out.println(str2);
		
		
		//���ڿ��� �Ϻ��ϰ� ������ ��
		str="������";
		str1="�����";
		System.out.println(str+"��(��)"+(str.equals("������")?"����":"���"));
		
		//���ڿ��� �� ���ڿ��� �����ϴ���
		str="�Ǿ���";
		if(str.startsWith("����")) {
			System.out.println("���� ����ϽǼ� �����ϴ�.");
		}else {
			System.out.println(str);
		}//end else
		
		str="����� ������";
		str1="������ �ȴޱ�";
		
		System.out.println(str+"��(��)"+(str.startsWith("����")?"����� �Դϴ�":"������ �ƴմϴ�."));
		System.out.println(str1+"��(��)"+(str1.startsWith("����")?"����� �Դϴ�":"������ �ƴմϴ�."));
		
		//Ư�� ���ڿ��� ��������
		str="����� ������ ���ﵿ";
		str1="��⵵ ������ ������";
		System.out.println(str+"��(��)"+(str.endsWith("��")?"����":"�ð�"));
		System.out.println(str1+"��(��)"+(str1.endsWith("��")?"����":"�ð�"));
		
		//ġȯ
		str="�� ���� �Ǿ����ε� �� ���� �������!";
		System.out.println(str.replaceAll("����","**"));
		
		//method�� �����ؼ� ȣ���ϴ� ���� method chain
		str="�� ���� �Ǿ����ε� �� ���� �� �����!";
		System.out.println(str.replaceAll("��","*").replaceAll("��","*") );
		
		str="   a bc   ";    //""�������� empty����Ѵ�
		System.out.println(str.replaceAll(" ", "") );
		
		int i=27;
//		str=i; 	int�� String���� �Ҵ� �� �� ����.
		//�⺻�� ���������� ���ڿ��� ��ȯ
		str=String.valueOf( i );
		System.out.println( str );
		
		double d=11.27;
		str=d+"";  //�̷��Ե� ���������� ���������� ����
		System.out.println(str);
		
		str="";
		System.out.println(str.isEmpty());		//True

		str="11";
		System.out.println(str.isEmpty());		//False
		
		//��ü ������ ���� �ʾ��� �� �� Ŭ������ �����ϴ� method�� ����Ҽ� ����. Error
//		str=null;
//		System.out.println(str.isEmpty());
		
		///////////////////////////////////////////////11- 28- 2018 split ��� �ڵ� �߰�///////////////////////////////////////////////
		String data=
				"������,������,���ü�~������~�����.������,������,������.������";
		//split�� �ѹ��� �ϳ��� ���ڷ� �����Ͽ� �ڸ���.
		String []arr=data.split("");	//.�� ���е��� �ʴ´�.  []��� ����.
		System.out.println("���е� �迭 ���� ����"+arr.length);
		for(String name : arr) {
			System.out.println( name );
		}//end for
		
		
		
		
		
		
		
		
		
		
	}// main;

}// class
