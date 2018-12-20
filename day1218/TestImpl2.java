package day1218;

import java.text.SimpleDateFormat;
import java.util.Date;
//18.12.18	-11번 자료- (instancof)  9 ~ 12번 연계
public class TestImpl2 implements Test {

	@Override
	public String getDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy EEEE");
		return sdf.format(new Date());
	}

}
