package day1218;

import java.util.Random;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

//18.12.18	-13번 자료- ( throw )  
/**
 * 예외를 강제로 발생
 * 
 * @author owner
 */
public class TestThrow {

	/**
	 * 택성은 길을 가다가 담배를 피우는 학생을 보면 정의사회를 구현한다.
	 */
	public void teacksung() throws Exception {
		String[] grade = { "초등학생", "중학생", "고등학생" };
		String randomGd = grade[new Random().nextInt(grade.length)];
		if (randomGd.equals("초등학생")) {
//		try {
			throw new Exception(randomGd + "행님들 금연해야 하는 부분 아니겠습니까?");
//		}catch(Exception e) {
//			e.printStackTrace();
		} else {
			System.out.println(randomGd + "모른척 지나간다.");
		} // end else

	}// teacksung

	
	
	
	public void teacksung2() throws TobaccoException{
		String[] grade = { "초등학생", "중학생", "고등학생" };
		String randomGd = grade[new Random().nextInt(grade.length)];
		
		if (randomGd.equals("초등학생")) {
			throw new TobaccoException();
		} else {
			System.out.println(randomGd + "모른척 지나간다.");
		} // end else

	}// teacksung2

	
	
	
	
	
	
	public static void main(String[] args) {
		TestThrow tt = new TestThrow();
		try {
			tt.teacksung2();
		} catch (TobaccoException e) {
			e.printStackTrace();
		} // end catch
		System.out.println("--------------");
		
//		try {
//		tt.teacksung2();
//		}catch	(TobaccoException e) {
//			tt.teacksung2();
//		}//end catch
		
	}// main

}// class
