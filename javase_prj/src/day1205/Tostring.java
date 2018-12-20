package day1205;

public class Tostring {
	String name="김건하";
	@Override
	public String toString() {
		return name+"이 오버라이드 했습니다.";
	}

	public static void main(String[] args) {
		
		String s="안녕하세요1";
		Tostring ts = new Tostring();
		
		System.out.println(s.toString());
		System.out.println(ts.toString());
		
		StringBuffer sb = new StringBuffer("안녕하세요2.");
		System.out.println(sb);
		
		s=sb.toString();
		System.out.println(s.toString());
	}
}
