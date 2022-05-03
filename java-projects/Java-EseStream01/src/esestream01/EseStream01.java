package esestream01;

import java.util.ArrayList;

/**
 *
 * @author ncvescera
 */
public class EseStream01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reader read = new Reader("data");
        Writer write = new Writer();
        
        ArrayList<String> parsed_file = Parser.parse(read.readAll());
        read.close();

        write.writeAll(parsed_file);
        write.close();
        
        // legge il file di output appena creato
        read = new Reader("out");
        
        System.out.println(read.readAll());
        
        read.close();
        
        System.out.println("DONE!");
    }
    
}
