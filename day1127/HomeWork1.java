package day1127;


/**
 * 	숙제
 * 	주민번호 입력받아 처리하는 프로그램 작성
 * 	각 작업은 method 정의하고 호출하여 결과를 받아서 처리
 * 	1-1. 생성자는 주민번호를 받아 instance 변수에 할당한다.
 * 		-인스턴스변수의 값 사용
 * 	1-2. 주민번호의 길이체크하여 14자가 아니면 false반환
 * 	1-3. 주민번호의 6번째 자리가 '-'이 아니면 	false 반환
 * 	1-4. 주민번호의 유효성 검증하여 유효하면 true/false 반환
 * 		  주민번호의 각 자리에 2 3 4 5 6 7 8 9 2 3 4 5 를 곱한 값을
 * 		  더하여 11로 나눈 나머지 값을 얻고 11에서 그 값을 빼고
 * 			10으로 나눈 나머지가 주민번호의 끝자리와 같다면 true/false
 * 	1-5. 생년월일 반환하는 일 "1988-11-11"
 * 	1-6. 나이를 반환하는일 31
 * 	1-7 성별을 반환 남.여
 * 	1-8 내국인/외국인 반환	 1,2,3,4 내국인 5,6,7,8외국인
 * 	1-9 띠를 반환 "양띠"
 * 
 * 
 * 
 * @author owner
 */
public class HomeWork1 {
	String ssn=new String();
	
	public HomeWork1(String ssn){
		this.ssn=ssn;
	}//1-1
	
	public boolean ssn1(String ssn) {
		boolean flag=true;
		
			if(ssn.length() !=14) {
				flag=false;
			}//end if
		return flag;
	}//1-2
	
	public boolean ssn2(String ssn) {
		boolean flag=false;
		
			if(ssn.substring(6, 7)!="-") {
				flag=true;
				
			}
		return flag;
	}//1-3
	
	public int year(int i) {
		int s =2018-i+1;
		
		return s;
	}//1-6
	
//	public int gender(int gender) {
//  }
	
	
	
	
	public static void main(String[] args) {
		HomeWork1 hw =new HomeWork1("901217-1074411"); 
		System.out.println(hw.ssn);
		
	System.out.println();
		
		
		System.out.println(hw.year(30));
		
		
		
		
		
		
		
		
		
	}//main

}//class
