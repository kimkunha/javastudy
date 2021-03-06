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

		// �迭�� ssn�� �� �ڸ��� ����
		for (int i = 0; i < 13; i++) {
			ssnArr[i] = Integer.valueOf(tempSsn.charAt(i) - '0');
		}

		// �� �ڸ��� ssn�� �ش� ���� ���ѵ� ����
		for (int i = 0; i < 12; i++) {
			if (i < 8)
				ssnArr[i] = ssnArr[i] * (i + 2);
			else
				ssnArr[i] = ssnArr[i] * (i - 6);

			ssnNum += ssnArr[i];// �� �ڸ��� ���Ѱ��� ����
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
		char gender = 'A';

		switch (ssn.charAt(7)) {
		case '1':
		case '3':
		case '5':
		case '7':
		case '9':
			gender = '��';
			break;
		default:
			gender = '��';
			break;
		}

		return gender;
	}

	// 1-8
	public String returnForeigner() {
		String foreigner = "���Ҽ�";

		switch (ssn.charAt(7)) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '9':
			foreigner = "������";
			break;
		default:
			foreigner = "�ܱ���";
			break;
		}

		return foreigner;
	}
	
	// 1-9
		public String returnZodiac() {
			String zodiac = "�����̶�";
			String year;
			int ck=0;
			
			year = returnBirth().substring(0, 4);
			ck = Integer.valueOf(year)%12;

			//4�� 5�� 6�� 7��
			//8�� 9�� 10�� 11�� 
			//0 �� 1�� 2�� 3 �� 
			switch (ck) {
			case 0:
				zodiac = "�����̶�";
				break;
			case 1:
				zodiac = "�߶�";
				break;
			case 2:
				zodiac = "����";
				break;
			case 3:
				zodiac = "������";
				break;
			case 4:
				zodiac = "���";
				break;
			case 5:
				zodiac = "�Ҷ�";
				break;
			case 6:
				zodiac = "ȣ���̶�";
				break;
			case 7:
				zodiac = "�䳢��";
				break;
			case 8:
				zodiac = "���";
				break;
			case 9:
				zodiac = "���";
				break;
			case 10:
				zodiac = "����";
				break;
			case 11:
				zodiac = "���";
				break;
			default:
				zodiac = "����";
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
					System.out.println("������� = "+sp.returnBirth());// 1-5
					System.out.println("���� = "+sp.returnAge());// 1-6
					System.out.println("���� = "+sp.returnGender());// 1-7
					System.out.println("������ = "+sp.returnForeigner());// 1-8
					System.out.println("������? = "+sp.returnZodiac());//1-9

				}else {
					System.out.println("�ֹι�ȣ�� ��ȿ���� �ʽ��ϴ�.");
				}
			}else {
				System.out.println("�ֹι�ȣ�� �������� 6��° �ڸ��� �����ϴ�.");
			}
			
		}else {
			System.out.println("�ֹι�ȣ�� ���̰� 14�ڸ��� �ƴմϴ�.");
		}
		

		

	}

}
