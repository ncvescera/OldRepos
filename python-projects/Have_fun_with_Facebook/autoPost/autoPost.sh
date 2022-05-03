#!/bin/bash
access=`cat ../tempToken`

#curl -i -X POST \
# -d "message=prova 2" \
# -d "link=https%3A%2F%2Fwww.facebook.com%2FSessoDrogaPastorizia%2Fphotos%2Fa.146681228844783.1073741828.144196815759891%2F597935057052729%2F%3Ftype" \
# -d "access_token=$access" \
# "https://graph.facebook.com/v2.7/me/feed"

#echo $access

curl -X POST "https://graph.facebook.com/v2.7/me/feed?link=$1&access_token=$access"
