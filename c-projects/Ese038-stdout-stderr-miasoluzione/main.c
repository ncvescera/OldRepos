
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STRLEN 30

int main(int argc, char** argv) {
    char stringa[MAX_STRLEN+1];
    int scelta;
    
    printf("Inserisci una stringa (%d, [fine] per terminare): ",MAX_STRLEN);
        scanf("%[^\n]",stringa);
    while(strcmp(stringa,"[fine]")){
        
        puts("Dove stampo la stringa ?");
        printf("1) stdout \t2) stderr\n");
        scanf("%d",&scelta);
        
        switch(scelta){
            case 1:
                fprintf(stdout,"stdout: %s\n",stringa);
                break;
            case 2:
                fprintf(stderr,"stderr: %s\n",stringa);
                break;
            default:
                fprintf(stdout,"stdout: %s\n",stringa);
                break;
        }
        
        printf("Inserisci una stringa (%d, [fine] per terminare): ",MAX_STRLEN);
        scanf("\n%[^\n]",stringa);
    }
    
    return (EXIT_SUCCESS);
}