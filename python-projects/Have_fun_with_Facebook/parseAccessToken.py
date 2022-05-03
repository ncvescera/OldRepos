#!/usr/bin/python

import json


f = open("secret.json","r")
lines = f.read()
f.close()

array = json.loads(lines)

print array['access_token']

f = open("access","w")
f.write(array['access_token'])
f.close()
