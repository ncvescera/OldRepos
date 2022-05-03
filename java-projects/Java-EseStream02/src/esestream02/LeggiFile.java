package esestream02;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author ncvescera
 */
public class LeggiFile {
    private DataInputStream inputStream;
    
    public LeggiFile(){
        try {
            this.inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("out.txt")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeggiFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Record leggi(){
        try {
            return new Record(this.inputStream.readUTF(), this.inputStream.readUTF(), this.inputStream.readUTF(), this.inputStream.readInt()); //ritoruna un Record
        } catch (IOException ex) {
            Logger.getLogger(LeggiFile.class.getName()).log(Level.SEVERE, null, ex);
            return null; //ritorna null in caso di errore
        }
    }
    
    public void readAll(ArrayList<Record> array){
        try {
            while(this.inputStream.available() != 0){
                array.add(this.leggi()); //aggiunge il Record letto all'array
            }
        } catch (IOException ex) {
            Logger.getLogger(LeggiFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close(){
        try {
            this.inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(LeggiFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
