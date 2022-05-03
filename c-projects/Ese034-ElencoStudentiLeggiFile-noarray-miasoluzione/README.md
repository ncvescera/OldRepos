# Ese031-ElencoStudentiOrdinato

Realizza un programma C che richieda all'utente di inserire i dati di N studenti, con N definito dal programmatore, e li stampi a schermo, uno per riga.

I dati di uno studente, da richiedere in questo esatto ordine, sono:

1. nome: stringa di lunghezza massima MAX_STRLEN, definita dal programmatore
2. cognome: stringa di lunghezza massima MAX_STRLEN, definita dal programmatore
3. età: intero non negativo
4. classe: stringa di lunghezza massima MAX_STRLEN, definita dal programmatore

Il programma *ordina* gli studenti per cognome (ordine crescente) e poi li stampa.

La stampa dovrà essere fatta nel formato seguente, con uno studente per riga.
`<nome>; <cognome>; <età>; <classe>`

Il programma dovrà usare un array di record. ricorda la funzione `strcmp`.