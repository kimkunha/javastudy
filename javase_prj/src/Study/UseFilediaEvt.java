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
			
		//버튼을 누르면 파일 다이얼로그 띄우기
			
		FileDialog fdOpen=new FileDialog(ufd, "파일열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		//경로, 이름 저장띄우기
		String path=fdOpen.getDirectory(); //경로 저장
		String name=fdOpen.getName(); //이름 가져옴
		if(name !=null ) {
			ufd.getJlbl().setText(name+"/"+path);
		}
		
				
			
			
			
			
		}//end if
		
		if(ae.getSource() == ufd.getJbtClose()) {
			
			FileDialog fdClose=new FileDialog(ufd, "파일저장", FileDialog.SAVE);
			fdClose.setVisible(true);
		}
			
			
		
			
			
			
//		}//end if
		
		
	}//actionPerformed

	
}//class
