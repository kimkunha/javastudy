package day1203;
//18.12.03 수업 15번 자료 (9번자료 클락 연계)
/**
 *	나는 것들의 일<br>
 *	나는 것은 속도, 높이
 * @author owner
 */
public interface Fly {
	/**
	 * 	나는 속도
	 * @param speed
	 * @return
	 */
	public abstract String speed(String speed);
	/**
	 * 	나는 높이
	 * @param height
	 * @return
	 */
	public String height(String height);						//인터페이스의 추상method는 public만 가능 protected 불가
	
}//interface
