#!/bin/bash

#access="EAACEdEose0cBAEmHOAu4C91ZBA5ZC9vyjFuxW9ZA0tP8UhhsAQIbQcQ0SzvGN2921BSgCAc8afz5pPEn7G3dytQBuMZCrCoCQwhnSO5K8iVPg3ZAEd4yyDaCJHBwBOnA8MM1coJsN0zWz3EYZAxJ91VAlasDpZBCyY49UFJMHJwZCQZDZD"
access=`cat access`
#curl -X GET \
# "https://graph.facebook.com/v2.7/SessoDrogaPastorizia/feed?access_token=$access" > posts.json

curl -X GET \
 "https://graph.facebook.com/v2.7/$1/feed?fields=link%2Cobject_id%2Ccreated_time%2Cid%2Cpicture%2Cmessage&access_token=$access&limit=100" > posts.json
