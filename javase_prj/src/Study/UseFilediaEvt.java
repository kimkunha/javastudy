package Study;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JLabel;

public class UseFilediaEvt extends WindowAdapter implements ActionListener{

	private UseFiledia ufd;
	
	public UseFilediaEvt(UseFiledia ufd) {
		this.ufd=ufd;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ufd.getJbtOpen()) {
			
		//��ư�� ������ ���� ���̾�α� ����
			
		FileDialog fdOpen=new FileDialog(ufd, "���Ͽ���", FileDialog.LOAD);
		fdOpen.setVisible(true);
		//���, �̸� �������
		String path=fdOpen.getDirectory(); //��� ����
		String name=fdOpen.getName(); //�̸� ������
		if(name !=null ) {
			ufd.getJlbl().setText(name+"/"+path);
		}
		
				
			
			
			
			
		}//end if
		
		if(ae.getSource() == ufd.getJbtClose()) {
			
			FileDialog fdClose=new FileDialog(ufd, "��������", FileDialog.SAVE);
			fdClose.setVisible(true);
		}
			
			
		
			
			
			
//		}//end if
		
		
	}//actionPerformed

	
}//class
