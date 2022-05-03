#!/usr/bin/python
import threading

stato_pin = dict(
    ventole = 'v',  #partono spente
    pompa = 'p',    #parte spenta
    led = 'K',       #partono accesi
    lampada = 'l'   #parte spenta
)

t_pause = dict(     #flag per controllo manuale, se True controllo manuale attivo
    ventole = False,
    pompa = False,
    lampada = False
)

global_lock = threading.Lock()
alive = True
