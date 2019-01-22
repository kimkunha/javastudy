package Study;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import day1217.ScoreVO;

public class Score {
	public static int INSERTSOCRE=1;
	private List<ScoreVO>list;
	
	public Score() {
	}
	
	public boolean insert() {
		boolean flag=false;
		String inputData=JOptionPane.showInputDialog("값입력\n예)1.이름 2.자바점수 3.오라클점수");
		String[] data=inputData.split(",");
		
		if(data.length !=3) {
			JOptionPane.showMessageDialog(null, "입력형식이 틀렸습니다");
			flag=false;
			return flag;
		}//end if
		String name="";
		int java=0;
		int oracle=0;
		try {
		for(int i=0; i<data.length; i++) {
			name=data[0];
			java=Integer.parseInt(data[1]);
			oracle=Integer.parseInt(data[2]);
		}//end for
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "입력형식이 다릅니다.");
		}//end catch
		try {
		List<ScoreVO>list=new ArrayList<>();
		list=null;
		ScoreVO sv=null;
			sv=new ScoreVO(name, java, oracle);
				list.add(sv);
				System.out.println(list);
		}catch(NullPointerException npe) {
			flag=true;
			npe.getStackTrace();
			JOptionPane.showMessageDialog(null, "입력이 추가되었습니다.");
		}
		return flag;
	}//insert
	
	public boolean select( ) {
		boolean flag=false;
		list=new ArrayList<>();
		ScoreVO sv=null;
		StringBuilder viewData = new StringBuilder();
		viewData.append("--------------------------------------------------------------")
		.append("---------------------------------------------------------------------\n")
		.append("번호\t이름\t자바점수\t오라클점수\t총점\t평균\n")
		.append("--------------------------------------------------------------")
		.append("---------------------------------------------------------------------\n");
		for(int i=0; i<list.size(); i++) {
			sv=list.get(i);
			sv=new ScoreVO(sv.getName(), sv.getJavaScore(), sv.getOracleScore());
			flag=true;
			viewData.append(i+1)
			.append("\t").append(sv.getName())
			.append("\t").append(sv.getJavaScore())
			.append("\t").append(sv.getOracleScore());
		}
		viewData.append("--------------------------------------------------------------")
		.append("---------------------------------------------------------------------\n");
		JTextArea jta = new JTextArea(15,50);
		jta.append(viewData.toString()); //화면을 구성한 데이터를 JTA에 붙여준다.
		JScrollPane jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
		return flag;
				
		
	}
	
	public static void main(String[] args) {
		Score so=new Score();
		boolean extFlag =false;
		do {
		String inputData=JOptionPane.showInputDialog(null, "메뉴선택\n1.입력 2.출력 3.닫기");
		switch (inputData) {
		case  "1" :
			so.insert();
			break;
		case "2" :
			so.select();
		default:
			extFlag=true;
		}
		}while(!extFlag);
	}//main

}//class
