package day1203;
//18.12.03 ���� 13�� �ڷ�
/**
 *	����Ŭ����(�ڽ�Ŭ����)���� �ݵ�� �����ؾ��ϴ� ���� ��ϸ�
 *	�����ϴ� interface�ǻ���.(������ ������)
 * @author owner
 */
//interface�� �θ� ������ ���� �� �ִ�.   
//�ڽ��� �θ� interface�� �߻�method�� �������� �ʴ´�.
public interface SuperInterface extends InterA, InterB{											
	//Constant : ������ ���ó�� ���
//	int i; //������ �ۼ��� �� ����.
	public static final int FLAG_VALUE=12;			//������� �빮�ڷ� ���ִ°��� ����
	
	//�߻�method ����							//�߻�method�� body�� ���°� Ư¡
	//�Ϲ� method �� ���� �� ����. Error
//	public void test() {	 }
	
//�������̽��� ��ӿ��� �߻�method�� Override���� �ʴ´�.
//		@Override
//		public String msg();
	
		//abstract�� ������� �ʾƵ� �ȴ�.  (��� body�� ������ �ȵȴ�.)
		public void methodA();				
		//abstract�� ����ص� �ȴ�.
		public abstract void methodB(int i);

	
}//interface
