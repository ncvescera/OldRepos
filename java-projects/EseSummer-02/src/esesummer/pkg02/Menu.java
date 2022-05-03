package esesummer.pkg02;

public class Menu {
    public static void print(){
        System.out.println("--------------------Menu--------------------");
        System.out.println("1) Aggiungi veicolo\t2) Rimuovi veicolo\n3)Stampa resoconto\t4) Piu' info\n5) Esci");
        System.out.println("--------------------------------------------");
    }
    
    private static String scegliTipo(){
        //System.out.println();
        int scelta = EasyInput.inputI("1) Moto\t2) Auto\t3) Furgone");
        String end = "";
        switch (scelta){
            case 1:
                end =  "moto";
                break;
            case 2:
                end = "auto";
                break;
            case 3:
                end = "furgone";
                break;
            default:
                end = "errore";
                break;
        }
        
        if(end.equals("errore")){
            return "errore";
        }
        else
            return end;
    }
    
    public static void scelta(int scelta, Garage garage){
        if(scelta == 1){
            int posto = EasyInput.inputI("Inserisci il posto: ");
            if(posto == 1){
                System.err.println("Errore, posto occupato!");
                return ;
            }
            else{
                String tipo = Menu.scegliTipo();
                if(tipo.equals("errore")){
                    System.err.println("Errore!");
                    return ;
                }
                else{
                    int success = Menu.addVeicolo(garage, posto, new Veicolo(tipo,EasyInput.inputS("Inserisci il nome del proprietario: "),EasyInput.inputS("Inserisci la targa: "),EasyInput.inputS("Inserisci la data di entrata (gg/mm/aaaa): "),EasyInput.inputS("Inserisci la data di uscita (gg/mm/aaaa): ")));
                    if(success == 1)
                        System.err.println("Errore, posto occupato!");
                    else
                        System.out.println("Veicolo inserito con successo!");
                }
            }
        }
        if(scelta == 2){
           int success = garage.rmVeicolo(EasyInput.inputI("Inserisci il posto da liberare: "));
           if(success == 1)
               System.err.println("Impossibile liberare il posto! Posto gia' vuoto.");
           else
               System.out.println("Posto liberato con successo!");
           
        }
        if(scelta == 3){
            Menu.situazione(garage);
        }
        if(scelta == 4){
            garage.piuInfo(EasyInput.inputI("Inserisci il posto: "));
        }
    }
    
    private static int addVeicolo(Garage garage, int posto, Veicolo veicolo){
        return garage.addVeicolo(posto,veicolo);
    }
    
    // opzione 3
    private static void situazione(Garage garage){
        garage.stampa();
    }
}
