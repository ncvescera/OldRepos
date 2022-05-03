#!/bin/bash

ris=`find ./ |grep index.html`		#il risultato della ricerca viene assegnato alla varibile ris
echo "$ris" | tr " " "\n" > doc		#redirezionamento dell'output nel file doc (scrivo tutto nel file)
i=0					#contatore per diversificare il nome di ogni link
while read LINE				#fin quando non trova una liena vuota CREDO
do
  ln -s $LINE "link$i"			#link simbolico nel percorso presente in LINE con il nome variabile
  i=`expr $i + 1`			# i = i+1
done < doc
