package day1122;


/**
 * method 의 4가지 형태
 *
 * @author owner
 */
public class MethodType {

	/**
	 * 반환형 없고 매개변수 없는 형 - 같은 일을 수행한다
	 */
	public void typeA() {
		System.out.println("안녕하세요?");
	}// typeA

	/**
	 * 반환형 없고, 매개변수 있는 형 - 가변일
	 * 
	 * @param i 는 출력라고 싶은 값
	 */
	public void typeB(int i) {
		System.out.println(i + "번 안녕?");
	}// typeb

	/**
	 * 반환형 있고, 매개변수 없는 형 - 고정 값 
	 * 	값을 받아 사용하는 코드가 필요.
	 * @return 년.월 을 실수형으로 반환
	 */
	public double typeC() {
//		int i = 11;
		return 2018.11;					//데이터형을 맞춰 줘야 한다.   casting , 형명시해서 반환값과 맞춰주면 사용할수 있다.
		// System.out.println("|||||"); //return 구문 아래에 코드가 정의 될수 없다.
	}// typeC

	/**
	 * 	반환형이 있고, 매개변수 있는 형 - 가변 값
	 * @param d 정수로 만들고 싶은 실수 값
	 * @return 정수로 변환된 값
	 */
	public int typeD(double d) {
		
		 int i=(int)d;
		 
		 return i;
	}//typeD
	
		 
	public static void main(String[] args) {

		MethodType mt = new MethodType();
		// 1. 고정 일 을 하는 method 호출
		mt.typeA(); // 객체명.method명(); 을 출력이된다.      좌항은 저장할값 = 우항은 값

		// 2. 가변 일 method 호출 // 입력되는 값에 따라 다른 일을 한다.
		mt.typeB(22);
		mt.typeB(21);
		mt.typeB(202);
		
		//3. 고정 값 method 호출 - 반환형과 일치하는 변수를 만들어서 값을 저장해야 한다.
			double i=mt.typeC()+1;
			System.out.println("고정값"+i);

		//4. 가변 값 method 호출 - 반황형과 일치하는 변수를 만들어서 값 저장
			int j=mt.typeD(300.003);
			System.out.println("가변값"+j);
		
		
		
	}// main

}// class
