package day1203;
//18.12.03 ���� 3�� �ڷ�
/**
 *
 * @author owner
 */
public class TestSub2 extends TestSuper{
	int i;
	
	public TestSub2() {
		super();
		System.out.println("�ڽ��� ������");
	}//TestSub   ������
	
	public void subMethod() {
		System.out.println("�ڽ��� subMethod2222222222222222");
	}//subMethod   �޼ҵ�
	
	@Override  //�̰��� �θ��� ���� �ֳ����̼��̶� �Ѵ�
	public void printI() {
		System.out.println("�ڽ�222222222 Override�� method"+this.i+", �θ��� i = "+super.i);
	}//printI   �޼ҵ�
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}//class
