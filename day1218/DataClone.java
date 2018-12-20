package day1218;

import java.util.Stack;
//18.12.18	-7�� �ڷ�- (Clone)  6 ~ 7�� ����
public class DataClone extends Data{
private Stack<Data> historyStack;

	public DataClone() {
		historyStack = new Stack<Data>();
	}// DataClone

	public void useData() throws CloneNotSupportedException {
		Data d=new Data("�ֿ� ��ġ��");
		
		if(d instanceof Cloneable) {	//�ڹٿ��� ������ ���ڿ� ������ ��ü�� instanceof Ŭ����, �������̽��� 
			
		d.setSchool("�ֿ��ʵ��б�");
		
		Data d1=d.getData();  //���� d��ü��  �ֿ��ʵ��б� �� ������ ��ü�� ���´�.
		historyStack.push(d1);
		d.setSchool("�ֿ����б�");
		
		Data d2=d.getData();  //���� d��ü��  �ֿ���, �ֿ����� ������ ��ü�� ���´�.
		historyStack.push(d2);
		d.setSchool("�ֿ����б�");
		
		Data d3=d.getData();  //���� d��ü��  �ֿ���, �ֿ���, �ֿ�� ������ ��ü�� ���´�.
		historyStack.push(d3);
		d.setSchool("�ֿ���б�");
		
		historyStack.push(d.getData());
		
		getHistoryData();
		}else {
			System.out.println(" Cloneable�� ó�� �մϴ�.");
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
			System.out.println("�������� �ʽ��ϴ�.");
			e.printStackTrace();
		}//catch
	}// main

}// class
