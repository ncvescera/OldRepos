package runnable;

public class Risorsa {
    char[][] matrice;
    final int X_DIM = 26;
    final int Y_DIM = 26;
    
    public Risorsa(){
        matrice = new char[Y_DIM][X_DIM];
    }
    
    public void setElem(int riga, int colonna, int elem){
        matrice[riga][colonna] = (char)elem;
    }
    
    public char getElem(int riga, int colonna){
        return matrice[riga][colonna];
    }
    
    public void print(){
        int i,j;
        
        for(i=0;i<Y_DIM;i++){
            for(j=0;j<X_DIM;j++){
                System.out.print(matrice[i][j]);
            }
            System.out.print("\n");
        }
    }
}
