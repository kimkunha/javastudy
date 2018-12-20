package day1205_sub;

/**
 *	로또 프로그램 만들기 프로젝트
 * @author owner
 */
public class Test {
	
	public int[] lottoPro() {
		int [] lotto =new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i]=(int)(Math.random()*45+1);
			for(int j=0; j<i; j++) {
			if(	lotto[i]==lotto[j] ) {
				i--;
				break;
			}
			}
		}
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}
		System.out.println();
		return lotto;
	}//method
	
	
	
	
	
	
public static void main(String[] args) {
	new Test().lottoPro();
	
	
}
}