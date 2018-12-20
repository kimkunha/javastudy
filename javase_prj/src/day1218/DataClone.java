package day1218;

import java.util.Stack;
//18.12.18	-7번 자료- (Clone)  6 ~ 7번 연계
public class DataClone extends Data{
private Stack<Data> historyStack;

	public DataClone() {
		historyStack = new Stack<Data>();
	}// DataClone

	public void useData() throws CloneNotSupportedException {
		Data d=new Data("쌍용 유치원");
		
		if(d instanceof Cloneable) {	//자바에서 유일한 문자열 연산자 객체명 instanceof 클래스, 인터페이스명 
			
		d.setSchool("쌍용초등학교");
		
		Data d1=d.getData();  //현재 d객체의  쌍용초등학교 가 복제된 객체가 나온다.
		historyStack.push(d1);
		d.setSchool("쌍용중학교");
		
		Data d2=d.getData();  //현재 d객체의  쌍용초, 쌍용중이 복제된 객체가 나온다.
		historyStack.push(d2);
		d.setSchool("쌍용고등학교");
		
		Data d3=d.getData();  //현재 d객체의  쌍용초, 쌍용중, 쌍용고가 복제된 객체가 나온다.
		historyStack.push(d3);
		d.setSchool("쌍용대학교");
		
		historyStack.push(d.getData());
		
		getHistoryData();
		}else {
			System.out.println(" Cloneable만 처리 합니다.");
		}//end else
	}//UseData
	
		public void getHistoryData() {
			
			Data temp=null;
			while(!historyStack.empty()) {
				temp=historyStack.pop();
				System.out.println(temp.getSchool());
				System.out.println(temp);
			}//end while
			
		}//getHistoryData
	
	
	
	public static void main(String[] args) {
		try {
			new DataClone().useData();
		} catch (CloneNotSupportedException e) {
			System.out.println("복제되지 않습니다.");
			e.printStackTrace();
		}//catch
	}// main

}// class
