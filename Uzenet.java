package EngWords;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Uzenet extends JDialog{
    
    Uzenet(boolean k){
        JButton btnOk = new JButton("Ok");
        JLabel lbMessage = new JLabel();
        if (k) {
            lbMessage.setText("Helyes válasz");
        } else {
            lbMessage.setText("Hibás válasz");
        }
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        setLayout(new FlowLayout());
        add(lbMessage,BorderLayout.PAGE_START);
        add(btnOk, BorderLayout.PAGE_END);
        pack();
    }
    
    public void showUzenet(){
        setModal(true);
        setVisible(true);
        
    }
}
