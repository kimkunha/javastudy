package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;

import kr.co.sist.memo.evt.MemoHelpEvt;

/**
 *	����â�� ���̾�α׸� ����
 *	�޸��� ����
 *	�� �޸����� java�� ����������� ������ �ڵ� ���� �� ������ �Ҽ� �ֽ��ϴ�.
 *	��, ���ڵ带 ����Ͽ� �������������� �ҽ������� ��Ģ�����Ѵ�. GNM
 *	�ۼ��� : ���ü�
 *	Version : 1.0 
 * @author owner
 */
//���
@SuppressWarnings("serial")
public class MemoHelp extends Dialog {
	//����
	private JavaMemo jm;
	private Button btnHelp;
	private TextArea taMsg;
	
		public MemoHelp(JavaMemo jm ) {
			super( jm, "����" ,true);
			this.jm=jm;
			
			//����
			btnHelp= new Button("Ȯ��");
			taMsg=new TextArea("�޸��� ����\n"
					+ "����â�� ���̾�α׸� ����޸��� ������ �޸����� java�� �����������\n"
					+ "������ �ڵ� ���� �� ������ �Ҽ� �ֽ��ϴ�.��, ���ڵ带 ����Ͽ� ��������������\n"
					+ "�ҽ������� ��Ģ�����Ѵ�. GNM�ۼ��� : ���ü�Version : 1.0 ");
			
			add("Center", taMsg);
			taMsg.setEditable(false);
			add("South", btnHelp);
			
			
			
			MemoHelpEvt mhe=new MemoHelpEvt(this);
			btnHelp.addActionListener(mhe);
			addWindowListener(mhe);
			
			setBounds(jm.getX()+100, jm.getY()+200, 500, 500);
			
			setVisible(true);
		}//HelpDialog

		
		
		public Button getBtnHelp() {
			return btnHelp;
		}//getBtnHelp
		
		
		
}//class
