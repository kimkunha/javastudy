package day1128;

/**
 *	4강의장 학생들의 성적처리 프로그램
 * @author owner
 */
public class ScoreProcess {

	public ScoreProcess() {
		String[] nameArr= {"이재찬","정택성","이재현","김건우","공선의"};
		int[] scoreArr= {89, 76, 99, 64, 50};
		int totalScore=0; // 총점을 누적 합
		int	maxScore=0; //최고점수				// int maxSCore=scoreArr[0]으로 해도 된다	
		int	minScore=101; //최하점수				// int maxSCore=0으로 해도 된다	
		int temp=0; //정렬값을 임시로 저장할 변수
		
		
		System.out.println("번호\t이름\t점수");
		System.out.println("--------------------------------------------------------------");
		
		for(int i=0; i<nameArr.length; i++) {
			System.out.printf("%d\t%s\t%d\n",i+1,nameArr[i],scoreArr[i]);					// printf는 여러개 값을 한번에 집어넣을수 있다  /i에+1를 한 이유는 다른 누군가가 보기 편하게 해줄려고 함
			totalScore += scoreArr[i];// totalscore= totaclscore+scorearr[i]
	
		//최고점수가현재 순환중인 방의 값보다 작다면
		if(maxScore<scoreArr[i]) {
			//현재 순환중인 방의 값으로 최고점수를 변경해준다.
			maxScore=scoreArr[i];
		}//end if
		
		//최하점수가현재 순환중인 방의 값보다 크다면
		if(minScore>scoreArr[i]) {
			//현재 순환중인 방의 값으로 최고점수를 변경해준다.
			minScore=scoreArr[i];
		}//end if
		
		
		
		
		
		}//end for
		
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("응시인원 : "+nameArr.length+"명");
		System.out.printf("총점 [%-5d] 평균 [%.2f]\n",totalScore,
				(double)totalScore/nameArr.length);								//정수나누기 정수는 정수가 나온다 그래서 소수점으로 출력안된다 출력하고 싶으면 double로 casting해줘야 한다
		System.out.printf("최고점[%3d]최하점[%d]\n",
				maxScore,minScore);
		
		
		
		for(int i=0; i<scoreArr.length-1; i++) {
			for(int j=i+1; j<scoreArr.length; j++) {
				if(scoreArr[i] <scoreArr[j]) {// 앞방의 값이 뒷 방보다 작다면                //여기서 조건을 반대로 하면 오름차순
					temp=scoreArr[i];
							scoreArr[i]=scoreArr[j];
							scoreArr[j]=temp;
				}//end if
			}//end for
		}//end for
		
		for(int i=0; i <scoreArr.length; i++) {
			System.out.printf("%-4d",scoreArr[i]);
		}//end for
		
		
		
	}//ScoreProcess
	
	
	public static void main(String[] args) {

		new ScoreProcess();				// 인스턴스변수를 생성하지않아서 이렇게 해도됨.?
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		//띠 구하기
		int birth = 1990;
		String[] zodiac= {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
		System.out.println(zodiac[birth%12]);
		
		
		
		
		
	}//main

}//class
