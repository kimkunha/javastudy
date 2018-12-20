package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	private String taNoteData; // TextAera�� ������ ������ ����
	private String openPath; // ������ ���ϸ��� ���庯��

	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
		taNoteData = "";
		openPath = "";

	}// JavaMemoEvt

	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
//		miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;	//������� ������ �����س��� �����ؾ� �� ����� ��ġ�� ����
		// �󺧷� �Ұ�� getter�ʿ� ����.

		// ���� �޴������ۿ��� �̺�Ʈ�� �߻� ������
		if (ae.getSource() == jm.getMiNew()) {
			newMemo();
		} // end if

		// ���� �޴������ۿ��� �̺�Ʈ�� �߻� ������
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(jm, "������ ������ ���� �� �����ϴ�.", "���� ���� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "������ ������ �о���̴� �� ������ �߻��Ͽ����ϴ�.", "���� ���� ����",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} // end if

		// ���� �޴������ۿ��� �̺�Ʈ�� �߻� ������
		if (ae.getSource() == jm.getMiSave()) {
			saveMemo();
		} // end if

		// �ٸ� �̸����� ���� �޴������ۿ��� �̺�Ʈ�� �߻� ���� ��
		if (ae.getSource() == jm.getMiNewSave()) {
			newSaveMemo();
		} // end if

		// ���� �޴������ۿ��� �̺�Ʈ�� �߻� ���� ��
		if (ae.getSource() == jm.getMiEnd()) {
			jm.dispose();
		} // end if

		// ���� �޴������ۿ��� �̺�Ʈ�� �߻� ���� ��
		if (ae.getSource() == jm.getMiFormat()) {
			formatDialog();
		} // end if

		// ���� �޴������ۿ��� �̺�Ʈ�� �߻� ���� ��
		if (ae.getSource() == jm.getMiHelp()) {
			helpDialog();
		} // end if

	}// actionPerformed

	/**
	 * ���� : TextArea�� �ʱ�ȭ�Ѵ�.
	 */
	public void newMemo() {

		TextArea tempTa = jm.getTaNote();
		boolean flagNew = false;
		// ������ ������ �Ǵ�
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, "�ٸ� �̸����� ���� �Ͻðڽ��ϱ�?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				newSaveMemo();
			case JOptionPane.NO_OPTION:
				flagNew = false;
				break;
			default:
				flagNew = true;
			} // end switch
		} // end if
		if (!flagNew) {

			tempTa.getText();
			tempTa.setText(""); // �̷��� �ؾ� �Ǵµ� ���׷� ���� getText�� ���� ȣ���Ѵ�.
			// ������ �� ���Ŀ��� �б��� ������ �ʱ�ȭ
			taNoteData = tempTa.getText(); // �о���� ������ ��� �ʱ�ȭ
			openPath = ""; // �ʱ�ȭ

			jm.setTitle("�޸��� - ����");
		} // end if
	}// newMemo

	/**
	 * txt���� ����
	 */
	public void openMemo() throws FileNotFoundException, IOException {

		// TextArea�� ����� �о�鿴�� ������ �ٸ��ٸ� ���忩�θ� ����, �۾��� �����Ѵ�.
		boolean flagOpen =false;
		TextArea tempTa = jm.getTaNote();
		if (!taNoteData.equals(tempTa.getText())) {
				int flag = JOptionPane.showConfirmDialog(jm, openPath + "\n�� �����Ͻðڽ��ϱ�?");
				switch(flag) {
				case JOptionPane.OK_OPTION :
					if (!openPath.equals("")) {
					// ������ �̸��� ������ ������
					saveMemo();
			} else {
				// �ٸ� �̸����� ����
				newSaveMemo();
			} // end else
			case JOptionPane.NO_OPTION :
				flagOpen=false;
				break;
			default :
				flagOpen=true;
		} // end if
		}// end if
	if( !flagOpen) {
		FileDialog fdOpen = new FileDialog(jm, "���� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String filePath = fdOpen.getDirectory();
		String fileName = fdOpen.getFile();

		if (filePath != null) { // ������ ������ ����
			/////////////////////////////////////// 12-20-2018 ��Ʈ������ ������ ������ �д� �ڵ� �߰�
			/////////////////////////////////////// ����/////////////////////////////////////////////////

			// ���� : ������ ���Ϸ� ���ϰ�ü ����.
			File file = new File(filePath + fileName);
			// 16bit stream ���
			BufferedReader br = null;

			try {
				br = new BufferedReader(new FileReader(file));
				String temp = "";
				tempTa.setText("");
				while ((temp = br.readLine()) != null) {
					// ���Ͽ��� �о���� ������ �����Ѵ�.
					tempTa.append(temp + "\n");
				} // end while
					// ������ �о���� ������ ����
				taNoteData = tempTa.getText();
				// ������ ���ϸ��� ����
				openPath = file.getAbsolutePath();

			} finally {
				if (br != null) {
					br.close();
				} // ������ �ǵ� �ȵǴ� ��ü�� ����� ���ִٸ� �ѹ� �����ּ���.

			} // end finally

			// �ۼ� :
			/////////////////////////////////////// 12-20-2018 �� �ڵ� �߰�
			// ��/////////////////////////////////////////////////

			// ������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸��� - ���� " + fileName + filePath);
		} // end if
		}//end if
	}// openMemo

	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� �����ϴ� ���ϸ� �ݿ�
	 */
	public void saveMemo() {
		newSaveMemo();
	}// saveMemp

	/**
	 * ���ϸ��� �Է¹޾� ���̸����� ����
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "���� ����", FileDialog.SAVE);
		fdSave.setVisible(true);

		String filePath = fdSave.getDirectory();
		String fileName = fdSave.getFile();

		if (filePath != null) { // ������ ������ ����

			// ������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸��� - ���� " + fileName + filePath);
		} // end if

	}// newSaveMemo

	/**
	 * �۲��� �����ϴ� ���̾�α׸� �����ϴ� ��
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}// format

	/**
	 * �޸��� ������ �����ϴ� ���̾�α׸� ����
	 */
	public void helpDialog() {
		new MemoHelp(jm);
	}// helpDialog

}// class
