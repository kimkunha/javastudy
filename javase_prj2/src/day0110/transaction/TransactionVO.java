package day0110.transaction;
//19.01.10 -5번자료- 트랜잭션의 VO
public class TransactionVO {

	private String subject, write;

	public TransactionVO() {
	}//기본 생성자

	public TransactionVO(String subject, String write) {
		this.subject = subject;
		this.write = write;
	}//인자있는 생성자

	//getter
	public String getSubject() {
		return subject;
	}

	public String getWrite() {
		return write;
	}
	
}//class
