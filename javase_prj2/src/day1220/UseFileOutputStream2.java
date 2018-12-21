package day1220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

//18.12.20	-3�� �ڷ�-	()
/**
 *	8bit Stream�� 16bit Stream�� ����Ͽ� ���ڿ� �����͸� File�� ���
 * 
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data="������ ����� �Դϴ� ������ �ݿ���. �𷡴� ������Դϴ�hi,hello.123124123ҽ�����ʪ���";
		//1. File��ü ���� : ������ �����Ѵٸ� ���� ���������� �Ǵ��ϱ� ���ؼ� �����.
		File file =new File("c:/dev/temp/java_write2.txt");
		
		boolean flag=false;	//������ ������ 														//�Ҹ��� ���°� �����غ���
		if(file.exists()) { //������ �����Ҷ�
			boolean[] temp= {false,true,true};	//��, �ƴϿ�, ���
			flag=temp[JOptionPane.showConfirmDialog(null, "����� �κ�? ����?")];
		}//end if
		
		//2. stream ����
		if( !flag ) {
			BufferedWriter bw=null;
			try {
				
				//8bit Stream�� 16bit Stream ������
//				//2-1. ������ �����ϴ� ��Ʈ�� : FileNoutFoundException �߻� -> ������ ������
//				FileOutputStream fos=new FileOutputStream( file );
//				//2-3. ���ڿ��� �������� ��Ʈ���� ���� / ������ : �ӵ��� ������
//				OutputStreamWriter osw=new OutputStreamWriter( fos );
//				//2-4. �����ӵ��� �����ϱ� ���� ��Ʈ���� ����
//				BufferedWriter bw=new BufferedWriter( osw );
				
				//����� �ڵ带 ����ȭ ��Ŵ
//				bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream( file )));
				
				///////////////////////////16bit�� ���//////////////////////////////////////
				//�ܼ��ϰ� ���ڿ��� ����Ҷ��� 16bit�� ����.
				bw=new BufferedWriter(new FileWriter( file ));
				
				
				bw.write( data );// ��Ʈ���� �����͸� ���
				bw.flush();//������ ���Ϸ� ����			//���Stream�� flush�� �⺻����
				System.out.println("���Ͽ���� �Ϸ�!!");
			
				
			}finally {
				//��Ʈ�� ��ü�� �����Ǿ� �ִٸ� ���� ����
//				if( bw!=null) {bw.close(); }//end if
			}//end finally
			
		}//end if
		
		
		
	}// UseFileOutputStream2

	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class
