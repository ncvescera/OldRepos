#!/bin/bash

if [ $# -eq 0 ]
then
	echo "Argomenti passati 0, richiesti 1"
	echo "./watchFB id_pagina"
	exit
fi

echo "Getting Access Token ..."
./getAccessToken.sh
echo "Decoding Access Token ..."
./parseAccessToken.py
echo "Getted Access Token !"
echo "Getting posts ..."
./getPosts.sh $1
echo "Done !"
echo ""
echo "Posts: "
./parseData.py
echo "Distinct Table ..."
./distinctTable.py
echo "Done !"
