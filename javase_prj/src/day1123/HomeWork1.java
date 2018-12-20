package day1123;

/**	라면을 추상화하여 만든 클래스
 * 	명사적 특징 : 라면의 이름, 국물의 색깔, 국물의 맛, 매운 강도, 가격, 면의 두께<br>
 * 	동사적 특징 : 먹는다 본다<br>
 * 
 * 	객체화 ) HomeWork1 객체명 = new HomeWork1();
 * 				생성된 객체로 먹는 일을 할수 있다.
 * @author owner
 *
 */
public class HomeWork1 {
	private String ramen, color, soup;
	private int spicy, price,thickness;

/*	public HomeWork1() {
		
	}//기본생성자
*/	
	public HomeWork1() {
	this("너구리","빨간색","진함",3,7000,3);
	}//기초값 설정
	
	
	public HomeWork1(String ramen, String color, String soup, int spicy, int price, int thickness) {
		this.ramen=ramen;
		this.color=color;
		this.soup=soup;
		this.spicy=spicy;
		this.price=price;
		this.thickness=thickness;
	}//원하는값 
	
	
	//setter
	/**
	 * 	생성된 라면 객체의 이름을 설정하는일
	 * @param ramen 이름
	 */
	public void setRamen(String ramen) {
		this.ramen=ramen;
 }//setRamen
	
	/**
	 * 	생성된 라면 객체의 라면 국물의 색깔을 설정하는 일
	 * @param color 국물색깔
	 */
	public void setColor(String color) {
		this.color=color;
	}//setColor
	
	/**
	 *  생성된 라면 객체의 라면 국물의 맛을 설정하는 일
	 * @param soup 국물의 맛
	 */
	public void setSoup(String soup) {
			this.soup=soup;
	}//setSoup
	
	/**
	 * 생성된 라면 객체의 라면맵기의 강도를 설정하는 일
	 * @param spicy 라면맵기 강도는 최대 3까지 설정 할수있다
	 * 	3개가 넘어가면 기본인 2로 설정된다
	 */
	public void setSpicy(int spicy) {
		if (spicy>4) {
			spicy=2;
		}//end if
		this.spicy=spicy;
	}//setSpicy
	
	/**
	 * 생성된 라면 객체의 가격을 설정하는 일
	 * @param price 가격
	 */
	public void setPrice(int price) {
		this.price=price;
	}//setPrice
	
	/**
	 * 생성된 라면객체의 면의 굵기를 설정하는일
	 * @param thickness 면의 굵기의 강도를 최대 3까지 설정 할수 있다
	 * 3개가 넘어가면 기본인 2로 설정된다
	 */
	public void setThickness(int thickness) {
		if(thickness>4) {
			thickness=2;
		}//end if
		this.thickness=thickness;
	}//setThickness
 
	//getter
	/**
	 *  생성된 라면 객체의 이름을 반환 하는 일
	 * @return 이름
	 */
	public String getRamen() {
		return ramen;
	}//getRamen
	
	/**
	 *  생선된 라면 객체의 국물색깔을 반환 하는 일
	 * @return 국물색깔
	 */
	public String getColor() {
		return color;
	}//getColor
	
	/**
	 *  생성된 라면 객체의 국물 맛을 반환 하는 일
	 * @return
	 */
	public String getSoup() {
		return soup;
	}//getSoup
	
	/**
	 *  생성된 라면 객체의 맵기 강도를 반환 하는 일
	 * @return
	 */
	public int getSpicy() {
		return spicy;
	}//getSpicy
 	
	/**
	 * 생성된 라면 객체의 가격을 반환 하는 일
	 * @return
	 */
	public int getPrice() {
		return price;
	}//getPricy
	
	/**
	 * 생성된 라면 객체의 면의 굵기를 반환 하는일
	 * @return
	 */
	public int getThickness() {
		return thickness;
	}//getThickness

	//동사적 특징
	public String eat() {
		return ramen+"의 색깔은"+color+"이며 국물의 맛은"+soup+"이고 맵기는 내가 매운강도를"+spicy+"으로해 먹을수 있고"+
				"면 굵기도"+thickness+"단계까지 조절 할수있다 이 모든것이 돈"+price+"에 맛 볼수 있다"; 
	}//eat

	public String eat(String ramen, int spicy, int price ) {
		return ramen+"은 단 돈"+price+ "에 매운강도"+spicy+"단계로 조절해 먹을수 있는 완제품이다 ";
	}//eat


























}//class
