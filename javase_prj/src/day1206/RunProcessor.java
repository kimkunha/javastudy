package day1206;
public class RunProcessor {

	public static void main(String[] args) {
		String str="������, �̺���, ������, ���ü�, ������, ������";
		
		ScoreProcessor sp =new ScoreProcessor(str);	//scoreProcessor�� Ŭ������ ��üȭ �Ѵ�.
		
		int cnt=0;
		
		while(true) {
			cnt =(int)(Math.random()*sp.name.size())+1;
			if(cnt>1)
				break;
		}
		sp.printScore( cnt);
		
		
		
		
		
		
		
	}//main

}//class
