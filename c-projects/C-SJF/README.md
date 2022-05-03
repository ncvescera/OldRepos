# C-SJF
Implementazione dell'algoritmo Shortest Job First
# How it works
Il seguente algoritmo richiede in input il numero di processi e il tempo di esecuzione di ogni processo. I valori inseriti vengono ordinati in modo crescente, tranne il primo, che sarebbe il processo che viene eseguito subito, poi vengono sommati al primo tutti tranne l'ultimo, il più grande, e in fine il risultato viene diviso per il numero di processi inseriti, trovando così il tempo di attesa medio. Quindi, prendiamo in considerazione il seguente esempio: 

input: 6,8,7,3

sort: 3,7,8

output: (6+3+7)/4 --> 4
# sjf.h
`float sjf();`

Ritorna: 
* -2 se i porcessi inseriti sono <= 0
* -3 se uno dei tempi di esecuzione è minore o uguale a 0
* float se non si presentano errori

