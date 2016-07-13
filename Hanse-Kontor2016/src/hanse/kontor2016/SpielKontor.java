package hanse.kontor2016;

import java.util.ArrayList;
import java.util.LinkedList;

import hanse.kontor2016.kontor.Kontor;
import hanse.kontor2016.kontor.Ware;
import hanse.kontor2016.lokalitaeten.GeoObjekt;
import hanse.kontor2016.lokalitaeten.Hafen;
import hanse.kontor2016.lokalitaeten.Route;
import hanse.kontor2016.lokalitaeten.Weg;
import hanse.kontor2016.lokalitaeten.Werft;

public class SpielKontor {
	private static SpielKontor instance = null;
	
	private final int geoObjektCount = 37;
	private final int streckenCount = 29;
	private final int wegeCount = 9;
	private GeoObjekt[] lokalitaeten = new GeoObjekt[geoObjektCount];
	private String[] stadtNamen = { "Köln", "Brügge", "London", "Bergen", "Hamburg", "Lübeck", "Visby", "Novgrod" };
	private Ware[] stadtWaren = Ware.values();
	private ArrayList<Weg> wege = new ArrayList<Weg>();
	private ArrayList<LinkedList<Route>> stadtRouten = new ArrayList<LinkedList<Route>>(stadtNamen.length);
	protected SpielKontor() {
		if (streckenCount + stadtNamen.length != geoObjektCount){
			throw new IllegalStateException("Anzahl der Strecken + Anzahl der Städte muss gleich Anzahl der GeoObjekte sein!");
		}
		geoObjekteAnlegen();
		wegeAnlegen();
		routenAnlegen();

	}
	
	private void geoObjekteAnlegen(){
		for (int i = 0; i < streckenCount; ++i) {
			lokalitaeten[i] = new GeoObjekt("Strecke" + i, GeoObjekt.STRECKE, null, null, null);
		}
		for (int i = streckenCount; i < geoObjektCount; ++i) {
			lokalitaeten[i] = new GeoObjekt(stadtNamen[i - streckenCount], GeoObjekt.STADT,
					new Kontor(stadtWaren[i - streckenCount]), new Hafen(), new Werft());
		}
	}
	private void wegeAnlegen(){
		wege.ensureCapacity(wegeCount);
		
		Weg koeln_bruegge = new Weg(); 
		koeln_bruegge.add(lokalitaeten[0]);
		wege.add(koeln_bruegge);
		
		Weg bruegge_london = new Weg();
		bruegge_london.add(lokalitaeten[1]);
		wege.add(bruegge_london);
		
		Weg london_bergen = new Weg();
		addStrecken(london_bergen, 2,7);
		wege.add(london_bergen);
		
		Weg bergen_hamburg = new Weg();
		addStrecken(bergen_hamburg, 7, 11);
		wege.add(bergen_hamburg);
		
		Weg hamburg_bruegge = new Weg();
		addStrecken(hamburg_bruegge, 12, 14);
		wege.add(hamburg_bruegge);
		
		Weg bergen_luebeck = new Weg();
		addStrecken(addStrecken(addStrecken(bergen_luebeck, 7, 8), 15, 15),17,19);
		wege.add(bergen_luebeck);
		
		Weg hamburg_luebeck = new Weg();
		addStrecken(addStrecken(addStrecken(hamburg_luebeck, 11, 10), 16, 16),17,19);
		wege.add(hamburg_luebeck);
		
		Weg luebeck_visby = new Weg();
		addStrecken(luebeck_visby, 20, 22);
		wege.add(luebeck_visby);
		
		Weg visby_novgrod = new Weg();
		addStrecken(visby_novgrod,23,28);
		wege.add(visby_novgrod);
	}
	
	private Weg addStrecken(Weg weg, int von, int bis){
		if (von <= bis){
			for (int i = von; i<= bis; i++){
				weg.add(lokalitaeten[i]);
			}
		} else {
			for (int i = von; i>= bis; i--){
				weg.add(lokalitaeten[i]);
			}
		}
		return weg;
	}
	private void routenAnlegen(){
		stadtRouten.ensureCapacity(stadtNamen.length);
		for (int i = 0; i<stadtNamen.length;++i){
			stadtRouten.set(i, new LinkedList<Route>());
		}
		GeoObjekt koeln = lokalitaeten[29];
		GeoObjekt bruegge = lokalitaeten[30];
		LinkedList<Route> brueggeRouten = stadtRouten.get(1);
		GeoObjekt london = lokalitaeten[31];
		GeoObjekt bergen = lokalitaeten[32];
		GeoObjekt hamburg = lokalitaeten[33];
		GeoObjekt luebeck = lokalitaeten[34];
		GeoObjekt visby = lokalitaeten[25];
		GeoObjekt novgrod = lokalitaeten[36];
		
		stadtRouten.get(0).add(new Route(koeln, bruegge, wege.get(0)));
		
		brueggeRouten.add(new Route(bruegge, koeln, wege.get(0).rueckWeg()));
		//TODO restliche Routen anlegen
	}
	public static SpielKontor getInstance() {
		if (instance == null) {
			return new SpielKontor();
		}
		return instance;
	}
	/**
	 * Gibt das GeoObjekt mit der gewünschten ID zurück. Id = Nummer auf der Karte - 1.
	 * @param id
	 * @return
	 */
	public GeoObjekt getGeoObjektById(int id){
		return lokalitaeten[id];
	}
}
