package kr.co.sist.lunch.user.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchClientView;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchLIstVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;

public class LunchClientController extends WindowAdapter implements ActionListener, MouseListener {
   private LunchClientView lcv;
   private LunchClientDAO lc_dao;
   
   public static final int DBL_CLICK = 2;
   
   public LunchClientController(LunchClientView lcv) {
      this.lcv = lcv;
      
      lc_dao = LunchClientDAO.getInstance();
      
      try {
         // Ŭ���̾�Ʈ�� ���� �̹����� üũ�Ͽ� 
         String[] fileNames = lunchImageList();
         
         // ������ ����, ���� �̹����� ���� ��
         lunchImageSend(fileNames);
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } // end catch
      
      // JTable�� �����Ѵ�.
      setLunchList();
      
   } // LunchClientController
   
   @Override
   public void windowClosing(WindowEvent we) {
      lcv.dispose();
   } // windowClosing
   
   @Override
   public void windowClosed(WindowEvent we) {
      System.exit(JFrame.ABORT);
   } // windowClosed
   
   @Override
   public void mouseClicked(MouseEvent me) {
      if (lcv.getJtp().getSelectedIndex() == 0) {
         lcv.setTitle("���� ���ö� �ֹ�");
      } // end if
      
      if (lcv.getJtp().getSelectedIndex() == 1) {
         lcv.setTitle("���� ���ö� �ֹ� ��ȸ");
      } // end if
      
      if (me.getSource() == lcv.getJtLunch()) {
         switch (me.getClickCount()) {
         case DBL_CLICK:
            JTable jtab = lcv.getJtLunch();
            
            String lunch_code = (String) jtab.getValueAt(jtab.getSelectedRow(), 2);
            
            // ���ö� �� ���� ��ȸ
            try {
               LunchDetailVO ldvo = lc_dao.selectDetailLunch(lunch_code);
               
               if (ldvo == null) {
                  // �ڵ�� ��ȸ�� ����� ���� ��
                  msgCenter(lcv, lunch_code + "�� ��ȸ�� ���ö��� �������� �ʽ��ϴ�.");
               } else {
                  // �ڵ�� ��ȸ�� ����� ���� ��
                  new LunchOrderDetailView(lcv, ldvo);
               } // end else
            } catch (SQLException sqle) {
               msgCenter(lcv, "�� ���� ��ȸ �� ������ �߻��߽��ϴ�.");
               sqle.printStackTrace();
            } // end catch
         } // end switch
      } // end if
   } // mouseClicked
   
