package ese01;

public class Main {

  public static void main(String[] args) {
    ElencoPersone elenco = new ElencoPersone(3);  //istanza della classe ElencoPersone

    //aggiunta di varie persone all'elenco di Persone. Sfrutta i principi del POLIMORFISMO
    elenco.add(new Studente("LLLL","NICO","VESCERA","UNIPG","NV980001"));
    elenco.add(new Docente("AAAA","EMILIO","DI GIACOMO","INFORMATICA",2300.00));
    elenco.add(new Persona("BBBB","CIRO","SIMONETTI"));

    System.out.println(elenco);
  }
}
