package day1127;

public class UseString1 {
	// �̸����� �Է¹޾� �̸����� ��ȿ���� �����Ͽ� boolean������ 
	// ����� ����� ��ȯ�ϴ� ���� �ϴ� method�� ����� ȣ���Ͽ� ����غ�����.
	
	String ch="kimkh8455@gmail.com";
	
	private boolean validEmail(String email) {
		boolean flag = false;
		
		if(email.length()>5 && email.indexOf("@") !=-1 && email.indexOf(".") != -1){
			flag=true;
		}//end else
	
//		flag =email.length()>5 && email.containts("@") && email.contains(".") ! =-1);
return flag;
	}//validEmail
	
	//'�ñ��� ������ '�ּҸ� n�� �Է¹޾� ����� ���� �ƴ����� �Ǵ��Ͽ� ����ϴ� method
	
	public static void main(String[] args) {
		UseString1 us1=new UseString1();
//		String email="rurodaum.net";
//		String email="@.";
//		String email="rurodaumnet";
		String email="kimkh8455@gmail.com";
		if(us1.validEmail(email)) {
			System.out.println(email+"��ȿ");
		}else{
			System.out.println(email+"��ȿ");
		}//end else
			
			
			
			
	}//class

}//main
