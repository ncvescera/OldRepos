#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "libreria.h"
#include "FNAME.h"

int main(int argc, char** argv) {
    int dimM=2;
    int dimF=2;
    int m,f,inserito;
    studente temp;
    studente *maschi;
    studente *femmine;
       
    maschi=(studente*)malloc(dimM*sizeof(studente));
    femmine=(studente*)malloc(dimF*sizeof(studente));
    
    m=0;
    f=0;
    inserito=-1;
    
    while(inserito!=0){
        if(m==dimM){
            maschi=rialloca(maschi,dimM);
            dimM*=2;
        }
        if(f==dimF){
            femmine=rialloca(femmine,dimF);
            dimF*=2;
        }
        
        temp=inserisciDati();          
        if(temp.sesso==0){
            maschi[m]=temp;
            m=m+1;
        }
        else{
            femmine[f]=temp;
            f=f+1;
        }
        
        printf("\nVuoi inserire altri numeri? (0 no - 1 si)");
        scanf("%d",&inserito);
        puts("");
    }
    
    ordinaDati(maschi,m);
    ordinaDati(femmine,f);
    
        
    stampa(maschi,m,FNAMEM);
    stampa(femmine,f,FNAMEF);
    
    free(maschi);
    free(femmine);
    
    return (EXIT_SUCCESS);
}

