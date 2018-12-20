package day1219;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *	JOptionPane.showInputDialog�� ����Ͽ� ��θ� �Է� �޴´�.

	�Է¹��� ��ο�  Ȯ���ڰ� java�� ������ �����Ѵٸ� 

 	JOptionPane.showConfirmDialog�� ����Ͽ�  �������θ� ���´�.

 	��� �޼���  "java ������ x�� �����մϴ�. �����Ͻðڽ��ϱ�?"
 	"��"�� ������ �ش� ������ �����ϰ� , "�ƴϿ�"�� "���"��  �������� 
	�����Ѵ�. 
 * @author owner
 */
public class WorkProcessor2 {
	private static final int YES =0;
	private static final int NO=1;
	private static final int ESC=2;
	public WorkProcessor2() {
		path();
	}//WorkProcessor2
	
	public void path() {
		String temp="";
		temp=JOptionPane.showInputDialog("�Է��ϼ���");
		File file=new File(temp);
		if(file.isDirectory( )){	//�������� ����
			deleteJavaFile(file);			//  <- method
		}//end if
		
	}//path
	
	public void deleteJavaFile(File file) {
		File[ ] fileArr= file.listFiles();
	
		List<File>javaFile=new ArrayList<File>();
	
		for(File f : fileArr) {
			if(f.getName().endsWith(".java")) {
				javaFile.add(f);
			}//end if
		}//end for
	
		int delFlag = JOptionPane.showConfirmDialog(null, "java ������"+javaFile.size()+"�� �����մϴ�. ���� �Ͻðڽ��ϱ�?");
		
		switch (delFlag) {
		case YES :
			for(int i=0; i< javaFile.size(); i++) {
				javaFile.get(i).delete();
			}//end for
			break;
		case NO : 
			return;
		case ESC :
			return;
		}//end switch
		
	}//deleteJavaFile
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new WorkProcessor2();
	}//main

}//class
