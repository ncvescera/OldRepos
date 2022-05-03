#!/usr/bin/python
import time
import datetime

from global_vars import *
from seriale import *

def update_data(lab_terreno, lab_temp, lab_umid):
    while alive:

        line = ser.readline()
        line = line[:-1]


        if len(line) > 0:
            data = line.split(';')

            if len(data) > 1:
                lab_terreno['text'] = data[0]
                lab_temp['text'] = data[1]
                lab_umid['text'] = data[2]





def save_hour():
    while alive:
        while global_lock.locked():
            time.sleep(1)
            continue

        global_lock.acquire()

        f = open("tempo", "w")
        ora = datetime.datetime.now().hour
        f.write(str(ora))
        f.close()

        global_lock.release()

        time.sleep(1)
