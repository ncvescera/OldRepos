#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "studente.h"


studente inserisciDati(){
    studente alunno;
   
    printf("Nome: ");
    scanf("%[^\n]",(alunno.nome));
    printf("Cognome: ");
    scanf("\n%[^\n]",(alunno.cognome));
    printf("Classe: ");
    scanf("%s",(alunno.classe));
    printf("Sesso (0 uomo 1 donna): ");
    scanf("%d",&(alunno.sesso));
    printf("Età: ");
    scanf("%d",&(alunno.eta));
      
    return alunno;
}
void stampa(studente *dato, int dim, char fname[]){
    FILE *puntafile=NULL;
    int i;
    
    puntafile=fopen(fname,"w");
    if(puntafile==NULL){
        fprintf(stderr,"Errore!");
        exit(1);
    }
        
    fprintf(puntafile,"nome;cognome;classe;sesso;eta\n");
    for(i=0;i<dim;i++){
        fprintf(puntafile,"%s;%s;%s;%d;%d\n",dato[i].nome,dato[i].cognome,dato[i].classe,dato[i].sesso,dato[i].eta);
    }
    fclose(puntafile);
}
void ordinaDati(studente *dato, int dim){
    int i,j;
    studente temp;
    
    for(i=0;i<dim-1;i++){
        for(j=0;j<dim-1;j++){
            if((strcmp(dato[j].cognome,dato[j+1].cognome))>0){
                temp=dato[j];
                dato[j]=dato[j+1];
                dato[j+1]=temp;
            }
        }
    }
}
studente* rialloca(studente* corrente, int dimCorrente){
    studente* nuovoPuntatore=NULL;
    int nuovaDimensione=dimCorrente*2;
    int i;
    
    nuovoPuntatore=(studente*)malloc(nuovaDimensione*sizeof(studente));
    for(i=0;i<dimCorrente;i++){
        nuovoPuntatore[i]=corrente[i];
    }
    
    free(corrente);
    return nuovoPuntatore;
}