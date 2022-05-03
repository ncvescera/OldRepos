package esestream01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author ncvescera
 */
public class Writer {
    private final String fname;
    private BufferedWriter writer;
    
    public Writer() {
        this.fname = "out";
        try {
            this.writer = new BufferedWriter(new FileWriter(this.fname));
        } catch(Exception e) {
            System.err.println("Ooopss!\n"+e);
        }
    }
    
    public Writer(String name) {
        this.fname = name;
        try {
            this.writer = new BufferedWriter(new FileWriter(this.fname));
        } catch(Exception e) {
            System.err.println("Ooopss!\n"+e);
        }
    }
    
    public void writeAll(ArrayList<String> toWrite) {
        for(String elem:toWrite)
            try {
                this.writer.write(elem+"\n");
            } catch (Exception e) {
                System.err.println("Ooopss!\n"+e);
            }
    }
    
    public void writeLine(String toWrite) {
         try {
            this.writer.write(toWrite+"\n");
         } catch(Exception e) {
            System.err.println("Ooopss!\n"+e);
        }
    }
    
    public void close() {
        try {
            this.writer.close();
        } catch(Exception e) {
            System.err.println("Ooopss!\n"+e);
        }
    }
}
