@echo off 
setlocal enabledelayedexpansion

set /A a=1 
set /A inc=1

dir *.txt /s /b > doc.txt 
for /F "eol=; tokens=1 " %%i in (doc.txt) do ( 
	
	mklink /H link!a!.txt %%i 
	set /A a+=1
)
pause 
