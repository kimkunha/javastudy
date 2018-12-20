package day1123;

public class HomeWork2 {

	public static void main(String[] args) {
		//객체화
		HomeWork1 ramen = new HomeWork1();
		//instance값 초기화
/*		ramen.setRamen("신라면");
		ramen.setColor("빨간색");
		ramen.setSoup("얼큰한맛");
		ramen.setSpicy(3);
		ramen.setPrice(7000);
		ramen.setThickness(3);*/
		
		HomeWork1 ramen1 = new HomeWork1("신라면","흰색","시원한 맛",3,6000,3);
		System.out.println(ramen1.getColor()+ramen1.getSoup()+ramen1.getSpicy()+ramen1.getPrice()+ramen1.getThickness());
		
		System.out.println(ramen.getRamen()+ramen.getColor()+ramen.getSoup()+
				ramen.getSpicy()+ramen.getPrice()+ramen.getThickness());
		
		System.out.println(ramen.eat());
		System.out.println(ramen.eat("신라면", 3,6000));
	}//main

}//class
