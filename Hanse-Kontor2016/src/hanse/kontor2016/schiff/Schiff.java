package hanse.kontor2016.schiff;

import hanse.kontor2016.kontor.Lager;
import hanse.kontor2016.lokalitaeten.GeoObjekt;
import hanse.kontor2016.lokalitaeten.Route;

public class Schiff {
	private String name;
	private Schiffstyp typ;
	private int zustand = 100;
	private GeoObjekt position;
	private Lager lager;
	private Route route = null;

	public Schiff(String name, Schiffstyp typ, GeoObjekt position) {
		super();
		this.name = name;
		this.typ = typ;
		lager = new Lager(Schiffstyp.getKapazitaet(typ));
		this.position = position;
	}

	public Schiff(Schiffstyp typ, GeoObjekt position) {
		this("Schiff", typ, position);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getZustand() {
		return zustand;
	}

	public void setZustand(int zustand) {
		this.zustand = zustand;
	}

	public GeoObjekt getPosition() {
		return position;
	}

	public void setPosition(GeoObjekt position) {
		this.position = position;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Schiffstyp getTyp() {
		return typ;
	}

	public Lager getLager() {
		return lager;
	}
}
