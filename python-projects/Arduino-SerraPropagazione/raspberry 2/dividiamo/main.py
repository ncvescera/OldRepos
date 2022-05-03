#!/usr/bin/python
import threading
import Tkinter as tk

from threads import *
from editThreadsState import *
from managers import *
from utils import *

#from Tkinter import *










#12 ore accesa, 12 ore spenta
#parte alle 18


frame = tk.Tk()
lab_terreno = tk.Label(frame, text="")
lab_temp = tk.Label(frame, text="")
lab_umid = tk.Label(frame, text="")

lab_terreno.pack(fill=tk.X)
lab_temp.pack(fill=tk.X)
lab_umid.pack(fill=tk.X)

#btn_pompa = tk.Button(frame, text="Pompa", command=lambda: write_on_serial('p'))
#btn_ventole = tk.Button(frame, text="Ventole", command=lambda: write_on_serial('v'))
#btn_led = tk.Button(frame, text="Led", command=lambda: write_on_serial('l'))

btn_pompa = tk.Button(frame, text="Pompa", command=lambda: pause_autom('pompa' ,True))
btn_ventole = tk.Button(frame, text="Ventole", command=lambda: pause_autom('ventole' ,True))
btn_led = tk.Button(frame, text="Led", command=lambda: pause_autom('led' ,False))
btn_lamp = tk.Button(frame, text="Lampada", command=lambda: pause_autom('lampada' ,True))
btn_resume = tk.Button(frame, text="Riprendi", command=lambda: resume_autom())

btn_pompa.pack(fill=tk.X)
btn_ventole.pack(fill=tk.X)
btn_led.pack(fill=tk.X)
btn_lamp.pack(fill=tk.X)
btn_resume.pack(fill=tk.X)

t_update_data = threading.Thread(target=update_data, args=(lab_terreno, lab_temp, lab_umid,))
t_update_data.start()

t_manager_ventole = threading.Thread(target=manager_ventole)
t_manager_ventole.start()


t_manager_pompa = threading.Thread(target=manager_pompa, args=(lab_terreno,))
t_manager_pompa.start()

t_save_hour = threading.Thread(target=save_hour)
t_save_hour.start()

t_manager_lampada = threading.Thread(target=manager_lampada)
t_manager_lampada.start()

frame.mainloop()
