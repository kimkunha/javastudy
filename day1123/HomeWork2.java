package day1123;

public class HomeWork2 {

	public static void main(String[] args) {
		//��üȭ
		HomeWork1 ramen = new HomeWork1();
		//instance�� �ʱ�ȭ
/*		ramen.setRamen("�Ŷ��");
		ramen.setColor("������");
		ramen.setSoup("��ū�Ѹ�");
		ramen.setSpicy(3);
		ramen.setPrice(7000);
		ramen.setThickness(3);*/
		
		HomeWork1 ramen1 = new HomeWork1("�Ŷ��","���","�ÿ��� ��",3,6000,3);
		System.out.println(ramen1.getColor()+ramen1.getSoup()+ramen1.getSpicy()+ramen1.getPrice()+ramen1.getThickness());
		
		System.out.println(ramen.getRamen()+ramen.getColor()+ramen.getSoup()+
				ramen.getSpicy()+ramen.getPrice()+ramen.getThickness());
		
		System.out.println(ramen.eat());
		System.out.println(ramen.eat("�Ŷ��", 3,6000));
	}//main

}//class
