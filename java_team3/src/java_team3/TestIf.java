package java_team3;

import java.time.temporal.ValueRange;

import javax.swing.JOptionPane;

/**
 * 조건문에는 단일if, elseif, switch문이 있다. 조건에 맞을경우 그다음 코드를 실행할수 있게 한다. 주로 if문이 사용되지만
 * 처리할 경우가 많은경우에는 switch문을 사용한다.
 * 
 * @author KIM
 */
public class TestIf {
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;
	public static final int GRADE_E = 5;

	public static void main(String[] args) {
/*	
	// 단일 if 문
		// 가장 기본적인 조건문이며 if( ) 조건식이 참이라면 { }안의 문장을 수행해라
		int score = Integer.parseInt(args[0]); // 문자열 정수형을 숫자형으로 변경해서 아큐먼츠를 받아서 조건
		String grade = "";

		if(score>90 && score<101) {
			grade="A";
			System.out.println("당신의 학점은 "+grade+"입니다. 축하 합니다");
		}else if(80<score && score<89 ){
			grade="B";
			System.out.println("당신의 학점은 "+grade+"입니다. 축하 합니다");
		}else if(70<score && score <79) {
			grade="c";
			System.out.println("당신의 학점은"+grade+"입니다. 분발하세요");
		}else if(score<0 || score>101) {
			System.out.println("점수는 0점 ~ 100점까지만 입력해주세요.");
		}
		// 자주 사용하는 연산자
		// 50 <x && x>90 50보다 크거나 90보다 작을떄
		// x<0 || X>100 0보다 작거나 100보다 클때
		// str.equals("이재찬 ") 문자열 내용이 이재찬이 있는지 비교할경우

		// switch문 사용 
		// 조건식if 에 case 값이 일치하면 값을 출력해라. 분기문 break, continue 같이 사용
		// 값을 상수로 선언해 학점을 나오게 출력
		String msg="";
		if (score > 0 && score < 101) {
			switch (score / 10) {
			case GRADE_A:
				msg="당신은 1등급 입니다. 축하드립니다";
				break;
			case GRADE_B:
				msg="당신은 2등급 입니다. 축하드립니다";
				break;
			case GRADE_C:
				msg="당신은 3등급 입니다. 축하드립니다";
				break;
			case GRADE_D:
				msg="당신은 4등급 입니다. 축하드립니다";
				break;
			case GRADE_E:
			default:
				break;

			}// end switch
			System.out.println(msg);
		} // end if
*/
		String sn="";
		boolean flag=false;
	try {
		do {
		String inputData=JOptionPane.showInputDialog("주민번호를 입력해주세요\n예xxxxxx-xxxxxxx");
		if(inputData.length()!=14 && !inputData.contains("-")) {
			JOptionPane.showMessageDialog(null, "형식이 잘못 되었습니다.\n다시 입력해주세요.");
			return;
//		}else if(inputData.length() !=14) {
//			System.out.println(inputData);
//			JOptionPane.showMessageDialog(null, "주민번호를 끝까지 다시 입력해주세요");
//			return;
		}
		char ssn=inputData.charAt(7);
//		sn=String.valueOf(ssn);
//		if(!inputData.contains("-") ) {
//			JOptionPane.showMessageDialog(null, "잘못된 형식입니다\n형식에 맞춰서 작성해주세요.");
//			return;
//		}
		switch (ssn) {
		case '1' : case '3' :
			JOptionPane.showMessageDialog(null, "남자입니다"); 
			break;
		case '2' : case '4' :	
			JOptionPane.showMessageDialog(null, "여자입니다.");
			break;

		default:
			JOptionPane.showMessageDialog(null, "주민번호가 일치하지 않습니다.");
			break;
			}
		}while(!flag);
			JOptionPane.showMessageDialog(null, "감사합니다.");
	}catch(NullPointerException ne) {
		JOptionPane.showMessageDialog(null, "감사합니다.");
		ne.printStackTrace();
	}//end catch
	}// main

}// class
