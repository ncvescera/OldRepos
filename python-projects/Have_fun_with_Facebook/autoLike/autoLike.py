#!/usr/bin/python

import psycopg2
import os

from connectDB import *

cur = conn.cursor()

cur.execute("SELECT object_id FROM posts ORDER BY created_time DESC")
result = cur.fetchall()

conn.close()

for elem in result:
	os.system("./autoLike.sh "+str(elem[0]))
