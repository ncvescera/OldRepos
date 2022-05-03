#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definisci le costanti
#define N 3
#define MAX_STRLEN 30
#define FNAME "elenco.csv"

// Definisci il tipo di dato struct s_studente
struct s_studente {
    char nome[MAX_STRLEN+1];
    char cognome[MAX_STRLEN+1];
    int eta;
    char classe[MAX_STRLEN+1];
};

// Definisci studente come struct s_studente
typedef struct s_studente studente;

int main(int argc, char** argv) {
    int i,check;
    FILE *puntafile;
    studente elenco[N];
    
    printf("Inserisci i dati di %d studenti!\n",N);
    for(i=0;i<N;i++){
        printf("Nome: ");
        scanf("%s",elenco[i].nome);
        printf("Cognome: ");
        scanf("%s",elenco[i].cognome);
        printf("Età: ");
        scanf("%d",&(elenco[i].eta));
        printf("Classe: ");
        scanf("%s",elenco[i].classe);
        printf("\n");
    }
    
    puntafile=fopen(FNAME,"w");
    if(puntafile==NULL){
        printf("Errore! Impossibile creare il file %s\n",FNAME);
        exit(-1);
    }
    else
        printf("File %s creato con successo!\n",FNAME);
        
    fprintf(puntafile,"nome;cognome;età;classe\n");
    for(i=0;i<N;i++){
        check=fprintf(puntafile,"%s;%s;%d;%s\n",elenco[i].nome,elenco[i].cognome,elenco[i].eta,elenco[i].classe);
        if(check<0){
            fprintf(stderr,"Impossibile scrivere nel file!");
            exit(1);
        }
    }
    puts("Operazione andata a buon fine!");
    fclose(puntafile);
    
    return (EXIT_SUCCESS);
}