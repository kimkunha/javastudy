package day0109.work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CreateTableViewEvt extends WindowAdapter implements ActionListener {

	private CreateTableView ctv;
	private StringBuilder sql;
	private String tabName;
	private boolean firstColumnFlag;
	private boolean pkFlag;
	private List<String> listColumnName;
	
	public CreateTableViewEvt( CreateTableView ctv) {
		this.ctv=ctv;
		listColumnName =new ArrayList<String>();
		
	}//???±ì??
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ctv.getJbAddTab() || ae.getSource() == ctv.getJtfTabName()) {
			tabName = ctv.getJtfTabName().getText().trim(); //?´ë²¤?? ì²?ë¦¬ë? ë°????¨ê±¸ ê³µë°±ì²?ë¦?
			
			if( tabName != null && !tabName.equals("")) {
				createDefaultQuery( tabName);

				JTextArea jta= ctv.getJtaQueryView();
				jta.setText(sql.toString());
				jta.append( " ) ; " ) ;
				
				ctv.getJtfColName().requestFocus();
				
			}else {
				JOptionPane.showMessageDialog(ctv, "???´ë?ëª??? ???¥í?´ì£¼?¸ì??.");
				ctv.getJtfTabName().requestFocus();
			}//end else
		}//end if
		
		if( ae.getSource() == ctv.getJbAddCo1() || ae.getSource() == ctv.getJtfColName() 
			|| ae.getSource() == ctv.getJtfColSize() ||ae.getSource() == ctv.getJtfConstName()) {
			if(sql == null ) {
				JOptionPane.showMessageDialog(ctv, "???´ë??? ë¨¼ì?? ???±í?´ì£¼?¸ì??.");
				ctv.getJtfTabName().requestFocus();
				return;
			}//end if
			
			addColumnQuery();
			
			JTextArea jta= ctv.getJtaQueryView();
			jta.setText(sql.toString());
			jta.append( "\n ) ; " ) ;
			
		}//end if
			
		if(ae.getSource() == ctv.getJbCreateTab() ) {
			if( ctv.getJtaQueryView().getText().isEmpty() ) {
				JOptionPane.showMessageDialog(ctv, "???´ë??? ???±í?´ì£¼?¸ì??.");
				ctv.getJtfTabName().requestFocus();
				return;
			}//end if
			
			String createTable = sql.append( " ) " ).toString();
//			System.out.println(createTable);
			try {
					new CreateTableDAO(createTable, ctv);
			}catch(SQLException se) {
				JOptionPane.showMessageDialog(ctv, "?´ë?? ??ëª??? ???´ë??? ì¡´ì?¬í?©ë????.");
				se.printStackTrace();
			}//end catch
		}//end if
		
		if( ae.getSource() == ctv.getJbClean() ) {
			if( !ctv.getJtaQueryView().getText().isEmpty() ) {
				System.out.println(sql.toString());
				sql.setLength(0);
				System.out.println(sql.toString());
				ctv.getJtaQueryView().setText( "" );
				ctv.getJtfTabName().setText("");
				ctv.getJtfColName().setText("");
				ctv.getJtfColSize().setText("");
				ctv.getJtfConstName().setText("");
				listColumnName.clear();
				firstColumnFlag = false;
				pkFlag = false;
				
			}else {
				JOptionPane.showMessageDialog(ctv, "Query Viewê°? ?´ë?? ì´?ê¸°í?????? ???µë????.");
			}//end else
		}//end if
		
	}//actionPerformed

	public void createDefaultQuery( String tabName) {
		sql = new StringBuilder();
		sql.append( " CREATE TABLE " ).append(tabName).append( " ( " );
	}
	
	public void addColumnQuery( ) {
		
		//ì»¬ë?¼ë? - ????
		String colName = ctv.getJtfColName().getText().trim();
		if( colName.isEmpty()) {
			JOptionPane.showMessageDialog(ctv, "ì»¬ë?¼ë??? ???? ??????. ");
			ctv.getJtfColName().requestFocus();
			return;
		}//end if
		
		//zì»¬ë?¼ë? - ????, ì½¤ë³´ë°??¤ì?´ë??ë¡? ë¬´ì¡°ê±? ??????
		String colType = ctv.getJcbColType().getSelectedItem().toString();
		
		String colSize= "";
		//size - VARCHAR2, NUMBER?? ?? ????, DATE?? ????X(empty)
		if( ! colType.equals("DATE")) {
			colSize = ctv.getJtfColSize().getText().trim();
			if( colSize.isEmpty() ) {
				JOptionPane.showMessageDialog(ctv, "VARCHAR2, CHAR, NUMBER?? ?¬ê¸°?? ???? ??????. ");
				ctv.getJtfColSize().requestFocus();
				return;
			}//end if
			
			try {
				if( colType.equals("NUMBER") ) {
					if(Integer.parseInt( colSize ) > 22) {
						JOptionPane.showMessageDialog(ctv, "NUMBER?? ìµ????¬ê¸°?? 22??????.");
						ctv.getJtfColSize().setText(" ");
						ctv.getJtfColSize().requestFocus();
						return;
						
					}//end if
				}//end if
				
				if( colType.equals( " CHAR " )) {
					if(Integer.parseInt(colSize) > 2000 ) {
						JOptionPane.showMessageDialog(ctv, "CHAR?? ìµ??? ?¬ê¸°?? 2000??????.");
						ctv.getJtfColSize().setText(" ");
						ctv.getJtfColSize().requestFocus();
						return;
					}//end if
					
				}//end if
				
				if( colType.equals( " VARCHAR2 " ) ) {
					if(Integer.parseInt( colSize ) > 4000 ) {
						JOptionPane.showMessageDialog(ctv, "VARCHAR2??ìµ??? ?¬ê¸°?? 4000??????.");
						ctv.getJtfColSize().setText( " " );
						ctv.getJtfColSize().requestFocus();
						return;
					}//end if
				}//end if
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(ctv, "?¬ê¸°?? ?«ì??ë§? ???¥ê??¥í?©ë????.");
				ctv.getJtfColSize().setText( " ");
				ctv.getJtfColSize().requestFocus();
				return;
			}//end catch
			
		}else {
			if( !ctv.getJtfColSize().getText().isEmpty() ) {
				JOptionPane.showMessageDialog(ctv, "DATE???? ?¬ê¸°ê°? ???µë????.");
				ctv.getJtfColSize().setText( " " );
				ctv.getJtfColSize().requestFocus();
				return;
			}//end if
			
		}//end else
		
	
	//???½ì?¬í?? ????
	String colConstraint = ctv.getJcbConstraint().getSelectedItem().toString();
	
	// NULL, NOT NULL ?¼ë?? ???½ì?¬í??ëª? ????, PK, FK, UNIQUE?¼ë?? ????
	String colConstName="";
		if( !(colConstraint.equals("NULL") || colConstraint.equals("NOT NULL") ) ) {
			colConstName = ctv.getJtfConstName().getText().trim();
			
			if(pkFlag) {
				JOptionPane.showMessageDialog(ctv, "PK?? ?´ë?? ?¤ì?????¨ì?µë????.");
				ctv.getJcbConstraint().requestFocus();
				return;
			}//end if
			
			if( colConstName.equals(" ")) {
				JOptionPane.showMessageDialog(ctv, colConstraint+" ???½ì?¬í??ëª??? ??????????.");
				ctv.getJtfConstName().requestFocus();
				return;
			}//end if
			
		}else {
			if( !ctv.getJtfConstName().getText().isEmpty() ) {
				JOptionPane.showMessageDialog(ctv, "NULL, NOT NULL?? ???½ì?¬í??ëª??? ???µë????.");
				ctv.getJtfConstName().setText("");
				ctv.getJtfConstName().requestFocus();
				return;
			}//end if
		}//end else
		
		for(String addedColName : listColumnName ) {
			if( colName.equals( addedColName ) ) {
				JOptionPane.showMessageDialog(ctv, "ì¤?ë³µë?? ì»¬ë?¼ë???????.");
				return;
			}//end if
		}//end for
	//ê²?ì¦??? ?????? sql?? ì¶?ê°?
		if(firstColumnFlag ) {
			sql.append( " ,  " );
		}//end if
		
		sql
		.append( "\n      ").append( colName ).append( "  " )
		.append( colType );
		
		if( !colSize.isEmpty() ) {
			sql.append( " ( " ).append( colSize ).append( " )  " );
		}else {
			sql.append( "  " );
		}//end else
		
		if( !colConstName.isEmpty() ) {
			if(colConstraint.equals( " PRIMARY KEY " ) ) {
				sql
				.append( " CONSTRAINT  " )
				.append( colConstName )
				.append( " PRIMARY KEY" );
				pkFlag= true;
			}//end if
		}else {
			sql.append( colConstraint );
		}//end else
	
		listColumnName.add(colName);
	}//addColumnQuery
	
	@Override
	public void windowClosed(WindowEvent e) {
		ctv.dispose();
	}//windowClosed
}//class
