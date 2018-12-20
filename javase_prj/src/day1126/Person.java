package day1126;

/**
 *	사람을 추상화하여 만든 클래스<br>
 *	명사적 특징 : 눈, 코, 입, 이름<br>
 *	동사적 특징 : 먹는다.<br>
 *
 *	객체화) person 객체명=new person();<br>
 *		생성된 객체로 먹는일을 할 수 있다.
 * @author owner
 */
public class Person {
	private String name;	// 이름
	private int eye, nose, mouth;		// 눈, 코, 입
	
	/**
	 * 	사람클래스의 기본 생성자<br>
	 * 	눈 2개, 코 1개, 입 1개를 가진 사람 객체를 생성
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouth=1;
	}//Person
	
	/**
	 * 	눈 2개, 코1개, 입1개가 아닌 사람 객체를 생성할 때 사용하는 생성자
	 * @param eye	눈의 수
	 * @param nose 코의 수
	 * @param mouth 입의 수
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=2;
		this.nose=1;
		this.mouth=1;
	}//Person()
	
	//setter 만들기
	/**
	 * 	생성된 사람 객체에 이름을 설정하는 일
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name=name;
	}//setName
	
	/**
	 * 	생성된 사람 객체의 눈을 설정하는 일<br>
	 * 	설정할 눈의 갯수는 최대 3개 까지 설정할 수 있습니다.
	 * 	3개가 넘어가면 2개로 설정된다.
	 * @param eye 눈의 갯수
	 */
	public void setEye(int eye) {
		if(eye >3) {
			eye=2;
		}//end if
		this.eye=eye;
	}//setEye
	
	/**
	 * 생성된 사람 객체의 코를 설정하는 일.
	 * @param nose 의 갯수
	 */
	public void setNose(int nose) {
		this.nose=nose;
	}//setEye
	
	/**
	 * 생성된 사람 객체에 입의 갯수 설정하는 일.
	 * @param mouth 설정할 입의 갯수
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}//setMouth
	
	
	//getter만들기
	/**
	 * 생성된 사람 객체에 이름을 반환하는 일.
	 * @return 이름
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * 생성된 사람 객체가 가지고 있는 눈의 객수 반환하는 일
	 * @return 눈의 갯수
	 */
	public int getEye() {
		return eye;
	}//getEye
	
	/**
	 * 	생성된 사람객체가 가지고 있는 코의 갯수를 반환 하는 일.
	 * @return 코의갯수
	 */
	public int getNose() {
		return nose;
	}//getNose
	
	/**
	 * 	생성된 사람객체가 가지고 있는 입의 갯수를 반환 하는 일.
	 * @return	입의 갯수
	 */
	public int getMouth() {
		return mouth;
	}//getMouth
	
	//동사적 특징
	/**
	 * 	동사적인 특징<br>
	 * 	생성된 사람객체가 집에서 밥을 먹는 일 구현.
	 * @return 결과
	 */
	public String eat() {
		return name+"이(가) 집에서 밥을 먹는다";
	}//eat
	
	/**
	 * 	method Overload(Overloading) : 다형성 - 같은 이름의 method를 여러개 정의 하는 방법<br>
	 * 	생성된 사람객체가 식당에 주문한 음식을 먹는 일을 구현.
	 * @param menu 음식의 종류
	 * @param price 음식의 가격
	 * @return 결과
	 */
	public String eat(String menu, int price) {					//매개변수를 사용한것이 overload이다
		return name+"이(가) 식당에서 "+menu+"인 음식을"+price+"원 내고 사먹는다.";
	}//eat
	
}//class
