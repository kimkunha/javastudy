package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

//18.12.06 	-3번 자료-  (List) 중요하니 공부많이할 것
/**
 *	List : <br>
 *	중복값을 허용하며, 검색의 기능이 있고, 순서대로 값을 입력하는 가변길이형      //중요하니 암기할 것.
 * @author owner
 */
public class UseList {

	public UseList() {
/*		JDK 1.4에서는 Generic이 제공되지 않고 객체만 저장된다.
		List list=new ArrayList();
		//값 추가 : JDK 1.5이하 에서는 객체로만 값을 넣을 수 있다.
	
  		list.add(new Integer(10));
		list.add(new Short((short)10));
		list.add("공선의");
		
		System.out.println(list.size());
		System.out.println( ((Integer)list.get(0)).intValue()+10);		//인덱스 0번방의 값 10, 객체는 연산이 되지 않는다. 그래서 이렇게 풀어서 사용
																				//근데 이것이 엄청 불편해서 JDK1.5부터는 언박싱이 추가되어 간편해짐
*/	
		//JDK1.5+ 에서 사용 : Generic, auto boxing, unboxing
		//1.5에서는 Generic을 권장.    
		List<Integer> list = new ArrayList<Integer>();    //// 제한을 설정 : 단일데이터형으로 구성
		list.add(10);// autoboxing => list.add(new Integer(10));을 해준다
		list.add(20);
		list.add(new Integer(30));
//		list.add("김건하"); // Generic으로 설정된 형이 아닌 데이터형을 추가할 수 없다.
		
		System.out.println("크기 "+list.size() );
		System.out.println(list.get(0)+10);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)+1);
		}//end for	
	}//UseList Constructor
	
	
	
	
	
	
	/**
	 * 	ArrayList 사용 : Multi Thread환경에서 동시 접근 가능.(동기화 X)
	 */
	public void useArrayList() {
		//1. 생성
		ArrayList<String> al=new ArrayList<String>();	//방 0 개 
		List<String> al1=new ArrayList<String>(100);			//방 100개  여도 size()가 없으면 0개
		
		System.out.println(al+" / "+al1); //주소가 나오지 않은 이유??   주소가 안나오면 오버라이딩해서../
		//값 추가 : 값은순서대로 추가된다.
		al.add("이재현");
		al.add("정택성");
		al.add("김정윤");
		al.add("김건하");
		al.add("김정윤");	// 중복값 저장가능
		al.add("노진경");
		al.add("김정윤");	// 중복값 저장가능
		al.add("공선의");
		System.out.println(al+" / "+al1); //	
		//size( ): 데이터의 크기
		System.out.println("al크기"+al.size()+" / al1의 크기 :  "+al1.size());
		
		//배열에 복사 toSting
		String[] names=new String[ al.size()];
		al.toArray(names);		//toArray( ) 배열을 복사하는 메소드
		
		//방의 값 삭제:
		//1. 인덱스로 삭제 : 특정 인덱스방의 값이 삭제
		al.remove(4);
		System.out.println(al.size()+" / "+ al ); 	
		//2. 방의 내용으로 삭제
		al.remove("김정윤"); //1. 가장 첫방이 삭제, 2. 가장 끝방의 값이 삭제, 3모두 삭제  -> 1번. 가장 첫방만 삭제된다.(주의 할것)  왼쪽->오른쪽으로 진행하면서 일치하는 첫방의 값만 삭제
		System.out.println(al.size()+" / "+ al ); 	
		
		for( String name : al ) {
			System.out.println( name );
		}//end for
		
		//모든 방의 값 삭제 : 
		al.clear();
		System.out.println("전체 삭제 후 : "+al.size()+" / "+al );
		
		//배열의 값
		for(int i=0; i< names.length; i++) {
			System.out.printf("%s\t\n", names[i]);
		}//end for
		System.err.println();
		
		
		
		
		
		
		
	}//useArrayList
	
	
	
	
	
	public void useVector() {
		
		//1. 생성
				Vector<String> vec=new Vector<String>();	//방 0 개 
				List<String> vec1=new Vector<String>(100);			//방 100개  여도 size()가 없으면 0개
				
				System.out.println(vec+" / "+vec1); //주소가 나오지 않은 이유??   주소가 안나오면 오버라이딩해서../
				//값 추가 : 값은순서대로 추가된다.
				vec.add("이재현");
				vec.add("정택성");
				vec.add("김정윤");
				vec.add("김건하");
				vec.add("김정윤");	// 중복값 저장가능
				vec.add("노진경");
				vec.add("김정윤");	// 중복값 저장가능
				vec.add("공선의");
				System.out.println(vec+" / "+vec1); //	
				//size( ): 데이터의 크기
				System.out.println("vec크기"+vec.size()+" / vec1의 크기 :  "+vec1.size());
				
				//배열에 복사 toSting
				String[] names=new String[ vec.size()];
				vec.toArray(names);		//toArray( ) 배열을 복사하는 메소드
				
				//방의 값 삭제:
				//1. 인덱스로 삭제 : 특정 인덱스방의 값이 삭제
				vec.remove(4);
				System.out.println(vec.size()+" / "+ vec ); 	
				//2. 방의 내용으로 삭제
				vec.remove("김정윤"); //1. 가장 첫방이 삭제, 2. 가장 끝방의 값이 삭제, 3모두 삭제  -> 1번. 가장 첫방만 삭제된다.(주의 할것)  왼쪽->오른쪽으로 진행하면서 일치하는 첫방의 값만 삭제
				System.out.println(vec.size()+" / "+ vec ); 	
				
				for( String name : vec ) {
					System.out.println( name );
				}//end for
				
				//모든 방의 값 삭제 : 
				vec.clear();
				System.out.println("전체 삭제 후 : "+vec.size()+" / "+vec );
				
				//배열의 값
				for(int i=0; i< names.length; i++) {
					System.out.printf("%s\t\n", names[i]);
				}//end for
				System.err.println();
				
				
				
				
				
				
				
	}//useVector
	
	
	
	
	public void useLinkedList() {
		
		//1. 생성
		LinkedList<String> ll=new LinkedList<String>();	//방 0 개 
		List<String> ll1=new LinkedList<String>();			
		
		System.out.println(ll+" / "+ll1); //주소가 나오지 않은 이유??   주소가 안나오면 오버라이딩해서../
		//값 추가 : 값은순서대로 추가된다.
		ll.add("이재현");
		ll.add("정택성");
		ll.add("김정윤");
		ll.add("김건하");
		ll.add("김정윤");	// 중복값 저장가능
		ll.add("노진경");
		ll.add("김정윤");	// 중복값 저장가능
		ll.add("공선의");
		System.out.println(ll+" / "+ll1); //	
		//size( ): 데이터의 크기
		System.out.println("ll크기"+ll.size()+" / ll1의 크기 :  "+ll1.size());
		
		//배열에 복사 toSting
		String[] names=new String[ ll.size()];
		ll.toArray(names);		//toArray( ) 배열을 복사하는 메소드
		
		//방의 값 삭제:
		//1. 인덱스로 삭제 : 특정 인덱스방의 값이 삭제
		ll.remove(4);
		System.out.println(ll.size()+" / "+ ll ); 	
		//2. 방의 내용으로 삭제
		ll.remove("김정윤"); //1. 가장 첫방이 삭제, 2. 가장 끝방의 값이 삭제, 3모두 삭제  -> 1번. 가장 첫방만 삭제된다.(주의 할것)  왼쪽->오른쪽으로 진행하면서 일치하는 첫방의 값만 삭제
		System.out.println(ll.size()+" / "+ ll ); 	
		
		for( String name : ll ) {
			System.out.println( name );
		}//end for
		
		//모든 방의 값 삭제 : 
		ll.clear();
		System.out.println("전체 삭제 후 : "+ll.size()+" / "+ll );
		
		//배열의 값
		for(int i=0; i< names.length; i++) {
			System.out.printf("%s\t\n", names[i]);
		}//end for
		System.err.println();
		
	}//useLinkedList
	
	
	
	
	public static void main(String[] args) {
		UseList ui = new UseList();
		System.out.println("---------------------------ArrayList------------------------------------------");
		ui.useArrayList();
		System.out.println("---------------------------Vector------------------------------------------");
		ui.useVector();
		System.out.println("---------------------------LinkedList------------------------------------------");
		ui.useLinkedList();
		
		
	}//main
	
	
}//class
