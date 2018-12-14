package day1207;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//18.12.07  -2���ڷ�-   ( map )
/**
 *	Map : KVP�� �Ǿ��ִ� �ڷᱸ��, Ű�� ����Ͽ� ���� ��� ��.
 * @author owner
 */
public class UseMap {
	public UseMap() {
		// JDK1.5 ������ ��� Generic�� ����� �� ����, ��ü�� ���尡��.
		//1. ����
			Map<String,String> map =new HashMap<String,String>();
		//2. �� �Ҵ� : Ű�� ����, ���� �ߺ� ����
			map.put("Oracle", "��뷮 �����ͺ��̽�");
			map.put("Java", "���α׷��� ���");
			map.put("Pyton", "���α׷��� ���");//���� �ߺ� ����
			map.put("Java", "�Ϻ��� ��ü���� ���.");			//Ű�� �����Ѵٸ� �ش� Ű�� ���� ����.  �̰��� upsert��� �Ѵ�.
			map.put("HTML", "Markup Language");			
				System.out.println( map.size()+" "+map );	//map�� ����� ������(���� ����)
		//3. �� ���) - Ű�� ����Ͽ� ���� ��´�.
		//Ű�� �ش��ϴ� ���� ���ٸ� (heap�� �ּҰ� ���) null�� ��ȯ
		String val=map.get("Java");//
		System.out.println( val );
		String val1=map.get("java");// Ű�� �ش��ϴ� ���� ���ٸ� null�� ���´� , ��� ���� ����
		System.out.println( val1 );
		//4. Ű�� �����ϴ� ��?
		String key="Java";
		boolean flag=map.containsKey("Java");
		System.out.println(key+ "Ű ���� "+flag);
		
		//5. �� ����.
		map.remove("Java");
		System.out.println("���� ��"+ map);
		
		//6. ��� Ű ���
		Set<String>allkeys=map.keySet();
		System.out.println("���� ���� ��� Ű : "+allkeys);
		
		//7. ��� �� ���
		Iterator<String> ita=allkeys.iterator();
		String value="";
		while( ita.hasNext() ) {		//Ű�������Ѵٸ�
			value=map.get( ita.next() ); //�� Ű�� ������ Map�� ���� ��´�.
			System.out.println( value );
		}//end while
		
		//8. ����
		map.clear();
		System.out.println("��� ���� :"+map.size()+" / "+map );
		
		
	}//UseMap
	
	/**
	 *	�⺻�����ڸ� ����ϸ� 11���� ���� �ڵ� ����
	 *	MultiThread���� ���� ���� �Ұ���.
	 *	�����Ͱ� ��ü �� ������ �� 75% ä������ �� ���� ���� �˻��� �Ѵ�. 
	 */
	public void useHashTable(String key) {
		//1. ����)
			Map<String, String> bloodmap=new Hashtable<String,String>(100);
		//2. �� �Ҵ�)
			bloodmap.put("A", "�����ϴ�, ģ���ϴ� ^o^b");
			bloodmap.put("B", "�����巴�� ��,.��");
			bloodmap.put("AB", "������ @,.@");
			bloodmap.put("O", "�����δ��ϴ� ~(^^~)(~^^)~");
			bloodmap.put("A", "�ҽ��ϴ�. ^.^");
			
			String value=bloodmap.get(key.toUpperCase());
			
//			if(value==null) {	//����� ���� ������ ��
			if(  ! bloodmap.containsKey(key.toUpperCase())) {//Ű�� �����ϴ� ��?   
				System.out.println(key+" �������� ����� ���� �ƴմϴ�.");
			}else {
				System.out.println(key+"�� Ư¡�� :"+ value);
			}//end if
	}//useHashTable
	
	/**
	 *	�⺻�����ڸ� ����ϸ� 16���� ���� �ڵ� ���� 
	 *	MultiThread���� ���� ���� ����. 
	 *	�����Ͱ� ��ü �� ������ �� 75% ä������ �� ���� ���� �˻��� �Ѵ�. 
	 */
	public void useHashMap(String key) {
		//1. ����)
			Map<String, String> map=new HashMap<String,String>();
		//2. �� �Ҵ�)
			map.put("���ʺ���", "Ǯ�� ���� ������ ���´�.");
			map.put("��������", "���濡 ���忡�� �����Ѵ�.");
			map.put("���乫��", "�ƹ��͵� ���� ������ �� �ݷ��ϰ� �ƹ��͵� ���� �ʰڴ�.");
			map.put("���γ���", "�����ϸ� �θǽ� �ϰ��ϸ� �ҷ�");
			map.put("�̺θ�õ", "���� ��� ��ȥ�ϸ� ��õ���� ���ϸ� ��õ����.");
			map.put("��������", "���� ���� �����");
			map.put("����ġ��", "�Լ��� ������ ¡�׷�����.");
			map.put("���ü���", "���α��� �ڶ�.");
			
		//3. �� ���	
			if(map.containsKey(key)) {		//�ʿ� Ű�� �����Ѵٸ�.
				String value=map.get(key);	//�� ���
				System.out.println(key+"�� ���� "+value);
			}else {
				System.out.println(key+"���ڼ���� �غ���� �ʾҽ��ϴ�.");
			}//end else
			
			
	}//useHashMap
	
	
	
	
	
	
	public static void main(String[] args) {
		UseMap um =new UseMap();
		System.out.println("---------------------HashTable------------------------");
		um.useHashTable("b");
		System.out.println("---------------------HashMap-------------------------");
		um.useHashMap("���ʺ���");
		
		
		
		
	}//main

}//class
