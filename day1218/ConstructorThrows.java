package day1218;

//18.12.18	-3�� �ڷ�- (������ Throws)
/**
 *	�����ڿ��� ���ܸ� ������ ���
 * @author owner
 */
public class ConstructorThrows  {
	//�����ڿ��� �����ۼ�
	public ConstructorThrows() throws ClassNotFoundException{
		Class.forName("java.lang.Object");
		System.out.println("��ü����");
	}//ConstructorThrows

	public static void main(String[] args) {
		try {
			ConstructorThrows ct=new ConstructorThrows();
			System.out.println("��üȭ ����"+ct);
		}catch(ClassNotFoundException cnfe) {
			System.out.println("��üȭ �� ���� �߻�!!!");
		}//end catch
	}//main

}//class
