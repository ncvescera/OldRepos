#!/usr/bin/python

import psycopg2

try:
	conn = psycopg2.connect("dbname= user= password= host= port=")
except:
	print "Impossibile connettersi al database!"
	exit(1)
#commento
