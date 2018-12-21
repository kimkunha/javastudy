package day1221;

public class MyClass {

	public MyClass() {
		String s="c:/dev/temp/java_read.txt";
		StringBuilder sb=new StringBuilder(s);
		System.out.println((sb.insert(s.lastIndexOf("."),"_bok")) );
	
	}
	
	public static void main(String[] args) {
		new MyClass();
		
		
	}

}
