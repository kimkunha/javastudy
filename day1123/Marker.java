package day1123;

/**
 *	��ī���� ������� �����Ͽ�, �߻�ȭ�� �����ϰ� ������� Ŭ����<br>
 *	��ī�� - ����� Ư¡ : ��, ��ü, �Ѳ� =&gt; ����<br>
 *			   ������ Ư¡ : ���� -&gt; method  <br>
 *	����)<br>
 *			�⺻�����ڸ� ����Ͽ� ��ü�� ������ �� Setter Method�� 
 *			ȣ���Ͽ� ���� ������ �� ����Ѵ�.
 *			Marker m = new Marker();<br>
 *			m.setXxx(��);<br>
 *
 *
 *	class�� ��������� �ڷ���, ������ �������� �̴�.
 *
 ** @author owner
 */
public class Marker {
	private String color;	// ��ī���� ��
	private int body;	// ��ī���� ��ü�ǰ���
	private int cap;		//��ī���� �Ѳ��� ����
	
	/**
	 * 	������ ��ī�水ü�� ���� �����ϴ� ��<br>
	 * ������, �Ķ���, �������� �����Ѵ�. �� �̿��� ���� ���������� ó���Ѵ�.
	 * @param color ������ ��
	 */
	public void setColor(String color) {
		//Instance������ ������ �������� ��������.
		if(! (color.equals("������")|| color.equals("�Ķ���")||
				color.equals("������"))) {
			color="������";
		}//end if
			this.color=color;
	}//setColor
	
	/**
	 * 	������ ��ī�� ��ü�� ��ü�ǰ����� �����ϴ� ��
	 * @param body ��ü�� ����
	 */
	public void setBody(int body){
		this.body=body;
	}//setBody

	/**
	 * 	������ ��ī���� ��ü�� �Ѳ� ������ �����ϴ� ��.
	 * @param cap �Ѳ��� ����
	 */
	public void setCap(int cap) {
		this.cap=cap;
	}//setCap

	/**
	 * 	������ ��ī�� ��ü�� ������ �ִ� ���� ��ȯ�ϴ� ��
	 * @return ��
	 */
	public String getColor() {
		return color;
	}//getColor

	/**
	 * 	������ ��ī�� ��ü�� ������ �ִ� ��ü�� ����
	 * @return ��ü�� ����
	 */
	public int getBody() {
		return body;
	}//getBody

	/**
	 * 	������ ��ī���� ��ü�� ������ �ִ� �Ѳ��� ����
	 * @return �Ѳ��� ����
	 */
	public int getCap() {
		return cap;
	}//getCap

	/**
	 * 	�Էµ� �޼����� ������ ��ī������ ĥ�ǿ� ���� ��.
	 * @param msg ĥ�ǿ� �� �޼���
	 * @return ���
	 */
	public String write(String msg) {
		return color+"�� ��ī������ ĥ�ǿ� \""+msg+"\"�� ����";
	}//write

}//class
