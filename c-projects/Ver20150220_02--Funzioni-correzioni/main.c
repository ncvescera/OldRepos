#include <stdio.h>
#include <stdlib.h>

#define N 4
#define REPUBBLICA 50

int etaMassima(int eta[], int size);
int etaMinima(int eta[], int size);
float etaMedia(int eta[], int size);
int presidenti(int eta[], int size, int etaMinima);

int main(int argc, char** argv) {
    int array[N];
    int i,massima,minima,possibiliPresidenti;
    float media;
    
    printf("Inserisci l'età di %d persone\n",N);

    for(i=0;i<N;i++){
       
        printf("Inserisci l'età della %da persona: \n",i+1);
        scanf("%d",&(array[i]));
    }
   
    massima=etaMassima(array,N);
    minima=etaMinima(array,N);
    media=etaMedia(array,N);
    possibiliPresidenti=presidenti(array,N,REPUBBLICA);
    
    printf("Età media: %f\n",media);
    printf("Età massima: %d\n",massima);
    printf("Età minima: %d\n",minima);
    printf("Numero di potenziali Presidenti della Reppubblica: %d",possibiliPresidenti);
    return (EXIT_SUCCESS);
}

int etaMassima(int eta[], int size){
    int massima=0;
    int i;
    for(i=0;i<size;i++){
        if(eta[i]>massima)
            massima=eta[i];
    }
    return massima;
}
int etaMinima(int eta[], int size){
    int minima=100;
    int i;
    for(i=0;i<size;i++){
        if(eta[i]<minima)
            minima=eta[i];
    }
    return minima;
}
float etaMedia(int eta[], int size){
    float media=0;
    int i;
    for(i=0;i<size;i++){
        media+=eta[i];
    }
    media/=size;
    return media;
}
int presidenti(int eta[], int size, int etaMinima){
    int presidenti=0;
    int i;
    for(i=0;i<size;i++){
         if(eta[i]>=etaMinima)
            presidenti++;
    }
    return presidenti;
}