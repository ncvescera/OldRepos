#!/usr/bin/python
import threading
import serial
import datetime
import time
import Tkinter as tk
#from Tkinter import *
#usare Event.wait() invece che time.sleep()

global_lock = threading.Lock()
log_lock = threading.Lock()
serial_lock = threading.Lock()

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

ser = serial.Serial('/dev/ttyUSB0', 9600)

alive = True


#colori: SeaGreen1 brown1
def update_data(lab_terreno, lab_temp, lab_umid, lab_livello, btn_pompa, btn_ventole, btn_led, btn_lamp):
    color_attivo = 'SeaGreen1'
    color_spento = 'brown1'

    while alive:
        line = ""
	try:
        	line = ser.readline()
       		line = line[:-1]
	except:
		time.sleep(1)
		continue

        if len(line) > 0:
            data = line.split(';')

            if len(data) > 3:
                lab_terreno['text'] = data[0]
                lab_temp['text'] = data[1]
                lab_umid['text'] = data[2]
		lab_livello['text'] = data[3]
		
		"""
		if "Impossibile" in data[1] or "Impossibile" in data[2]:
            		log("sensore_t_u")
	    		write_on_serial('s')
	    		time.sleep(2)
	    		write_on_serial('S')
		"""

                """
                if "Impossibile" in data[1] or "Impossibile" in data[2]:
                    log("sensore_t_u")
                """

        if stato_pin['pompa'] == 'P':
            btn_pompa['bg'] = color_attivo
        else:
            btn_pompa['bg'] = color_spento

        if stato_pin['ventole'] == 'V':
            btn_ventole['bg'] = color_attivo
        else:
            btn_ventole['bg'] = color_spento

        if stato_pin['led'] == 'K':
            btn_led['bg'] = color_attivo
        else:
            btn_led['bg'] = color_spento

        if stato_pin['lampada'] == 'L':
            btn_lamp['bg'] = color_attivo
        else:
            btn_lamp['bg'] = color_spento

        """
        if "Impossibile" in data[1] or "Impossibile" in data[2]:
            log("sensore_t_u")
	    write_on_serial('s')
	    time.sleep(2)
	    write_on_serial('S')
        """      

    print "DANZO"


def write_on_serial(command):
    while serial_lock.locked():
            time.sleep(1)
            continue

    serial_lock.acquire()
    ser.write(command)
    serial_lock.release()


##Controllo Manuale-Automatico
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
#######################


##Gestione Ventole
ventole_exit_flag = threading.Event()

def ventole_on_temp(lab_temp):
    temperatura = 0.0

    while alive:
        if not t_pause['ventole']:
            try:
                temperatura = float(lab_temp['text'].split(' ')[1])   #dovrebbe prendere la temperatura
            except:
                time.sleep(1)
                continue

            if temperatura > 30.0 and stato_pin['ventole'] == 'v':
                write_on_serial('V')
            elif temperatura < 30.0 and stato_pin['ventole'] == 'v':
                write_on_serial('v')

            time.sleep(5)
        else:
            time.sleep(1)


def manager_ventole(lab_temp):
    time.sleep(10)  #aspetta che chipckit si attivi prima di scrivere sulla seriale

    t_ventole_on_temp = threading.Thread(target=ventole_on_temp, args=(lab_temp,))
    t_ventole_on_temp.start()

    while alive:
        if not t_pause['ventole']:
            write_on_serial('V')
            stato_pin['ventole'] = 'V'
            #time.sleep(10)
            #time.sleep(600)    #accende le ventole per 10 minuti
            ventole_exit_flag.wait(600)

            if not alive:
                break

            if t_pause['ventole']:
                continue

            write_on_serial('v')
            stato_pin['ventole'] = 'v'
            #time.sleep(30)
            #time.sleep(1200)     #spegne le ventole per 20 minuti
            ventole_exit_flag.wait(1200)

        else:
            time.sleep(1)

    t_ventole_on_temp.join()
    print "DANZO"
#######################


##Gestione Pompa
def manager_pompa(lab_terreno, lab_livello):
    time.sleep(3)

    terreno = 0
    livello = 0

    while alive:

        if not t_pause['pompa']:
        #    print "ASD"
            try:
                terreno = int(lab_terreno['text'].split(' ')[0])
		livello = int(lab_livello['text'])
            except:
                time.sleep(1)
                continue

            if  terreno > 604:
                if terreno > 630:
                    log("terreno")

		if livello < 250:
		    log("livello")
		    time.sleep(1)
		    continue

                write_on_serial('P')
                stato_pin['pompa'] = 'P'
                log("pompa")

                time.sleep(5)

                write_on_serial('p')
                stato_pin['pompa'] = 'p'
                time.sleep(10)
            else:
                time.sleep(1)

        else:
            time.sleep(1)

    print "DANZO"
#######################


##Gestione Lampada
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


    print "Ore luce: "+str(sleep_luce)
    print "Ore notte "+str(sleep_notte)
    print skip_to_notte


    return dict(luce = sleep_luce, notte = sleep_notte, skip = skip_to_notte)


