package day0110.transaction;
//19.01.10 -5���ڷ�- Ʈ������� VO
public class TransactionVO {

	private String subject, write;

	public TransactionVO() {
	}//�⺻ ������

	public TransactionVO(String subject, String write) {
		this.subject = subject;
		this.write = write;
	}//�����ִ� ������

	//getter
	public String getSubject() {
		return subject;
	}

	public String getWrite() {
		return write;
	}
	
}//class
