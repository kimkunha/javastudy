package kr.co.sist.lunch.user.vo;

public class LunchDetailVO {

	private String lunchCode, lunchName, img, spec, req; 
	private int price;
	
	
	public LunchDetailVO(String lunchCode, String lunchName, String img, String spec, String req, int price) {
		super();
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.img = img;
		this.spec = spec;
		this.req=req;
		this.price = price;
	}


	public String getLunchCode() {
		return lunchCode;
	}


	public String getLunchName() {
		return lunchName;
	}


	public String getImg() {
		return img;
	}


	public String getSpec() {
		return spec;
	}


	public int getPrice() {
		return price;
	}


	public String getReq() {
		return req;
	}


	@Override
	public String toString() {
		return "LunchDetailVO [lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", img=" + img + ", spec=" + spec
				+ ", req=" + req + ", price=" + price + "]";
	}



	
}
