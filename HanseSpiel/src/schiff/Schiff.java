package schiff;

import gueter.Gut;
import gueter.Lager;
import objekt.GeoObjekt;
import objekt.Stadt;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Schiff {

	private String name;

	private int schadenspunkte;
	private int MAXSCHADENSPUNKT;

	private Stadt target;

	private GeoObjekt position;
	private int travelTime;

	/**
	 * Ob das schiff diese runde schon dran war
	 */
	private boolean move;

	private SchiffsTyp schiffsTyp;
	public Lager lager;

	/**
	 * 
	 * @param name
	 * @param position
	 * @param schadenspunkte
	 */
	public Schiff(String name, GeoObjekt position, SchiffsTyp schiffsTyp) {
		this.position = position;
		this.name = name;
		this.lager = new Lager(schiffsTyp.lagerKap);
		this.travelTime = 0;
		this.schadenspunkte = 100;
		this.MAXSCHADENSPUNKT = this.schadenspunkte;
		this.schiffsTyp = schiffsTyp;
	}

	/**
	 * Schiff verlässt die Stadt
	 * 
	 * @param position
	 * @param travelTime
	 */
	public void inSeeStechen(GeoObjekt position, int travelTime) {
		this.move(position);
		this.travelTime = travelTime;
	}

	/**
	 * Schiff schaden zufügen.
	 * 
	 * @param dmg
	 * @return
	 */
	public int dmgSchiff(int dmg) {

		this.schadenspunkte -= dmg;

		if (this.schadenspunkte <= 0) {
			this.zerstoert();
		}

		return this.schadenspunkte;
	}

	/**
	 * Schiff reparien
	 * 
	 * @return
	 */
	public int repair() {
		this.schadenspunkte = this.MAXSCHADENSPUNKT;
		return this.schadenspunkte;
	}

	/**
	 * Schiff ist Kaputt und versinkt im Meer
	 */
	private void zerstoert() {

		// TODO

	}

	/**
	 * Schiff bewegt sich von GeoObjekt zu GeoObjekt
	 * 
	 * @param position
	 */
	public void move(GeoObjekt position) {
		this.setMoved();
		this.position = position;
		this.travelTime--;
		this.dmgSchiff(1);
	}

	/**
	 * Schiff wurde bewegt
	 */
	private void setMoved() {
		this.move = true;
	}

	/**
	 * Reset Boolean for Move
	 */
	public void resetMove() {
		this.move = false;
	}

	public boolean hasMoved() {
		return this.move;
	}

	public GeoObjekt getPosition() {
		return this.position;
	}

	public int getTravelTime() {
		return travelTime;
	}

	@Override
	public String toString() {
		String tmp = this.name + "  -  " + this.travelTime + "\n";
		tmp += "Schadenspunkte:  " + this.schadenspunkte + " / " + this.MAXSCHADENSPUNKT + "\n";
		tmp += "Lager: " + this.lager.getKapazitaet() + "/" + this.schiffsTyp.lagerKap + "\n";
		tmp += lager.toString();

		return tmp;
	}

	public String getName() {
		return this.name;
	}

	public Stadt getTarget() {
		return target;
	}

	public SchiffsTyp getSchiffsTyp() {
		return this.schiffsTyp;
	}

	public void setTarget(Stadt target) {
		this.target = target;
	}

	public void beladen(Gut gut, int menge) {
		this.lager.beladen(gut, menge);
	}

	public void entladen(Gut gut, int request) {
		this.lager.entladen(gut, request);
	}
}
