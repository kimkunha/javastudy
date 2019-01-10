package day0110.callalbestatement;
//19.01.10 -3번째자료- VO (한줄 조회)
public class TestProcOneVO {

	private int sal;
	private String ename, job, hiredate;
	
	public TestProcOneVO() {
	}//기본 생성자
	public TestProcOneVO(int sal, String ename, String job, String hiredate) {
		super();
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}//인자 있는 생성자
	
	//getter
	public int getSal() {
		return sal;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public String getHiredate() {
		return hiredate;
	}
	@Override
	public String toString() {
		return "TestProcOneVO [sal=" + sal + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + "]";
	}
	
	
	
}//class
