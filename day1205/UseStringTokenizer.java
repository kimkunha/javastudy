package day1205;
//18.12.05 2�� �ڷ� (StringTokenizer ����)
import java.util.StringTokenizer;

/**
 *	���ڿ��� ª�� ����� �����ϴ� StringTokenizer�� ���
 * @author owner
 */
public class UseStringTokenizer {
	public UseStringTokenizer() {
		String msg="������ ������ �Դϴ�. ������ -5�Դϴ�. �����ٰ� �սô�";
		
		//�������� ���� : �Ű����� �ϳ��� �����ڸ� ���.
		StringTokenizer stk=new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"��");
		
		while(stk.hasMoreTokens()) {	//��ū�� �����ϴ� ��?
			//��ū�� ��� �����͸� �������� �̵�
			System.out.println(stk.nextToken());
		}//end while
		
		String names="������,������~���ü�,����ö.������~������,������";
		
		//Ư�����ڷ� ��ū ���� : �Ű����� �ΰ��� ������(String," " )
		StringTokenizer stk1= new StringTokenizer(names, ",~.");    //" "�ȿ� �ش��ϴ� ���ڿ��� ���߶� ����� �����ϴ�. �ѱ۵� ���� �ش繮�ڴ� �߷����� ���
				System.out.println("-----------------------------------------");
		System.out.println("��ū�� �� : "+stk1.countTokens());
		
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}//end while
	
		//Ư�����ڷ� ��ū ����, ���е� ���ڿ��� ��ū���� ���(ó��) :
		//�Ű����� ������ �����ڸ� ����ϸ� �ȴ�.
		System.out.println("---------------------------------------------------------------------------------------------------");
		StringTokenizer stk2=new StringTokenizer(names,",.~",false);		//true : ��ū���� ���
		System.out.println("��ū�� �� : "+stk2.countTokens());
	
		while(stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}//end while
		
		System.out.println(stk);
		
	}//UseStringTokenizer
	
	
	public static void main(String[] args) {
		new UseStringTokenizer();
		
		
	}//main

}//class
