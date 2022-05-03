package esesummer.pkg01;

import java.util.ArrayList;

public class EseSummer01 {
    public static void main(String[] args) {
        ArrayList<Libro> libri = new ArrayList();
        final int N_LIBRI = 10; //numero di libri da inserire
        int i;
        
        System.out.println("Inserisci i "+N_LIBRI+" libri !");
        
        for(i = 0; i < N_LIBRI; i++){
            libri.add(new Libro(EasyInput.inputI("Inserisci il numero di pagine: "), EasyInput.inputS("Inserisci il nome del libro")));
        }
        
        System.out.println("\nI libri con numero di pagine < di 100 sono: ");
        
        for(Libro elem:libri){
            if(elem.getPagine() < 100)
                elem.print();
        }
    }

}
