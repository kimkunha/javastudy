package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoreProcessor {
	//����Ʈ�� �̸��� ���� ����
	List<String> name = new ArrayList<>();
	List<Integer>score= new ArrayList<>();
	
	//�����ڷ� �̸��� ���� �ʱ�ȭ
	
	public ScoreProcessor(String str) {		//Runprocessor������ �Ű������� �޴´�
		
		String [] name = str.split(",");
		
		for(int i=0; i<name.length; i++) {
			this.name.add(name[i]);
		}//end for
	}//ScoreProcessor Constructor	score.add(r.nextInt(101));
		
		
		//����� ����� ���� �Է¹޾Ƽ� ���
		public void printScore(int cnt) {
			int sumOfScore=0;
			Random r =new Random();
			int [] tmpidx = new int[name.size()];
			
			//��������� �ߺ���µ�, �������� �̴µ� �ߺ��� idx�� ����
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
				System.out.println("����"+sumOfScore);
		}
	
	
	


}//class
