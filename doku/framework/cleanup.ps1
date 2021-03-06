# Verschiebt alle Dateien mit bestimmten Dateiendungen in diesem sowie allen Unterordnern in den Unterordner \temp.

# Liste der Dateiendungen:
$direction = $args[0] 

# Temp-Dateien aus dem Unterordner "temp" nach "Root" verschieben.
if ($direction -eq "toRoot") {
     
    $Pfad_root = get-location
    $Pfad_tmp = (join-path -path $Pfad_root -childpath \temp)
    $Liste = get-childitem -path $Pfad_tmp -recurse | Where-object { ($_.Extension -like '.acn') -or 
                                                                     ($_.Extension -like '.acr') -or 
                                                                     ($_.Extension -like '.alg') -or 
                                                                     ($_.Extension -like '.aux') -or 
                                                                     ($_.Extension -like '.bbl') -or 
                                                                     ($_.Extension -like '.bcf') -or  
                                                                     ($_.Extension -like '.blg') -or
                                                                     ($_.Extension -like '.glg') -or
                                                                     ($_.Extension -like '.glo') -or
                                                                     ($_.Extension -like '.gls') -or
                                                                     ($_.Extension -like '.ilg') -or 
                                                                     ($_.Extension -like '.ind') -or 
                                                                     ($_.Extension -like '.ist') -or 
                                                                     ($_.Extension -like '.lof') -or 
                                                                     ($_.Extension -like '.log') -or 
                                                                     ($_.Extension -like '.lot') -or 
                                                                     ($_.Extension -like '.nav') -or 
                                                                     ($_.Extension -like '.out') -or 
                                                                     ($_.Extension -like '.snm') -or 
                                                                     ($_.Extension -like '.toc') -or 
                                                                     ($_.Extension -like '.vrb')}

    if ($Liste) {

        foreach($Datei in $Liste){
        
            $ZielPfad = (join-path -path $Pfad_root -childpath $Datei.FullName.SubString($Pfad_tmp.length))
            $NeuerOrdner = (join-path -path $Pfad_root -childpath $Datei.DirectoryName.SubString($Pfad_tmp.length))
            new-item $NeuerOrdner -type directory -ea SilentlyContinue
            move-item -Path $Datei.FullName -destination $ZielPfad -force
            
            }
        }
 }


# Temp-Dateien in den Unterordner "temp" verschieben.  
   if ($direction -eq "toTemp") {
     
    $Pfad_root = get-location
    $Pfad_tmp = (join-path -path $Pfad_root -childpath \temp)
    $Liste = get-childitem -path $Pfad_root -recurse | where {$_.DirectoryName -notmatch 'temp'} | Where-object { ($_.Extension -like '.acn') -or  
                                                                                                                  ($_.Extension -like '.acr') -or 
                                                                                                                  ($_.Extension -like '.alg') -or 
                                                                                                                  ($_.Extension -like '.aux') -or 
                                                                                                                  ($_.Extension -like '.bbl') -or 
                                                                                                                  ($_.Extension -like '.bcf') -or  
                                                                                                                  ($_.Extension -like '.blg') -or
                                                                                                                  ($_.Extension -like '.glg') -or
                                                                                                                  ($_.Extension -like '.glo') -or
                                                                                                                  ($_.Extension -like '.gls') -or
                                                                                                                  ($_.Extension -like '.ilg') -or 
                                                                                                                  ($_.Extension -like '.ind') -or 
                                                                                                                  ($_.Extension -like '.ist') -or 
                                                                                                                  ($_.Extension -like '.lof') -or 
                                                                                                                  ($_.Extension -like '.log') -or 
                                                                                                                  ($_.Extension -like '.lot') -or 
                                                                                                                  ($_.Extension -like '.nav') -or 
                                                                                                                  ($_.Extension -like '.out') -or 
                                                                                                                  ($_.Extension -like '.snm') -or 
                                                                                                                  ($_.Extension -like '.toc') -or 
                                                                                                                  ($_.Extension -like '.vrb')}

    if ($Liste) {

        foreach($Datei in $Liste){
        
            $ZielPfad = (join-path -path $Pfad_tmp -childpath $Datei.FullName.SubString($Pfad_root.path.length))
            $NeuerOrdner = (join-path -path $Pfad_tmp -childpath $Datei.DirectoryName.SubString($Pfad_root.path.length))
            new-item $NeuerOrdner -type directory -ea SilentlyContinue
            move-item -Path $Datei.FullName -destination $ZielPfad -force
            
            }
        }
   }