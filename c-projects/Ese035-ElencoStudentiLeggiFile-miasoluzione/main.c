#include <stdio.h>
#include <stdlib.h>

// Definisci le costanti
#define N 2
#define MAX_STRLEN 30
// Definisci il tipo di dato struct s_studente
struct s_studente{
    char nome[MAX_STRLEN+1];
    char cognome[MAX_STRLEN+1];
    int eta;
    char classe[MAX_STRLEN+1];
};
// Definisci studente come struct s_studente
typedef struct s_studente studente;

int main(int argc, char** argv) {
    // Dichiara le variabili locali
    FILE *puntafile;
    int i;
    int quantoHoLetto;
    char fileName[MAX_STRLEN+1];
    studente elenco[N];
    // Codice per la richiesta del nome del file
    printf("Inserisci il nome del file che voi aprire: ");
    scanf("%s",fileName);
    // Codice per l'apertura del file e la lettura
    puntafile=fopen(fileName,"rb");
    if(puntafile==NULL)
        printf("Errore! Impossibile aprire il file!");
    else{
        printf("---Stampa---\n");
        while(!feof(puntafile)){
            quantoHoLetto=fread(elenco,sizeof(studente),N,puntafile);
            // Codice per la stampa a schermo
            for(i=0;i<quantoHoLetto;i++){
		printf("Nome: %s\n",elenco[i].nome);
                printf("Cognome: %s\n",elenco[i].cognome);
                printf("Età: %d\n",elenco[i].eta);
                printf("Classe: %s\n\n",elenco[i].classe);
            }
        }
    }
    fclose(puntafile);
    return (EXIT_SUCCESS);
}
