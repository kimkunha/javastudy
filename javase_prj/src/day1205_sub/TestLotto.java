package day1205_sub;

/**
 *	�ζ����α׷� �����
 *	�������� ������ +45+1�� �ϴ°�
 *	for���� 2�� ������
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
			}//���� end for 
		}//end for
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+"�� ");
		}//end for
		return lotto;
	}//method
	
	
	
	public static void main(String[] args) {
	new TestLotto().lottoNumber();
	
	
	}//main

}//class
