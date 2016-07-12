package hanse.kontor2016.kaufmann;

import java.util.LinkedList;
import java.util.Scanner;

import hanse.kontor2016.lokalitaeten.GeoObjekt;
import hanse.kontor2016.lokalitaeten.Lokalitaeten;
import hanse.kontor2016.lokalitaeten.Route;
import hanse.kontor2016.schiff.Schiff;


/**
  * Class Kaufmann
  * 
  * @author Zilch Daniel
  * @author Marx Armin
  * @author Simon Bastian : hier gibts noch was zu tun
  */
  

public class Kaufmann
{
    private Lokalitaeten lokal;
    private LinkedList<Schiff> eigeneSchiffe;
    private Konto meinKonto;
    
    public Kaufmann (Lokalitaeten l)
    {
        lokal = l;
        eigeneSchiffe = new LinkedList<Schiff>();
        meinKonto = new Konto();
    }

    
    public void macheZug ()
    {
        LinkedList <GeoObjekt> hafenList = lokal.getHafen();
        GeoObjekt chosenHafen = null;
        GeoObjekt chosenRoute = null;
        Schiff chosenSchiff = null;
        LinkedList <Schiff> eigeneSchiffeInHafen = new LinkedList<Schiff>();
        LinkedList <Route> hafenRouten = null;
        Scanner sc = new Scanner(System.in);
        String hafenWahl = new String();
        String routeWahl = new String();
        String schiffWahl = new String();
        boolean hafenChosen     = false;
        boolean hafenDone       = false;
        boolean routeChosen     = false;
        boolean schiffRouteDone = false;
        boolean schiffChosen    = false;
        int schiffCounter       = 0;
        
        while ( !hafenDone )
        {
            hafenChosen     = false;
            routeChosen     = false;
            schiffRouteDone = false;
            schiffChosen    = false;
            schiffCounter   = 0;
            
            eigeneSchiffeInHafen.clear();
        
        
            while ( !hafenChosen )
            {
                System.out.println("Häfen:\n");
                
                for ( GeoObjekt hafen : hafenList )
                {
                    System.out.println(hafen.getID() + " " + hafen.toString());
                }

                System.out.println("\nBitte ID des gewünschten Hafens eingeben oder -1 um Zug zu beenden: ");
                
                hafenWahl = sc.next();
                
                if ( !hafenWahl.equals("-1") )
                {
                    for ( GeoObjekt hafen : hafenList )
                    {
                        if ( hafen.getID() == Integer.parseInt(hafenWahl) )
                        {
                            chosenHafen = hafen;
                            hafenChosen = true;
                        }
                    }
                }
                else 
                {
                    System.out.println("Hafen Auswahl beendet!");
                    hafenChosen = true;
                    hafenDone = true;
                }
            }

            if ( !hafenDone )
            {
                hafen.WaehleHafen(this);
                
                hafenRouten = hafen.getRoute();
                
                while ( !schiffRouteDone )
                {
                    while ( !routeChosen )
                    {
                        System.out.println("Mögliche Routen für Hafen " + hafen.getName() + ":");
                        
                        for ( Route route : hafenRouten )
                        {
                            System.out.println(route.getID() + " " + route.toString());
                        }
                        
                        System.out.println("\nBitte ID der gewünschten Route eingeben oder -1 um Auswahl zu beenden: ");
                        
                        routeWahl = sc.next();
                        
                        if ( !routeWahl.equals("-1") )
                        {
                            for ( GeoObjekt route : hafenList )
                            {
                                if ( route.getID() == Integer.parseInt(routeWahl) )
                                {
                                    chosenRoute = route;
                                    routeChosen = true;
                                }
                            }
                        }
                        else 
                        {
                            System.out.println("Route Auswahl beendet!");
                            routeChosen = true;
                            schiffRouteDone = true;
                        }
                    }
                    
                    if ( !schiffRouteDone )
                    {
                        for ( Schiff schiff : eigeneSchiffe )
                        {
                            if ( chosenHafen.getSchiffe().contains(schiff) )
                            {
                                eigeneSchiffeInHafen.add(schiff);
                            }
                        }
                        
                        while ( !schiffChosen )
                        {
                            System.out.println("Verfügbare Schiffe in Hafen " + hafen.getName() + ":");
                            
                            for ( Schiff schiff : eigeneSchiffeInHafen )
                            {                            
                                System.out.println(schiff.toString());
                            }
                            
                            System.out.println("\nBitte Name des gewünschten Schiffes eingeben oder -1 um Auswahl zu beenden: ");
                            
                            schiffWahl = sc.next();
                            
                            if ( !schiffWahl.equals("-1") )
                            {
                                for ( Schiff schiff : eigeneSchiffeInHafen )
                                {
                                    if ( schiff.getName().equals(schiffWahl) )
                                    {
                                        chosenSchiff = schiff;
                                        schiffChosen = true;
                                    }
                                }
                            }
                            else 
                            {
                                System.out.println("Schiff Auswahl beendet!");
                                schiffChosen = true;
                                schiffRouteDone = true;
                            }
                        }
                        
                        if ( !schiffRouteDone )
                            chosenSchiff.sendeSchiff(chosenRoute);
                    }   
                }
            }
            
            if ( hafenDone )
                System.out.println("Zug beendet!");
        }
        
    }   

    public LinkedList<Schiff> getSchiffe () { return eigeneSchiffe; }
    
    public void addSchiff (Schiff s) { eigeneSchiffe.add(s); }
    
    public void deleteSchiff (Schiff s) { eigeneSchiffe.remove(s); }
    
    public double getKontostand () { return meinKonto.kontostand(); }
    
    public boolean zahleBetragEin (double b) { return meinKonto.einzahlen(b); }
    
    public boolean zahleBetragAus (double b) { return meinKonto.auszahlen(b); }
    
}

