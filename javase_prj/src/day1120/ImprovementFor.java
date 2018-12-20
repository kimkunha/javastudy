package day1120;

import java.util.ArrayList;
import java.util.List;

/**
 *	개선된 for문 : 배열이나 Collection들의 모든 방을 값을 처음부터 끝까지
 * 순차적으로 출력하기 위해 제공.<br>
 * 		개선된 for문은 JDK1.5에서부터 사용가능<br>
 * 문법) for ( 데이터형 변수명 : 배열명(collection명)){ <br>
 * 				변수명;(배열(collection)방의 값을 사용할수있다.)<br>
 * 				}
 * @author owner
 */
public class ImprovementFor {

	public static void main(String[] args) {

			int[] tempArr= {2018, 11, 20, 16, 5};
			//이전의 for로 모든 방의 값을 출력
			for(int i=0; i < tempArr.length ; i++) {
				System.out.println(tempArr[i]);
			}//end for
	System.out.println("--------------------------개선된 for----------------------------------------");
	for( int value : tempArr) {
		System.out.println(value);
	}//end for
	
	//Collection
	List<Integer> list=new ArrayList<>();
	list.add(10);
	list.add(20);
	list.add(110);
	list.add(1);
	System.out.println("----------------List 이전 for---------------------");
	for(int i=0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}//end for
	
	System.out.println("----------------List 향상된 for---------------------");
	for(int i : list) {
		System.out.println(i);
	}//end for
	
	
	
	
	
	
	
	
	}//main
}//class
