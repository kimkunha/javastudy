package day1212;
//숙제 영민   -따라서 반복해볼것 -
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WorkEvent extends WindowAdapter implements ActionListener, ItemListener {
	private WorkDesign wd;
	
	public WorkEvent(WorkDesign wd) {
		this.wd = wd;
	} // WorkEvent
	
	@Override
	public void windowClosing(WindowEvent we) {
		wd.dispose();
	} // windowClosing
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		// list의 아이템을 클릭하면 선택한 값이 TextField에 입력된다.
		if (ie.getSource() == wd.getLstBoard()) {
			lstPrinted();
		} // end if
	} // itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 추가가 눌리면 이름, 나이, 주소를 List에 추가하고 TextField를 초기화한다.
		if (ae.getSource() == wd.getBtnAdd()) {
			// 추가할 때 TextField에서 빈 값이 있다면
			if (!(wd.getTfName().getText().isEmpty()) || 
				!(wd.getTfAge().getText().isEmpty()) || 
				!(wd.getTfAddr().getText().isEmpty())) {
				btnAdd();
			} // end if
		} // end if
		
		// 삭제가 눌려지면 list의 아이템이 선택되었는지 확인 후 TextField의 값과 일치하는 아이템을 삭제한다.
		if (ae.getSource() == wd.getBtnDelete()) {
			btnDelete();
		} // end if
		
		// 변경이 눌려지면 list의 아이템이 선택되었는지 확인 후 TextField의 값으로 해당 값을 수정한다.
		if (ae.getSource() == wd.getBtnUpdate()) {
			btnUpdate(); // 작성 대기
		} // end if
		
		// 닫기가 눌려지면 프로그램을 종료한다. (굳이 메서드를 만들 필요가 없지 않니?)
		if (ae.getSource() == wd.getBtnClose()) {
			wd.dispose();
		} // end if
		
	} // actionPerformed
	
	// -------------------- 버튼 메서드 선언 --------------------
	private void lstPrinted() {
		// list의 아이템을 클릭하면 선택한 값이 TextField에 입력된다.
		List tempList = wd.getLstBoard();
		
		String[] info = tempList.getSelectedItem().split(" / ");

		wd.getTfName().setText(info[0]);
		wd.getTfAge().setText(info[1]);
		wd.getTfAddr().setText(info[2]);
	} // lstPrinted
	
	private void btnAdd() {
		String tfName, tfAge, tfAddr;
		
		// TextField에 있는 이름, 나이, 주소의 값을 가져와서 
		tfName = wd.getTfName().getText();
		tfAge = wd.getTfAge().getText();
		tfAddr = wd.getTfAddr().getText();
		
		// List에 추가하고 
		wd.getLstBoard().add(tfName + " / " + tfAge + " / " + tfAddr);
		
		// TextField를 초기화한다.
		wd.getTfName().getText();
		wd.getTfAge().getText();
		wd.getTfAddr().getText();
		
		wd.getTfName().setText("");
		wd.getTfAge().setText("");
		wd.getTfAddr().setText("");
	} // btnAdd
	
	private void btnDelete() {
		List tempList = wd.getLstBoard();
		
		// 삭제가 눌려지면 list의 아이템이 선택되었는지 확인 후
		String[] info = tempList.getSelectedItem().split(" / ");
		
		int selectedIdx = tempList.getSelectedIndex();
		
		// TextField의 값과 일치하는 아이템을 삭제한다.
		if (info[0].equals(wd.getTfName().getText()) && 
			info[1].equals(wd.getTfAge().getText()) && 
			info[2].equals(wd.getTfAddr().getText())) {
			tempList.remove(selectedIdx);
		} // end if
	} // btnDelete
	
	private void btnUpdate() {
		List tempList = wd.getLstBoard();
		
		// 변경이 눌려지면 list의 아이템이 선택되었는지 확인 후 
		String tfName, tfAge, tfAddr;
		
		int selectedIdx = tempList.getSelectedIndex();
		
		// TextField의 값을 받아와서 
		tfName = wd.getTfName().getText();
		tfAge = wd.getTfAge().getText();
		tfAddr = wd.getTfAddr().getText();
		
		// 해당 list에 TextField의 값으로 수정한다. (변경은 삭제 → 추가의 작업이다.)
		tempList.remove(selectedIdx);
		tempList.add(tfName + " / " + tfAge + " / " + tfAddr, selectedIdx);
	} // btnUpdate
	
} // class
