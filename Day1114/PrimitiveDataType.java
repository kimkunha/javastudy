package Day1114;
/*
�⺻�� ��������												���ֻ��
	������ : byte, short, int, long								int,long 
	������ : char												char,boolean
	�Ǽ��� : float, double
	������ : boolean
*/

class  PrimitiveDataType {
	public static void main(String[] args) {
		//������
		byte a=10;
		short b=20;
		int c=30;
		long d=40; // �Ҵ�Ǵ� ���� 4byte�� �̹Ƿ� literal �� ��ȯ�� �ʿ䰡 ����.
		long e=2147483648L;
		//literal�� ������ ���� �����Ƿ� literal�� ũ�⸦ ����  -������- ��� ��

		System.out.println("byte : " +a+", short : " +b+
				", int : " + c +",long : " +d+","+e);

		//������ : unioncode �� : \u0000
		//char f='A';// �Ҵ� unicode
		char f=66;//unicode���� 10������ �Ҵ簡��.
		char g='0';
		char h='��';
		//��� : unicode�� ���� ���� ���
		System.out.println("char :" +f+","+g+","+h);

		//�Ǽ�
		float i=3.14F;
		//float�� 4����Ʈ�ε� ���ͷ� 3.14�� 8����Ʈ�� ���� ������ ����� �Ѵ�. �װ��� ������
		//������ - �Ǽ� literal�� 8byte�̰� float ���������� 4byte�̹Ƿ� ���Ҵ��� ���� �ʴ´�.
		//�׷��� �׷��� �ڿ� F���ٿ� ���̰� Ű��°� L�̴�.
		double j=3.14;// ���ͷ��� ���������� �����Ƿ� �����ø� ���� �Ҽ��ִ�.
		double k=3.14D;

		System.out.println("float : "+i+", double : "+j+","+k);

		//�Ҹ���
		boolean l=true;
		boolean m=false;
		System.out.println("boolean : "+l+","+m);

		byte b1=10, b2=20;
		int result=0;       //byte������ �ϸ� �ȵ����� int�� �ϸ� �����ϴ� 
		result = b1 + b2;
			System.out.println(result);
	




	}//main
}//class