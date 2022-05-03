package ese04;

public class Main {
  public static void main(String[] args) {
    DataFormattata[] array = new DataFormattata[3]; //Array di tipo DataFormattata, conterrà le varie date

    //Creo varie date con diversa formattazione
    array[0] = new DataNumerica(8,4,1998);
    array[1] = new DataEstesa(8,4,1998);
    array[2] = new DataNumerica(4,4,4);

    //Sfruttando le proprietà del polimorfismo stampo le varie date formattate
    for(DataFormattata item:array){
      System.out.println(item.formatta());
    }
  }
}
