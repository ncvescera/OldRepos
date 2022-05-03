package esesummer.pkg01;

public class Libro {
    private int pagine;
    private String nome;
    
    public Libro(int pagine, String nome){
        this.pagine = pagine;
        this.nome = nome;
    }
    
    public int getPagine(){
        return this.pagine;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void print(){
        System.out.println("Nome: "+this.nome+"\tPagine: "+this.pagine);
        System.out.println("------------------------------------");
    }
}
