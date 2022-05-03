package ese01;

public class Contatto {
  private String nome;
  private String cognome;
  private String telefono;

  public Contatto(String nome, String cognome, String telefono){
    this.nome = nome;
    this.cognome = cognome;
    this.telefono = telefono;
  }

  public String getNome(){
    return this.nome;
  }

  public String getCognome(){
    return this.cognome;
  }

  public String getTelefono(){
    return this.telefono;
  }

  @Override
  public String toString(){
    return this.nome + " " + this.cognome + " : " + this.telefono;
  }

  //override del metodo equals permettere il buon funzionamento del metodo contains di ArrayList
  @Override
  public boolean equals(Object c){
    if(this.toString().equals(c.toString()))
      return true;
    else
      return false;
  }
}
