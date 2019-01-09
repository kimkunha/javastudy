package day0108;
//19.01.07 -3번자료- (주소 VO )
public class ZipcodeVO {
	private String zipcode, sido, gugun, dong, bunji ;

	public ZipcodeVO() {
	}

	public ZipcodeVO(String zipcode, String sido, String gugun, String dong, String bunji) {
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getSido() {
		return sido;
	}

	public String getGugun() {
		return gugun;
	}

	public String getDong() {
		return dong;
	}

	public String getBunji() {
		return bunji;
	}

	@Override
	public String toString() {
		return "ZipcodeVO [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + "]";
	}	


	
	
}//class