   @Override
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == lcv.getJtfName()) {
         lcv.getJtfTel().requestFocus();
      } // end if
      
      if (ae.getSource() == lcv.getJbtSearch() || ae.getSource() == lcv.getJtfTel()) {
         // �ֹ��� ���ö� ��� ��ȸ
         searchLunchOrder();
      } // end if
   } // actionPerformed
   
   private void msgCenter(Component comp, String msg) {
      JOptionPane.showMessageDialog(comp, msg);
   } // msgCenter
   
   /**
    * ���ö� ����� ��ȸ�Ͽ� JTable�� �����ϴ� ��
    * Ư������ 25�� �̻��̶�� 24�ڱ����� ����ϰ�, 
    * �������� ...���� �ٿ��� ����
    */
   private void setLunchList() {
      // ���ö� ��� ��ȸ
      try {
         List<LunchLIstVO> list = lc_dao.selectLunchList();
         
         DefaultTableModel dtm = lcv.getDtmLunchList();
         dtm.setRowCount(0);
         
         Object[] rowData = null;
         
         LunchLIstVO llvo = null;
         
         String clientPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/s_";
         
         String spec = "";
         
         for (int i = 0; i < list.size(); i++) {
            llvo = list.get(i);
            
            rowData = new Object[5];
            
            rowData[0] = new Integer(i + 1);
            rowData[1] = new ImageIcon(clientPath + llvo.getImg());
            rowData[2] = llvo.getLunchCode();
            rowData[3] = llvo.getLunchName();
            
            spec = llvo.getLunchSpec();
            
            if (spec.length() > 25) {
               spec = spec.substring(0, 24) + "...";
            } // end if
            
            rowData[4] = spec;
            
            dtm.addRow(rowData);
         } // end for
      } catch (SQLException sqle) {
         msgCenter(lcv, "���ö� ����� ��ȸ�ϴ� �� ������ �߻��߽��ϴ�.");
         sqle.printStackTrace();
      } // end catch
   } // setLunchList
   
   /**
    * �ֹ��ڸ�� ��ȭ��ȣ�� ������ ���ö��� ��ȸ
    */
   private void searchLunchOrder() {
      JTextField jtfName = lcv.getJtfName();
      
      String name = jtfName.getText().trim();
      
      if (name.equals("")) {
         msgCenter(lcv, "�ֹ��ڸ��� �ʼ� �Է��Դϴ�.");
         jtfName.setText("");
         jtfName.requestFocus();
         return;
      } // end if
      
      JTextField jtfTel = lcv.getJtfTel();
      
      String tel = jtfTel.getText().trim();
      
      if (tel.equals("")) {
         msgCenter(lcv, "��ȭ��ȣ�� �ʼ� �Է��Դϴ�.");
         jtfTel.setText("");
         jtfTel.requestFocus();
         return;
      } // end if
      
      try {
         // �Է°��� ����Ͽ� ��ȸ
         List<OrderListVO> list = lc_dao.selectOrderList(new OrderInfoVO(name, tel));
         
         // JTable ���
         DefaultTableModel dtmOrderList = lcv.getDtmOrderList();
         dtmOrderList.setRowCount(0);
         
         String[] rowData = null;
         
         OrderListVO olvo = null;
         
         for (int i = 0; i < list.size(); i++) {
            olvo = list.get(i);
            
            rowData = new String[4];
            rowData[0] = String.valueOf(i + 1);
            rowData[1] = olvo.getLunchName();
            rowData[2] = olvo.getOrderDate();
            rowData[3] = String.valueOf(olvo.getQuan());
            
            dtmOrderList.addRow(rowData);
         } // end for
         
         if (list.isEmpty()) {
            msgCenter(lcv, "�Է��� ������ ��ȸ�� ����� �����ϴ�.");
         } else {
            lcv.setTitle("���� ���ö� - ��ȸ [ " + name + "���� �ֹ���Ȳ ]");
         } // end else
         
         jtfTel.setText("");
         jtfName.setText("");
         jtfName.requestFocus();
      } catch (SQLException sqle) {
         msgCenter(lcv, "");
         sqle.printStackTrace();
      } // end catch
   } // searchLunchOrder
   
   /**
    * ���ö� �̹��� ����Ʈ
    */
   private String[] lunchImageList() {
      String[] fileList = null;
      
      String path = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";
      
      File dir = new File(path);
      
      List<String> list = new ArrayList<String>();

      for (String fileName : dir.list()) {
         if (!fileName.startsWith("s_")) {
            list.add(fileName);
         } // end if
      } // end for
      
      fileList = new String[list.size()];
      
      list.toArray(fileList);
      
      return fileList;
   } // lunchImageList
   
   /**
    * ������ �̹����� ������, ���� �̹����� �޴� ��
    * @param fileName
    */
   private void lunchImageSend(String[] fileNames) throws IOException {
      Socket socket = null;
      
      DataOutputStream dos = null;
      DataInputStream dis = null;
      
      FileOutputStream fos = null;
      
      int cnt = 0;
      
      try {
         socket = new Socket("211.63.89.137", 25000);
         
         dos = new DataOutputStream(socket.getOutputStream());
         dos.writeInt(fileNames.length);
         dos.flush();
         
         for (int i = 0; i < fileNames.length; i++) {
            // ������ ����
            dos.writeUTF(fileNames[i]);
            dos.flush();
         } // end for
         
         // ������ �������� ���� �� ����
         dis = new DataInputStream(socket.getInputStream());
         
         int fileCnt = dis.readInt();
         int fileSize = 0;
         int fileLen = 0;
         
         String fileName = "";
         String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";
         
         for (int i = 0; i < fileCnt; i++) {
            // ���޹��� ���� ������ ����
            fileSize = dis.readInt();
            
            // ���ϸ� �ޱ�
            fileName = dis.readUTF();
            
            fos = new FileOutputStream(imgPath + fileName);
            
            byte[] readData = new byte[512];
            
            while (fileSize > 0) {
               // �������� ������ ���� ������ �о�鿩 
               fileLen = dis.read(readData);
               
               // ������ ���Ϸ� ����Ѵ�.
               fos.write(readData, 0, fileLen);
               fos.flush();
               
               fileSize--;
            } // end while
         } // end for
      } finally {
         if (fos != null) { fos.close(); } // end if
         if (dis != null) { dis.close(); } // end if
         if (dos != null) { dos.close(); } // end if
         if (socket != null) { socket.close(); } // end if
      } // end finally
      
   } // lunchImageSend
   
   @Override
   public void mousePressed(MouseEvent e) { }

   @Override
   public void mouseReleased(MouseEvent e) { }

   @Override
   public void mouseEntered(MouseEvent e) { }

   @Override
   public void mouseExited(MouseEvent e) { }
   
   ////////////////////////////////////////////////////////////
   public LunchClientController() {
      try {
         // Ŭ���̾�Ʈ�� ���� �̹����� üũ�Ͽ� 
         String[] fileNames = lunchImageList();
         
         // ������ ����, ���� �̹����� ���� ��
         lunchImageSend(fileNames);
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } // end catch
   }
   
   public static void main(String[] args) {
      new LunchClientController();
      
   }
   
} // class