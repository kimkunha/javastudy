package day1203_sub;

/**
 * InterA, InterB�� ����� �޴´� ���߻��
 * 	�������̽����� �������̵��� ���� �ʾƵ� �ȴ�.	
 *	����� �빮�ڷ� ���ִ� ���� ����
 *	�������̽��� �Ϲ� �޼ҵ带 ������ ����.
 * @author owner
 */
public interface SuperInterface extends InterA,InterB {
	
	public void methodA(); //�߻�method �ٵ� ������ �ʴ´�
	public abstract void methodB(int i); 
	
	
	
	
}//interface
