#!/bin/bash
namefile="diary" #absolute file path

function log {
	echo "[`date`] $1" >> $namefile
}
function newtitle {
	echo -e "\t--- $1 ---" >> $namefile #-e enable escape chars
}
function end {
	echo "[`date`] Done !" >> $namefile
}
function menu {
	echo "MakeDiary help menu:"
	echo "use makediary [command] [string] to vrite on your diary !"
	echo 'An example: makediary newtitle "I am a title example"'
	echo ""
	echo "Command lists:"
	echo -e "newtitle \tAdd a new title in the diary\n        \tAn example: \n        \t--- Title ---"
	echo ""
	echo -e "log     \tWrite a normal string in your diary\n        \tAn example: \n        \tmake a log [lun  2 gen 2017, 21.25.00, STD]"
	echo ""
	echo -e "done    \tWrite a Done ! log in the diary\n        \tAn example: \n        \tDone! [lun  2 gen 2017, 21.25.00, STD]"
	echo ""
	echo -e "cat     \tShow the diary"
}
function show {
	cat $namefile;
}

case "$1" in
	--help)
		menu
		;;
	newtitle)
		newtitle "$2"
		;;
	log)
		log "$2"
		;;
	done)
		end
		;;
	show)
		show
		;;
	*)
		echo "Error! Commando not found !"
		menu
		;;
esac
