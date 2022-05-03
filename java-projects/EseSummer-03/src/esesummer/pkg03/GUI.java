package esesummer.pkg03;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class GUI extends JFrame{
    JPanel panel = new JPanel();
    JTextField textbox = new JTextField(50);
    JTextArea testo = new JTextArea("Il cane mangia il gatto come il topo mangia il cane");
    String array = "Il cane mangia il gatto come il topo mangia il cane";
    JTextPane prova = new JTextPane();
    
    public GUI(){
        textbox.getDocument().addDocumentListener(new MyDocumentListener(prova));
        
        prova.setContentType("text/html");
        prova.setText("Il cane mangia il gatto come il topo mangia il cane");
        /*panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        
        panel.add(textbox);
        panel.add(testo);
        */
        this.add(textbox,"North");
        //this.add(testo,"Center");
        this.add(prova,"Center");
        
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
