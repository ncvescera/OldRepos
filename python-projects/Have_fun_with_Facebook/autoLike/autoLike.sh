#!/bin/bash
access=`cat ../tempToken`

#curl -X POST -d "https://graph.facebook.com/v2.7/$1/likes?access_token=$access"
# -d "access_token=$access" \
#curl -i -X POST \
# "https://graph.facebook.com/v2.7/$1/likes?access_token=$access"

curl -X POST \
 -d "access_token=$access" \
 "https://graph.facebook.com/v2.7/$1/likes"
