/*
2. 이름, 교통수단과 출퇴근 거리를 입력받아 아래와 같이 출력하세요.
   교통수단은 "버스,지하철,택시,도보"로 제한한다.
   버스요금 1200원, 지하철 요금 1250원, 택시요금 3800원 입니다.
   요금은 10키로 까지는 기본요금, 매 5키로 초과시 마다 100원씩 증가 합니다.

 출력   :  xxx님 출퇴근 교통수단은 xx이며 거리는 xx 키로 입니다.
            편도 이용 요금 xx원이고, 왕복이용 요금 xx원이며, 한달 20일기준
            교통비는 총: xxxx원 입니다.  */

package day1119;

public class Homework2 {

	public static void main(String[] args) {
		String name =args[0];
		//System.out.println(name+"님");
		String trans=args[1];
		//System.out.println(trans);
		int km=Integer.parseInt(args[2]);
		int charge =0;
		int plus_charge=0;
	if (trans.equals("버스")) {
		charge=1200;
	}else if (trans.equals("지하철")){
			charge=1250;
	}else if (trans.equals("택시")) {
			charge=3800;
	}else {
			charge=0;
	}
	if (km>10) {
		plus_charge= (int)((km-10)/5)*100;
		charge = charge+plus_charge;
	}
	System.out.println(name+" "+trans+" "+km+" "+ charge);
	}//main	

}//class
