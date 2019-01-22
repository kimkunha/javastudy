package kr.co.sist.admin.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.run.LunchAdminMain;

public class FileServer extends Thread {
   @Override
   public void run() {
      ServerSocket server = null;
      
      try {
         try {
            server = new ServerSocket(25000);
            
            Socket client = null;
            
            DataInputStream dis = null;
            DataOutputStream dos = null;
            
            int cnt = 0;
            
            String[] fileNames = null;
            String[] serverfileNames = null;
            
            List<String> tempFileList = new ArrayList<String>();
            
            while (true) {
               client = server.accept();
               
               dis = new DataInputStream(client.getInputStream());
               
               // 클라이언트가 보내오는 파일명의 수
               cnt = dis.readInt();
               
               fileNames = new String[cnt];
               
               for (int i = 0; i < cnt; i++) {
                  fileNames[i] = dis.readUTF();
               } // end for
               
               // 서버에 존재하는 파일명을 배열로 복사
               serverfileNames = new String[LunchAdminMain.lunchImageLIst.size()];
               
               LunchAdminMain.lunchImageLIst.toArray(serverfileNames);
               //클라이언트가 없는 파일명을 출력
               for (String tName : LunchAdminMain.lunchImageLIst) {
                  tempFileList.add(tName);
                  tempFileList.add("s_"+tName);
               } // end for
               for (String rmName : fileNames) {
                  tempFileList.remove(rmName);
               } // end for
               
               dos = new DataOutputStream(client.getOutputStream());
               
               // 전송할 파일의 개수를 보낸다.
               dos.writeInt(tempFileList.size());
               dos.flush();
               
               for (String fName : tempFileList) {
                  fileSend(fName, dos);
                  
                  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  
               } // end for
            } // end while
         } finally {
            if (server != null) { server.close(); } // end if
         } // end finally
      } catch (IOException ioe) {
         JOptionPane.showMessageDialog(null, "파일 전송 실패");
         ioe.printStackTrace();
      } // end catch
   } // run
   
   private void fileSend(String fName, DataOutputStream dos) throws IOException {
      FileInputStream fis = null;
      
      try {
         String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";
         
         fis = new FileInputStream(imgPath + fName);
         
         int fileLen = 0;
         int fileData = 0;
         
         byte[] readData = new byte[512];
         
         while ((fileLen = fis.read(readData)) != -1) {
            fileData++;
         } // end while
         
         fis.close();
         
         dos.writeInt(fileData);
         dos.flush();
         
         dos.writeUTF(fName);
         dos.flush();
         
         fis = new FileInputStream(imgPath + fName);
         
         while ((fileLen = fis.read(readData)) != -1) {
            dos.write(readData, 0, fileLen);
            dos.flush();
            fileData--;
         } // end while
      } finally {
         if (fis != null) { fis.close(); } // end if
      } // end finally
      
   } // fileSend
   
} // class