package day0107;

public class CpEmp2AllVO {

	private int empno, sal;
	private String ename, hiredate;

	public CpEmp2AllVO() {
	}//기본생성자
	
	public CpEmp2AllVO(int empno, int sal, String ename, String hiredate) {
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.hiredate = hiredate;
	}//인자있는 생성자
	
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
	
	
	
}//class
