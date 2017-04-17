package EngWords;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EngWordsGUI extends JFrame implements ActionListener{

    private JTextField jtfAnswer = new JTextField();
    private JLabel lblAsk = new JLabel();
    private JButton btnOk = new JButton("Ok");
    private JButton btnNewWords = new JButton("Új szavak felvitele");
    private JButton btnNew = new JButton("Új kérdés");
    private JButton btnExit = new JButton("Kilépés");
    private ArrayList<Words> szavak = new ArrayList<>();
    private Words kerdezett = new Words("", "", 1);
    
    public EngWordsGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);        
        //setLayout(new GridLayout(2, 1));
        JPanel jpController = new JPanel();            
        jpController.add(btnExit);        
        add(jpController, BorderLayout.PAGE_END);
        JPanel jp = new JPanel();
        
        jp.setLayout(new GridLayout(5,1));    
        jp.add(btnNewWords);        
        jp.add(btnNew);
        lblAsk.setText("Ez lesz a kérdés");
        jp.add(lblAsk);
        jtfAnswer.setSize(new Dimension(jp.getSize().width-20, 30));
        jp.add(jtfAnswer);
        btnOk.setEnabled(false);
        jp.add(btnOk);
        add(jp);
        btnOk.addActionListener(this);
        btnNew.addActionListener(this);
        btnNewWords.addActionListener(this);
        btnExit.addActionListener(this);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {        
        if (ae.getSource() == btnNew) {
            Random r = new  Random();
            int num = r.nextInt(szavak.size());
            kerdezett = szavak.get(num);
            lblAsk.setText(kerdezett.getAngol());
            btnOk.setEnabled(true);
        }
        if (ae.getSource() == btnNewWords) {
            NewWords p = new NewWords();            
//            String e = v[0];
//            String m = v[1];
//            //String l = p.showDialog();
//            int i = 1;
            ArrayList<Words> nw = p.showDialog();
            for (Words words : nw) {                            
                szavak.add(words);
            }
        }
        if (ae.getSource() == btnOk) {
            Uzenet u = new Uzenet(kerdezett.helyes(kerdezett.getAngol(), jtfAnswer.getText()));
            u.showUzenet();
            btnOk.setEnabled(false);            
        }
        if (ae.getSource() == btnExit) {
            System.exit(0);
        }        
    }
    
    public static void main(String[] args) {
//        String english, hungarian;
//        int lection;
//        Scanner sc= new Scanner(System.in);
//        do {
//            System.out.print("Kérem a következő angol szót: ");
//            english = sc.nextLine();         
//            System.out.println("Kérem a magyar megfelelőjét: ");
//            hungarian= sc.nextLine();
//            System.out.println("Kérem a leckeszámot: ");
//            lection=sc.nextInt();
//            sc.nextLine();
//            wordList.add(new Words(english,hungarian,lection));
//        } while (!english.isEmpty());
        new EngWordsGUI();        
    }
        
}
