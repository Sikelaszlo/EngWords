/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EngWords;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class NewWords extends JDialog{
    String angol;
    String magyar;
    JTextField tfAngol = new JTextField(15);
    JTextField tfMagyar = new JTextField(15);
    private ArrayList<Words> ujLista = new ArrayList<>();
        
	NewWords()
	{
		JButton btnOk = new JButton("Rögzít");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                            angol = tfAngol.getText();				
                            magyar = tfMagyar.getText();             
                            if (!ujLista.contains(new Words(angol, magyar,1)))
                                ujLista.add(new Words(angol, magyar, 1));
//                            System.out.println(ujLista);
                            tfAngol.setText("");
                            tfMagyar.setText("");
                            
			}
		});
                JButton btnEnd = new JButton("Bezár");
                btnEnd.addActionListener(new ActionListener() {                 
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        setVisible(false);
                    }
                });
		add(new JLabel("Angol: "));
		add(tfAngol);
                add(new JLabel("Magyar: "));
                add(tfMagyar);
		add(btnOk);
                add(btnEnd);
		setLayout(new FlowLayout());
		pack();
	}
	public ArrayList<Words> showDialog()
	{
		setModal(true);
		setVisible(true);                
//                String[] szavak = new String[2];
//                szavak[0] = angol;
//                szavak[1] = magyar;
		return ujLista;		
	}
}
