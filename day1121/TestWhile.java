package day1121;

/**
 *	while : 시작과 끝을 모를때 사용하는 반복문 <br>
 *			 최소 0번수행 최대 조건까지 수행<br>
 *	문법 )
 *			while(조건식){<br>
 *				반복수행문장<br>
 *			   }
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {

			int i =1; //초기값;    
//			int i =100;			//조건에 맞지않게 초기값을 크게넣으면 한번도 실행 안할수 있다. (while의 특징)
			while(i <10) {//조건식
				System.out.println("i="+i);
				i++;//증가식
			}//end while
	
			System.out.println("================================================================'");
			
			//단을 입력받아 2단~9단사이라면 구구단 출력
			int j =2;
			int k=2;
			while(j<10) {
				System.out.println(j+"단시작");
			
				while(k<10) {
					System.out.println(j+" * "+k+" ="+(j*k));
				j++;
					k++;
				}
			}//end while
			
			//무한loop
			i=0;
			while(true) {
				System.out.println("무한 loop");
				if(i==5) {
					break;
				}//end if
				i++;
			}//end while
		
		
		
		
		
	}//main

}//class
