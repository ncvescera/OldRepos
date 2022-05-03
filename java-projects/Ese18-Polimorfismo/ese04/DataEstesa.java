package ese04;

public class DataEstesa extends DataFormattata {
  //Array contenente i mesi dell'anno, facilita la formattazione della variabile mese
  private String[] dizionario_mesi = {"gennaio","febbraio","marzo","aprile","maggio","giugno","luglio","agosto","settembre","ottobre","novembre","dicembre"};

  public DataEstesa(int giorno, int mese, int anno){
    super(giorno, mese, anno);
  }

  @Override
  /**
  * Formatta la data nello specifico formato definito
  * @return Data formattata
  **/
  public String formatta(){
    String day;
    String mounth;
    String year;

    //formatta il giorno
    if(this.giorno <= 9){
      day = "0"+Integer.toString(this.giorno);
    }
    else{
      day = Integer.toString(this.giorno);
    }

    //formatta il mese
    mounth = this.dizionario_mesi[this.mese-1]; //converte il numero del mese nel suo nome

    //formatta l'anno
    if(this.anno >= 0 && this.anno <= 9){
      year = "200"+Integer.toString(this.anno);
    }
    else if(this.anno >= 10 && this.anno <= 99){
      year = "20"+Integer.toString(this.anno);
    }
    else{
      year = Integer.toString(this.anno);
    }

    //assembla la stringa e la ritorna
    return (day+" "+mounth+" "+year);
  }
}
