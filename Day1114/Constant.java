package Day1114;
/*
	Constant(������ ���ó�� ����ϴ°� : ���) �� ���
	���� : class field������
	*/

class Constant{
	//Constant ����
	public static final int MAX_SCORE=100;
	public static final int MIN_SCORE=0;

	public static void main(String[] args) 	{
		System.out.println(MAX_SCORE+" / "+MIN_SCORE);

		System.out.println(Constant.MAX_SCORE+" / "+
			Constant.MIN_SCORE);

		int my_score=95;

		System.out.println(" ������ �ְ����� "+
			Constant.MAX_SCORE+"���̰�, �������� "+
			MIN_SCORE+"�Դϴ�. ȹ�� ������ " +my_score+
			"�̰�, �ְ����� ȹ�� ������ ���̴�" +
			(MAX_SCORE-my_score));

		System.out.println("long �ִ밪"+
			Long.MAX_VALUE+" / �ּҰ� : "+
			Long.MIN_VALUE);


	}//main
}//class
