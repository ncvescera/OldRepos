#!/usr/bin/python
import time
import datetime

from global_vars import *


def calcola_ore():
    while global_lock.locked():
        time.sleep(1)
        continue

    global_lock.acquire()

    f = open("tempo", "r")
    ora_letta = int(f.readline())
    f.close()
    global_lock.release()

    ore_lavoro_fatte = (ora_letta - 18) % 24    #18 -> la lampada si deve accendere alle 18

    sleep_luce = 0
    sleep_notte = 0
    skip_to_notte = False

    #print "Ore lavoro fatte: " + str(ore_lavoro_fatte)

    if ore_lavoro_fatte <= 12: #12 -> ore di luce
        sleep_luce = 12 - ore_lavoro_fatte
        sleep_notte = 12
    else:
        skip_to_notte = True
        sleep_luce = 12
        sleep_notte = 12 - (ore_lavoro_fatte - 12)  #12 -> ore di notte

    return dict(luce = sleep_luce, notte = sleep_notte, skip = skip_to_notte)
    """
    print "Ore luce: "+str(sleep_luce)
    print "Ore notte "+str(sleep_notte)
    print skip_to_notte
    """
