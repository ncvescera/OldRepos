package ese02;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    Catalogo<Mobile> mobili = new Catalogo<Mobile>();

    //aggiunta di articoli al catalogo
    mobili.aggiungiArticolo(new Mobile("UNO",22.0,1,1,1));
    mobili.aggiungiArticolo(new Mobile("DUE",56.0,2,2,2));
    mobili.aggiungiArticolo(new Mobile("TRE",98.0,3,3,3));
    mobili.aggiungiArticolo(new Mobile("QUATTRO",54.0,4,4,4));

    System.out.println(mobili); //test del metodo toString di Catalogo

    List<Mobile> scelta = segliMobile(mobili, 98.0, 4,4,4); //test della funzione scegliMobile

    //stampa del risultato dell'istruzione precedente
    for(Mobile elem:scelta){
      System.out.println(elem);
    }
  }

  public static <T extends Mobile> List<T> segliMobile(Catalogo<T> in, double prezzo, int lunghezza, int larghezza, int profondita){
    List<T> result = new ArrayList<T>();  //lista da ritornare
    List<T> list = in.getArticoliSottoPrezzo(prezzo); //tutti gli elementi minori di un determinato prezzo
    Iterator<T> i = list.iterator();
    T elem;

    while(i.hasNext()){
      elem = i.next();

      if(elem.getLarghezza() < larghezza && elem.getLunghezza() < lunghezza && elem.getProfondita() < profondita){
        result.add(elem);
      }
    }

    return result;
  }
}
