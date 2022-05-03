package ese01;

public class Main {
  public static void main(String[] args){
    Rubrica rubrica = new Rubrica();  //creazione dell'oggetto Rubrica

    rubrica.aggiungiContatto("Nicolo","Vescera","3294617424");  //aggiunta di un nuovo conatto
    rubrica.aggiungiContatto("Ciro","Simonetti","3456273845");
    rubrica.aggiungiContatto("Francesco","Corbucci","0000000000");
    rubrica.aggiungiContatto("Francesco","Corbucci","0000000000");  //aggiunta di un contatto già esistente
    rubrica.aggiungiContatto("Fabio","Proietti","443322110099");

    System.out.println(rubrica);  //test del metodo toString

    System.out.println(rubrica.cerca("Francesco", "Corbucci")); //ricerca di un contatto già esistente
    System.out.println(rubrica.cerca("Pietro", "Smusi"));       //ricerca di un contatto non esistente

    System.out.println();

    rubrica.rimuoviContatto("Fabio", "Proietti"); //rimozione di un contatto esistente
    rubrica.rimuoviContatto("Pietro", "Smusi");   //rimozione di un contatto non esistente

    System.out.println(rubrica);
  }
}
