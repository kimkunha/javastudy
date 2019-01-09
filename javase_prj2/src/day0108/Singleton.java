package day0108;
//19.01.08 -1���ڷ�- (singleton) 1-2����
/**
 *	��������JVM���� �ϳ��� ��ü�� ���������, �ϳ��� ��ü�� ���Ǵ� pattern
 * @author owner
 */
public class Singleton {
	private static Singleton single;
	
	/**
	 * 	1. class�ܺο��� ��üȭ�� ���´�.
	 */
	private Singleton() {
	}//Singleton
	
	public static Singleton getInstance() {
		if( single == null) { //��ü�� �����Ǿ����� �ʴٸ� ��ü�� �����ϰ�
				single=new Singleton();
		}//end if
		//��ü�� �����Ǿ� �ִٸ� ������ ��ü�� ��ȯ�ȴ�.
		return single;
	}//getInstance
	
}//class
