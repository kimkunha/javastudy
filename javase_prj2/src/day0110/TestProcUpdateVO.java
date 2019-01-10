package day0110;
//19.01.10 -1번째자료- VO
public class TestProcUpdateVO {
	private int empno, sal;
	private String job;
	
	public TestProcUpdateVO() {
	}//기본 생성자
	
	public TestProcUpdateVO(int empno, int sal, String job) {
		this.empno = empno;
		this.sal = sal;
		this.job = job;
	}//인자 있는 생성자
	
	
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
