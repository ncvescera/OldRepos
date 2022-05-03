#!/usr/bin/python
import sounddevice as sd
import soundfile as sf

import urllib2
import re

import time
import sys
import os
import wget

import pyautogui

import unidecode

from bs4 import BeautifulSoup

from pydub import AudioSegment

def get_sec(time_str):
    """Get Seconds from time."""
    h = 0
    m = 0
    s = 0

    tmp = time_str.split(':')

    if len(tmp) == 3:
        h , m, s = tmp
    elif len(tmp) == 2:
        m, s = tmp
    else:
        s, = tmp

    return int(h) * 3600 + int(m) * 60 + int(s)


#html = urllib2.urlopen("https://uochitoki.bandcamp.com/album/malaeducaty-2")
#html = urllib2.urlopen("https://uochitoki.bandcamp.com/album/uochi-toki-live-autunno-2017")

#Richiedo pagina html
response = urllib2.urlopen(str(sys.argv[1]))

html = response.read()

response.close()

#Parsing Html
parsed_html = BeautifulSoup(html, features='html.parser')

album, artista = parsed_html.title.text.split(" | ")

nomi_html   = parsed_html.find_all('span', attrs={'class': 'track-title'})
tempi_html  = parsed_html.find_all('span', attrs={'class': 'time secondaryText'})

titoli = []
durate = []
durate_sec = []
tempo_totale = 0
count = 0

print "Scarico la copertina ..."
wget.download(parsed_html.find('a', attrs={'class':'popupImage'})['href'], "copertina.jpg") #scarica la copertina dell'album

print "\n"

if len(nomi_html) != len(tempi_html):
    print "La lunghezza dei tag e' diversa"
    quit()

for i in range(0, len(nomi_html)):
    titolo = unidecode.unidecode(nomi_html[i].text)
    durata = re.sub("\s+", "", tempi_html[i].text)
    titoli.append(titolo)
    durate.append(durata)

    print str(i+1) + ") " + titolo + "\t"+ durata
    #print nomi_html[i].text
    #print re.sub("\s+", "", tempi_html[i].text)

    count +=1

print "\nTOTALE: "+ str(count)

for i in range(0, len(durate)):
    #f.write(durate[i] + ",")
    dato = get_sec(durate[i])
    durate_sec.append(dato)
    tempo_totale += dato

#print durate_sec
print "Durata complessiva (in secondi): " + str(tempo_totale)

print "\nPorta il cursore sul pulsante Play"
print "Aspetta 3 secondi ..."

time.sleep(3)

fs = 48000
seconds = tempo_totale + (2 * 60)   #aggiungo 2 minuti di registrazione per essere sicuro di
                                    #registrare tutte le canzoni. Tra una canzone ed un'altra
                                    #c'e' qualche secondo di ritardo

print "Via !"

pyautogui.click()

recording = sd.rec(int( seconds * fs), samplerate=fs, channels=2)
sd.wait()

sf.write('new_file.wav', recording, fs, 'PCM_24')

"""
Taglio audio con metodo iniziale dopo aver risolto bug di conversione tempo_totale
Il tutto lavora in millisecondi
"""

print "Importo traccia audio ..."
audio = AudioSegment.from_wav("new_file.wav")
print "Fatto!"

count = 0

inizio  = 0
fine    = durate_sec[0] * 1000

print "Esporto traccia " + str(count+1) + "..."

taglio  = audio[:fine]
taglio.export(str(count+1) + "-" + titoli[0] + ".mp3", format="mp3", tags={'title': titoli[0], 'number':count+1, 'album':album, 'artist':artista})

print "Fatto!"

audio   = audio[fine:]

count += 1

for i in range(1, len(titoli)):
    inizio  = 0
    fine    = durate_sec[i] * 1000

    print "Esporto traccia " + str(count+1) + "..."

    taglio = audio[:fine]
    taglio.export(str(count+1) + "-" + titoli[i] + ".mp3", format="mp3", tags={'title': titoli[i], 'number':count+1, 'album':album, 'artist':artista})

    print "Fatto!"

    audio = audio[fine + 1000:]

    count += 1

"""
Devo sistemare il taglio delle tracce. Questo metodo risulta piu veloce.
#Taglio la traccia audio nelle varie canzoni
#count = 0
command_canzone = "ffmpeg -y -i new_file.wav -t " + durate[0] + " " +  "\"" + titoli[0] + ".wav\""
command_base    = "ffmpeg -y -i new_file.wav -ss " + durate[0] + " tmp.wav"
command_replace = "mv tmp.wav new_file.wav"

os.system(command_canzone)
os.system(command_base)
os.system(command_replace)
#count = count + 1

for i in range(1, len(titoli)):
    command_canzone = "ffmpeg -y -i new_file.wav -t " + durate[i] + " " +  "\"" + titoli[i] + ".wav\""
    command_base    = "ffmpeg -y -i new_file.wav -ss " + durate[i] + " tmp.wav"

    print command_canzone
    print command_base

    os.system(command_canzone)
    os.system(command_base)
    os.system(command_replace)
    #count = count + 1

"""
"""
<span class="time secondaryText">

            03:23

        </span>
"""
