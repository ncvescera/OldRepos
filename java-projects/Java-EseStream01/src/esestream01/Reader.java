package esestream01;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author ncvescera
 */
public class Reader {
    private String fname;
    private BufferedReader buff_reader;
    
    public Reader(String fname) {
        this.fname = fname;
        try{
            this.buff_reader = new BufferedReader(new FileReader(this.fname));
        } catch(Exception e){
            System.err.println("Ooopss!\n"+e);
        }
    }
    
    public String readLine() {
        String tmp = null;
        
        try{
            tmp = this.buff_reader.readLine();
        } catch(Exception e) {
            System.err.println("Ooopss!\n"+e);
        }
                
        return tmp;
    }
    
    public String readAll() {
        String allFile = "";
        String tmp = null;
        
        try{
            while((tmp = this.buff_reader.readLine()) != null){
                allFile += tmp+"\n"; //readline non legge i ritorni a capo
            }
        } catch(Exception e) {
            System.err.println("Ooopss!\n"+e);
        }
        
        return allFile;
    }
    
    public void close() {
        try {
            this.buff_reader.close();
        } catch (Exception e) {
            System.err.println("Ooopss!\n"+e);
        }
    }
}
