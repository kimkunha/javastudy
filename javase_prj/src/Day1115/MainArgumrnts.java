package Day1115;
/*
	java ���α׷� �ܺο��� java ���α׷� ���η� ����
	���� �Ҷ�		main method�� Arguments ���.
	����) java bytecode�� �� �� ��
*/

class MainArgumrnts{
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		Integer.parseInt("111");
		
		System.out.println(args[0]+args[1]);
		//���ڿ��� ������ ��ȯ
		//Integer.parselnt(���ڿ�); ���ڿ��� �����Ͽ� int������ ��ȯ�� �� �� ���� ��ȯ�ϴ� �� -���ֻ��-
		int i=Integer.parseInt(args[0]);
		int j=Integer.parseInt(args[1]);

		System.out.println( i * j);

		System.out.println(args[2]+"�� �ȳ��ϼ���");
	}//main
}//class
