#!/usr/bin/python
from global_vars import *
from seriale import *

def pause_autom(pin, pause_val):
    global stato_pin

    if stato_pin[pin].islower():
        stato_pin[pin] = stato_pin[pin].upper()
    else:
        stato_pin[pin] = stato_pin[pin].lower()

    ser.write(stato_pin[pin])

    #if not (pin == 'led'):
    global t_pause
    t_pause[pin] = pause_val


def resume_autom():
    global t_pause
    t_pause['ventole'] = False
    t_pause['pompa'] = False
    t_pause['lampada'] = False
