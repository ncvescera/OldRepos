#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definisci le costanti
#define N 3
#define MAX_STRLEN 30
// Definisci il tipo di dato struct s_studente
struct s_studente{
    char name[MAX_STRLEN+1];
    char surname[MAX_STRLEN+1];
    unsigned int age;
    char class[MAX_STRLEN+1];
};
// Definisci studente come struct s_studente
typedef struct s_studente studente;
// Dichiara il prototipo della funzione di ordinamento
void ordina( studente record[], int n);
int main(int argc, char** argv) {
    // Dichiara le variabili locali
    int i;
    studente elenco[N];
    // Codice per l'inserimento, da parte dell'utente, dei dati
    for(i=0;i<N;i++){
        printf("Inserisci il nome della %d persona: ",i+1);
        scanf("%s",(elenco[i].name));
        printf("Inserisci il cognome della %d persona: ",i+1);
        scanf("%s",(elenco[i].surname));
        printf("Inserisci l'età della %d persona: ",i+1);
        scanf("%d",&(elenco[i].age));
        printf("Inserisci la classe della %d persona: ",i+1);
        scanf("%s",(elenco[i].class));
    }
    // Ordina l'elenco (con funzione)
    ordina(elenco,N);
    // Codice per la stampa dei dati (uno studente per riga)
    for(i=0;i<N;i++){
        printf("%s; %s; %d; %s;\n",elenco[i].name,elenco[i].surname,elenco[i].age,elenco[i].class);
    }
    return (EXIT_SUCCESS);
}
// Definisci la funzione di ordinamento
void ordina( studente record[], int n){
    studente temp;
    int i,j,min;
    for(i=0;i<n-1;i++){
        min=i;
        for(j=i+1;j<n;j++){
            if(strcmp(record[j].surname,record[min].surname)<0){
                min=j;
                }
            }
        temp=record[min];
        record[min]=record[i];
        record[i]=temp;
    }
}
