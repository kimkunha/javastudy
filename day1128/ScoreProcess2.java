package day1128;

import java.util.jar.Attributes.Name;

/**
 * �л��� Oracle, Java, JDBC ���� ������ ó���ϴ� ���α׷�
 * 
 * @author owner
 */
public class ScoreProcess2 {
	private int total;
	private int total1;
	private String javascore;
	private String oraclescore;
	private String jdbcsocre; 
	
	public ScoreProcess2() {
		total=0;
	}//ScoreProcess2
	
	/**
	 * 	������ ���� ��
	 * @param score
	 */
	public void addTotal(int score) {
		total+=score;
	}//setTotal
	
	/**
	 * 	������ ��� ��
	 * @return
	 */
	public int getTotal() {
		return total;
	}//getTotal
	
	/**
	 *  ���� ���    0���� 3���� ������ �;��Ѵ�.   name, score
	 */
	public void average(int [] score ) {
		average=
			return average;	
		
	}

	
	/**
	 * 	���� ������ �ʱ�ȭ
	 */
	public void resetTotal() {
		total=0;
	}//resetTotal
	
	
	
//		public int getAverage() {
//		return average;
//	}
	
	
	public String[] nameData() {
		String[] name = { "������", "������", "���ü�", "������", "������", "�����" };
		return name;
	}// namaData

	public int[][] scoreData() {
		int[][] score = { { 85, 86, 81 }, { 95, 91, 100 }, { 89, 71, 59, }, { 97, 96, 91 }, { 78, 74, 77 },
				{ 100, 95, 68 } };
		return score;
	}// scoreData

	

	//2. �� ����� ������ ������ ����
	
	public void javasum() {
		for(int i=0; i<)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void printScore(String[] name, int[][] score) {
		//����. -��� ���� �մ��� �Ű������� ��ȯ���� ����Ͽ�
		// method�� �����Ͽ� ȣ���Ͽ� ����Ѵ�.
		//1. �� �л��� ����� ���Ͽ� ���(��� �Ҽ����� ���ڸ� ������ ���).
		
		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����\t���");
		System.out.println("================================================================");
		for(int i=0; i<score.length; i++) {//��
			System.out.printf("%d\t%s\t",i+1,name[i]);
			for(int j=0; j<score[i].length; j++ ) {//��
				System.out.printf("%d\t",score[i][j]);
				addTotal(score[i][j]); //�� ������
//				average(score[i][j]);
			}//end for
			
			System.out.println(getTotal());
//			System.out.println(getAverage());
			System.out.println();
			resetTotal();

		}//end for
		System.out.println("================================================================");
		//2. �� ����� ������ ������ ����
		System.out.println("��������================================================================");
		//3. �� ����� ��հ� ��ü ���(��ü����� �Ҽ����� ���ڸ� �������)
		System.out.println("�������================================================================");
		//4. �� ����� �ְ������� ���
		System.out.println("�ְ� ���� �ڹ� [ ] ����Ŭ [ ] JDBC [ ]================================================================");
		//5. �ϵ��л��� �̸��� ����, ��ȣ
		System.out.println("TOP ��ȣ [ ] �̸� [ ] ���� [ ]================================================================");
		//6. �ڹ������� �������� �����Ͽ� ���.
		
		
		
		for(int i=0; i<score.length; i++) {//��
			for(int j=0; j<score[i].length; j++ ) {
				if(i==0) {
					
					
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
	}// printScore
	//���� 2.
	/* 2���� �迭�� ������ �������� ����� �Ʒ��� ���� ���� �־� ����ϴ� method�� �ۼ�.
	 *     1 1 1 1 1 1 1 1 1
	 *     1 0 0 0 0 0 0 0 1
	 *     1 0 0 0 0 0 0 0 1
	 *     1 0 0 0 0 0 0 0 1
	 *     1 0 0 0 0 0 0 0 1
	 *     1 1 1 1 1 1 1 1 1
	 */
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		String[] name = sp2.nameData();
		int[][] score = sp2.scoreData();
		// ó��
		sp2.printScore(name, score);
	}// main
	
}// class
