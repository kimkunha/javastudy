package day1218;
//18.12.18	-6�� �ڷ�- (Clone)  6 ~ 7�� ����
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
	Data data=(Data)this.clone();	// Clone()�� protected ���������ڸ� ������ �־� �ܺ� Ŭ�������� 
										//�ٸ� Ŭ������ clone()�� ȣ���� �� ����.
		return data;
	}
	
	
}//class
