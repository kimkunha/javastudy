package day1127;

public class UseString1 {
	// 이메일을 입력받아 이메일의 유효성을 검증하여 boolean형으로 
	// 결과를 만들어 반환하는 일을 하는 method를 만들어 호출하여 사용해보세요.
	
	String ch="kimkh8455@gmail.com";
	
	private boolean validEmail(String email) {
		boolean flag = false;
		
		if(email.length()>5 && email.indexOf("@") !=-1 && email.indexOf(".") != -1){
			flag=true;
		}//end else
	
//		flag =email.length()>5 && email.containts("@") && email.contains(".") ! =-1);
return flag;
	}//validEmail
	
	//'시군구 형태의 '주소를 n개 입력받아 서울시 인지 아닌지를 판단하여 출력하는 method
	
	public static void main(String[] args) {
		UseString1 us1=new UseString1();
//		String email="rurodaum.net";
//		String email="@.";
//		String email="rurodaumnet";
		String email="kimkh8455@gmail.com";
		if(us1.validEmail(email)) {
			System.out.println(email+"유효");
		}else{
			System.out.println(email+"무효");
		}//end else
			
			
			
			
	}//class

}//main
