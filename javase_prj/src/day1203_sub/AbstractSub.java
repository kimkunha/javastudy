package day1203_sub;

/**
 *	abstract�� �θ�Ŭ������ ��ӹ޾� ����غ���
 *	�߻�method�� ������ ���� �����ؾ��Ѵ�.
 * @author owner
 */
public class AbstractSub extends AbstractSuper {			//�����ߴ� ������ �߻�method�� �������� �ʾƼ� �̴�
		//�ڽ��� �޼ҵ�, ���� �����غ���
		int number;
		int score;
		String name;
		String grade;
	
		public String gradeMethod(int score) {
			return String.valueOf(score).concat("���");
		}//�ڽ� method
		
	
	//���� �θ�Ŭ������ �߻�method2������ �����غ���
		@Override
		public void absmethod() {
			System.out.println("abstract Overriding ���ڽ� �޼ҵ� �ȳ��ϼ���");
		}//�߻�method 
		
		public String absmethod1(int i) {	//�Ű������� int�� �޾Ƽ� String.ValueOf�� �⺻�������͸� ���ڿ��� ��������� �Ѵ�.
			
			return String.valueOf(i).concat("�ȳ�~");
		}//end
	
	
	public static void main(String[] args) {
		//�ڽ� ���̺�� ���� ��üȭ ����
		AbstractSub as= new AbstractSub();	//�θ��� �����ڸ� �����´�.. 
		as.absmethod();
		System.out.println(as.absmethod1(10));  //�ڽ� method ���
		as.pMethod(5);//�θ� method�� ����غ�.
		as.methodA();  // �θ��� �߻�Ŭ�������� ����� method���
		System.out.println("-------------------------------------------------------------");
		//is a ���� ��üȭ
		AbstractSuper abs= new AbstractSub();
		//�θ����̺�� �������̵��� method ����غ���
		abs.i=12;
		System.out.println("abs.i = "+abs.i);
		abs.absmethod();
		System.out.println(abs.absmethod1(14));
		abs.methodA();
		abs.pMethod(5);
		
		
		
		
		
		
	}//main

}//class
