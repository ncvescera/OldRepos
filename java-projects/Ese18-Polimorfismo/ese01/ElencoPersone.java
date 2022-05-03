package ese01;

public class ElencoPersone {

  private Persona[] array;  //array che conterrà tutte le persone
  private int len;          //lungezza massima dell'array
  private int next;         //prima posizione libera dell'array

  /**
  * Costruttore della classe
  * @param len Lunghezza massima dell'array
  **/
  public ElencoPersone(int len){
    this.next   = 0;
    this.len    = len;
    this.array  = new Persona[len];
  }

  /**
  * Aggiunge una persona all'array
  * @param elem Persona da aggiungere
  * @return -1 Se è stato impossibile aggiungere la persona, altrimenti 0
  **/
  public int add(Persona elem){
    int result;

    if(this.next < this.len){
      this.array[this.next] = elem;
      this.next ++;
      result = 0;
    }
    else{
      result = -1;
    }

    return result;
  }

  @Override
  /**
  * Overriding del metodo toString
  * @return L'oggetto sotto forma di Stringa
  **/
  public String toString(){
    String result = "";

    for(Persona item:array){
      result += item.toString()+"\n\n";
    }

    return result;
  }

}
