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
		String inputData=JOptionPane.showInputDialog("���Է�\n��)1.�̸� 2.�ڹ����� 3.����Ŭ����");
		String[] data=inputData.split(",");
		
		if(data.length !=3) {
			JOptionPane.showMessageDialog(null, "�Է������� Ʋ�Ƚ��ϴ�");
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
			JOptionPane.showMessageDialog(null, "�Է������� �ٸ��ϴ�.");
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
			JOptionPane.showMessageDialog(null, "�Է��� �߰��Ǿ����ϴ�.");
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
		.append("��ȣ\t�̸�\t�ڹ�����\t����Ŭ����\t����\t���\n")
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
		jta.append(viewData.toString()); //ȭ���� ������ �����͸� JTA�� �ٿ��ش�.
		JScrollPane jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
		return flag;
				
		
	}
	
	public static void main(String[] args) {
		Score so=new Score();
		boolean extFlag =false;
		do {
		String inputData=JOptionPane.showInputDialog(null, "�޴�����\n1.�Է� 2.��� 3.�ݱ�");
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
