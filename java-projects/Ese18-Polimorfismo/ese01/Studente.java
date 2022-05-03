package ese01;

public class Studente extends Persona {
  private String universita;  //nome dell'università dello studente
  private String matricola;   //identificativo dello studente

  public Studente(String codiceFiscale, String nome, String cognome, String universita, String matricola){
    super(codiceFiscale, nome, cognome);

    this.universita = universita;
    this.matricola  = matricola;
  }

  //GETTERS E SETTERS
  public void setUniversita(String universita){
    this.universita = universita;
  }

  public String getUniversita(){
    return this.universita;
  }

  public void setMatricola(String matricola){
    this.matricola = matricola;
  }

  public String getMatricola(){
    return this.matricola;
  }

  @Override
  /**
  * Overriding del metodo toString
  * @return L'oggetto sotto forma di Stringa
  **/
  public String toString(){
    return super.toString()+"\tMatricola: "+this.matricola+"\tUniversità: "+this.universita;
  }
}
