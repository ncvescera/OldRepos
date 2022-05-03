#!/usr/bin/python

prova = dict( ventole = {'nome' : 'Ventole', 'value' : 'V'}, pompa = {'nome' : 'Pompa', 'value' : 'P'})
"""
stato_pin = dict([
	nome='Ventole',
	value='V'
])
"""
def myf():
	a = 1
	b = 2
	c = True
	return dict( luce = a, notte = b, skip = c)
"""
#tempo = 1
import datetime
print datetime.datetime.now().
"""
print myf()
print myf()['skip']

import threading
import time

alive = True
flag_v = threading.Event()

def myt():
	while alive:
		print "A"
		time.sleep(2)
		print "B"
		#time.sleep(600)
 		flag_v.wait(300)

tread = threading.Thread(target=myt)
tread.start()

time.sleep(10)

alive = False
#flag_v.set()
tread.join()
