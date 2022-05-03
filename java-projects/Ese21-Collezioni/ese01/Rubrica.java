package ese01;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Rubrica {
  //Lista contenente tutti i contatti
  private List<Contatto> contatti;

  public Rubrica(){
    this.contatti = new ArrayList<Contatto>();
  }

  /**
  * Aggiunge un contatto se non esiste già
  * @param nome Nome del Contatto
  * @param cognome Cognome del Contatto
  * @param telefono Telefono del Contatto
  **/
  public void aggiungiContatto(String nome, String cognome, String telefono){
    Contatto temp = new Contatto(nome, cognome, telefono);

    if(!(this.contatti.contains(temp))){
      this.contatti.add(temp);
    }
  }

  /**
  * Rimuove un contatto se esistente
  * @param nome Nome del contatto da rimuovere
  * @param cognome Cognome del contatto da rimuovere
  */
  public void rimuoviContatto(String nome, String cognome){
    Iterator<Contatto> i = this.contatti.iterator();
    Contatto elem;

    while(i.hasNext()){
      elem = i.next();
      if(elem.getNome().equals(nome) && elem.getCognome().equals(cognome)){
        i.remove();
      }
    }
  }

  /**
  * Cerca un contatto dato nome e Cognome
  * @param nome Nome del contatto da cercare
  * @param cognome Cognome del contatto da cercare
  * @return Numero di telefono del contatto se presente, altrimenti NULL
  **/
  public String cerca(String nome, String cognome){
    Iterator<Contatto> i = this.contatti.iterator();
    Contatto elem = null;
    boolean trovato = false;

    while(i.hasNext() && !trovato){
      elem = i.next();

      if(elem.getNome().equals(nome) && elem.getCognome().equals(cognome)){
        trovato = true;
      }
    }

    if(trovato)
      return elem.getTelefono();
    else
      return null;
  }

  //Override del metodo toString
  @Override
  public String toString(){
    String result = "";

    Iterator<Contatto> i = this.contatti.iterator();
    while(i.hasNext()){
      result += i.next().toString()+"\n";
    }

    return result;
  }
}
