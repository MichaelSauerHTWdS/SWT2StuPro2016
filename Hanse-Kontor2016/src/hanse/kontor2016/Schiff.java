/* Hauptklasse der Schiffe

für nächstes Mal: linkedlist für Ware
methode upgrade
abstimmen */
package hanse.kontor2016;

import java.util.ArrayList;

public class Schiff {
	
	public ArrayList<Ware> schiffsware = new ArrayList<Ware>();
	private String typ = ""; 
	public  int name = 0;                     // Muss von Team Werft übergeben werden
	public  String besitzer = "";
	public	int wert = 0;
	public	int zustand = 0;
	public	int lastMaximal = 0;
	public	int lastAktuell = 0;
	//public  LinkedList ware = new LinkedList(); // benoetigen Art und Menge, des Typs Ware
	//public	GeoObjekt position = null;								// muss noch abgestimmt werden von GameLoop
	//public	Route route = null;                                    // muss noch abgestimmt werden von GameLoop
	
	public Schiff (int name, String besitzer, String typ)
	{
		// LinkedList ware, GeoObjekt position, Route route 
		this.name = name;
		this.besitzer = besitzer;
		this.typ = typ;
		this.zustand = 100;
		//this.position = position;
		this.lastAktuell = 0;
		//this.ware = ware;
		//this.route = route;
		
		switch (typ)
		{
			case "Schnigge":	
				this.wert = 250;
				this.lastMaximal = 40;
				break;
			case "Kogge":		
				this.wert = 400;
				this.lastMaximal = 100;
				break;
			case "Holk":
				this.wert = 700;
				this.lastMaximal = 150;
				break;
			case "Kraweel":
				this.wert = 1500;
				this.lastMaximal = 400;
				break;
			case "Karacke":
				this.wert = 2000;
				this.lastMaximal = 600;
				break;					
			case "Linienschiff":
				this.wert = 2500;
				this.lastMaximal = 1000;
				break;					
		}
				
	}
	
	public static void wareLaden(Schiff schiff , Ware ware) {
		if (schiff.schiffsware.contains(ware.name)) {
			int index = schiff.schiffsware.indexOf(ware.name);
			schiff.schiffsware.get(index).menge += ware.menge;
		}
		else
			schiff.schiffsware.add(ware);
	}
	
		
	//getter


	public String gettyp()
	{
		return typ;
	}
		public String getbesitzer()
	{
		return besitzer;
	}
	public int getwert()
	{
		return wert;
	}
	public int getzustand()
	{
		return zustand;
	}
	public int getlastMaximal()
	{
		return lastMaximal;
	}
	public int getlastAktuell()
	{
		return lastAktuell;
	}
	/*public GeoObjekt getposition()
	{
		return position;
	}
	public Route getroute()
	{
		return route;
	}
	*/
	
	//setter
	
	public String settyp()
	{
		return typ;
	}
	public String setbesitzer()
	{
		return besitzer;
	}
	public int setwert()
	{
		return wert;
	}
	public int setzustand()
	{
		return zustand;
	}
		public int setlastAktuell()
	{
		return lastAktuell;
	}
	/*public GeoObjekt setposition()
	{
		return position;
	}
	public Route setroute()
	{
		return route;
	}
	*/
	
}
