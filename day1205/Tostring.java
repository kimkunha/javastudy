package day1205;

public class Tostring {
	String name="�����";
	@Override
	public String toString() {
		return name+"�� �������̵� �߽��ϴ�.";
	}

	public static void main(String[] args) {
		
		String s="�ȳ��ϼ���1";
		Tostring ts = new Tostring();
		
		System.out.println(s.toString());
		System.out.println(ts.toString());
		
		StringBuffer sb = new StringBuffer("�ȳ��ϼ���2.");
		System.out.println(sb);
		
		s=sb.toString();
		System.out.println(s.toString());
	}
}
