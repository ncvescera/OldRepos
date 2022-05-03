#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define N 4
#define REPUBBLICA 50

int main(int argc, char** argv) {
    int array[N];
    int i,cont,massima,minima,capo;
    float media;
    printf("Inserisci l'età di %d persone\n",N);

    for(i=0;i<N;i++){
    cont=i+1;
    printf("Inserisci l'età della %da persona: \n",cont);
    scanf("%d",&(array[i]));
    }
    media=0;
    massima=INT_MIN;
    minima=INT_MAX;
    capo=0;
    for(i=0;i<N;i++){
        media+=array[i];
        if(array[i]>massima)
            massima=array[i];
        if(array[i]<minima)
            minima=array[i];
        if(array[i]>=REPUBBLICA)
            capo++;
    }
    media/=N;




    printf("Età media: %f\n",media);
    printf("Età massima: %d\n",massima);
    printf("Età minima: %d\n",minima);
    printf("Numero di potenziali Presidenti della Reppubblica: %d",capo);
    return (EXIT_SUCCESS);
}

