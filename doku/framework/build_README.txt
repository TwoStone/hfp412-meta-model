Hinweis:	In der build.bat finden sich einige Einstellungsmöglichkeiten.
			Normalerweise sollten hier aber keine Änderungen notwendig sein,
			außer man benutzt Pdf4Eclipse. Dann sollte man die Option "synctex"
			auf den Wert "1" setzen, damit die Rückwärtssuche im PDF funktioniert.

Anleitung:	Wie baue ich mir eine Build-Datei für LaTeX?

Eine Build-Datei besteht im Prinzip aus lediglich zwei Zeilen. Ein Bespiel:
	---
	cd %~f0\..
	call .\framework\build.bat <option> <parameter...>
	---
Die erste Zeile wird immer benötigt, damit wechselt man das Verzeichnis,
in dem die .bat-Datei ausgeführt wird, in das Verzeichnis, in dem die
.bat-Datei liegt. Eclipse nimmt sonst das Eclipse-Verzeichnis, das ist
nicht wirklich hilfreich.

Die zweite Zeile sieht auch immer genau so aus, nur das "<option>" wird
durch die entsprechende Option, die ausgeführt werden soll, ersetzt.

Optionen sind derzeit:
	clean			Räumt die generierten Dateien auf (d. h. ins temp-Verzeichnis)
	pdf				Generiert das PDF.
	openpdf			Öffnet das PDF.
	bibliography	Generiert die Index-Dateien für die Bibliotheken und das PDF.
	glossaries		Generiert die Index-Dateien für die Verzeichnisse und das PDF.
	all				Generiert alle Indizes und das PDF.

Eine einfache Build-Datei ist also z. B.:
	---
	cd %~f0\..
	call .\framework\build.bat pdf
	---
oder
	---
	cd %~f0\..
	call .\framework\build.bat bibliography
	---

Zusätzlich kann man noch eine beliebige Anzahl Parameter hinzufügen, indem
man sie einfach dahinter schreibt (Leerzeichen-separiert).

Parameter sind derzeit:
	autoclose		Schließt das Konsolenfenster automatisch nach der Generierung.
	openpdf			Öffnet das PDF nach der Generierung.
	noclean			Unterbindet die Verschiebung der generierten Dateien.
	synctex			Aktiviert die Synctex-Generierung für Pdf4Eclipse.

Beispiele:

Eine Build-Datei, die das PDF generiert und sich danach selbst schließt:
	---
	cd %~f0\..
	call .\framework\build.bat pdf autoclose
	---

Eine Build-Datei, die die Verzeichnis-Indizes generiert,
sich danach selbst schließt und danach nicht aufräumt:
	---
	cd %~f0\..
	call .\framework\build.bat glossaries autoclose noclean
	---

Eine Build-Datei, die das PDF generiert, die fertige Datei öffnet
und sich danach selbst schließt:
	---
	cd %~f0\..
	call .\framework\build.bat pdf autoclose openpdf
	---

Ansonsten einfach mal in die build.bat reinschauen, ist keine Raketenwissenschaft (: