package java_team3;

/**
 * 	2차원 배열 만들기
 * 	주로 2차원 배열은 테이블 형태의 데이터를 담는데 사용된다.
 * 
 * @author KIM
 */
public class TestArray2 {

	public TestArray2() {
		//1. 2차원 배열생성
		int [][] intArr =new int[4][3];   //앞 배열이 행(세로), 뒷 배열이 열(가로)
		//2. 2차원 배열은 행(row), 열(column)으로 구성되어 있어 index도 행,열에 각각 하나씩 존재한다.
		//3. 생성과 초기화 동시에
		int [][] arr =new int [] []{   {  }  };  //2차원은 괄호가 추가되어 안쪽 괄호로 행을구별해준다.
	
		//점수 프로그램
		int[][] score= {
							{100,100,100},
							{87,50,30},
							{86,48,38},
							{49,20,60},
							{99,58,60}
						 };
	//과목별 총점
		int javaTotal=0, orclTotal=0, pythonTotal=0;
		System.out.println("번호\t자바\t오라클\t파이썬\t총점\t평균");
		System.out.println("====================================================");
		
		for(int i=0; i<score.length; i++) {
			int sum=0; //총점 구하는 변수
			float avg=0.0f; //평균 구하는 변수
			
			javaTotal 	+=	score[i][0];
			orclTotal 		+=	score[i][1];
			pythonTotal 	+=	score[i][2];
			System.out.printf("3%d\t", i+1);
			
			for(int j=0; j<score[i].length; j++) {
				sum+=score[i][j];
				System.out.printf("%5d\t",score[i][j]);
			}//end for
			avg=sum/(float)score[i].length; //평균계산
			System.out.printf("%5d %5.1f%n", sum, avg);
		}
			System.out.println("===================================================");
			System.out.printf("총점:\t%3d\t %4d\t %4d%n\t",javaTotal,orclTotal,pythonTotal );
	}
	
	public static void main(String[] args) {
			new TestArray2();
	}//main

}//class
