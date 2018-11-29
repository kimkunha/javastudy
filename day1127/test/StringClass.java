package day1127.test;

public class SsnProcessing {
	String ssn;

	// 1-1
	public SsnProcessing(String ssn) {
		this.ssn = ssn;
	}

	// 1-2
	public boolean ssnLength() {
		boolean ck = false;

		if (ssn.length() == 14)
			ck = true;

		return ck;
	}

	// 1-3
	public boolean ssnHyphen() {
		boolean ck = false;

		if (ssn.charAt(6) == '-')
			ck = true;

		return ck;
	}

	// 1-4
	public boolean ssnValid() {
		boolean ck = false;
		String tempSsn = ssn;
		int ssnNum = 0;
		int[] ssnArr = new int[13];

		tempSsn = ssn.replaceAll("-", "");

		// 배열에 ssn을 각 자리에 대입
		for (int i = 0; i < 13; i++) {
			ssnArr[i] = Integer.valueOf(tempSsn.charAt(i) - '0');
		}

		// 각 자리의 ssn에 해당 숫자 곱한뒤 더함
		for (int i = 0; i < 12; i++) {
			if (i < 8)
				ssnArr[i] = ssnArr[i] * (i + 2);
			else
				ssnArr[i] = ssnArr[i] * (i - 6);

			ssnNum += ssnArr[i];// 각 자리에 곱한값을 더함
		}
		ssnNum = (11 - (ssnNum % 11)) % 10;

		return (ssnNum == ssnArr[12]);
	}

	// 1-5
	public String returnBirth() {
		String birth;
		birth = ssn.substring(0, 2);

		switch (ssn.charAt(7)) {
		case '0':
		case '9':
			birth = "18" + birth;
			break;
		case '1':
		case '2':
		case '5':
		case '6':
			birth = "19" + birth;
			break;
		case '3':
		case '4':
		case '7':
		case '8':
			birth = "20" + birth;
			break;
		}
		birth = birth + "-" + ssn.substring(2, 4) + "-" + ssn.substring(4, 6);

		return birth;
	}

	// 1-6
	public int returnAge() {
		int age = 0;
		String year;
		year = returnBirth().substring(0, 4);
		age = 2018 - Integer.valueOf(year) + 1;

		return age;
	}

	// 1-7
	public char returnGender() {
		char gender = '읭';

		switch (ssn.charAt(7)) {
		case '1':
		case '3':
		case '5':
		case '7':
		case '9':
			gender = '남';
			break;
		default:
			gender = '여';
			break;
		}

		return gender;
	}

	// 1-8
	public String returnForeigner() {
		String foreigner = "무소속";

		switch (ssn.charAt(7)) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '9':
			foreigner = "내국인";
			break;
		default:
			foreigner = "외국인";
			break;
		}

		return foreigner;
	}
	
	// 1-9
		public String returnZodiac() {
			String zodiac = "고양이띠";
			String year;
			int ck=0;
			
			year = returnBirth().substring(0, 4);
			ck = Integer.valueOf(year)%12;

			//4자 5축 6인 7묘
			//8진 9사 10오 11미 
			//0 신 1유 2술 3 해 
			switch (ck) {
			case 0:
				zodiac = "원숭이띠";
				break;
			case 1:
				zodiac = "닭띠";
				break;
			case 2:
				zodiac = "개띠";
				break;
			case 3:
				zodiac = "돼지띠";
				break;
			case 4:
				zodiac = "쥐띠";
				break;
			case 5:
				zodiac = "소띠";
				break;
			case 6:
				zodiac = "호랑이띠";
				break;
			case 7:
				zodiac = "토끼띠";
				break;
			case 8:
				zodiac = "용띠";
				break;
			case 9:
				zodiac = "뱀띠";
				break;
			case 10:
				zodiac = "말띠";
				break;
			case 11:
				zodiac = "양띠";
				break;
			default:
				zodiac = "기모띠";
				break;
			}

			return zodiac;
		}

	public static void main(String[] args) {
		String ssn = "121212-1234567";
		SsnProcessing sp = new SsnProcessing(ssn);// 1-1

		//1-2
		if(sp.ssnLength()) {
			//1-3
			if(sp.ssnHyphen()) {
				//1-4
				if(sp.ssnValid()) {
					System.out.println("생년월일 = "+sp.returnBirth());// 1-5
					System.out.println("나이 = "+sp.returnAge());// 1-6
					System.out.println("성별 = "+sp.returnGender());// 1-7
					System.out.println("원산지 = "+sp.returnForeigner());// 1-8
					System.out.println("무슨띠? = "+sp.returnZodiac());//1-9

				}else {
					System.out.println("주민번호가 유효하지 않습니다.");
				}
			}else {
				System.out.println("주민번호에 하이픈이 6번째 자리에 없습니다.");
			}
			
		}else {
			System.out.println("주민번호의 길이가 14자리가 아닙니다.");
		}
		

		

	}

}
