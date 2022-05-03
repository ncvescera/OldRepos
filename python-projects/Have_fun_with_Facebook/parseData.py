#!/usr/bin/python

import json
import psycopg2

from connectDB import *

f = open("posts.json","r")
all_str = f.read()
f.close()
array = json.loads(all_str)
"""
for elem in array:
	print elem
"""
data = array['data']
i = 0
condizione = 2

for elem in data:
	forQuery = []
	""""
	if i > condizione:
		condizione = condizione + 5
		string = raw_input("Press enter to continue ...\n")
		if string == "q":
			exit(0)
		print "============================================================================================="
	"""
	print "User: "+elem['id']+" Time: "+elem['created_time']
	
	forQuery.append(elem['id'])
	forQuery.append(elem['created_time'])
	
	try:
		print "Message: \n"+elem['message']
		forQuery.append(elem['message'].replace("\""," ").replace("\'"," "))
	except:
		print "Message: none"
		forQuery.append("none")
	try:
		print "Link: "+elem['link']
		forQuery.append(elem['link'])
	except:
		print "Link: none"
		forQuery.append("none")
	try:
		print "Pic: "+elem['picture']+""
		forQuery.append(elem['picture'])
	except:
		print "Pic: none"
		forQuery.append("none")
	try:
		print "Object_id: "+str(elem['object_id'])+"\n\n"
		forQuery.append(str(elem['object_id']))
	except:
		print "Object_id: none\n\n"
		forQuery.append("none")

		
	cur = conn.cursor()
	cur.execute("INSERT INTO posts(id,created_time,message,link,pic,object_id) VALUES('"+forQuery[0]+"','"+forQuery[1]+"','"+forQuery[2]+"','"+forQuery[3]+"','"+forQuery[4]+"','"+forQuery[5]+"')")
	cur.execute("COMMIT")
	"""
	try:
		print "User: "+str(elem['id'])+" Time: "+str(elem['created_time'])
		print "Message:\n"+elem['message']+"\n"
		print "Stroy: "+elem['story']+"\n\n"
		#i = i + 1
		#continue
	except:
		#commento		
		#try:
		#	#print "User: "+str(elem['id'])+" Time: "+str(elem['created_time'])
		#	print "Strory:\n"+str(elem['story'])+"\n\n"
		#	#i = i + 1
		#	#continue
		#except:
		#	#print "User: "+str(elem['id'])+" Time: "+str(elem['created_time'])
		#	print "Message:\n"+elem['message']+"\n\n"
		#commento
		pass
	"""
	i = i + 1
