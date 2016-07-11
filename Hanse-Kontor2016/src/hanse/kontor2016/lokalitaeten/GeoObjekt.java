package hanse.kontor2016.lokalitaeten;

import java.util.LinkedList;

import hanse.kontor2016.kontor.Kontor;
import hanse.kontor2016.schiff.Schiff;

public class GeoObjekt {
	public static final boolean STADT = false;
	public static final boolean STRECKE = true;
	private static int idcount = 0;

	private String name = null;
	private boolean typ = STADT;
	private double wetter = 0.0;
	private boolean pirate = false;
	private LinkedList<Schiff> schiffe = new LinkedList<Schiff>();
	private Kontor kontor = null;
	private Hafen hafen = null;
	private Werft werft = null;
	private final int id = idcount++;

	public GeoObjekt(String name, boolean typ, Kontor kontor, Hafen hafen, Werft werft) {
		this.name = name;
		this.typ = typ;
		this.kontor = kontor;
		this.hafen = hafen;
		this.werft = werft;
	}

	public String getName() {
		return name;
	}

	public boolean isTyp() {
		return typ;
	}

	public void setTyp(boolean typ) {
		this.typ = typ;
	}

	public double getWetter() {
		return wetter;
	}

	public void setWetter(double wetter) {
		this.wetter = wetter;
	}

	public boolean isPirate() {
		return pirate;
	}

	public void setPirate(boolean pirate) {
		this.pirate = pirate;
	}

	public Kontor getKontor() {
		return kontor;
	}

	public void setKontor(Kontor kontor) {
		this.kontor = kontor;
	}

	public Hafen getHafen() {
		return hafen;
	}

	public void setHafen(Hafen hafen) {
		this.hafen = hafen;
	}

	public Werft getWerft() {
		return werft;
	}

	public void setWerft(Werft werft) {
		this.werft = werft;
	}

	public static int getIdcount() {
		return idcount;
	}

	public int getId() {
		return id;
	}

	public LinkedList<Schiff> getSchiffe() {
		return schiffe;
	}

	public boolean addSchiff(Schiff schiff) {
		return schiffe.add(schiff);

	}

	public boolean removeSchiff(Schiff schiff) {
		return schiffe.remove(schiff);
	}

}
