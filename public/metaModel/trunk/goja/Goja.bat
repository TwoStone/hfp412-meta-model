@echo off

set currentGojaFile="Goja20130221JVM6.jar"

set java7BinDir="C:\Program Files\Java\jre7\bin"

start "Goja" /B /D "%~f0\.." %java7BinDir%\javaw.exe -jar %currentGojaFile%