package day0110.callalbestatement;
//19.01.10 -3��°�ڷ�- VO (���� ��ȸ)
public class TestProcOneVO {

	private int sal;
	private String ename, job, hiredate;
	
	public TestProcOneVO() {
	}//�⺻ ������
	public TestProcOneVO(int sal, String ename, String job, String hiredate) {
		super();
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}//���� �ִ� ������
	
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
