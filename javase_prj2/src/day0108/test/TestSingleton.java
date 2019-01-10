package day0108.test;

/**
 *	�̱��� �׽�Ʈ
 *	�� �ϳ��� ��ü�� ����� ����ϴ� pattern
 *	�ӵ��� ������, �޸𸮸� ���� ����Ѵ�.
 *	��ü�� �Ҹ�Ǹ� �ش����� ����Ҽ� ������ �� �����ڵ尡 ����
 *
 *
 * @author owner
 */
public class TestSingleton {
	private static TestSingleton ts;  //���������� private�� static������ ����
	
	private TestSingleton() {
	}//�����ڷ� ����
	
	//������ method ����
	public static TestSingleton getinstans() { //method�� static���� �����ؾ� �Ѵ�.
		if( ts==null) {
			ts=new TestSingleton();
		}
		return ts;
	}
	
	public static void main(String[] args) {
//		TestSingleton ts=new TestSingleton();
//		TestSingleton ts1=new TestSingleton();
//		TestSingleton ts2=new TestSingleton();
//		System.out.println(ts);
//		System.out.println(ts1);
//		System.out.println(ts2);
		//��ü���� �ּҰ��� �ٸ��� ���´�
		
		TestSingleton ts=TestSingleton.getinstans();
		TestSingleton ts2=TestSingleton.getinstans();
		TestSingleton ts3=TestSingleton.getinstans();
		TestSingleton ts4=TestSingleton.getinstans();
		System.out.println(ts);
		System.out.println(ts2);
		System.out.println(ts3);
		System.out.println(ts4);
				
		
	}//main	

}//class
