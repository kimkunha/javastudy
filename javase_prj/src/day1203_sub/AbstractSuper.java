package day1203_sub;

/**
 *	abstract�θ� Ŭ���� 
 *	��üȭ�� �Ҽ� ����. (�ڽ��� ��üȭ�ϸ� ��밡��)
 * 	�߻�method�� �����ϸ� �ڽ� Ŭ������ ������ �����ؾ� �Ѵ�.(������ ������???)
 * @author owner
 */
public abstract class AbstractSuper {
	
	int i=130;
	
	public AbstractSuper() {
		System.out.println("�θ��� �⺻ ������!!!!!!!!!!!!!!!");
	}//������
	
	public  void pMethod(int i) {
		if(i>10) {
			i=100;
			System.out.println("��÷~~~");
		}else{ System.out.println("���� ��ȸ��~~");
			
		}//end if
	}//�θ� method
	
	//�������� ���� method�ۼ�
	public void methodA() {
		System.out.println("�θ� method!!");
	}//method
	
	//�׸��� �߻�method�ۼ� �غ���
	public  abstract void absmethod();	//�ڽ� Ŭ������ ������ �����ؾ��Ѵ�.
	public abstract String absmethod1(int i) ;// ��ȯ�� �Ű����� �ִ� �߻� �޼ҵ�
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
