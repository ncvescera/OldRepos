#include <stdio.h>
#include <stdlib.h>

int potenzaIterativa(int base, int esponente);
int potenzaRicorsiva(int base, int esponente);

int main(int argc, char** argv) {
    int base,esponente;
    int rIterativo, rRicorsivo;
    
    printf("Inserisci la base (intera): ");
    scanf("%d", &base);
    printf("Inserisci l'esponente (intero non ngeativo): ");
    scanf("%d", &esponente);
    
    rIterativo = potenzaIterativa(base, esponente);
    rRicorsivo = potenzaIterativa(base, esponente);
    
    printf("%d^%d = %d (formulazione iterativa)\n", base, esponente, rIterativo);
    printf("%d^%d = %d (formulazione ricorsiva)\n", base, esponente, rRicorsivo);
    return (EXIT_SUCCESS);
}

int potenzaIterativa(int base, int esponente) {
    int r=1;
    for(esponente;esponente>0;esponente--)
        r*=base;
    return r;
}
int potenzaRicorsiva(int base, int esponente) {//corretto il nome della funzione, ha perso un bonus saltapercossa!
    int r=0;
    if(esponente==0)
        return 1;
    else{
        r=base*potenzaRicorsiva(base,esponente-1);
        return r;
    }
}