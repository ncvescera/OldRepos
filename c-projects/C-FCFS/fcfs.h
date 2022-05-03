float fcfs(int MoT){
    int processi;
    int time;
    int i;
    float totale;
    
    if (MoT<1 || MoT>2)
        return -1;
    
    printf("Inserisci il numero di processi: ");
    scanf("%d",&processi);
    
    if(processi <= 0)
        return -2;
    
    i = processi;
    while(i){
        printf("Inserisci la durata del processo: ");
        scanf("%d",&time);
        
        if(time <= 0)
            return -3;
        
        totale += time;
        i--;
    }
    totale -= time;
    
    if (MoT == 1)
        return totale;
    else
        return totale/processi;
}
