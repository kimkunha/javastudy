package Day1114;
/*
	�ٸ� Ŭ������ �ִ� ����� ����غ��� ���� Ŭ����
*/

class UseConstant {
	public static void main(String[] args) {
		int my_score=95;
		System.out.println(my_score);
		my_score=93;
//		MAX_SCORE=90; // ����� �� �Ҵ��� ���� �ʴ´�.
		my_score=83;
		//�ٸ� Ŭ������ �����ϴ� ����� �ݵ�� "Ŭ������.�����" �� ������ ������.
		//System.out.println( MAX_SCORE);  <-- MAX_SCORE�� ����� �ٸ� Ŭ������ �־ ���Ұ�
		System.out.println( Constant.MAX_SCORE+" / "+
			Constant.MIN_SCORE);     // ConstantŬ������ �ִ� ����� ������ . �� �ٿ� ����� �Է��� ���
	}//main
}//class
