package day1129;

public class HomeWork2 {
//	번호,이름,주소,나이,성별
	int seoulliving;

	public HomeWork2() {
		
		//1. 선언 데이터형[] 배열명 = null;
			HomeWork1[] hkArr=null;
		//2. 생성 : 배열명 = new 데이터형[방의 수]
			hkArr= new HomeWork1[7];
		//3. 값 할당 : 배열명[방의번호] = new 생성자
			hkArr[0]=new HomeWork1(1,"이재찬","서울시 강남구 역삼동",28,"남자");
			hkArr[1]=new HomeWork1(2,"이재현","서울시 동대문구 답십리동",27,"남자");
			hkArr[2]=new HomeWork1(3,"김정운","수원시 영통구 영통동",26,"남자");
			hkArr[3]=new HomeWork1(4,"정택성","서울시 구로구 구로동",27,"남자");
			hkArr[4]=new HomeWork1(5,"정택순","서울시 동작구 상도동",29,"여자");
			hkArr[5]=new HomeWork1(6,"김건하","경기도 부천시 부천동",26,"남자");
			hkArr[6]=new HomeWork1(7,"이재순","서울시 광진구 광나루동",27,"여자");
			
			//일괄 처리
/*			HomeWork1 tempData=null;
			for(int i=0; i<hkArr.length; i++) {
				tempData=hkArr[i];
				System.out.println(tempData.getNum()+" , "+tempData.getName()+" , "+tempData.getAddr()+" , "+tempData.getAge()+" , "+
				tempData.gerGender());
			}
			*/
			
			
			
/*			HomeWork1 tempData=null;
			for(int i=0; i<hkArr.length; i++) {
				tempData=hkArr[i];
				if( tempData.getAddr().startsWith("서울시")==true) {
					seoulliving+=1;	    };
					
					System.out.println(tempData.getNum()+" , "+tempData.getName()+" , "+tempData.getAddr()+" , "+tempData.getAge()+" , "+
							tempData.gerGender());
			}
			System.out.println("서울에 사는 사람"+seoulliving+"명");
	}
			*/
	
			
	
	
	
	
		public void seoulLiving(HomeWork1[] hkArr) {
			if( tempData.getAddr().startsWith("서울시")==true) {
				seoulliving+=1;	    };
		}
		
		
		
		
		
		
		
		
		
		
		
	}// HomWork2
//			 2번 method 에서 서울시에 살고 있는 인원수를 출력 할것.

		
				
				
				
				
				
				
				
				
			
			
			

	public static void main(String[] args) {
		new HomeWork2();
	}// main

}// class
