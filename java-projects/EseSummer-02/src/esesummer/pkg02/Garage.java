package esesummer.pkg02;

public class Garage {
    private final int POSTI = 30;
    private final int TARIFFA_AUTO = 20;
    private final int TARIFFA_MOTO = 10;
    private final int TARIFFA_FURGONE = 30;
    
    private Veicolo[] posti;
    public Garage(){
        posti = new Veicolo[POSTI];
    }
    
    public int calcolaTariffa(Veicolo veicolo){
        //1 giorno = 1000*60*60*24 ms = 86400000 ms
        long differenza = (veicolo.getUscita().getTimeInMillis())-(veicolo.getEntrata().getTimeInMillis());
        int giorni = (int)(differenza/86400000);
        
        int tariffa = 0;
        switch (veicolo.getTipo()) {
            case "furgone":
                tariffa = giorni * TARIFFA_FURGONE;
                break;
            case "moto":
                tariffa = giorni * TARIFFA_MOTO;
                break;
            case "auto":
                tariffa = giorni * TARIFFA_AUTO;
                break;
        }
        return tariffa;
    }
    
    public int rmVeicolo(int posto){
        if(this.posti[posto] != null){
            this.posti[posto] = null;
            return 0;
        }
        else
            return 1;
    }
    
    public int addVeicolo(int posto, Veicolo veicolo){
        if(posto < this.POSTI && this.posti[posto] == null){
            this.posti[posto] = veicolo;
            veicolo.setTariffa(this.calcolaTariffa(veicolo));
            return 0; // andato a buon fine
        }
        else{
            return 1; // presente errore
        }
    }
    
    public void stampa(){
        int i;
        
        System.out.println("Veicoli presenti nel garage!");
        
        for(i = 0; i < this.posti.length; i++){
            if(this.posti[i] == null)
                System.out.println("Posto: "+i+" VUOTO");
            else
                System.out.println("Posto: "+i+"\tTipo: "+this.posti[i].getTipo()+"\tProprietario: "+this.posti[i].getProprietario()+"\tEntrata: "+this.posti[i].getEntrataS()+"\tUscita: "+this.posti[i].getUscitaS()+"\tTariffa: "+this.posti[i].getTariffa());
            
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }
    
    public void piuInfo(int posto){
        if(posto < this.POSTI && this.posti[posto] != null)
            this.posti[posto].print();
        else
            System.err.println("Errore! Il posto è vuoto.");
    }
}
