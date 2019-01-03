package day1221;

import java.io.Serializable;

//18.12.21	-2���ڷ�-
/**
 *	�����͸� ������ �ִ� Ŭ������ ����ȭ ��� Ŭ����
 * @author owner
 */
public class UserData implements Serializable {
	private static final long serialVersionUID = 1433112021624942957L;
	/**
	 * 
	 */
	private int age;
	private  /*transient*/ double weight;		//transient Ű����� ��ü�� ����ȭ �Ǵ°��� ���´�( �׷��Ƿ� �� ��� X)
	private /*transient*/ String name;			// ����ȭ ���� Ű���� (���� JVM�ܺη� ���޵��� �ʴ´�)
	
	public UserData() {
		
	}

	public UserData(int age, double weight, String name) {
		super();
		this.age = age;
		this.weight = weight;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserData [age=" + age + ", weight=" + weight + ", name=" + name + "]";
	}
	
	
	
	
	
	
}//class
