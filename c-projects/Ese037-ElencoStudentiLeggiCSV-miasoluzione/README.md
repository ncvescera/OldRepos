# Ese037-ElencoStudentiLeggiCSV

[CSV] (http://it.wikipedia.org/wiki/Comma-separated_values) è un _formato testuale_ per salvare dati organizzati in tabella. CSV è l'acronimo
di Comma-Separated Values, poichè i valori in ogni riga sono separati da virgole.
In realtà è possibile impiegare anche altri caratteri, come, ad esempio, punto e
virgola.

Realizza un programma C che richieda all'utente di specificare il nome di un file
CSV da cui leggere un elenco di studenti.

I dati presenti nel file CSV sono organizzati come specificato nell'esercizio
[Ese036-ElencoStudentiSalvaCSV](https://github.com/frtrotta/Ese036-ElencoStudentiSalvaCSV)

I dati letti dovranno essere stampati a schermo secondo quanto specificato dal
seguente esempio.

Il progetto contiene già il file `elenco.csv`.

Esempio di output
```
Studente 1
Nome: Francesco
Cognome: Trotta
Eta': 37
Classe: 3ainf

Studente 2
Nome: Marcello
Cognome: Rossi
Eta': 15
Classe: 3ainf
```
*ATTENZIONE*: quando chiediamo alla funzione `(f)scanf` di leggere una stringa, essa
la considera terminata non appena incontra un carattere spazio o un ritorno a capo. Per
questa ragione risulta difficile leggere cognomi come "Di Gaetano" o "De Leonardis".
Come possiamo, allora, impiegare la funzione `(f)scanf` per leggere stringhe separate
da punto e virgola? Suggerimento: cerca "scanf scanset"
