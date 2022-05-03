#!/usr/bin/python

import psycopg2

from connectDB import *

cur = conn.cursor()
cur.execute("SELECT DISTINCT id,created_time,message,pic,link,object_id FROM posts")
result = cur.fetchall()


cur = conn.cursor()
cur.execute("DELETE FROM posts")
cur.execute("COMMIT")

for elem in result:
	cur = conn.cursor()
	cur.execute("INSERT INTO posts(id,created_time,message,pic,link,object_id) VALUES('"+str(elem[0])+"','"+str(elem[1])+"','"+str(elem[2])+"','"+str(elem[3])+"','"+str(elem[4])+"','"+str(elem[5])+"')")
	cur.execute("COMMIT")

conn.close()
