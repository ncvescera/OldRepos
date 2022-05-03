#!/usr/bin/python
import color_markup_string as cms

def scritta():
	print " _                       _                            _ _       "
	print "| |                     (_)                          | (_)      "
	print "| |     __ _   _ __ ___  _  __ _   _ __ ___   ___  __| |_  __ _ "
	print "| |    / _` | | '_ ` _ \| |/ _` | | '_ ` _ \ / _ \/ _` | |/ _` |"
	print "| |___| (_| | | | | | | | | (_| | | | | | | |  __/ (_| | | (_| |"
	print "|______\__,_| |_| |_| |_|_|\__,_| |_| |_| |_|\___|\__,_|_|\__,_|"
	print "\n"                                                                 
#fine procedura

media = 0
totale = 0
inserito = 1
numero = 0

scritta()

while ( inserito != 0 ):
	inserito = input("Inserisci un numero: ")
	if (inserito):
		numero = inserito
		media = media + numero
		totale = totale + 1
	

media = (float(media) / totale)
if (media > 6):
	str_inizio = "<green>"
	str_fine = "</green>"
elif (media == 6):
	str_inizio = "<yellow>"
	str_fine = "</yellow>"
else:
	str_inizio = "<red>"
	str_fine = "</red>"
print cms.color("\nLa tua media e': "+str_inizio+str(media)+str_fine)


