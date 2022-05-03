package ese04;

public abstract class DataFormattata {
  protected int giorno;
  protected int mese;
  protected int anno;

  public DataFormattata(int giorno, int mese, int anno){
    this.giorno   = giorno;
    this.mese     = mese;
    this.anno     = anno;
  }

  /**
  * Formatta la data nello specifico formato definito
  * @return Data formattata
  **/
  public abstract String formatta();

}
