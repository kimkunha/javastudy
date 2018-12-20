package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoreProcessor {
	//리스트로 이름과 점수 생성
	List<String> name = new ArrayList<>();
	List<Integer>score= new ArrayList<>();
	
	//생성자로 이름과 점수 초기화
	
	public ScoreProcessor(String str) {		//Runprocessor에서의 매개변수를 받는다
		
		String [] name = str.split(",");
		
		for(int i=0; i<name.length; i++) {
			this.name.add(name[i]);
		}//end for
	}//ScoreProcessor Constructor	score.add(r.nextInt(101));
		
		
		//출력할 사람의 수를 입력받아서 출력
		public void printScore(int cnt) {
			int sumOfScore=0;
			Random r =new Random();
			int [] tmpidx = new int[name.size()];
			
			//같은사람이 중복출력됨, 랜덤값을 뽑는데 중복된 idx가 나옴
			for(int i=0; i<tmpidx.length; i++) {
				tmpidx[i]=r.nextInt(name.size());
				for(int j=0; j<1; j++) {
					if (tmpidx[i]==tmpidx[j]) {
						i--;
						break;
						
					}
				}
			}
				for(int i=0; i<cnt; i++) {
			System.out.println(name.get(tmpidx[i])+" "+score.get(tmpidx[i]));
			sumOfScore +=score.get(tmpidx[i]);
		}
				System.out.println("총점"+sumOfScore);
		}
	
	
	


}//class
