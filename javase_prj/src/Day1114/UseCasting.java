package Day1114;
/*
	��������ȯ : ������ ���������� �Ͻ������� ��ȯ�Ͽ� ����ϴ� ��
*/

class UseCasting{
	public static void main(String[] args) 	{
		byte b1=10,b2=20; //int�� �ڵ�����ȯ
		byte result = (byte)(b1+b2);// byte������ ������ ����� int�� �ڵ�����ȯ��  ������ result�� Byte�� ������ �ȵǴ� int�� �ٲ���� �Ѵ�.
								//������ ����� int�� �ڵ�����ȯ �Ǵ°��� byte�� ��������ȯ
								//��ȣ�� + ���� ���������� �ǹǷ� ��ȣ�� ���༭ ������ �ؾ���  -���� ��õ����-
		System.out.println( b1+" + "+b2+" = " +result);

		double d=11.14;
		float f=(float)d;
		System.out.println("double : "+d+", float : "+f);

		float f1=(float)2018.11;
		System.out.println("double : " +f1);

		//long l=(long)2147483648;// ������� literal ���� ũ�ٸ� casting�� �����ϱ����� ERROR�߻�.

		int i=(int)f1;   // byte���� ������ �� ������ Ʋ���� ERROR�߻�, ��������ȯ���� �����Ҽ� ������ �Ǽ����� ���� ��� ����� �Ҵ�)  -���ս� �߻�-
		System.out.println("int : "+i+", float : "+f1);

		char c='A';
		System.out.println(c+"�� unicode(ASCII code)��" +
						(int)c);

		//��(�⺻��, <-> ������)�� �ٸ��� ��������ȯ�� ���� �ʴ´�.
//		String s="11";//������
//		int i=(int)s;//�⺻��
				

		//boolean ���� boolean�� ������ ��ȯ ����
		boolean b=true;
		//i=(int)b;  //ERROR
		boolean bc=(boolean)b; //�Ǳ� ������ �ƹ� �ǹ̾���.
		System.out.println(bc);

	}//main
}//class
