package day1218;
//18.12.18	-6번 자료- (Clone)  6 ~ 7번 연계
public class Data /*implements Cloneable*/ {
	private String school;
	

	public Data() {
	}//Data

	public Data(String school) {
		this.school = school;
	}//Data

	public String getSchool() {
		return school;
	}//getSchool

	public void setSchool(String school) {
		this.school = school;
	}//setSchool
	
	
	public Data getData() throws CloneNotSupportedException {
	Data data=(Data)this.clone();	// Clone()은 protected 접근지정자를 가지고 있어 외부 클래스에서 
										//다른 클래스의 clone()를 호출할 수 없다.
		return data;
	}
	
	
}//class
