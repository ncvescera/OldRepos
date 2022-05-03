package scantcp;

/**
 *
 * @author ncvescera
 */
public class ScanTCP {
    
    public static void main(String[] args) {
        PortToName magic = new PortToName(); //inizializzo l'oggetto per trsformare la porta nel nome del servizio
        
        Scanner scan;
        switch (args.length) {
            case 0:
                System.err.println("Missing arguments!");
                break;
            case 1:
                scan = new Scanner(args[0]);
                scan.scan();
                break;
            case 2:
                if(args[1].indexOf("-") > 0){
                    scan = new Scanner(args[0],args[1]);
                    scan.scan();
                }
                else {
                    scan = new Scanner(args[0], Integer.parseInt(args[1]));
                    scan.scan();
                }
                break;
            default:
                System.err.println("Missing arguments!");
                break;
        }
      
    }
    
}
