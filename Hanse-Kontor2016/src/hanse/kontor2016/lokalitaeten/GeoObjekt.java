package hanse.kontor2016.lokalitaeten;

import java.util.LinkedList;

import hanse.kontor2016.kontor.Kontor;
import hanse.kontor2016.schiff.Schiff;
/**
 * Eine Klasse zur Repräsentation von Städten und Strecken im Hanse-Kontor Spiel
 * @author sbastian
 *
 */
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
	/**
	 * Konstruiert ein GeoObjekt 
	 * @param name
	 * @param typ
	 * @param kontor
	 * @param hafen
	 * @param werft
	 */
	public GeoObjekt(String name, boolean typ, Kontor kontor, Hafen hafen, Werft werft) {
		this.name = name;
		this.typ = typ;
		this.kontor = kontor;
		this.hafen = hafen;
		this.werft = werft;
	}
	/**
	 * liefert den Namen des GeoObjekts
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * liefert den Typ des GeoObjekts
	 * @return type
	 */
	public boolean isTyp() {
		return typ;
	}
	/**
	 * ändert den typ des GeoObjekts
	 * @param typ
	 */
	public void setTyp(boolean typ) {
		this.typ = typ;
	}
	/**
	 * liefert das wetter des GeoObjekts
	 * @return
	 */
	public double getWetter() {
		return wetter;
	}
	/**
	 * ändert das wetter des GeoObjekts
	 * @param wetter
	 */
	public void setWetter(double wetter) {
		this.wetter = wetter;
	}
	/**
	 * gibt an ob es Piraten beim GeoObjekt gibt
	 * @return pirate
	 */
	public boolean isPirate() {
		return pirate;
	}
	/**
	 * legt fest ob es Piraten gibt oder nicht
	 * @param pirate
	 */
	public void setPirate(boolean pirate) {
		this.pirate = pirate;
	}
	/**
	 * gibt den Kontor des GeoObjekts zurück
	 * @return kontor
	 */
	public Kontor getKontor() {
		return kontor;
	}
	/**
	 * legt den Kontor des GeoOBjekts fest
	 * @param kontor
	 */
	public void setKontor(Kontor kontor) {
		this.kontor = kontor;
	}
	/**
	 * gibt den Hafen des GeoObjekts zurück
	 * @return hafen
	 */
	public Hafen getHafen() {
		return hafen;
	}
	/**
	 * legt den hafen des GeoObjekts fest
	 * @param hafen
	 */
	public void setHafen(Hafen hafen) {
		this.hafen = hafen;
	}
	/**
	 * gibt die Werft des GeoObjekts zurück
	 * @return
	 */
	public Werft getWerft() {
		return werft;
	}
	/**
	 * legt die Werft des GeoObjekts fest
	 * @param werft
	 */
	public void setWerft(Werft werft) {
		this.werft = werft;
	}
	/**
	 * Gibts zurück wie viele GeoObjekte erstellt wurden
	 * @return idcount
	 */
	public static int getIdcount() {
		return idcount;
	}
	/**
	 * liefert die Id des GeoObjekts
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * gibt die Schiffe die sich beim GeoObjekt aufhalten zurück
	 * @return schiffe
	 */
	public LinkedList<Schiff> getSchiffe() {
		return schiffe;
	}
	/**
	 * fügt ein Schiff dem GeoObjekt hinzu
	 * @param schiff
	 * @return true
	 */
	public boolean addSchiff(Schiff schiff) {
		return schiffe.add(schiff);

	}
	/**
	 * entfernt ein Schiff vom GeoObjekt
	 * @param schiff
	 * @return true, wenn das schiff beim GeoObjekt war
	 */
	public boolean removeSchiff(Schiff schiff) {
		return schiffe.remove(schiff);
	}

}
