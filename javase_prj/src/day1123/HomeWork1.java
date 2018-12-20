package day1123;

/**	����� �߻�ȭ�Ͽ� ���� Ŭ����
 * 	����� Ư¡ : ����� �̸�, ������ ����, ������ ��, �ſ� ����, ����, ���� �β�<br>
 * 	������ Ư¡ : �Դ´� ����<br>
 * 
 * 	��üȭ ) HomeWork1 ��ü�� = new HomeWork1();
 * 				������ ��ü�� �Դ� ���� �Ҽ� �ִ�.
 * @author owner
 *
 */
public class HomeWork1 {
	private String ramen, color, soup;
	private int spicy, price,thickness;

/*	public HomeWork1() {
		
	}//�⺻������
*/	
	public HomeWork1() {
	this("�ʱ���","������","����",3,7000,3);
	}//���ʰ� ����
	
	
	public HomeWork1(String ramen, String color, String soup, int spicy, int price, int thickness) {
		this.ramen=ramen;
		this.color=color;
		this.soup=soup;
		this.spicy=spicy;
		this.price=price;
		this.thickness=thickness;
	}//���ϴ°� 
	
	
	//setter
	/**
	 * 	������ ��� ��ü�� �̸��� �����ϴ���
	 * @param ramen �̸�
	 */
	public void setRamen(String ramen) {
		this.ramen=ramen;
 }//setRamen
	
	/**
	 * 	������ ��� ��ü�� ��� ������ ������ �����ϴ� ��
	 * @param color ��������
	 */
	public void setColor(String color) {
		this.color=color;
	}//setColor
	
	/**
	 *  ������ ��� ��ü�� ��� ������ ���� �����ϴ� ��
	 * @param soup ������ ��
	 */
	public void setSoup(String soup) {
			this.soup=soup;
	}//setSoup
	
	/**
	 * ������ ��� ��ü�� ���ʱ��� ������ �����ϴ� ��
	 * @param spicy ���ʱ� ������ �ִ� 3���� ���� �Ҽ��ִ�
	 * 	3���� �Ѿ�� �⺻�� 2�� �����ȴ�
	 */
	public void setSpicy(int spicy) {
		if (spicy>4) {
			spicy=2;
		}//end if
		this.spicy=spicy;
	}//setSpicy
	
	/**
	 * ������ ��� ��ü�� ������ �����ϴ� ��
	 * @param price ����
	 */
	public void setPrice(int price) {
		this.price=price;
	}//setPrice
	
	/**
	 * ������ ��鰴ü�� ���� ���⸦ �����ϴ���
	 * @param thickness ���� ������ ������ �ִ� 3���� ���� �Ҽ� �ִ�
	 * 3���� �Ѿ�� �⺻�� 2�� �����ȴ�
	 */
	public void setThickness(int thickness) {
		if(thickness>4) {
			thickness=2;
		}//end if
		this.thickness=thickness;
	}//setThickness
 
	//getter
	/**
	 *  ������ ��� ��ü�� �̸��� ��ȯ �ϴ� ��
	 * @return �̸�
	 */
	public String getRamen() {
		return ramen;
	}//getRamen
	
	/**
	 *  ������ ��� ��ü�� ���������� ��ȯ �ϴ� ��
	 * @return ��������
	 */
	public String getColor() {
		return color;
	}//getColor
	
	/**
	 *  ������ ��� ��ü�� ���� ���� ��ȯ �ϴ� ��
	 * @return
	 */
	public String getSoup() {
		return soup;
	}//getSoup
	
	/**
	 *  ������ ��� ��ü�� �ʱ� ������ ��ȯ �ϴ� ��
	 * @return
	 */
	public int getSpicy() {
		return spicy;
	}//getSpicy
 	
	/**
	 * ������ ��� ��ü�� ������ ��ȯ �ϴ� ��
	 * @return
	 */
	public int getPrice() {
		return price;
	}//getPricy
	
	/**
	 * ������ ��� ��ü�� ���� ���⸦ ��ȯ �ϴ���
	 * @return
	 */
	public int getThickness() {
		return thickness;
	}//getThickness

	//������ Ư¡
	public String eat() {
		return ramen+"�� ������"+color+"�̸� ������ ����"+soup+"�̰� �ʱ�� ���� �ſ����"+spicy+"������ ������ �ְ�"+
				"�� ���⵵"+thickness+"�ܰ���� ���� �Ҽ��ִ� �� ������ ��"+price+"�� �� ���� �ִ�"; 
	}//eat

	public String eat(String ramen, int spicy, int price ) {
		return ramen+"�� �� ��"+price+ "�� �ſ��"+spicy+"�ܰ�� ������ ������ �ִ� ����ǰ�̴� ";
	}//eat


























}//class
