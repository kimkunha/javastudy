package kr.co.sist.multichat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import kr.co.sist.multichat.client.view.ClientChatView;
import kr.co.sist.multichat.client.view.ClientSelectTeamView;

public class ClientSelectTeamEvt implements ActionListener, ItemListener {
   private String selectTeam;
   private ClientSelectTeamView cstv;
   
   public ClientSelectTeamEvt(ClientSelectTeamView cstv) {
      this.cstv = cstv;
   }
   
   @Override
   public void actionPerformed(ActionEvent ae) {
      if(!(selectTeam.isEmpty())){
         System.out.println(selectTeam);
      }else {
         JOptionPane.showMessageDialog(cstv, "조를 선택해주세요.");         
      }
      
   }

   @Override
   public void itemStateChanged(ItemEvent ie) {
      if (ie.getSource() == cstv.getJrTeam1()) {
         selectTeam = "1조";
         new ClientChatView();
      } else if (ie.getSource() == cstv.getJrTeam2()) {
         selectTeam = "2조";
      } else if (ie.getSource() == cstv.getJrTeam3()) {
         selectTeam = "3조";
      } else if (ie.getSource() == cstv.getJrTeam4()) {
         selectTeam = "4조";
      }
   }

}