#12 ore accesa, 12 ore spenta
#parte alle 18
lampada_exit_flag = threading.Event()

def manager_lampada():
    risultati = calcola_ore()

    """
    print risultati['luce']
    print risultati['notte']
    print risultati['skip']
    """
    time.sleep(10)

    while alive:
        if datetime.datetime.now().hour == 18:
            risultati = calcola_ore()

        if not t_pause['lampada']:
            if not risultati['skip']:
                write_on_serial('L')
                write_on_serial('K')
                stato_pin['lampada'] = 'L'
                stato_pin['led'] = 'K'
                lampada_exit_flag.wait(risultati['luce'] * 60 * 60)
                #time.sleep(risultati['luce'] * 60 * 60)
                #time.sleep(10) #valore di test

            if not alive:
                break

            if t_pause['lampada']:
                continue

            write_on_serial('l')
            write_on_serial('k')
            stato_pin['lampada'] = 'l'
            stato_pin['led'] = 'k'
            risultati['skip'] = False
            lampada_exit_flag.wait(risultati['notte'] * 60 * 60)
            #time.sleep(risultati['notte'] * 60 * 60)
            #time.sleep(30) #valore di test

        else:
            risultati = calcola_ore()
            time.sleep(1)

    print "DANZO"
#######################


def log(errore):
    while log_lock.locked():
        time.sleep(1)
        continue

    log_lock.acquire()

    file = open("log","a")
    data_log = str(datetime.datetime.now())

    #if errore == "sensore_t_u":
    #    file.write("Impossibile Leggere il sensore! " + data_log)
    if errore == "terreno":
        file.write("Terreno secco! " + data_log)
    if errore == "livello":
	file.write("Acqua finita! " + data_log)
    if errore == "pompa":
        file.write("Attivata pompa " + data_log)
    if errore == "sensore_t_u":
	file.write("Sensore riavviato ! " + data_log)

    file.write("\n")
    file.close()

    log_lock.release()


def reset_sensor(lab_temp, lab_umid):
	while alive:
		if "Impossibile" in lab_temp['text'] or "Impossibile" in lab_umid['text']:
			log("sensore_t_u")
		    	write_on_serial('s')
		    	time.sleep(20)
		    	write_on_serial('S')
		time.sleep(1)
	print "DANZO"


frame = tk.Tk()
lab_terreno = tk.Label(frame, text="", font=("Courier", 18), anchor="w", justify="left")
lab_temp = tk.Label(frame, text="", font=("Courier", 18), anchor="w", justify="left")
lab_umid = tk.Label(frame, text="", font=("Courier", 18), anchor="w", justify="left")
lab_livello = tk.Label(frame, text="", font=("Courier", 18), anchor="w", justify="left")

lab_terreno.pack(fill=tk.X)
lab_temp.pack(fill=tk.X)
lab_umid.pack(fill=tk.X)
lab_livello.pack(fill=tk.X)

#btn_pompa = tk.Button(frame, text="Pompa", command=lambda: write_on_serial('p'))
#btn_ventole = tk.Button(frame, text="Ventole", command=lambda: write_on_serial('v'))
#btn_led = tk.Button(frame, text="Led", command=lambda: write_on_serial('l'))

btn_pompa = tk.Button(frame, text="Pompa", font=("Courier", 14), command=lambda: pause_autom('pompa' ,True))
btn_ventole = tk.Button(frame, text="Ventole", font=("Courier", 14), command=lambda: pause_autom('ventole' ,True))
btn_led = tk.Button(frame, text="Led", font=("Courier", 14), command=lambda: pause_autom('led' ,False))
btn_lamp = tk.Button(frame, text="Lampada", font=("Courier", 14), command=lambda: pause_autom('lampada' ,True))
btn_resume = tk.Button(frame, text="Riprendi", font=("Courier", 14), command=lambda: resume_autom())

btn_pompa.pack(fill=tk.X)
btn_ventole.pack(fill=tk.X)
btn_led.pack(fill=tk.X)
btn_lamp.pack(fill=tk.X)
btn_resume.pack(fill=tk.X)

t_update_data = threading.Thread(target=update_data, args=(lab_terreno, lab_temp, lab_umid, lab_livello, btn_pompa, btn_ventole, btn_led, btn_lamp,))
t_update_data.start()

t_manager_ventole = threading.Thread(target=manager_ventole, args=(lab_temp,))
t_manager_ventole.start()


t_manager_pompa = threading.Thread(target=manager_pompa, args=(lab_terreno, lab_livello,))
t_manager_pompa.start()

t_save_hour = threading.Thread(target=save_hour)
t_save_hour.start()

t_manager_lampada = threading.Thread(target=manager_lampada)
t_manager_lampada.start()

t_reset_sensor = threading.Thread(target=reset_sensor, args=(lab_temp, lab_umid,))
t_reset_sensor.start()

frame.mainloop()

alive = False

t_update_data.join()

ventole_exit_flag.set()
t_manager_ventole.join()

t_manager_pompa.join()
t_save_hour.join()

lampada_exit_flag.set()
t_manager_lampada.join()

t_reset_sensor.join()
