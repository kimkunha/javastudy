package Day1114;
/*
	다른 클래스에 있는 상수를 사용해보기 위한 클래스
*/

class UseConstant {
	public static void main(String[] args) {
		int my_score=95;
		System.out.println(my_score);
		my_score=93;
//		MAX_SCORE=90; // 상수는 값 할당이 되지 않는다.
		my_score=83;
		//다른 클래스에 존재하는 상수는 반드시 "클래스명.상수명" 의 형식을 가진다.
		//System.out.println( MAX_SCORE);  <-- MAX_SCORE의 상수는 다른 클래스에 있어서 사용불가
		System.out.println( Constant.MAX_SCORE+" / "+
			Constant.MIN_SCORE);     // Constant클래스의 있는 상수를 가져와 . 을 붙여 상수명 입력해 사용
	}//main
}//class
