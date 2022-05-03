#!/usr/bin/python
import time

from global_vars import *
from seriale import *
from utils import *



def manager_pompa(lab_terreno):
    time.sleep(3)

    terreno = 0

    while alive:

        if not t_pause['pompa']:
        #    print "ASD"
            try:
                terreno = int(lab_terreno['text'].split(' ')[0])
            except:
                time.sleep(1)
                continue

            if  terreno > 604:
                write_on_serial('P')
                stato_pin['pompa'] = 'P'
                time.sleep(5)
                write_on_serial('p')
                stato_pin['pompa'] = 'p'
                time.sleep(10)
            else:
                time.sleep(1)

        else:
            time.sleep(1)

def manager_ventole():
    #time.sleep(3)

    while alive:
        if not t_pause['ventole']:
            write_on_serial('V')
            stato_pin['ventole'] = 'V'
            time.sleep(10)    #accende le ventole per 10 minuti
            if t_pause['ventole']:
                continue
            write_on_serial('v')
            stato_pin['ventole'] = 'v'
            time.sleep(30)     #spegne le ventole per 20 minuti
        else:
            time.sleep(1)
    #print "MORTO"

def manager_lampada():
    risultati = calcola_ore()

    """
    print risultati['luce']
    print risultati['notte']
    print risultati['skip']
    """
    #time.sleep(3)
    while alive:
        if datetime.datetime.now().hour == 18:
            risultati = calcola_ore()

        if not t_pause['lampada']:
            if not risultati['skip']:
                write_on_serial('L')
                stato_pin['lampada'] = 'L'
                time.sleep(risultati['luce'] * 60 * 60)
                #time.sleep(10) #valore di test

            if t_pause['lampada']:
                continue

            write_on_serial('l')
            stato_pin['lampada'] = 'l'
            risultati['skip'] = False
            time.sleep(risultati['notte'] * 60 * 60)
            #time.sleep(30) #valore di test

        else:
            risultati = calcola_ore()
            time.sleep(1)
