package day1218;
//18.12.18	-14�� �ڷ�- ( ����� ����ó�� Ŭ����)  
/**
 *	��������� ����ó�� Ŭ����
 * @author owner
 */
//1. Exception�̳� RuntimeException�� ��� �޴´�
@SuppressWarnings("serial")
public class TobaccoException extends Exception {
 
	public TobaccoException() {
		this("��迹�� - ����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");

	}//TobaccoException
	public TobaccoException(String msg) {
			super(msg);
	
	
	}//TobaccoException
	
}//class
