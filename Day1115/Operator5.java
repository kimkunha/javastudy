package Day1115;
/*
		�������� : 
		�Ϲݳ�
			&& : ���װ� ������ ��� true �϶��� true ��ȯ, �� �ܿ��� False ��ȯ
			|| : ���װ� ������ ��� False�϶��� false ��ȯ �� �ܿ��� True ��ȯ
		��Ʈ��
			& (AND) : ������Ʈ�� ������Ʈ ��� 1�ΰ�� 1����
			|	(OR) :  ������Ʈ�� ������Ʈ ��� 0�ΰ�� 0���� 
			^	(XOR) - Exclusive OR : ������Ʈ�� ������Ʈ ���� �ϳ��� 1�ΰ�� 1����
		 	
*/
class Operator5 {
	public static void main(String[] args) {
		boolean flag1=true,flag2=false,flag3=true,flag4=false;
		int i=0, j=0;

		System.out.println("-------------------&&-------------------------");

		System.out.println(flag1+" && "+flag3+" = "	+ (flag1 && flag3));//true
		System.out.println(flag1+" && "+flag2+" = "	+ (flag1 && flag2));//false
		//������ false�̸� ������ ������� �ʰ� fals�� ����� �����.
		System.out.println(flag2+" && "+flag1+" = "	+ (flag2 && flag1));//false
		System.out.println(flag2+" && "+flag4+" = "	+ (flag2 && flag4));//false

		System.out.println("-------------------&&-------------------------");


											
		System.out.println("-------------------&&-------------------------");

		System.out.println(flag1+" || "+flag3+" = "+ (flag1 || flag3));//true
		System.out.println(flag1+" || "+flag2+" = "+ (flag1 || flag2));//true
											//������ false�̸� ������ ������� �ʰ� fals�� ����� �����.
		System.out.println(flag2+" || "+flag1+" = "+ (flag2 || flag1));//true
		System.out.println(flag2+" || "+flag4+" = "+ (flag2 || flag4));//false

		System.out.println("-------------------&&-------------------------");
		
		flag1=false;
		flag2=false;
		flag3=false;

		flag3=(flag1=3<4) && (flag2=5>4);
		System.out.println("���� : "+flag1+", ���� : "+flag2+",���� : "+ flag3);

		System.out.println("-------------------&&-------------------------");
		i=28;
		j=48;
		System.out.println(i+ " & " +j+" = "+(i&j));
		i=16;
		j=3;
		System.out.println(i+ " & " +j+" = "+(i|j));
		i=10;
		j=12;
		System.out.println(i+ " & " +j+" = "+(i^j));
		
	}//main
}//class
