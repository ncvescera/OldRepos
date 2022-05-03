package scantcp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ncvescera
 */
public class PortToName {
    private static Map<Integer,String>magic;
    
    public PortToName(){
        magic = new HashMap(); //instazio l'array associativo
        
        try{
            initMagics();
        } catch(FileNotFoundException e){
            System.err.println("File magic not found!");
        }
    }
    
    public static String toService(int port){
        return magic.get(port);
    }
    
    private void initMagics() throws FileNotFoundException {
        
        BufferedReader buffer = new BufferedReader(new FileReader("magic"));
        
        try{
            String line = buffer.readLine();
            while(line != null){
                int port = Integer.valueOf(line.substring(0,line.indexOf(" ")));
                String name = line.substring(line.indexOf(" ")+1);
                
                magic.put(port, name);
                
                line = buffer.readLine();
            }
            
        } catch(IOException e){
            System.err.println(e);
        } finally {
            try{
                buffer.close();
            } catch(IOException e){
                System.err.println(e);
            }
        }
        
    }
}
