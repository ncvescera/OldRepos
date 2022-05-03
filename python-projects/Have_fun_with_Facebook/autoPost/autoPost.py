#!/usr/bin/python
import psycopg2
import os
import sys

from connectDB import *

#print len(sys.argv)
if len(sys.argv) < 2:
	number = 10
else:
	number = sys.argv[1]

cur = conn.cursor()
cur.execute("SELECT link FROM posts ORDER BY created_time desc LIMIT "+str(number))
result = cur.fetchall()

#print line
#print result[0][0]

for elem in result:
	#print elem[0]
	os.system("./autoPost.sh "+elem[0])
	#if i > 10:
	#	break
	#i = i + 1

"""
f = open("last","w")
f.write(result[0][0])
f.close()
"""

