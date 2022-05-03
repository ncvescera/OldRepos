package scantcp;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ncvescera
 */
public class Scanner {
    private Socket socket;
    private int port;
    private String range_port;
    private String ip;
    
    private boolean range_scan      = false;
    private boolean complete_scan   = false;
    private boolean single_scan     = false;
    
    
    
    public Scanner(String ip){
        this.ip = ip;
        
        complete_scan = true;
    }
    
    public Scanner(String ip, int port){
        this.ip = ip;
        this.port = port;
        
        single_scan = true;
    }
    
    public Scanner(String ip, String range_port){
        this.ip = ip;
        this.range_port = range_port;
        
        range_scan = true;
    }
    
    public void scan(){
        if(complete_scan){
            completeScan();
        } 
        if(range_scan){
            rangeScan();
        }
        if(single_scan){
            singlePortScan();
        }
       
    }
    
    private void completeScan(){
        System.out.println("Scanning host "+ip);
        for(port = 1; port <= 1024; port++){
            try{
                socket = new Socket(ip,port);
                socket.close();
                System.out.println("\tPort "+port+"("+PortToName.toService(port)+")"+" is open");
            } catch(IOException e){
                //la porta è chiusa
            }
        }
    }
    
    private void singlePortScan(){
        System.out.println("Scanning port "+port+" on host "+ip);
        
        try{
            socket = new Socket(ip,port);
            socket.close();
            System.out.println("\tPort "+port+"("+PortToName.toService(port)+")"+" is open");
        } catch(IOException e){
            System.out.println("\tPort "+port+"("+PortToName.toService(port)+")"+" is closed");
        }
    }
    
    private void rangeScan(){
        int start = Integer.valueOf(range_port.substring(0,range_port.indexOf("-")));
        int end = Integer.valueOf(range_port.substring(range_port.indexOf("-")+1));
        
        if(end < start){
            int tmp = end;
            end = start;
            start = tmp;
        }
        
        System.out.println("Scanning ports "+start+" to "+end+" on host "+ip);
        for(port = start; port <= end; port++){
            try{
                socket = new Socket(ip,port);
                socket.close();
                System.out.println("\tPort "+port+"("+PortToName.toService(port)+")"+" is open");
            } catch(IOException e){
                //la porta è chiusa
            }
        }
    }
    
}
