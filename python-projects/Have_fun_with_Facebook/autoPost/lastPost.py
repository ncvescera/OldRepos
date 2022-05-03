#!/usr/bin/python

import psycopg2

conn = psycopg2.connect("dbname=FB user=postgres password=@@blackforce@@ host=blackforce.irpi.cnr.it port=5432")
cur = conn.cursor()
cur.execute("SELECT created_time,message,id FROM posts ORDER BY created_time desc LIMIT 5")
result = cur.fetchall()
cur.close()

for elem in result:
	print "ID: "+str(elem[2])+" TIME: "+elem[0]
	print "Message:\n"+elem[1]+"\n\n"
	
