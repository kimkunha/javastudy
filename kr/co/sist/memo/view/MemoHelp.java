package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;

import kr.co.sist.memo.evt.MemoHelpEvt;

/**
 *	헬프창에 다이얼로그를 띄우기
 *	메모장 정보
 *	이 메모장은 java로 만들어졌으며 누구나 코드 수정 및 배포를 할수 있습니다.
 *	단, 이코드를 사용하여 개선했을때에는 소스공개를 원칙으로한다. GNM
 *	작성자 : 정택성
 *	Version : 1.0 
 * @author owner
 */
//상속
@SuppressWarnings("serial")
public class MemoHelp extends Dialog {
	//선언
	private JavaMemo jm;
	private Button btnHelp;
	private TextArea taMsg;
	
		public MemoHelp(JavaMemo jm ) {
			super( jm, "도움말" ,true);
			this.jm=jm;
			
			//생성
			btnHelp= new Button("확인");
			taMsg=new TextArea("메모장 정보\n"
					+ "헬프창에 다이얼로그를 띄우기메모장 정보이 메모장은 java로 만들어졌으며\n"
					+ "누구나 코드 수정 및 배포를 할수 있습니다.단, 이코드를 사용하여 개선했을때에는\n"
					+ "소스공개를 원칙으로한다. GNM작성자 : 정택성Version : 1.0 ");
			
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
