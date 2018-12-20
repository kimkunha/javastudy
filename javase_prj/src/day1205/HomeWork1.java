package day1205;
/*숙제
1. 1~45 까지의 사이의 수중에서 무작위로 하나를 뽑아 6개의 세트를 
   만들어 배열로 반환하는 method를 만들고 호출하여 출력할 것.
   단, 중복된 수는 배열에 입력되지 않아야한다.*/
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
