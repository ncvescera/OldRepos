#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
    const int nrighe=4;
    const int ncolonne=4;
    int scambia[ncolonne];
    int matrice[nrighe][ncolonne];
    int righe,colonne;
   

    for(righe=0;righe<nrighe;righe++){
        for(colonne=0;colonne<ncolonne;colonne++){
            printf("Inserisci un numero che andrà nella riga %d e nella colonna %d: ",righe,colonne);
            scanf("%d",&(matrice[righe][colonne]));
        }
    }
    for(righe=0;righe<nrighe;righe++){
        for(colonne=0;colonne<ncolonne;colonne++){
            printf("%d\t",matrice[righe][colonne]);
        }
        printf("\n");
    }
    printf("\n");
    int i;
    for(i=1;i<nrighe;i+=2){
        for(colonne=0;colonne<nrighe;colonne++){
            scambia[colonne]=matrice[i][colonne];
            matrice[i][colonne]=matrice[i-1][colonne];
            matrice[i-1][colonne]=scambia[colonne];
            
        }
        
    }
     for(righe=0;righe<nrighe;righe++){
        for(colonne=0;colonne<ncolonne;colonne++){
            printf("%d\t",matrice[righe][colonne]);
        }
        printf("\n");
    }
            
    return (EXIT_SUCCESS);
}

