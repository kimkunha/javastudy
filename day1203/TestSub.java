package day1203;
//18.12.03 ���� 2�� �ڷ�
/**
 *
 * @author owner
 */
public class TestSub extends TestSuper{
	int i;
	
	public TestSub() {
		super();
		System.out.println("�ڽ��� ������");
	}//TestSub   ������
	
	public void subMethod() {
		System.out.println("�ڽ��� subMethod");
	}//subMethod   �޼ҵ�
	
	@Override  //�̰��� �θ��� ���� �ֳ����̼��̶� �Ѵ�
	public void printI() {
		System.out.println("�ڽ��� Override�� method"+this.i+", �θ��� i = "+super.i);
	}//printI   �޼ҵ�
	
		
		
		
		
		
		
		
		
		
		
		
		
		


}//class
