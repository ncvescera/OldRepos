package runnable;


public class Vigenere implements Runnable{
    int inizio_riga, fine_riga;
    int inizio_colonna, fine_colonna;
    String nome;
    Risorsa matrix;
    
    public Vigenere(int inizio_riga, int fine_riga, int inizio_colonna, int fine_colonna, String nome, Risorsa matrix){
        this.inizio_riga = inizio_riga;
        this.fine_riga = fine_riga;
        this.inizio_colonna = inizio_colonna;
        this.fine_colonna = fine_colonna;
        
        this.nome = nome;
        this.matrix = matrix;
    }
    
    @Override
    public void run(){
        int colonna,riga,elem;
        for(riga=inizio_riga;riga<fine_riga;riga++){
            for(colonna=inizio_colonna;colonna<fine_colonna;colonna++){
                elem =riga+colonna+65;
                if(elem>90)
                    elem = elem - 26;
                matrix.setElem(riga, colonna, elem);
            }
        }
    }
    
}
