package day1212;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.12  -1��° �ڷ�- (  )
/**
 *	Keyboard Event ó��
 * @author owner
 */
//1. Window component ���, �̺�Ʈ ó�� �����ʸ� ����
@SuppressWarnings("serial")
public class UseKeyListener extends Frame implements KeyListener{
	
	public static final int ENTER=10;

//2. �̺�Ʈ�� �����ִ� ������Ʈ ����
	private TextField tf;
	private Label lbl;
	
	public UseKeyListener() {
		super("Ű���� �̺�Ʈ�� ����");
	//3. ������Ʈ ����	
		tf=new TextField();
		lbl=new Label("���â",Label.CENTER );  //���� ����� ����
		
	//4. ��ġ	
		setLayout(new BorderLayout());
		add("North",tf);
		add("Center", lbl);
		
	//5. ������Ʈ�� �̺�Ʈ�� ���
		tf.addKeyListener( this );
		
	//6. ������ ũ�� ����
		setBounds(100, 100, 400, 150);
		
	//7. ����ڿ��� �����ֱ� (����ȭ)
		setVisible(true);
		
	//8. ������ ����ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
	}//UsedKeyListener
	

	@Override
	public void keyTyped(KeyEvent ke) {
	//2. Ű�� ���� ������ ���޵Ǵ� ����. ���� Ű�� ������ ���ڸ� �� �� �� �ִ�.
//		System.out.println("KeyTyped");
	}//KeyTyped

	@Override
	public void keyPressed(KeyEvent ke) { 
	//1. Ű������ Ű�� ������ �����̾ Ű�� ������ �˼� ����.
//		System.out.println("KeyPressed");
	}//KeyPressed

	@Override
	public void keyReleased(KeyEvent ke) {
	//3. ���� Ű�� ������ �����ϰ� �ٽ� �ö���� ����. ����Ű�� ������ �˼� �ִ�.
//		System.out.println("KeyEvent");
		
		//����Ű�� ���ڿ� �ڵ尪�� ���
		char inputKey=ke.getKeyChar();
		int inputCode=ke.getKeyCode(); 
		//keyCode�� Ű���� Ű�� ������ : uniCode�� �ٸ��� ���� ���� ���´�.
//		System.out.println(inputKey+" "+inputCode);
//		//��� Label�� �Ѹ���.
		StringBuilder output=new StringBuilder();
		output.append("����Ű ���� : ").append(inputKey).append(", ����Ű�� Ű�ڵ� : ").append(inputCode);
		
		lbl.setText( output.toString());
		
		switch (inputCode) {
		case ENTER :
				//JDK1.7���� �߻��� ���� : TextField, TextArea�� setText("")�� �ٷ� ����ϸ� �ʱ�ȭ ���� �ʴ´�.
				tf.getText(); //���� �ѹ� ����
				tf.setText(""); //�ʱ�ȭ�� �ϸ� �ʱ�ȭ�� �� �ȴ�.
			break;
		case KeyEvent.VK_ESCAPE :
			dispose();
		}//	end switch	
			
	
	}//KeyReleased

	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new UseKeyListener();
		
		
	}//main
}//class
