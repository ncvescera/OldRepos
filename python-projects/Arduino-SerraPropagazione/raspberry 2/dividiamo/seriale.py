#!/usr/bin/python
import serial

ser = serial.Serial('/dev/ttyUSB0', 9600)

def write_on_serial(command):
    ser.write(command)
