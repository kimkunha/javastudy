package day1129;

public class HomeWork2 {
//	��ȣ,�̸�,�ּ�,����,����
	int seoulliving;

	public HomeWork2() {
		
		//1. ���� ��������[] �迭�� = null;
			HomeWork1[] hkArr=null;
		//2. ���� : �迭�� = new ��������[���� ��]
			hkArr= new HomeWork1[7];
		//3. �� �Ҵ� : �迭��[���ǹ�ȣ] = new ������
			hkArr[0]=new HomeWork1(1,"������","����� ������ ���ﵿ",28,"����");
			hkArr[1]=new HomeWork1(2,"������","����� ���빮�� ��ʸ���",27,"����");
			hkArr[2]=new HomeWork1(3,"������","������ ���뱸 ���뵿",26,"����");
			hkArr[3]=new HomeWork1(4,"���ü�","����� ���α� ���ε�",27,"����");
			hkArr[4]=new HomeWork1(5,"���ü�","����� ���۱� �󵵵�",29,"����");
			hkArr[5]=new HomeWork1(6,"�����","��⵵ ��õ�� ��õ��",26,"����");
			hkArr[6]=new HomeWork1(7,"�����","����� ������ �����絿",27,"����");
			
			//�ϰ� ó��
/*			HomeWork1 tempData=null;
			for(int i=0; i<hkArr.length; i++) {
				tempData=hkArr[i];
				System.out.println(tempData.getNum()+" , "+tempData.getName()+" , "+tempData.getAddr()+" , "+tempData.getAge()+" , "+
				tempData.gerGender());
			}
			*/
			
			
			
/*			HomeWork1 tempData=null;
			for(int i=0; i<hkArr.length; i++) {
				tempData=hkArr[i];
				if( tempData.getAddr().startsWith("�����")==true) {
					seoulliving+=1;	    };
					
					System.out.println(tempData.getNum()+" , "+tempData.getName()+" , "+tempData.getAddr()+" , "+tempData.getAge()+" , "+
							tempData.gerGender());
			}
			System.out.println("���￡ ��� ���"+seoulliving+"��");
	}
			*/
	
			
	
	
	
	
		public void seoulLiving(HomeWork1[] hkArr) {
			if( tempData.getAddr().startsWith("�����")==true) {
				seoulliving+=1;	    };
		}
		
		
		
		
		
		
		
		
		
		
		
	}// HomWork2
//			 2�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.

		
				
				
				
				
				
				
				
				
			
			
			

	public static void main(String[] args) {
		new HomeWork2();
	}// main

}// class
