package hanse.kontor2016.lokalitaeten;

public class Route {
	private GeoObjekt start;
	private GeoObjekt ziel;
	private Weg weg;
	public Route(GeoObjekt start, GeoObjekt ziel, Weg weg) {
		super();
		if (start.isTyp() != GeoObjekt.STADT || ziel.isTyp() != GeoObjekt.STADT){
			throw new IllegalArgumentException("Eine Route kann nur zwischen zwei Städten existieren!");
		}
		this.start = start;
		this.ziel = ziel;
		this.weg = weg;
	}
	public GeoObjekt getStart() {
		return start;
	}
	public GeoObjekt getZiel() {
		return ziel;
	}
	public Weg getWeg() {
		return weg;
	}
	
	
}
