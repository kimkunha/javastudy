package kr.co.sist.lunch.admin.vo;

public class LunchVO {
	private String lunchCode, lunchname, img;
	private int price;

	public LunchVO(String lunchCode, String lunchname, String img, int price) {
		super();
		this.lunchCode = lunchCode;
		this.lunchname = lunchname;
		this.img = img;
		this.price=price;
	}//»ý¼ºÀÚ

	//getter
	public String getLunchCode() {
		return lunchCode;
	}

	public String getLunchname() {
		return lunchname;
	}

	public String getImg() {
		return img;
	}
	

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "LunchVO [lunchCode=" + lunchCode + ", lunchname=" + lunchname + ", img=" + img + "]";
	}
	
	
}//class
