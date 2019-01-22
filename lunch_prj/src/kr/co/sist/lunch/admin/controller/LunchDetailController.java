package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.StyleContext.SmallAttributeSet;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;

public class LunchDetailController extends WindowAdapter implements ActionListener{

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	private String originalImg;
	private String uploadImg;
	
	public LunchDetailController(LunchDetailView ldv, LunchMainController lmc, String originalImg) {
		this.ldv= ldv;
		this.lmc = lmc;
		la_dao = LunchAdminDAO.getInstance();
		this.originalImg = originalImg;
		uploadImg="";
	}//LunchDetailController
	
	@Override
	public void windowClosing(WindowEvent e) {
		ldv.dispose();
	}//windowClosing
	
	private void removeLunch(String code) {		
		try {
			if(la_dao.deleteLunch(code)) {//���ö� ����
				lmc.setLunch(); //���ö� ����Ʈ�� ����
				//������ ����
				File file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+originalImg);
				File rmFile = new File(file.getAbsolutePath()); //ū����
				File rmFile2 = new File(file.getParent()+"/s_"+file.getName()); //��������
				
				rmFile.delete();
				rmFile2.delete();
				
				
				
				JOptionPane.showMessageDialog(ldv, "���ö��� ���� �Ǿ����ϴ�.");
			}else {
				JOptionPane.showMessageDialog(ldv, "���ö��� �������� �ʽ��ϴ�.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv,"DB���� ���� �߻��Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}//removeLunch
	
	public void chgImg() {
		boolean flag = false;
		FileDialog fdOpen = new FileDialog(ldv, "���ö� �̹��� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();
		
		if (path != null) {
			String[] extFlag = { "jpg", "gif", "jpeg", "png", "bmp" };
			for (String ext : extFlag) {
				if (name.toLowerCase().endsWith(ext)) { // ���ε� ���� Ȯ����
					flag = true;
				} // end if
			} // end for
			if (flag) {
				uploadImg = path + name;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
			} else {
				JOptionPane.showMessageDialog(ldv, name + "�� �̹����� �ƴմϴ�.");
			} // end else

		} // end if

	}//chgImg
	
	/**
	 * ���ö��ڵ�, ���ö���, �̹���, ����, Ư������ �Է¹޾� �ڵ忡 �ش��ϴ� ���ö��� ������ ����.
	 * @return
	 */
	private void modifyLunch() {
		//��ȿ�� ���� : ���ö���, ����, Ư������ ""�� �ƴ� ��, ������ ��������,
		// �̹����� ����Ǿ��ٸ� �̹����� s_�� ���� �̹����� �����ϴ� �̹�������
		JTextField tfName = ldv.getJtfLunchName();
		JTextField tfPrice= ldv.getJtfLunchPrice();
		JTextArea taSpec = ldv.getJtaLunchSpec();
		
		if(tfName.getText().trim().equals("")) {
			tfName.setText("");
			JOptionPane.showMessageDialog(ldv,"���ö����� �Է����ּ���.");
			tfName.setText("");
			tfName.requestFocus();
			return;
		}//end if
		if(tfPrice.getText().trim().equals("")) {
			tfPrice.setText("");
			JOptionPane.showMessageDialog(ldv,"���ö� ������ �Է����ּ���.");
			tfPrice.setText("");
			tfPrice.requestFocus();
			return;
		}//end if
		if(taSpec.getText().trim().equals("")) {
			taSpec.setText("");
			JOptionPane.showMessageDialog(ldv,"���ö��� Ư������ �Է����ּ���.");
			taSpec.setText("");
			taSpec.requestFocus();
			return;
		}//end if
		
		int price =0;
		try {
			price = Integer.parseInt(tfPrice.getText().trim());
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(ldv, "���ö� ������ ���ڸ� �Է� ����");
			return;
		}//end catch
		
		//������ �̹����� ������ �̸��� �̹����� s_�� ������ ���� ��� �̹����۾��� �Ǿ����� ���� ���. uploadImg�� ���
		if(!uploadImg.equals("")) { //�̹��� ������ ������ ���
			File tempFile = new File(uploadImg); //ū �̹���
			File smallFile = new File(tempFile.getParent()+"/s_"+tempFile.getName()); //���� �̹���
			if(!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "�����Ͻ� ������ ���� �̹����� �������� �ʽ��ϴ�.");
				uploadImg ="";
				return;
			}//end if
		}//end if
		
		StringBuilder updateMsg = new StringBuilder();
		updateMsg.append("��������\n").append("���ö���: ")
		.append(tfName.getText()).append("\n")
		.append("����: ").append(tfPrice.getText()).append("\n")
		.append("Ư����: ").append(taSpec.getText()).append("\n")
		.append("���� ������ ���ö��� ������ ����˴ϴ�. �����Ͻðڽ��ϱ�?");
		
		switch (JOptionPane.showConfirmDialog(ldv,updateMsg.toString())) {
		case JOptionPane.OK_OPTION :
			//����� ������ VO�� �����ϰ�
			File file = new File(uploadImg);
			LunchUpdateVO luvo = new LunchUpdateVO(ldv.getJtfLunchCode().getText(), tfName.getText().trim(), 
					file.getName(), taSpec.getText(), price);
			try {
				if(la_dao.updateLunch(luvo)) { //DB Table���� update �� ����
					JOptionPane.showMessageDialog(ldv, "���ö� ������ ����Ǿ����ϴ�.");
					if(!uploadImg.equals("")) { //������ �̹����� �����ϴ� ���
						try {
							//���� �̹����� ������ ��.
							File original = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+originalImg);
							File small = new File(original.getPath()+"/s_"+original.getName());
							original.delete();
							small.delete();
							
							uploadImg(file); //������ �̹����� ������ ������ ���ε��Ѵ�.
						} catch (IOException e) {
							e.printStackTrace();
						}//end catch
					}//end if
					lmc.setLunch(); //�θ�â�� ���ö� ����Ʈ�� �����Ѵ�.
				}else {
					JOptionPane.showMessageDialog(ldv, "���ö� ������ ��������ʾҽ��ϴ�.");
				}//end else
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(ldv, "DB���� ���� �߻�......");
				e.printStackTrace();
			}//end catch
			
			break;
		}//end switch
//		LunchUpdateVO luvo = new LunchUpdateVO(lunch_code, lunch_name, img, spec, price);	
	}//modifyLunch
	/**
	 * ū �̹������� ���� File��ü�� �Է��Ͽ� ���ε� ������ ū �̹���(m1_l1.gif)�� s_������ ���� �̹���(s_m1_l1.gif)�� 
	 * ���ε� �Ѵ�.
	 * @param file
	 */
	private void uploadImg(File file) throws IOException{
		//ū �̹����� ���ε�
		FileInputStream fis=null;
		FileOutputStream fos =null;
		
		try {
			//ū �̹��� ���ε�
			fis = new FileInputStream(file);
			byte[] readData = new byte[512];
		
			int len = 0;
			String uploadPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";
			fos = new FileOutputStream(uploadPath+file.getName());
		
			while((len=fis.read(readData))!=-1){
				fos.write(readData,0,len);
				fos.flush();
			}//end while
		
			fis.close();
			fos.close();
		
		//���� �̹��� ���ε�
		
			fis = new FileInputStream(file.getParent()+"/s_"+file.getName());
		
			len = 0;
			uploadPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";
			fos = new FileOutputStream(uploadPath+"s_"+file.getName());
		
			while((len=fis.read(readData))!=-1){
				fos.write(readData,0,len);
				fos.flush();
			}//end while
		
		}finally {
			if(fis!=null) {fis.close();}
			if(fos!=null) {fos.close();}
		}
		
	}//uploadImg
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() ==ldv.getJbUpdate()) {//����
			modifyLunch();
		}
		if(ae.getSource() == ldv.getJbDelete()) {//����
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(")
				.append(ldv.getJtfLunchCode().getText()).append(")��(��) �����Ͻðڽ��ϱ�?");
			
			switch(JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION:
//				System.out.println(ldv.getJlLunchImg().getIcon());
				removeLunch(ldv.getJtfLunchCode().getText());
			
			}//end switch
			
		}
		if(ae.getSource() == ldv.getJbEnd()) {//����
			ldv.dispose();
		}
		if(ae.getSource() == ldv.getJbImg()) {//�̹�������
			chgImg();
		}
	}//actionPerformed
	
	

}
