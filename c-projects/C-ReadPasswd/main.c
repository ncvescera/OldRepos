#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINELEN 50
#define MAXNAMELEN 20

struct s_data{
    char name[MAXNAMELEN + 1];
    char x[2];
    int user;
    int group;
    char type[MAXNAMELEN + 1];
    char other[30+1];
};
typedef struct s_data data;

int main(int argc, char** argv) {
    char temp[MAXLINELEN + 1];
    data riga[70];
    FILE *puntafile;
    FILE *puntafileOld;
    int i;
    int cont;
    
    puntafile = fopen("/etc/passwd","r");
    if(puntafile == NULL){
        printf("ERROR!");
        exit(-1);
    }
    else{
        i = 0;
        do{
            puntafileOld = puntafile;
            fscanf(puntafile,"%s",temp);
            fscanf(puntafileOld,"%[^:]:%[^:]:%d:%d:%[^:]:%s",riga[i].name,riga[i].x,&riga[i].user,&riga[i].group,riga[i].type,riga[i].other);
            i++;
        }//while(strcmp(temp,"List")!=0);
        while(!feof(puntafile));
      
        cont = i;
        for(i=0;i<cont;i++){
            if(riga[i].user >= 1000 && riga[i].user <=  9999){
                printf("Name: %s\n",riga[i].name);
                printf("UserId:\n%d\n",riga[i].user);
               /* printf("Type: %s\n",riga[i].type);
                printf("Other: %s\n",riga[i].other);*/
            }
        }
            
        }
    
    return (EXIT_SUCCESS);
}

