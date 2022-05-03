#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
    float a, b;
    int scelta,i;
    float risultato, frazionale;
    
    puts("Benvenuto nel SuperCaolcolatore, il piu' innovativo software di calcolo presente sul mercato.\n");
    printf("Inserisci a, il primo operando (frazionale): ");
    scanf("%f", &a);
    printf("Inserisci b, il secondo operando (frazionale): ");
    scanf("%f", &b);
    
    getchar();
    /* La presenza di questa chiamata alla funzione getchar() è dovuto al funzionamento
     * "buffered line" definito dallo standard POSIX.
     */
    
    puts("\nOperazioni:");
    puts("1 -  Somma a+b");
    puts("2 -  Sottrazione a-b");
    puts("3 -  Moltiplicazione a*b");
    puts("4 -  Divisione a/b con risultato frazionale");
    puts("5 -  Disione a/b con parte intera e parte frazionale");
    puts("6 -  Elevamento a potenza a^b (l'esponente è troncato ad intero)");
    scelta = getchar();
    scelta = scelta - '0';
    
    switch(scelta) {
        case 1:
            risultato = a+b;
            printf("%f+%f=%f\n", a, b, risultato);
            break;
        case 2:
            risultato = a-b;
            printf("%f-%f=%f\n", a, b, risultato);
            break;
        case 3:
            risultato = a*b;
            printf("%f*%f=%f\n", a, b, risultato);
            break;
        case 4:
            risultato = a/b;
            printf("%f/%f=%f\n", a, b, risultato);
            break;
        case 5:
            risultato = (int)a/b;
            frazionale = a/b-(int)risultato;
            
            printf("%f/%f= %d (intera) e %f (frazionale)\n", a, b, (int)risultato, frazionale);
            break;
        case 6:
            risultato = 1;
            for(i=0;i<b;i++){
                risultato*=a;
            }
            printf("%f^%d=%f\n", a, (int)b, risultato);
            break;
        default:
            puts("Nuove oprazioni saranno disponibili a breve!\n");        
    }
    return (EXIT_SUCCESS);
}