package esesummer.pkg02;

import java.util.GregorianCalendar;

public class Veicolo {
    private String tipo;
    private String proprietario;
    private String targa;
    private String entrataS;
    GregorianCalendar entrata;
    private String uscitaS;
    GregorianCalendar uscita;
    private int tariffa;
    
    public Veicolo(String tipo, String proprietario, String targa, String entrata, String uscita){
        this.tipo = tipo;
        this.proprietario = proprietario;
        this.targa = targa;
        this.entrataS = entrata;
        this.entrata = this.stringToGregorian(entrata);
        this.uscitaS = uscita;
        this.uscita = this.stringToGregorian(uscita);
    }
    
    private GregorianCalendar stringToGregorian(String data){
        int[] date = new int[3];
        int i;
        for(i = 0; i < date.length-1; i++){
            date[i] = Integer.parseInt(data.substring(0,data.indexOf('/')));
            data = data.substring(data.indexOf('/')+1);
        }
        date[i] = Integer.parseInt(data);
        
        return new GregorianCalendar(date[2],date[1],date[0]);
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getProprietario(){
        return this.proprietario;
    }
    
    public String getTarga(){
        return this.targa;
    }
    
    public String getEntrataS(){
        return this.entrataS;
    }
    
    public String getUscitaS(){
        return this.uscitaS;
    }
    
    public GregorianCalendar getEntrata(){
        return this.entrata;
    }
    
    public GregorianCalendar getUscita(){
        return this.uscita;
    }
     
    public void setTariffa(int tariffa){
         this.tariffa = tariffa;
    }
    public int getTariffa(){
        return this.tariffa;
    }
    
    public void print(){
        System.out.println("Tipo: "+this.tipo);
        System.out.println("Proprietario: "+this.proprietario);
        System.out.println("Targa: "+this.targa);
        System.out.println("Entrata: "+this.entrataS);
        System.out.println("Uscita: "+this.uscitaS);
    }
}
