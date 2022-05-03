package ese01;

public class Docente extends Persona {
  private String materia; //materia che insegna il Docente
  private double salario; //salario del Docente

  /**
  * Metodo costruttore della classe
  **/
  public Docente(String codiceFiscale, String nome, String cognome, String materia, double salario){
    super(codiceFiscale, nome, cognome);

    this.materia = materia;
    this.salario = salario;
  }

  //GETTERS E SETTERS
  public void setMateria(String materia){
    this.materia = materia;
  }

  public String getMateria(){
    return this.materia;
  }

  public void setSalario(double salario){
    this.salario = salario;
  }

  public double getSalario(){
    return this.salario;
  }

  @Override
  /**
  * Overriding del metodo toString
  * @return L'oggetto sotto forma di Stringa
  **/
  public String toString(){
    return super.toString()+"\tMateria: "+this.materia+"\tSalario: "+Double.toString(this.salario);
  }
}
