package day0110;
//19.01.10 -2번째자료- VO (전체조회)
public class TestProcAllVO {

	private int empno, sal;
	private String ename, hiredate, job;
	
	public TestProcAllVO() {
	}//생성자

	public TestProcAllVO(int empno, int sal, String ename, String hiredate, String job) {
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.hiredate = hiredate;
		this.job = job;
	}//인자 있는 생성자

	
	//getter
	public int getEmpno() {
		return empno;
	}

	public int getSal() {
		return sal;
	}

	public String getEname() {
		return ename;
	}

	public String getHiredate() {
		return hiredate;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "TestProcAllVO [empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", hiredate=" + hiredate
				+ ", job=" + job + "]";
	}//toString
	
	
	
}//class
