package kr.co.sist.multichat.client.view;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import kr.co.sist.multichat.client.evt.ClientSelectTeamEvt;

@SuppressWarnings("serial")
public class ClientSelectTeamView extends JFrame {

   private JPanel topPanel, teamPanel;
   private JLabel jrSelectTeam;
   private JRadioButton jrTeam1, jrTeam2, jrTeam3, jrTeam4;
   private ButtonGroup gpTeam;
   private JButton jbConnect;

   public ClientSelectTeamView() {
      super("채팅방 선택");
      topPanel = new JPanel();
      teamPanel = new JPanel();
      jrSelectTeam = new JLabel("채팅방 선택");
      jrTeam1 = new JRadioButton("1조");
      jrTeam2 = new JRadioButton("2조");
      jrTeam3 = new JRadioButton("3조");
      jrTeam4 = new JRadioButton("4조");
      jbConnect = new JButton("접속");
      gpTeam = new ButtonGroup();

      topPanel.add(jrSelectTeam);

      gpTeam.add(jrTeam1);
      gpTeam.add(jrTeam2);
      gpTeam.add(jrTeam3);
      gpTeam.add(jrTeam4);

      teamPanel.add(jrTeam1);
      teamPanel.add(jrTeam2);
      teamPanel.add(jrTeam3);
      teamPanel.add(jrTeam4);

      jrSelectTeam.setBounds(65, 20, 100, 30);
      add(jrSelectTeam);
      teamPanel.setBounds(30, 60, 50, 130);
      add(teamPanel);
      jbConnect.setBounds(65, 200, 60, 50);
      add(jbConnect);
      
      ClientSelectTeamEvt cste = new ClientSelectTeamEvt(this);
      jrTeam1.addItemListener(cste);
      jrTeam2.addItemListener(cste);
      jrTeam3.addItemListener(cste);
      jrTeam4.addItemListener(cste);
      jbConnect.addActionListener(cste);

      setLayout(null);
      setBounds(100, 100, 200, 300);
      setResizable(false);
      setVisible(true);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public JRadioButton getJrTeam1() {
      return jrTeam1;
   }

   public JRadioButton getJrTeam2() {
      return jrTeam2;
   }


   public JRadioButton getJrTeam3() {
      return jrTeam3;
   }

   public JRadioButton getJrTeam4() {
      return jrTeam4;
   }
   
public static void main(String[] args) {
	new ClientSelectTeamView();
}
}