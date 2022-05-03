#include <stdio.h>
#include <stdlib.h>

// Definisci le costanti
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
    char fileName[MAX_STRLEN+1];
    studente temp;
    FILE *puntafile;
    // Codice per la richiesta del nome del file
    printf("Inserisci il nome del file che vuoi aprire: ");
    scanf("%s",fileName);
    // Codice per l'apertura del file, la lettura e la stampa a schermo
    puntafile=fopen(fileName,"rb");
    if(puntafile==NULL)
        printf("Errore! Impossibile aprire il file!\n");
    else{
        printf("---Stampa---\n");
        fread(&temp,sizeof(studente),1,puntafile);
        while(!feof(puntafile)){
            printf("Nome: %s\n",temp.nome);
            printf("Cognome: %s\n",temp.cognome);
            printf("Età: %d\n",temp.eta);
            printf("Classe: %s\n\n",temp.classe);
            fread(&temp,sizeof(studente),1,puntafile);
        }
        fclose(puntafile);
    }
    return (EXIT_SUCCESS);
}
