package day1205_sub;

/**
 *	로또프로그램 만들기
 *	주의점은 난수에 +45+1를 하는것
 *	for문을 2번 돌린다
 * @author owner
 */
public class TestLotto {
	int [] lottoNumber() {
		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i]=(int)(Math.random()*45+1);
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}//end if
			}//안쪽 end for 
		}//end for
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+"번 ");
		}//end for
		return lotto;
	}//method
	
	
	
	public static void main(String[] args) {
	new TestLotto().lottoNumber();
	
	
	}//main

}//class
