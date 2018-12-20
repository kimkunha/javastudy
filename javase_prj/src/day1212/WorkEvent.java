package day1212;
//���� ����   -���� �ݺ��غ��� -
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
		// list�� �������� Ŭ���ϸ� ������ ���� TextField�� �Էµȴ�.
		if (ie.getSource() == wd.getLstBoard()) {
			lstPrinted();
		} // end if
	} // itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		// �߰��� ������ �̸�, ����, �ּҸ� List�� �߰��ϰ� TextField�� �ʱ�ȭ�Ѵ�.
		if (ae.getSource() == wd.getBtnAdd()) {
			// �߰��� �� TextField���� �� ���� �ִٸ�
			if (!(wd.getTfName().getText().isEmpty()) || 
				!(wd.getTfAge().getText().isEmpty()) || 
				!(wd.getTfAddr().getText().isEmpty())) {
				btnAdd();
			} // end if
		} // end if
		
		// ������ �������� list�� �������� ���õǾ����� Ȯ�� �� TextField�� ���� ��ġ�ϴ� �������� �����Ѵ�.
		if (ae.getSource() == wd.getBtnDelete()) {
			btnDelete();
		} // end if
		
		// ������ �������� list�� �������� ���õǾ����� Ȯ�� �� TextField�� ������ �ش� ���� �����Ѵ�.
		if (ae.getSource() == wd.getBtnUpdate()) {
			btnUpdate(); // �ۼ� ���
		} // end if
		
		// �ݱⰡ �������� ���α׷��� �����Ѵ�. (���� �޼��带 ���� �ʿ䰡 ���� �ʴ�?)
		if (ae.getSource() == wd.getBtnClose()) {
			wd.dispose();
		} // end if
		
	} // actionPerformed
	
	// -------------------- ��ư �޼��� ���� --------------------
	private void lstPrinted() {
		// list�� �������� Ŭ���ϸ� ������ ���� TextField�� �Էµȴ�.
		List tempList = wd.getLstBoard();
		
		String[] info = tempList.getSelectedItem().split(" / ");

		wd.getTfName().setText(info[0]);
		wd.getTfAge().setText(info[1]);
		wd.getTfAddr().setText(info[2]);
	} // lstPrinted
	
	private void btnAdd() {
		String tfName, tfAge, tfAddr;
		
		// TextField�� �ִ� �̸�, ����, �ּ��� ���� �����ͼ� 
		tfName = wd.getTfName().getText();
		tfAge = wd.getTfAge().getText();
		tfAddr = wd.getTfAddr().getText();
		
		// List�� �߰��ϰ� 
		wd.getLstBoard().add(tfName + " / " + tfAge + " / " + tfAddr);
		
		// TextField�� �ʱ�ȭ�Ѵ�.
		wd.getTfName().getText();
		wd.getTfAge().getText();
		wd.getTfAddr().getText();
		
		wd.getTfName().setText("");
		wd.getTfAge().setText("");
		wd.getTfAddr().setText("");
	} // btnAdd
	
	private void btnDelete() {
		List tempList = wd.getLstBoard();
		
		// ������ �������� list�� �������� ���õǾ����� Ȯ�� ��
		String[] info = tempList.getSelectedItem().split(" / ");
		
		int selectedIdx = tempList.getSelectedIndex();
		
		// TextField�� ���� ��ġ�ϴ� �������� �����Ѵ�.
		if (info[0].equals(wd.getTfName().getText()) && 
			info[1].equals(wd.getTfAge().getText()) && 
			info[2].equals(wd.getTfAddr().getText())) {
			tempList.remove(selectedIdx);
		} // end if
	} // btnDelete
	
	private void btnUpdate() {
		List tempList = wd.getLstBoard();
		
		// ������ �������� list�� �������� ���õǾ����� Ȯ�� �� 
		String tfName, tfAge, tfAddr;
		
		int selectedIdx = tempList.getSelectedIndex();
		
		// TextField�� ���� �޾ƿͼ� 
		tfName = wd.getTfName().getText();
		tfAge = wd.getTfAge().getText();
		tfAddr = wd.getTfAddr().getText();
		
		// �ش� list�� TextField�� ������ �����Ѵ�. (������ ���� �� �߰��� �۾��̴�.)
		tempList.remove(selectedIdx);
		tempList.add(tfName + " / " + tfAge + " / " + tfAddr, selectedIdx);
	} // btnUpdate
	
} // class
