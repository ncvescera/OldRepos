package contocorrente;

import java.util.ArrayList;

public class Contocorrente {

    private String                  iban;
    private float                   saldo;
    private ArrayList<Movimento>    movimenti;
    private int                     n_movimenti;

    public Contocorrente(String iban, float saldo) {
        this.iban           =   iban;
        this.saldo          =   saldo;
        this.movimenti      =   new ArrayList();
        this.n_movimenti    =   0;
    }

    public void prelievo(float prelievo) {
        if(prelievo > 0 && prelievo < this.saldo){
           this. saldo -= prelievo;
           this.movimenti.add(new Movimento(++this.n_movimenti,System.currentTimeMillis(),prelievo,"prelievo"));
        }
        else
            System.err.println("Importo errato !");
    }

    public void versamento(float versamento) {
        if(versamento > 0){
            this.saldo += versamento;
            this.movimenti.add(new Movimento(++this.n_movimenti,System.currentTimeMillis(),versamento,"versamento"));
        }
        else
            System.err.println("Importo errato !");
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void printSaldo() {
        System.out.println(this.saldo);
    }

    public void printMovimenti() {
        for(Movimento elem:this.movimenti){
            System.out.println("Codice: "+elem.getCodice()+"\nData: "+elem.getData()+"\nImporto: "+elem.getImporto()+"\nCausale: "+elem.getCausale());
        }
    }
}
