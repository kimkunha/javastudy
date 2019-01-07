package day0107;

import java.sql.Date;

public class CpEmp2OneVO {

	private int sal;
	private String ename;
	private Date hiredate;
	
	public CpEmp2OneVO() {
	}//기본생성자
	public CpEmp2OneVO(int sal, String ename, Date hiredate) {
		this.sal = sal;
		this.ename = ename;
		this.hiredate = hiredate;
	}//인자있는 생성자
	
	public int getSal() {
		return sal;
	}
	public String getEname() {
		return ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	
	
	
}//class
