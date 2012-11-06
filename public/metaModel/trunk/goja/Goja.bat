@echo off

set currentGojaFile="Goja20121106JVM6.jar"

set java7BinDir="C:\Program Files (x86)\Java\jre7\bin"

start "Goja" /B /D "%~f0\.." %java7BinDir%\javaw.exe -jar %currentGojaFile%