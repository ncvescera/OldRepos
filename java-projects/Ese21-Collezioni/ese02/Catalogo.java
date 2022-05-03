package ese02;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Catalogo<E extends Articolo>{
  private List<E> catalogo;

  public Catalogo(){
    this.catalogo = new ArrayList<E>();
  }

  public void aggiungiArticolo(E articolo){
    this.catalogo.add(articolo);
  }

  public List<E> getArticoliSottoPrezzo(double prezzo){
    List<E> result = new ArrayList<E>();
    Iterator<E> i = this.catalogo.iterator();
    E elem;

    while(i.hasNext()){
      elem = i.next();
      if(elem.getPrezzo() < prezzo)
        result.add(elem);
    }

    return result;
  }

  @Override
  public String toString(){
    String result = "";
    Iterator<E> i = this.catalogo.iterator();

    while(i.hasNext()){
      result += i.next().toString()+"\n";
    }

    return result;
  }
}
