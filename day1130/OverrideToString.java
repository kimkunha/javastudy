package day1130;

/**
 *  Override(Overriding)
 *	�θ�Ŭ������ �����ϴ� ����� �ڽ�Ŭ������ ���� �ʴ´ٸ�
 *	�ڽ�Ŭ�������� �θ� Ŭ������ method�� ������ method�� �����Ͽ�
 *	����ϴ� ��.
 * @author owner
 */
public class OverrideToString {
	
	@Override				//���ֻ���Ұ�
	public String toString() {
//		toString();
		return"OverrideToString Ŭ����"+super.toString();
	}//toString



}//class
