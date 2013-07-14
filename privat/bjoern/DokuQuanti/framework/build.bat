@echo off
cd %~f0\..\..

REM ##### KONSTANTEN ######

REM Bin-Verzeichnis von MiKTeX. Standard: "C:\Programme\MiKTeX 2.9\miktex\bin\".
set miktexBinDir="C:\Program Files\MiKTeX 2.9\miktex\bin\x64\"

REM Name des Hauptdokuments ohne die Dateiendung. Standard: "document".
set document=document

REM Synctex-Archiv für die Rückwärtssuche in Pdf4Eclipse generieren?
REM Standard: "0", zum Aktivieren auf den Wert "1" setzen.
set synctex=1


REM ##### PARAMETER AUSWERTEN ######

REM Aktion, die ausgeführt wird.
set action=%1

REM Optionen auswerten
For %%i in (%*) do if /i "%%~i" equ "autoclose" set autoclose=true
For %%i in (%*) do if /i "%%~i" equ "openpdf" set openpdf=true
For %%i in (%*) do if /i "%%~i" equ "noclean" set noclean=true
For %%i in (%*) do if /i "%%~i" equ "synctex" set synctex=1


REM ##### FUNKTIONEN ######

REM Schiebt alle generierten Dateien in das Temp-Verzeichnis.
IF "%action%" == "clean" (
	GOTO end
)

REM Öffnet die PDF-Datei.
IF "%action%" == "openpdf" (
	set noclean=true
	GOTO end
)

REM Führt den LaTeX-Compiler zweimal aus, um auch die Verzeichnisse neu zu generieren.
IF "%action%" == "pdf" (
	echo Verschiebe generierte Dateien aus dem letzten Build ins Hauptverzeichnis...
	start /B /WAIT powershell .\framework\cleanup.ps1 toRoot
	%miktexBinDir%pdflatex.exe -draftmode -interaction=nonstopmode %document%
	%miktexBinDir%pdflatex.exe -synctex=%synctex% -interaction=nonstopmode %document%
	GOTO end
)

REM Erstellt die Indizes für die Bibliotheken und generiert anschließend das PDF.
IF "%action%" == "bibliography" (
	echo Verschiebe generierte Dateien aus dem letzten Build ins Hauptverzeichnis...
	start /B /WAIT powershell .\framework\cleanup.ps1 toRoot
	%miktexBinDir%pdflatex.exe -draftmode -interaction=nonstopmode %document%
	%miktexBinDir%bibtex.exe Literatur
	%miktexBinDir%bibtex.exe Recht
	%miktexBinDir%bibtex.exe Internet
	%miktexBinDir%bibtex.exe Unternehmen
	%miktexBinDir%pdflatex.exe -draftmode -interaction=nonstopmode %document%
	%miktexBinDir%pdflatex.exe -synctex=%synctex% -interaction=nonstopmode %document%
	GOTO end
)

REM Erstellt die Indizes für die Verzeichnisse und generiert anschließend das PDF.
IF "%action%" == "glossaries" (
	echo Verschiebe generierte Dateien aus dem letzten Build ins Hauptverzeichnis...
	start /B /WAIT powershell .\framework\cleanup.ps1 toRoot
	%miktexBinDir%pdflatex.exe -draftmode -interaction=nonstopmode %document%
	%miktexBinDir%makeindex.exe -s %document%.ist -t %document%.alg -o %document%.acr %document%.acn
	%miktexBinDir%makeindex.exe -s %document%.ist -t %document%.glg -o %document%.gls %document%.glo
	%miktexBinDir%pdflatex.exe -synctex=%synctex% -interaction=nonstopmode %document%
	GOTO end
)

REM Erstellt alle Indizes und generiert anschließend das PDF.
IF "%action%" == "all" (
	echo Verschiebe generierte Dateien aus dem letzten Build ins Hauptverzeichnis...
	start /B /WAIT powershell .\framework\cleanup.ps1 toRoot
	%miktexBinDir%pdflatex.exe -draftmode -interaction=nonstopmode %document%
	%miktexBinDir%makeindex.exe -s %document%.ist -t %document%.alg -o %document%.acr %document%.acn
	%miktexBinDir%makeindex.exe -s %document%.ist -t %document%.glg -o %document%.gls %document%.glo
	%miktexBinDir%bibtex.exe Literatur
	%miktexBinDir%bibtex.exe Recht
	%miktexBinDir%bibtex.exe Internet
	%miktexBinDir%bibtex.exe Unternehmen
	%miktexBinDir%pdflatex.exe -draftmode -interaction=nonstopmode %document%
	%miktexBinDir%pdflatex.exe -synctex=%synctex% -interaction=nonstopmode %document%
	GOTO end
)

REM Keine valide Option wurde gefunden, Fehlermeldung ausgeben und beenden.
echo Die Option "%1" wurde nicht gefunden.
echo.
echo Usage: call build.bat "option" [parameter...]
echo.
echo Valide Optionen: clean pdf openpdf bibliography glossaries all
echo Valide Parameter: autoclose openpdf noclean synctex
echo.
pause
exit

:end

REM PDF nach dem Generieren öffnen?
IF "%openpdf%" == "true" (
	echo Starte Anzeige des PDFs.
	start "C:\Programme\Adobe\Reader\AcroRd32.exe" %document%.pdf
)

REM Temporäre Dateien in den Temp-Ordner verschieben?
IF NOT "%noclean%" == "true" (
	echo Verschiebe generierte Dateien ins temp-Verzeichnis...
	start /B powershell .\framework\cleanup.ps1 toTemp
)

REM Das Fenster automatisch schließen?
IF NOT "%autoclose%" == "true" (
	pause
)