package esestream01;

import java.util.ArrayList;

/**
 *
 * @author ncvescera
 */
public class Parser {
    
    private static final String DATA_SEPARATOR = "end";
    
    public static ArrayList parse(String allFile){
        String tmp = allFile;
        String result = "";
        ArrayList<String> toReturn = new ArrayList();
        
        while(tmp.contains("end")){
            toReturn.add(tmp.substring(0,tmp.indexOf(DATA_SEPARATOR)).replace("\n", ";")); //rimpiazza i \n con ; e aggiunge la stringa all'array
            tmp = tmp.substring(tmp.indexOf(DATA_SEPARATOR)+(DATA_SEPARATOR.length()+1)); //elimina la prima occerrenza di end\n
        }
                
        return toReturn;
    }
}
