package day1203;
//18.12.03 ���� 15�� �ڷ� (9���ڷ� Ŭ�� ����)
/**
 *	���� �͵��� ��<br>
 *	���� ���� �ӵ�, ����
 * @author owner
 */
public interface Fly {
	/**
	 * 	���� �ӵ�
	 * @param speed
	 * @return
	 */
	public abstract String speed(String speed);
	/**
	 * 	���� ����
	 * @param height
	 * @return
	 */
	public String height(String height);						//�������̽��� �߻�method�� public�� ���� protected �Ұ�
	
}//interface
