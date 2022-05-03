# Ese038-stdout-stderr

La funzione `fprintf` è impiegata per scrivere su file in modalità testuale.

Dato che ogni programma ha almeno tre file sempre disponibili, `fprintf` può essere
impiegata per scrivere su `stdout` (standard output) e `stderr` (standard error).

Effettivamente `printf` è la versione "semplificata" di `fprintf`, che assume `stdout`
come file.

Creare un programma che chieda all'utente di inserire una stringa, comprensiva di spazi,
e di specificare una scelta numerica.

- Se il numero inserito è 1, la stringa verrà stampata su stdout.
- Se il numero inserito è 2, la stringa verrà stampata su stderr.

Il programma continua a chiedere di inserire stringhe, fintanto che non viene
specificata la stringa \[fine\] (comprensiva di parentesi quadre), che determina la fine
del programma.

1. Eseguire il programma da riga di comando senza alcun parametro.
2. Eseguire il programma da riga di comando con `./ese038-stdout-stderr.exe >output.txt`
e notare il contenuto del file `output.txt`
3. Eseguire il programma da riga di comando con `./ese038-stdout-stderr.exe 2>error.txt`
e notare il contenuto del file `error.txt`
4. Eseguire il programma da riga di comando `./ese038-stdout-stderr.exe &>entrambi.txt`
e notare il contenuto del file `entrambi.txt`
