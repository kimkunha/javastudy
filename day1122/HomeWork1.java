/*
숙제 
아래의 업무를 처리하는 method를 type에 알맞게 작성하고 API주석을
 설정한 후 호출하여 결과를 본 후 Java Doc을 생성해보세요.
- API주석은 어떤 형태의 method인지를 주석으로 기술할것.

1. 자신의 이름을 반환하는 method작성.
2. 나이를 입력받아 태어난 해를 반환하는  method 작성.
3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의
    문자를  출력하는 일을 하는 method  작성
5. 호출하면 자신의 주소를 출력하는  method 작성.
6. 친구의 이름을 입력받아 출력하는  method 작성(친구는 n명 입니다.)
*/
package day1122;

public class HomeWork1 {

	/**
	 * @return 김수정
	 */
	public String name() {
		return "김수정";
	}// 이름반환 method

	/**
	 * age를 입력 받은 값으로 생년코드를 reyear만들어 반환한다.
	 * @param 나이를 입력받음
	 * @return 값을 생년월일
	 */
	public int year(int age) {
		int reyear = 2018 - age + 1;

		return reyear;
	}
//3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.

	/**
	 * 	문자를 입력받은것을 unicode로 바꾸려면 int형으로 casting이 필요하므로
	 * 	 casting 후 반환하면 출력문은 int형으로 나온다
	 * @param ch 문자형 ch가 유니코드로 나오게할려면 int형 casting 필요
	 * @return int로 캐스팅한 값을 출력하면 int형으로 나옴
	 */
	public int message(char ch) {

		int i = (int) ch;
		return i;
	}
/*	
	4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의
    문자를  출력하는 일을 하는 method  작성 65~90
*/
	
//	5. 호출하면 자신의 주소를 출력하는  method 작성.
	
	 
	
	public void add(){
		System.out.println("옥수동");
		
	}
	
	
	 public void number (int range) {
		 
		 if(range>65 && range<90) {
		char	aaaaa=(char)range;
			 System.out.println(aaaaa
					 );
		 }//end if
	
	 }
	 
	 
/*	 
	 6. 친구의 이름을 입력받아 출력하는 
	 method 작성(친구는 n명 입니다.) 
 */
	 /**
	 * @param friend 친구의 값을 입력받을려면 매개변수 friend를 만듬
	 */
	public void name1(String ... friend) {
		for(int i=1; i<friend.length; i++ ) {
			 System.out.println(friend[i]);
		}//end for
	 }
	 
	 
	public static void main(String[] args) {
		HomeWork1 hw = new HomeWork1();

		System.out.println(hw.name());

		System.out.println(hw.year(29));

		System.out.println(hw.message('A'));

		hw.number(66);
		
		hw.name1("김하열","김하늘","한아형","박현지");
		
		hw.add();
		
	}// main
}// class
