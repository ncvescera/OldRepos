package esesummer.pkg03;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class MyDocumentListener implements DocumentListener{
    
    private JTextPane testo;
    
    public MyDocumentListener(JTextPane testo){
        this.testo = testo;
    }
    
    //metodi da sovrascrivere di DocumentListener
    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            /*try {
            System.out.println(getTextFieldText(e));
            } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            String[] da_stampare = getMetchedWords(this.testo.getText(), getStringWords(getTextFieldText(e)));
            String text = getTextFieldText(e);
            for(String elem:da_stampare){
                this.testo.setText(this.testo.getText().replace(elem, ("<font color=\"red\">"+elem+"</font>")));
            }
            
            //this.testo.setText(text);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        /*try {
            String[] prova = getStringWords(getTextFieldText(e));
            for(int i = 0; i < prova.length; i++)
            System.out.println(prova[i]);
        } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
          try {
            /*try {
            System.out.println(getTextFieldText(e));
            } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            String[] da_stampare = getMetchedWords(this.testo.getText(), getStringWords(getTextFieldText(e)));
            String text = getTextFieldText(e);
            for(String elem:da_stampare){
                this.testo.setText(this.testo.getText().replace(elem, ("<font color=\"red\">"+elem+"</font>")));
            }
            
            //this.testo.setText(text);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
          try {
            /*try {
            System.out.println(getTextFieldText(e));
            } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            String[] da_stampare = getMetchedWords(this.testo.getText(), getStringWords(getTextFieldText(e)));
            String text = getTextFieldText(e);
            for(String elem:da_stampare){
                this.testo.setText(this.testo.getText().replace(elem, ("<font color=\"red\">"+elem+"</font>")));
            }
            
            //this.testo.setText(text);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(MyDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodi creati da me u.u
    private String getTextFieldText(DocumentEvent e) throws BadLocationException{
        return e.getDocument().getText(0, e.getDocument().getLength());
    }
    
    private String[] getStringWords(String text){
        ArrayList<String> array = new ArrayList();
        for(int i = 0; i < text.length(); i++){
            if(text.indexOf(' ') > 0){
                array.add(text.substring(0,text.indexOf(' ')));
                text = text.substring(text.indexOf(' ')+1);
            }
        }
        array.add(text);
        
        String[] end = new String[array.size()];
        array.toArray(end);
        
        return end;
    }
    
    private String[] getMetchedWords(String testo, String[] words){
        ArrayList<String> metch = new ArrayList();
        
        for(int i = 0; i < words.length; i++){
            if(testo.contains(words[i]))
                metch.add(words[i]);
        }
        
        String[] end = new String[metch.size()];
        metch.toArray(end);
        
        return end;
    }
        

}
