package day1126;

/**
 *	����� �߻�ȭ�Ͽ� ���� Ŭ����<br>
 *	����� Ư¡ : ��, ��, ��, �̸�<br>
 *	������ Ư¡ : �Դ´�.<br>
 *
 *	��üȭ) person ��ü��=new person();<br>
 *		������ ��ü�� �Դ����� �� �� �ִ�.
 * @author owner
 */
public class Person {
	private String name;	// �̸�
	private int eye, nose, mouth;		// ��, ��, ��
	
	/**
	 * 	���Ŭ������ �⺻ ������<br>
	 * 	�� 2��, �� 1��, �� 1���� ���� ��� ��ü�� ����
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouth=1;
	}//Person
	
	/**
	 * 	�� 2��, ��1��, ��1���� �ƴ� ��� ��ü�� ������ �� ����ϴ� ������
	 * @param eye	���� ��
	 * @param nose ���� ��
	 * @param mouth ���� ��
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=2;
		this.nose=1;
		this.mouth=1;
	}//Person()
	
	//setter �����
	/**
	 * 	������ ��� ��ü�� �̸��� �����ϴ� ��
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name=name;
	}//setName
	
	/**
	 * 	������ ��� ��ü�� ���� �����ϴ� ��<br>
	 * 	������ ���� ������ �ִ� 3�� ���� ������ �� �ֽ��ϴ�.
	 * 	3���� �Ѿ�� 2���� �����ȴ�.
	 * @param eye ���� ����
	 */
	public void setEye(int eye) {
		if(eye >3) {
			eye=2;
		}//end if
		this.eye=eye;
	}//setEye
	
	/**
	 * ������ ��� ��ü�� �ڸ� �����ϴ� ��.
	 * @param nose �� ����
	 */
	public void setNose(int nose) {
		this.nose=nose;
	}//setEye
	
	/**
	 * ������ ��� ��ü�� ���� ���� �����ϴ� ��.
	 * @param mouth ������ ���� ����
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}//setMouth
	
	
	//getter�����
	/**
	 * ������ ��� ��ü�� �̸��� ��ȯ�ϴ� ��.
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ�ϴ� ��
	 * @return ���� ����
	 */
	public int getEye() {
		return eye;
	}//getEye
	
	/**
	 * 	������ �����ü�� ������ �ִ� ���� ������ ��ȯ �ϴ� ��.
	 * @return ���ǰ���
	 */
	public int getNose() {
		return nose;
	}//getNose
	
	/**
	 * 	������ �����ü�� ������ �ִ� ���� ������ ��ȯ �ϴ� ��.
	 * @return	���� ����
	 */
	public int getMouth() {
		return mouth;
	}//getMouth
	
	//������ Ư¡
	/**
	 * 	�������� Ư¡<br>
	 * 	������ �����ü�� ������ ���� �Դ� �� ����.
	 * @return ���
	 */
	public String eat() {
		return name+"��(��) ������ ���� �Դ´�";
	}//eat
	
	/**
	 * 	method Overload(Overloading) : ������ - ���� �̸��� method�� ������ ���� �ϴ� ���<br>
	 * 	������ �����ü�� �Ĵ翡 �ֹ��� ������ �Դ� ���� ����.
	 * @param menu ������ ����
	 * @param price ������ ����
	 * @return ���
	 */
	public String eat(String menu, int price) {					//�Ű������� ����Ѱ��� overload�̴�
		return name+"��(��) �Ĵ翡�� "+menu+"�� ������"+price+"�� ���� ��Դ´�.";
	}//eat
	
}//class
