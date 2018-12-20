package day1203;
//18.12.03 ���� 7�� �ڷ�  (7��~10������ �ڷ� ����)
/**
 *	����� �߻�ȭ�Ͽ� ���� Ŭ����<br>
 *	����� Ư¡ : ��, ��, ��, �̸�<br>
 *	������ Ư¡ : �Դ´�.<br>
 *
 *	��üȭ) person ��ü��=new person();<br>
 *		������ ��ü�� �Դ����� �� �� �ִ�.
 *
 *	18/12/03 ����
 *	person�� �Ϲ� Ŭ�������� abstractŬ������ ����<br>
 *	��� ����� ������ �Դ��ϰ� �ۿ��� ��Դ� ��, �� �ݵ�� ������.
 *
 * @author owner
 */
public abstract class Person {
	private String name;	// �̸�
	private int eye, nose, mouth;		// ��, ��, ��
	//18.12.03 �߰�
	private String[]language;//����ϴ� ���
	
	/**
	 * 	���Ŭ������ �⺻ ������<br>
	 * 	�� 2��, �� 1��, �� 1���� ���� ��� ��ü�� ����
	 */
	public Person() {
//		super(); //this�ϰ� ���� ��� �Ұ���
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouth=1;
	}//Person
	
	/**
	 * 	�� 2��, ��1��, ��1���� �ƴ� ��� ��ü�� ������ �� ����ϴ� ������
	 * 	18.12.03 �߰�
	 * 	�� �߰� �� �� �ֵ���
	 * @param eye	���� ��
	 * @param nose ���� ��
	 * @param mouth ���� ��
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;
		language=new String[10];
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
	
	public String[] getLanguage() {
		return language;
	}//
	
	//������ Ư¡
	/**
	 * 	�������� Ư¡<br>
	 * 	������ �����ü�� ������ ���� �Դ� �� ����.
	 * @return ���
	 */
	public abstract String eat(); 	//�߻� method�� �ݵ�� �ڽĿ��� �����ؾ��Ѵ�. ���ϸ� error
	
	/**
	 * 	method Overload(Overloading) : ������ - ���� �̸��� method�� ������ ���� �ϴ� ���<br>
	 * 	������ �����ü�� �Ĵ翡 �ֹ��� ������ �Դ� ���� ����.
	 * @param menu ������ ����
	 * @param price ������ ����
	 * @return ���
	 */
	public  abstract String eat(String menu, int price);     //�Ϲ� method�� �ݵ�� body�� �־�� �ϴµ� �����Ƿ� Error abstract�� ������ �߻�method�� ���ؼ� error�� ���� �ʴ´�.
	/**
	 * 	����� �� ������ �� �� �ִ�.
	 * @return �Ҽ��ִ� ���
	 */
	public String[] language(String lang) {
		// ���ο� �߻�method�� �߰��ؼ� ���� �߻�method�� �������� �ʴ� HongGilDong �ϰ� Clark Class�� Error�� ���� �ڽ�Ŭ���� �ݵ��
		String[] tempLang = getLanguage();
		int idx=0;
		for(int i=0; i< tempLang.length; i++) {
			
			
			if(tempLang[i] !=null) {	
				//������ �� �����Ѵٸ� ���� �ε����� ��´�.
				if(lang.equals(tempLang[i])) {		
					//�Էµ� �� �̹� ����� ����� ���� ���� �ε����� ������.
				if(lang.endsWith(tempLang[i]))
					//�Էµ� �� �̹̽����� ����� �ݺ����� �������� �ش�濡 ���� �����ִ� �ε����� ������.
					break;
				}//end if
				idx++;
			}//end if
			}//end if
		//������ �߰��ǰ� �ִٸ� �����. : upsert
		tempLang[idx]=lang;
		return tempLang;
		
	}
																					//�θ��� �߻�method�� �����ؾ��Ѵ�.
	
}//class
