package day1205;
/*����
1. 1~45 ������ ������ ���߿��� �������� �ϳ��� �̾� 6���� ��Ʈ�� 
   ����� �迭�� ��ȯ�ϴ� method�� ����� ȣ���Ͽ� ����� ��.
   ��, �ߺ��� ���� �迭�� �Էµ��� �ʾƾ��Ѵ�.*/
public class HomeWork1 {

	public int [] lottoNumber() {
		int [] lotto = new int[6];
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i]=(int)(Math.random()*45+1);
			
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
					
					
					}
				}
			}
		
		
		for (int i = 0; i < lotto.length; i++) {
						System.out.print(lotto[i] + " ");
		}
		return lotto;
	}//lottonumber
	
	
	public static void main(String[] args) {
		HomeWork1 hk1 = new HomeWork1();
			hk1.lottoNumber();
		
		
		
	
		
	}//main

}//class
