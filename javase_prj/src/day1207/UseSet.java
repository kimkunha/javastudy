package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


//18.12.07  -1번자료-   ( set )
/**
 *	Set : 검색의 기능이 없으며(get X), 중복값을 저장하지 않는 기능.
 * @author owner
 */
public class UseSet {
	public UseSet() {
		// JDK 1.5 이하에서는 Generic이 지원되지 않고 객체만 저장.
		//1. 생성)
		Set<String> set=new HashSet<String>();
		//2. 값 할당) - 순서대로 입력되지 않는다.
		set.add("정택성");					//제네럴이 있는 값만 허용하도록 바뀜
		set.add("이재현");					
		set.add("공선의");					
		set.add("김정운");					
		set.add("노진경");					
		set.add("최지우");					
		set.add("이봉현");					
		set.add("김정운");					
		System.out.println(set.size()+" / "+set);		//객체만 넣어도 주소값이 안나오는 이유는 object의 toSting를 오버라이딩 해서 값 출력됨
		set.remove("김정운");	// 삭제해봄   //가변길이형
		System.out.println(set.size()+" / "+set);		
		
		//배열로 복사
		String[] names = new String[set.size()];
		set.toArray(names);
		
		//set의 모든 방(Element)의 값 얻기
//		System.out.println(set.get("김정운"));	// set자체는 검색의 기능이 없다. 그러므로 iterator 사용한다아아아
		//Iterator를 사용하여 값을 얻기
		Iterator<String> ita=set.iterator();
		
		String name="";
		while( ita.hasNext()) {	//Iterator가 참조하는 set의 요소가 존재한다면  
			name=ita.next();	// 해당 요소의 값을 얻고 다음 포인터로 이동
			System.out.printf("[%s]\t", name);
		}//end while
		System.out.println();
		System.out.println("------------------------------ 향상된 for -----------------------------------------------------------------");
		for( String temp : set) {			
			System.out.println(temp);
		}//end for
		
		//모든 방의 값 삭제
		set.clear();
		System.out.println("clear후"+set.size()+", "+set);
		System.out.println("----------------------------- 배열에 복사한 값 -------------------------------------------------------------");
		for(int i=0; i< names.length; i++) {
			System.out.printf("[%s]\t", names[i]);
		}//end for
		System.out.println();
	}//UseSet
		public int [] lotto() {
			int[] tempLotto=new int[6];
			
			Random random= new Random();
			for(int i=0; i<tempLotto.length; i++) {
				tempLotto[i]=random.nextInt(45)+1;	//	같은수가 발생할 수 있다.
				for(int j=0; j<i; j++) {
					if(tempLotto[i]==tempLotto[j]) {	// 방의 값이 같다.
						i--;// 중복 발생된 번호의 인덱스번째를 다시 발생시키기 위해 인덱스번호를 하나 줄인다.
						break;		//반복문을 빠져나간다.
					}//end if
				}//end for
			}//end for
			return tempLotto;
		}//tempLotto
		
		
		public Integer [] lotto1() {
			Integer[] tempLotto=new Integer[6];
			
			Set<Integer> set=new HashSet<Integer>();			//set의 제너럴은 기본형int 로 쓸수없다 그러므로 Integer로 써서 했음
			Random random= new Random();
			while( true ) {
				set.add(random.nextInt(45)+1);	//	같은수가 추가되지 않는다.
				if(set.size()==6) {
					break;
				}//end if
			}//end for
			set.toArray(tempLotto);
			
			return tempLotto;
		}//tempLotto
	
	
	
	
	
	public static void main(String[] args) {
		UseSet us = new UseSet();
		int[] temp= us.lotto();
		
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i]+" ");
		}//end for
		System.out.println();
		System.out.println("---------------------------------------------------");
		Integer[] temp1= us.lotto1();
		for(int i=0; i<temp1.length; i++) {
			System.out.print(temp1[i]+" ");
		}//end for	
		
		
	}//main

}//class

