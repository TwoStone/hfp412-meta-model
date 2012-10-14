@echo off

set java7BinDir="C:\Program Files (x86)\Java\jre7\bin"
set currentGojaFile="Goja20121008.jar"

start "Goja" /B /D "%~f0\.." %java7BinDir%\javaw.exe -jar %currentGojaFile%