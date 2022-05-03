#include <stdio.h>
#include <stdlib.h>

struct s_elemento {
    int value;
    struct s_elemento *next;
};

typedef struct s_elemento elemento;

elemento * addElemento(elemento *primo, int value);
void stampa(elemento *primo);
void libera(elemento *primo);

int main(int argc, char** argv) {
    elemento * primo;
    int value;
    
    primo = NULL;
    value = 1;
    
    while(value != 0) {
        printf("Inserisci un numero (0 per terminare): ");
        scanf("%d", &value);
        if(value!=0) {
            primo=addElemento(primo, value);
            if(primo==NULL) {
                fprintf(stderr, "Errore!");
                exit(1);
            }
        }
    }
    
    stampa(primo);
    
    libera(primo);
    
    return (EXIT_SUCCESS);
}

elemento* addElemento(elemento *primo, int value) {
    elemento* nuovoElemento;
    
    nuovoElemento=(elemento *)malloc(sizeof(elemento));
    if(nuovoElemento!=NULL){
        nuovoElemento->value=value;
        nuovoElemento->next=primo;
    }
    primo=nuovoElemento;
    return primo;
}

void stampa(elemento *primo) {
    elemento *corrente;
    
    printf("\nStampa\n");
    corrente=primo;
    while(corrente!=NULL){
        printf("%d\n", corrente->value);
        corrente=corrente->next;
    }
}

void libera(elemento *primo) {
    elemento *temp;
    
    printf("\nSto svuotando la lista... ");
    while(primo!=NULL) {
        temp=primo;
        primo=primo->next;
        free(temp);
    }
    printf("Fine\n");
}