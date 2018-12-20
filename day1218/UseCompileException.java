package day1218;
//18.12.18	-1�� �ڷ�- (Compile Exception)
/**
 *	Compile Exception : byte code�� ���������� �����ϱ� ���Ѱ�.
 *	�����ڰ� �ݵ�� ���ܻ�Ȳ�� ó���ؾ� �ϴ� ����.
 * @author owner
 */
public class UseCompileException {


	public static void main(String[] args) {
		//new�� ���� �ʰ� ��ü�� �� �����ִ� ���
		
		try {
//			Object obj=Class.forName("java.lang.String");		//������ �߸� 2��° try�� ó�� �Ҽ� �ִ�.
			Object obj=Class.forName("day1217.UseRuntimeException");		//������ �߸� 2��° try�� ó�� �Ҽ� �ִ�.
			System.out.println("�ε��� Ŭ����"+obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�˼��մϴ�.");
			System.err.println("���� �޼��� ��� : "+cnfe.getMessage() );	//getMessage�� �θ��� ���ܸ޼����� ����Ҽ� �ִ�.
			System.err.println("����ó�� ��ü�� �޼��� : "+cnfe);
			cnfe.printStackTrace();
//			System.out.println("--------");		//println�� printStackTrace���� ���� ��µȴ�.
			
			//���� �߻��ϸ� �ٸ��� ���ٵ� �������� Ŭ������ ����. ������ ����..
			// �𸣸� ���۸��ؼ� ã�ƺ���.
			
		}finally {
			System.out.println("������ּż� �����մϴ�.");
		}//end finally
			
		
		
		
	}//main

}//class
