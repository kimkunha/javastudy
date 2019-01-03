package kr.co.sist.multichat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.co.sist.multichat.client.view.ClientChatView;
import kr.co.sist.multichat.client.view.ClientSelectUserView;

public class ClientChatEvt implements ActionListener {
    private ClientChatView ccv;
    public ClientChatEvt(ClientChatView ccv) {
        this.ccv = ccv;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==ccv.getJbConnect()) {
            
        }else if(ae.getSource()==ccv.getJbCapture()) {
            
        }else if(ae.getSource()==ccv.getJbClose()) {
            
        }else if(ae.getSource()==ccv.getJbUser()) {
            new ClientSelectUserView(ccv);
        }
    }

}