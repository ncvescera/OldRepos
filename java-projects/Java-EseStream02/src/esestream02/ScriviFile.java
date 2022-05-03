/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestream02;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ncvescera
 */
public class ScriviFile {
    private String cognome;
    private String materia;
    private String valutazione;
    private int voto;
    
    private DataOutputStream outStream;
    
    public ScriviFile(){
        try {
            this.outStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("out.txt")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScriviFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrivi(String cognome, String materia, String valutazione, int voto){
        try {
            this.outStream.writeUTF(cognome);
            this.outStream.writeUTF(materia);
            this.outStream.writeUTF(valutazione);
            //this.outStream.writeInt(voto);
            this.outStream.writeInt(voto);
        } catch (IOException ex) {
            Logger.getLogger(ScriviFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close(){
        try {
            this.outStream.close();
        } catch (IOException ex) {
            Logger.getLogger(ScriviFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
