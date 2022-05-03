void ordinaDati(int *dato, int dim){
    int i,j;
    int temp;
    
    for(i=0;i<dim-1;i++){
        for(j=0;j<dim-1;j++){
            if(dato[j] > dato[j+1]){
                temp=dato[j];
                dato[j]=dato[j+1];
                dato[j+1]=temp;
            }
        }
    }
}

float sjf(){
    int nProcessi;
    int *processi;
    int i;
    float totale = 0;
    int first;
    
    printf("Inserisci il numero dei processi: ");
    scanf("%d",&nProcessi);
    
    if(nProcessi <= 0)
        return -2;
    
    nProcessi -= 1; //ci serve una posizione in meno dato che il primo valore che verrà inserito deve essere sempre sommato e non ordinato.
    
    processi = ((int*)malloc(nProcessi*(sizeof(int))));
    
    printf("Inserisci il tempo di esecuzione: ");
    scanf("%d",&first);
    totale += first;
    
    if(first <= 0)
        return -3;
    
    for(i=0;i<nProcessi;i++){
        printf("Inserisci il tempo di esecuzione: ");
        scanf("%d",&processi[i]);
        
        if(processi[i] <= 0)
            return -3;
    }
    
    ordinaDati(processi,nProcessi);
    
    for(i=0;i<nProcessi-1;i++){ //l'ultima posizione del vettore non ci serve perchè l'algoritmo è così
        totale += processi[i];
	
    }
    totale /= nProcessi+1;
    return totale;
}
