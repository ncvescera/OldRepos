package ese01;

public class Persona {
  protected String codiceFiscale;
  protected String nome;
  protected String cognome;

  public Persona(String codiceFiscale, String nome, String cognome){
    this.codiceFiscale  = codiceFiscale;
    this.nome           = nome;
    this.cognome        = cognome;
  }

  public void setCodiceFiscale(String codiceFiscale){
    this.codiceFiscale = codiceFiscale;
  }

  public String getCodiceFiscale(){
    return this.codiceFiscale;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

  public void setCognome(String cognome){
    this.cognome = cognome;
  }

  public String getCognome(){
    return this.cognome;
  }

  @Override
  /**
  * Overriding del metodo toString
  * @return L'oggetto sotto forma di Stringa
  **/
  public String toString(){
    return ("CODF: "+this.codiceFiscale+"\nNome: "+this.nome+"\tCognome: "+this.cognome);
  }
}
