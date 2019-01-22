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
         // 클라이언트가 가진 이미지를 체크하여 
         String[] fileNames = lunchImageList();
         
         // 서버로 보내, 없는 이미지를 받은 후
         lunchImageSend(fileNames);
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } // end catch
      
      // JTable을 갱신한다.
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
         lcv.setTitle("재찬 도시락 주문");
      } // end if
      
      if (lcv.getJtp().getSelectedIndex() == 1) {
         lcv.setTitle("재찬 도시락 주문 조회");
      } // end if
      
      if (me.getSource() == lcv.getJtLunch()) {
         switch (me.getClickCount()) {
         case DBL_CLICK:
            JTable jtab = lcv.getJtLunch();
            
            String lunch_code = (String) jtab.getValueAt(jtab.getSelectedRow(), 2);
            
            // 도시락 상세 정보 조회
            try {
               LunchDetailVO ldvo = lc_dao.selectDetailLunch(lunch_code);
               
               if (ldvo == null) {
                  // 코드로 조회된 결과가 없을 때
                  msgCenter(lcv, lunch_code + "로 조회된 도시락이 존재하지 않습니다.");
               } else {
                  // 코드로 조회된 결과가 있을 때
                  new LunchOrderDetailView(lcv, ldvo);
               } // end else
            } catch (SQLException sqle) {
               msgCenter(lcv, "상세 정보 조회 중 문제가 발생했습니다.");
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
         // 주문한 도시락 목록 조회
         searchLunchOrder();
      } // end if
   } // actionPerformed
   
   private void msgCenter(Component comp, String msg) {
      JOptionPane.showMessageDialog(comp, msg);
   } // msgCenter
   
   /**
    * 도시락 목록을 조회하여 JTable에 설정하는 일
    * 특장점이 25자 이상이라면 24자까지만 출력하고, 
    * 나머지는 ...으로 붙여서 설정
    */
   private void setLunchList() {
      // 도시락 목록 조회
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
         msgCenter(lcv, "도시락 목록을 조회하는 중 문제가 발생했습니다.");
         sqle.printStackTrace();
      } // end catch
   } // setLunchList
   
   /**
    * 주문자명과 전화번호를 가지고 도시락을 조회
    */
   private void searchLunchOrder() {
      JTextField jtfName = lcv.getJtfName();
      
      String name = jtfName.getText().trim();
      
      if (name.equals("")) {
         msgCenter(lcv, "주문자명은 필수 입력입니다.");
         jtfName.setText("");
         jtfName.requestFocus();
         return;
      } // end if
      
      JTextField jtfTel = lcv.getJtfTel();
      
      String tel = jtfTel.getText().trim();
      
      if (tel.equals("")) {
         msgCenter(lcv, "전화번호는 필수 입력입니다.");
         jtfTel.setText("");
         jtfTel.requestFocus();
         return;
      } // end if
      
      try {
         // 입력값을 사용하여 조회
         List<OrderListVO> list = lc_dao.selectOrderList(new OrderInfoVO(name, tel));
         
         // JTable 출력
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
            msgCenter(lcv, "입력한 정보로 조회된 결과가 없습니다.");
         } else {
            lcv.setTitle("재찬 도시락 - 조회 [ " + name + "님의 주문현황 ]");
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
    * 도시락 이미지 리스트
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
    * 서버로 이미지를 보내고, 없는 이미지를 받는 일
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
            // 서버로 전송
            dos.writeUTF(fileNames[i]);
            dos.flush();
         } // end for
         
         // 서버가 보내오는 파일 수 저장
         dis = new DataInputStream(socket.getInputStream());
         
         int fileCnt = dis.readInt();
         int fileSize = 0;
         int fileLen = 0;
         
         String fileName = "";
         String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";
         
         for (int i = 0; i < fileCnt; i++) {
            // 전달받을 파일 조각의 개수
            fileSize = dis.readInt();
            
            // 파일명 받기
            fileName = dis.readUTF();
            
            fos = new FileOutputStream(imgPath + fileName);
            
            byte[] readData = new byte[512];
            
            while (fileSize > 0) {
               // 서버에서 전송한 파일 조각을 읽어들여 
               fileLen = dis.read(readData);
               
               // 생성한 파일로 기록한다.
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
         // 클라이언트가 가진 이미지를 체크하여 
         String[] fileNames = lunchImageList();
         
         // 서버로 보내, 없는 이미지를 받은 후
         lunchImageSend(fileNames);
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } // end catch
   }
   
   public static void main(String[] args) {
      new LunchClientController();
      
   }
   
} // class