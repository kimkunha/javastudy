package day1126;

/**
 * ��ī���� ������ Ŭ������ ����ϴ� Ŭ����.<br>
 * 4.��ü���� <br>
 * 5.������ ��ü�� ���
 * 
 * @author owner
 */
public class UseMarker {

	public static void main(String[] args) {
		// ������ ��ī�� 1�� ����
		Marker black = new Marker();
		Marker red = new Marker("������", 5, 5);

//		black.setColor("������");
//		black.setCap(1);
//		black.setBody(1);

		System.out.printf("������ ��ī�� ��[%s],�Ѱ�[%d],��ü[%d]\n", black.getColor(), black.getCap(), black.getBody());
		// ������ ��ü�� ���
		System.out.println(black.write("�ȳ��ϼ���....?"));

//		red.color="���";	//���� �����ڰ� public�̶�� �ܺο��� ���� ���� ������ �� �����Ƿ� �߸��� ���� �Էµ� �� �ִ�.
//		red.setColor("���");
//		red.setCap(5);
//		red.setBody(5);

		System.out.printf("������ ��ī�� ��[%s],�Ѳ�[%d],��ü[%d]\n", red.getColor(), red.getCap(), red.getBody());
		System.out.println(red.write("�ȳ��ϼ���????"));

	}// main

}// class
