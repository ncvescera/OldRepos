#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definisci le costanti
#define N 3
#define MAX_STRLEN 30
// Definisci il tipo di dato struct s_studente
struct s_studente{
    char nome[MAX_STRLEN+1];
    char cognome[MAX_STRLEN+1];
    unsigned int eta;
    char classe[MAX_STRLEN+1];
};
// Definisci studente come struct s_studente
typedef struct s_studente studente;

int main(int argc, char** argv) {
    // Dichiara le variabili locali
    int i;
    studente elenco[N];
    FILE *puntafile;
    // Codice per l'inserimento, da parte dell'utente, dei dati in un array
    printf("---Inserimento Dati---\n\n");
    for(i=0;i<N;i++){
        printf("Inserisci il nome del %d studente:\n",i+1);
        scanf("%s",elenco[i].nome);
        printf("Inserisci il cognome del %d studente:\n",i+1);
        scanf("%s",elenco[i].cognome);
        printf("Inserisci l'etè del %d studente:\n",i+1);
        scanf("%d",&elenco[i].eta);
        printf("Inserisci la classe del %d studente:\n",i+1);
        scanf("%s",elenco[i].classe);
        printf("\n");
    }
    // Codice per la scrittura dell'elenco su file
    puntafile=fopen("elenco.dat","wb");
    if(puntafile!=NULL){
        fwrite(elenco,sizeof(studente),N,puntafile);
        fclose(puntafile);
        
        printf("---Stampa---\n\n");
        puntafile=fopen("elenco.dat","rb");
        if(puntafile!=NULL){
            fread(elenco,sizeof(studente),N,puntafile);
            fclose(puntafile);
            for(i=0;i<N;i++){
                printf("Nome: %s\n",elenco[i].nome);
                printf("Cognome: %s\n",elenco[i].cognome);
                printf("Età: %d\n",elenco[i].eta);
                printf("Classe: %s\n\n",elenco[i].classe);
            }
        }
        else{
            printf("ERRORE! Non sono riscito ad aprire il file!\n");
        }
    }
    else{
        printf("ERRORE! Non sono riscito ad aprire il file!\n");
    }
    
    return (EXIT_SUCCESS);
}
