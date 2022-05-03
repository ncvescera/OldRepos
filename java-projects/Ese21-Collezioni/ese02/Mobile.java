package ese02;

public class Mobile implements Articolo {
  private int larghezza;
  private int lunghezza;
  private int profondita;
  private double prezzo;
  private String nome;

  public Mobile(String nome, double prezzo, int lunghezza, int larghezza, int profondita){
    this.nome = nome;
    this.prezzo = prezzo;
    this.lunghezza = lunghezza;
    this.larghezza = larghezza;
    this.profondita = profondita;
  }

  @Override
  public String getNome(){
    return this.nome;
  }

  @Override
  public double getPrezzo(){
    return this.prezzo;
  }

  @Override
  public String toString(){
    return this.nome + " " + Double.toString(this.prezzo) + " " + Integer.toString(lunghezza) + " " + Integer.toString(larghezza) + " " + Integer.toString(profondita);
  }
  public int getLarghezza(){
    return this.larghezza;
  }

  public int getLunghezza(){
    return this.lunghezza;
  }

  public int getProfondita(){
    return this.profondita;
  }
}
