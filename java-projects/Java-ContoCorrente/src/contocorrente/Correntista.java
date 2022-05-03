package contocorrente;

public class Correntista extends Thread{
    private String          nome;
    private String          ndg;
    private Contocorrente   conto;
    private float           soldi;
    private String          azione;
    
    public Correntista(String nome, String ndg, Contocorrente conto, String azione, float soldi){
        super();
        
        this.nome   =   nome;
        this.ndg    =   ndg;
        this.conto  =   conto;
        this.soldi  =   soldi;
        this.azione =   azione;
    }
    
    @Override
    public void run(){
        if(this.azione.equals("prelievo")){
            this.conto.prelievo(this.soldi);
            System.out.println("Il thread "+this.nome+" ha prelevato: "+this.soldi);
        }
        else if(this.azione.equals("versamento")){
            this.conto.versamento(this.soldi);
            System.out.println("Il thread "+this.nome+" ha versato: "+this.soldi);
        }
       

    }
}
