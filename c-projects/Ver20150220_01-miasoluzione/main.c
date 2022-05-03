#include <stdio.h>
#include <stdlib.h>
#define N 4
#define ETA 18

int main(int argc, char** argv) {
    int array[N];
    int i,maggiori,cont;
    printf("Inserisci l'età di %d persone\n",N);

    for(i=0;i<N;i++){
    cont=i+1;
    printf("Inserisci l'età della %da persona: \n",cont);
    scanf("%d",&(array[i]));
    }
    maggiori=0;
    for(i=0;i<N;i++){
        if(array[i]>=ETA)
            maggiori++;
    }
    printf("I maggiorenni sono: %d\n",maggiori);
    return (EXIT_SUCCESS);
}

