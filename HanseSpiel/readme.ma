#Version 0.07
Autoren:	- David : ki.david.baldauf@htw-saarland.de
			-
					
Das ist die Erste Grundlags Version des Spiels(Das selbst noch nicht da ist).

        - Runden Ablauf
                + Events
                + Schiffs Bewegung
                + Spieler Reihenfoleg
                + Preis Berechnung
                + Verbrauch von Gütern

	- Events
		+ Piraten
		+ Wetter
		
	- Schiff
		+ Alle Typen
		
	- Lager
		+ Einlagern und auslagern möglich
		+ Max. Kap festlegen
		+ TODO
			# ??
	- SeeRouten
		+ befahrbar
		+ TODO
			# mehre SeeRouten nutzen gleiches Wasser (siehe Wasser)
		
	- Wasser
		+ Events werden generiert
		+ TODO 
			# Wasseranzahl verringern (Wird mit GUI implementiert)
		
	- Städte
		+ Schiff können anlegen/ablegen
		+ Kontoren
        
        - Markt
                + Stadt Lager
                + Organiesiert den An und Verkauf der Waren
                + Preisbestimmung
                + TODO:
                    Individueller Verbrauch von waren (Unwichtig)
	- Spieler
		+ TODO
			# ?
	- Konten
		+ aus-/einbezahlen
		+ TODO
			# ?
	- Gut
	
	- TODO Erfolge (-.-)
            + Erfassung der entsprechden Events
    
        - TODO Runden Begrenzung  ( esay )
    
	
	- TUI (Text)
		+ Spiel Einstellungen
			# Change Startkapital
			# Change Startschiff Anzahl
			# Add Player
			# Spieler können Startschiffe freiverteilen
			# TODO
				* ?
				
		+ ErsterPrototyp
		+ Weltkart
		+ Stadt
			# Hafen 
				* Entsenden
				* Reparieren
                                * Ent-/Beladen (Zu Kontor)
				* TODO
					- Aufrüsten
					- Ver-/Kauf von Schiffen 
			# Kontor 
                                * Kauf des Regional Gutes
                                * Preis-Liste und Lager Bestände anzeigen 
                                * Verkauf von Gütern
                                * TODO 
                                        - Regional Gut besser darstellen (Wird nicht merh kommen)
			
	- GUI (Graphische)
		+ TODO
	
	- Exception
            + Lager fehler
            + Konto fehler
            + TODO
                # all over
			
Starten:
    java -jar HanseSpiel.jar

Bekannte Fehler:
	- Eingabe von falschen Zeichen führen zu einer Exception die zu einem Programmabruch führt. (TODO)
	- 
