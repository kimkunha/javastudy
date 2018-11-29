package day1128;

import java.util.jar.Attributes.Name;

/**
 * 학생의 Oracle, Java, JDBC 과목 점수를 처리하는 프로그램
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
	 * 	점수를 누적 합
	 * @param score
	 */
	public void addTotal(int score) {
		total+=score;
	}//setTotal
	
	/**
	 * 	점수를 얻는 일
	 * @return
	 */
	public int getTotal() {
		return total;
	}//getTotal
	
	/**
	 *  점수 평균    0행의 3열을 가지고 와야한다.   name, score
	 */
	public void average(int [] score ) {
		average=
			return average;	
		
	}

	
	/**
	 * 	총합 점수를 초기화
	 */
	public void resetTotal() {
		total=0;
	}//resetTotal
	
	
	
//		public int getAverage() {
//		return average;
//	}
	
	
	public String[] nameData() {
		String[] name = { "김정운", "이재현", "정택성", "노진경", "최지우", "김건하" };
		return name;
	}// namaData

	public int[][] scoreData() {
		int[][] score = { { 85, 86, 81 }, { 95, 91, 100 }, { 89, 71, 59, }, { 97, 96, 91 }, { 78, 74, 77 },
				{ 100, 95, 68 } };
		return score;
	}// scoreData

	

	//2. 각 과목당 총점과 총점의 총점
	
	public void javasum() {
		for(int i=0; i<)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void printScore(String[] name, int[][] score) {
		//숙제. -모든 일은 합당한 매개변수와 반환형을 사용하여
		// method로 정의하여 호출하여 사용한다.
		//1. 각 학생의 평균을 구하여 출력(출력 소수이하 한자리 까지만 출력).
		
		System.out.println("번호\t이름\tOracle\tJava\tJDBC\t총점\t평균");
		System.out.println("================================================================");
		for(int i=0; i<score.length; i++) {//행
			System.out.printf("%d\t%s\t",i+1,name[i]);
			for(int j=0; j<score[i].length; j++ ) {//열
				System.out.printf("%d\t",score[i][j]);
				addTotal(score[i][j]); //총 점수합
//				average(score[i][j]);
			}//end for
			
			System.out.println(getTotal());
//			System.out.println(getAverage());
			System.out.println();
			resetTotal();

		}//end for
		System.out.println("================================================================");
		//2. 각 과목당 총점과 총점의 총점
		System.out.println("과목총점================================================================");
		//3. 각 과목당 평균과 전체 평균(전체평균은 소수이하 두자리 까지출력)
		System.out.println("과목평균================================================================");
		//4. 각 과목당 최고점수를 출력
		System.out.println("최고 점수 자바 [ ] 오라클 [ ] JDBC [ ]================================================================");
		//5. 일등학생의 이름과 총점, 번호
		System.out.println("TOP 번호 [ ] 이름 [ ] 총점 [ ]================================================================");
		//6. 자바점수만 오름차순 정렬하여 출력.
		
		
		
		for(int i=0; i<score.length; i++) {//행
			for(int j=0; j<score[i].length; j++ ) {
				if(i==0) {
					
					
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
	}// printScore
	//숙제 2.
	/* 2차원 배열을 참조형 형식으로 만들고 아래와 같이 값을 넣어 출력하는 method를 작성.
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
		// 처리
		sp2.printScore(name, score);
	}// main
	
}// class
