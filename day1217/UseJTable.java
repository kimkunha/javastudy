package day1217;
//18.12.17 -1번 자료- ( JTable)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *	MVC Pattern이 적용된 class
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener{
private JButton btnAdd;
private DefaultTableModel dtm;
private JTable jt;
private UseJTable ujt;
	public UseJTable() {
		super("JTable 연습");
		ujt=this;	
	//1.데이터를 관리하는 Model 클래스 생성
		String[] columnNames= {"번호", "이름", "주소", "이메일"};
		String[][] rowData= {   {"1","이재찬","인천시 소래동","chan@test.com"},
									 {"2","정택성","서울시 구로동","teack@test.com"},
									 {"3","정택성","경기도 안양시","hyun@test.com"}
		};
		dtm=new DefaultTableModel(rowData, columnNames) {
		//셀을 더블클릭 했을경우 편집을 불가능 하게 만드는 method 어나니먼스로 클래스로 정의했다.
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
			}	
		};
	
		//2. 데이터를 보여주는 View 클래스 생성
			jt=new JTable(dtm);
		//2-2. 테이블 컬럼의 크기 변경 : 컬럼은 하나의  넓이를 변경하면 하위 모든 컬럼은 동일한 크기를 적용 받게 된다.
			//컬럼 크기 변경 1. : 컬럼을 얻는다.
				TableColumn tc=jt.getColumnModel().getColumn(0);			//테이블 컬럼의 객체를 사용
//			컬럼 크기 변경 2. : 컬럼의 크기변경.
				tc.setPreferredWidth(10);												//크기변경하는 Method
			//2줄 사용하면 코드가 길어지니 따로 객체생성없이 아래와 같이 사용할수 있다.
				
//				jt.getColumnModel().getColumn(0).setPreferredWidth(10);	
				jt.getColumnModel().getColumn(1).setPreferredWidth(30);	
				jt.getColumnModel().getColumn(2).setPreferredWidth(100);
				jt.getColumnModel().getColumn(3).setPreferredWidth(150);
				
		//2-3. 테이블의 행의 높이
				jt.setRowHeight(25);
				
			btnAdd=new JButton("데이터 추가");
			//2-1. Column의 이름과 ScrollBar를 사용 할 수 있도록 JScrollPane에 배치
				JScrollPane jsp=new JScrollPane(jt);
				JPanel jp=new JPanel();
				jp.add(btnAdd);
			
		//3. 배치
			add("Center", jsp);
			add("South", jp);
			setBounds(100, 100, 500, 300);
		//3-1. 이벤트등록
			btnAdd.addActionListener(this);
			//inner 클래스 객체화
			UseJTable.TableEvt te= this.new TableEvt();
			jt.addMouseListener(te);
	
			
		//4. 가시화
			setVisible(true);
		//5. 종료처리
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}//UseJTable
	

@Override
public void actionPerformed(ActionEvent ae) {
	String inputData=JOptionPane.showInputDialog("데이터입력\n예)번호,이름,주소,이메일");
	String[] tempData=inputData.split(",");
	//유효성검증 콤마를 기준으로 4개 를 넣어야한다 
	if(tempData.length !=4) {
		JOptionPane.showMessageDialog(this, "입력데이터의 형태는 \n번호,이름,주소,이메일 이어야 합니다", "입력오류", JOptionPane.ERROR_MESSAGE);
		return;	//method void인경우 return인경우는 더 내려가지 말고 호출한곳으로 돌아가라.
	}//end if
	//입력된 데이터를 화면에 보여주기 위해 DefaultTableModel에 추가(행추가)
	dtm.addRow(tempData);
	
	
}//actionPerformed

//////////////////////////////////////////////////////////// inner class 시작 ////////////////////////////////////////////////////////////////////
public class TableEvt extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent me) {
//		System.out.println("행선택 : "+jt.getSelectedRow()+", 열선택 : "+jt.getSelectedColumn());	//선택한 행과 열을 아는 method
		System.out.println(jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn())); 	//행과 열 위치에 있는 값을 얻는 method (값을 하나 뽑는 경우)
//		String selectedValue=(String)jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());
//		String selectedValue0=(String)jt.getValueAt(jt.getSelectedRow(), 0);
//		String selectedValue1=(String)jt.getValueAt(jt.getSelectedRow(), 1);
//		String selectedValue2=(String)jt.getValueAt(jt.getSelectedRow(), 2);
//		String selectedValue3=(String)jt.getValueAt(jt.getSelectedRow(), 3);
		
		StringBuilder viewData=new StringBuilder();
		int selectedRow=jt.getSelectedRow();
		int columnCount=jt.getColumnCount();
		
		//행 삭제하기
		int flag=JOptionPane.showConfirmDialog(ujt, "예를 누르면 조회, 아니오 누르면 삭제를 수행합니다.");
		switch (flag) {
		case JOptionPane.OK_OPTION :
			for(int i=0; i< columnCount; i++) {
				viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
			}//end for
			
			JOptionPane.showMessageDialog(ujt , viewData);
			break;
			
		case JOptionPane.NO_OPTION :
			
			switch (JOptionPane.showConfirmDialog(ujt, "정말 삭제하시겠습니까?")) {
			case JOptionPane.OK_OPTION : 
				dtm.removeRow(selectedRow);
			}//end switch

		}//end switch
	}//mousClicked
	
//		for(int i=0; i< columnCount; i++) {
//			viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
//		}//end for
//		
//			JOptionPane.showMessageDialog(ujt , viewData);
//	}//mouseClicked
	
}//class
//////////////////////////////////////////////////////////// inner class 끝 //////////////////////////////////////////////////////////////////////


public static void main(String[] args) {
	new UseJTable();
	}//main
}//class
