package day1203;
//18.12.03 ���� 16�� �ڷ�  ( 16�� ~ 17���ڷ� ����)
/**
 *	default method : �������̽����� ����(�ڹ��ڵ�)�� ����� �� �ִ� method<br>
 *	default method �� ȣ�� �ҷ��� ���� Ŭ������ is a ������ ��üȭ�� �ؾ߸� �Ѵ�.
 * @author owner
 */
public interface UseDefault {
	
	public void test();
	
	public default void temp() {
		System.out.println("����ó�� �ڵ� ����");
	}//temp
}//interface
