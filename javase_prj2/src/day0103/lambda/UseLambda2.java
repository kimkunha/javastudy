package day0103.lambda;

//19.01.03 -4�� �ڷ�- (3�� �������̽� ����)			//��ȣ�� ���� ������
public class UseLambda2 {

	public static void main(String[] args) {
		//�Ű������� �ִ� abstract method ���
		//1. �߻� method�� �Ű������� ������ �ִٸ� ���ٽĿ� �Ű������� ����
//		TestLambda2 tl2=(int i, int j)-> System.out.println( i+" + "+j+" = "+(i+j));
//		tl2.plus(1, 3);
		
		//2. ���ٽĿ� ����Ǵ� �Ű��������� �߻� method�� �Ű�������� ���� �ʿ�� ����.
//		TestLambda2 tl2=(int num1, int num2)-> System.out.println( num1+" + "+num2+" = "+(num1+num2));
//		tl2.plus(1, 3);

		//3. Ÿ�� �߷� : ���ٽĿ� ����Ǵ� �Ű������� ���������� �����Ҽ� �ִ�.
//		TestLambda2 tl2=(num1, num2)-> System.out.println( num1+" + "+num2+" = "+(num1+num2));
//		tl2.plus(1, 3);
		
		//������ ���¶�� { }�� �־� ����Ѵ�.
		TestLambda2 tl2=(num1, num2)-> {
		StringBuilder sb=new StringBuilder();
		sb.append(num1).append(" + ").append(num2).append(" = ").append(num1+num2);
		
		System.out.println( num1+" + "+num2+" = "+(num1+num2));
		};
		
		tl2.plus(1, 3);
		
		
		
		
		
	}//main

}//class
