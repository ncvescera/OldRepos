#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float calcolaDelta(float a, float b, float c);
int esistonoSoluzioniReali(float a,float b,float c);
float soluzione1(float a, float b, float c);
float soluzione2(float a, float b, float c);
void stampa(float x1, float x2);
int main(int argc, char** argv) {
    float a,b,c,r1,r2;
    puts("---------Risolutore Equazione di Secondo Grado---------");
    puts("Inserisci il coefficente a");
    scanf("%f",&a);
    puts("Inserisci il coefficente b");
    scanf("%f",&b);
    puts("Inserisci il termine noto");
    scanf("%f",&c);
    if (esistonoSoluzioniReali(a,b,c)){
    r1=soluzione1(a,b,c);
    r2=soluzione2(a,b,c);
    stampa(r1,r2);
    }
    else{
        puts("NON ESISTONO SOLUZIONI!");
    }    
    return (EXIT_SUCCESS);
}
float calcolaDelta(float a,float b, float c){
    float r;
    r=b*b-(4*a*c);
    return r;
}
int esistonoSoluzioniReali(float a, float b,float c){
    float delta;
    delta=calcolaDelta(a,b,c);
    if(delta>=0)
        return 1;
    else 
        return 0;
}
float soluzione1(float a, float b, float c){
    float risultato;
    float delta=calcolaDelta(a,b,c);
    delta=sqrt(delta);
    risultato=((b*-1)+delta)/(2*a);
    return risultato;
}

float soluzione2(float a, float b, float c){
    float risultato;
    float delta=calcolaDelta(a,b,c);
    delta=sqrt(delta);
    risultato=((b*-1)-delta)/(2*a);
    return risultato;
}

void stampa(float x1,float x2){
    puts("---------RISULTATO---------");
    printf("Il valore di x1 è: %f\n",x1);
    printf("Il valore di x2 è: %f\n",x2);
    puts("---------------------------");
}
