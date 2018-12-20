package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

//18.12.06 	-3�� �ڷ�-  (List) �߿��ϴ� ���θ����� ��
/**
 *	List : <br>
 *	�ߺ����� ����ϸ�, �˻��� ����� �ְ�, ������� ���� �Է��ϴ� ����������      //�߿��ϴ� �ϱ��� ��.
 * @author owner
 */
public class UseList {

	public UseList() {
/*		JDK 1.4������ Generic�� �������� �ʰ� ��ü�� ����ȴ�.
		List list=new ArrayList();
		//�� �߰� : JDK 1.5���� ������ ��ü�θ� ���� ���� �� �ִ�.
	
  		list.add(new Integer(10));
		list.add(new Short((short)10));
		list.add("������");
		
		System.out.println(list.size());
		System.out.println( ((Integer)list.get(0)).intValue()+10);		//�ε��� 0������ �� 10, ��ü�� ������ ���� �ʴ´�. �׷��� �̷��� Ǯ� ���
																				//�ٵ� �̰��� ��û �����ؼ� JDK1.5���ʹ� ��ڽ��� �߰��Ǿ� ��������
*/	
		//JDK1.5+ ���� ��� : Generic, auto boxing, unboxing
		//1.5������ Generic�� ����.    
		List<Integer> list = new ArrayList<Integer>();    //// ������ ���� : ���ϵ����������� ����
		list.add(10);// autoboxing => list.add(new Integer(10));�� ���ش�
		list.add(20);
		list.add(new Integer(30));
//		list.add("�����"); // Generic���� ������ ���� �ƴ� ���������� �߰��� �� ����.
		
		System.out.println("ũ�� "+list.size() );
		System.out.println(list.get(0)+10);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)+1);
		}//end for	
	}//UseList Constructor
	
	
	
	
	
	
	/**
	 * 	ArrayList ��� : Multi Threadȯ�濡�� ���� ���� ����.(����ȭ X)
	 */
	public void useArrayList() {
		//1. ����
		ArrayList<String> al=new ArrayList<String>();	//�� 0 �� 
		List<String> al1=new ArrayList<String>(100);			//�� 100��  ���� size()�� ������ 0��
		
		System.out.println(al+" / "+al1); //�ּҰ� ������ ���� ����??   �ּҰ� �ȳ����� �������̵��ؼ�../
		//�� �߰� : ����������� �߰��ȴ�.
		al.add("������");
		al.add("���ü�");
		al.add("������");
		al.add("�����");
		al.add("������");	// �ߺ��� ���尡��
		al.add("������");
		al.add("������");	// �ߺ��� ���尡��
		al.add("������");
		System.out.println(al+" / "+al1); //	
		//size( ): �������� ũ��
		System.out.println("alũ��"+al.size()+" / al1�� ũ�� :  "+al1.size());
		
		//�迭�� ���� toSting
		String[] names=new String[ al.size()];
		al.toArray(names);		//toArray( ) �迭�� �����ϴ� �޼ҵ�
		
		//���� �� ����:
		//1. �ε����� ���� : Ư�� �ε������� ���� ����
		al.remove(4);
		System.out.println(al.size()+" / "+ al ); 	
		//2. ���� �������� ����
		al.remove("������"); //1. ���� ù���� ����, 2. ���� ������ ���� ����, 3��� ����  -> 1��. ���� ù�游 �����ȴ�.(���� �Ұ�)  ����->���������� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����
		System.out.println(al.size()+" / "+ al ); 	
		
		for( String name : al ) {
			System.out.println( name );
		}//end for
		
		//��� ���� �� ���� : 
		al.clear();
		System.out.println("��ü ���� �� : "+al.size()+" / "+al );
		
		//�迭�� ��
		for(int i=0; i< names.length; i++) {
			System.out.printf("%s\t\n", names[i]);
		}//end for
		System.err.println();
		
		
		
		
		
		
		
	}//useArrayList
	
	
	
	
	
	public void useVector() {
		
		//1. ����
				Vector<String> vec=new Vector<String>();	//�� 0 �� 
				List<String> vec1=new Vector<String>(100);			//�� 100��  ���� size()�� ������ 0��
				
				System.out.println(vec+" / "+vec1); //�ּҰ� ������ ���� ����??   �ּҰ� �ȳ����� �������̵��ؼ�../
				//�� �߰� : ����������� �߰��ȴ�.
				vec.add("������");
				vec.add("���ü�");
				vec.add("������");
				vec.add("�����");
				vec.add("������");	// �ߺ��� ���尡��
				vec.add("������");
				vec.add("������");	// �ߺ��� ���尡��
				vec.add("������");
				System.out.println(vec+" / "+vec1); //	
				//size( ): �������� ũ��
				System.out.println("vecũ��"+vec.size()+" / vec1�� ũ�� :  "+vec1.size());
				
				//�迭�� ���� toSting
				String[] names=new String[ vec.size()];
				vec.toArray(names);		//toArray( ) �迭�� �����ϴ� �޼ҵ�
				
				//���� �� ����:
				//1. �ε����� ���� : Ư�� �ε������� ���� ����
				vec.remove(4);
				System.out.println(vec.size()+" / "+ vec ); 	
				//2. ���� �������� ����
				vec.remove("������"); //1. ���� ù���� ����, 2. ���� ������ ���� ����, 3��� ����  -> 1��. ���� ù�游 �����ȴ�.(���� �Ұ�)  ����->���������� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����
				System.out.println(vec.size()+" / "+ vec ); 	
				
				for( String name : vec ) {
					System.out.println( name );
				}//end for
				
				//��� ���� �� ���� : 
				vec.clear();
				System.out.println("��ü ���� �� : "+vec.size()+" / "+vec );
				
				//�迭�� ��
				for(int i=0; i< names.length; i++) {
					System.out.printf("%s\t\n", names[i]);
				}//end for
				System.err.println();
				
				
				
				
				
				
				
	}//useVector
	
	
	
	
	public void useLinkedList() {
		
		//1. ����
		LinkedList<String> ll=new LinkedList<String>();	//�� 0 �� 
		List<String> ll1=new LinkedList<String>();			
		
		System.out.println(ll+" / "+ll1); //�ּҰ� ������ ���� ����??   �ּҰ� �ȳ����� �������̵��ؼ�../
		//�� �߰� : ����������� �߰��ȴ�.
		ll.add("������");
		ll.add("���ü�");
		ll.add("������");
		ll.add("�����");
		ll.add("������");	// �ߺ��� ���尡��
		ll.add("������");
		ll.add("������");	// �ߺ��� ���尡��
		ll.add("������");
		System.out.println(ll+" / "+ll1); //	
		//size( ): �������� ũ��
		System.out.println("llũ��"+ll.size()+" / ll1�� ũ�� :  "+ll1.size());
		
		//�迭�� ���� toSting
		String[] names=new String[ ll.size()];
		ll.toArray(names);		//toArray( ) �迭�� �����ϴ� �޼ҵ�
		
		//���� �� ����:
		//1. �ε����� ���� : Ư�� �ε������� ���� ����
		ll.remove(4);
		System.out.println(ll.size()+" / "+ ll ); 	
		//2. ���� �������� ����
		ll.remove("������"); //1. ���� ù���� ����, 2. ���� ������ ���� ����, 3��� ����  -> 1��. ���� ù�游 �����ȴ�.(���� �Ұ�)  ����->���������� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����
		System.out.println(ll.size()+" / "+ ll ); 	
		
		for( String name : ll ) {
			System.out.println( name );
		}//end for
		
		//��� ���� �� ���� : 
		ll.clear();
		System.out.println("��ü ���� �� : "+ll.size()+" / "+ll );
		
		//�迭�� ��
		for(int i=0; i< names.length; i++) {
			System.out.printf("%s\t\n", names[i]);
		}//end for
		System.err.println();
		
	}//useLinkedList
	
	
	
	
	public static void main(String[] args) {
		UseList ui = new UseList();
		System.out.println("---------------------------ArrayList------------------------------------------");
		ui.useArrayList();
		System.out.println("---------------------------Vector------------------------------------------");
		ui.useVector();
		System.out.println("---------------------------LinkedList------------------------------------------");
		ui.useLinkedList();
		
		
	}//main
	
	
}//class
