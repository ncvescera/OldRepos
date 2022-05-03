#include <stdio.h>
#include <stdlib.h>
#include "fcfs.h"

void menu();

int main(int argc, char** argv) {
    
   float totale; 
   int MoT;                                                

   menu();
   
   printf("[1]Totale\t[2]Media\t[0]Exit\n");
   scanf("%d",&MoT);
   
   if (!MoT)
       exit(EXIT_SUCCESS);
   
   totale = fcfs(MoT);
   
   if (totale >= 0)
       printf("Il tempo di attesa è: %5.2f\n",totale);
   else if (totale == -2)
       printf("Error!Incorrect number of processes");
   else if (totale == -1)
       printf("Error! Invalid MoT\n");
   else if (totale == -3)
       printf("Error! Invalid execution time value");
    return (EXIT_SUCCESS);
}

void menu(){
    printf(" ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄\n"); 
    printf("▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n");
    printf("▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ \n");
    printf("▐░▌          ▐░▌          ▐░▌          ▐░▌          \n");
    printf("▐░█▄▄▄▄▄▄▄▄▄ ▐░▌          ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ \n");
    printf("▐░░░░░░░░░░░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n");
    printf("▐░█▀▀▀▀▀▀▀▀▀ ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀█░▌\n");
    printf("▐░▌          ▐░▌          ▐░▌                    ▐░▌\n");
    printf("▐░▌          ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌           ▄▄▄▄▄▄▄▄▄█░▌\n");
    printf("▐░▌          ▐░░░░░░░░░░░▌▐░▌          ▐░░░░░░░░░░░▌\n");
    printf(" ▀            ▀▀▀▀▀▀▀▀▀▀▀  ▀            ▀▀▀▀▀▀▀▀▀▀▀ \n");
}

