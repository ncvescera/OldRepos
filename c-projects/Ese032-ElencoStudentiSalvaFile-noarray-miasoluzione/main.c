#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definisci le costanti
#define N 2
#define MAX_STRLEN 20

// Definisci il tipo di dato struct s_studente
struct s_studente{
    char nome[MAX_STRLEN+1];
    char cognome[MAX_STRLEN+1];
    unsigned int eta;
    char classe[MAX_STRLEN+1];
};

// Definisci studente come struct s_studente
typedef struct s_studente studente ;

int main(int argc, char** argv) {
    // Dichiara le variabili locali
    int i;
    studente record;
    FILE *puntafile;
    // Codice per l'inserimento, da parte dell'utente, dei dati e del salvataggio
    // nel file
    puntafile=fopen("elenco.dat","wb");
    if(puntafile!=NULL){
        printf("---Inserimento Dati---\n");
        for(i=0;i<N;i++){
            
            printf("Inserisci il nome del %d studente:\n",i+1);
            scanf("%s",record.nome);
            printf("Inserisci il cognome del %d stdente:\n",i+1);
            scanf("%s",record.cognome);
            printf("Inserisci l'età del %d studente:\n",i+1);
            scanf("%d",&record.eta);
            printf("Inserisci la classe del %d studente:\n",i+1);
            scanf("%s",record.classe);
            printf("\n");
            
            fwrite(&record,sizeof(studente),1,puntafile);
        }
        fclose(puntafile);
        
        puntafile=fopen("elenco.dat","rb");
        printf("---Stampa---\n\n");
        
        for(i=0;i<N;i++){
            fread(&record, sizeof(studente), 1, puntafile);
            
            printf("Nome: %s\n",record.nome);
            printf("Cognome: %s\n",record.cognome);
            printf("Eta': %d\n",record.eta);
            printf("Classe: %s\n\n",record.classe);            
        }
        
        fclose(puntafile);
        printf("Tutto è andato a buon fine!\n");
        
    }
    
    
    else
        printf("ERRORE! Non sono riuscito ad aprire il file !\n");
    
    return (EXIT_SUCCESS);
}