package day0110;
//19.01.10 -1��°�ڷ�- VO
public class TestProcUpdateVO {
	private int empno, sal;
	private String job;
	
	public TestProcUpdateVO() {
	}//�⺻ ������
	
	public TestProcUpdateVO(int empno, int sal, String job) {
		this.empno = empno;
		this.sal = sal;
		this.job = job;
	}//���� �ִ� ������
	
	
	//getter
	public int getEmpno() {
		return empno;
	}
	public int getSal() {
		return sal;
	}
	public String getJob() {
		return job;
	}
	
	
}//class
