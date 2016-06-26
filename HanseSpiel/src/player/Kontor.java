package player;

import gueter.Gut;
import gueter.Lager;
import objekt.Stadt;

public class Kontor {

	static final int MAXKAPKONTOR = 1000;

	Player owner;
	int kap;

	Stadt standort;

	public Lager lager;

	/**
	 * 
	 * @param owner
	 * @param kap
	 * @param standort
	 */
	public Kontor(Player owner, int kap, Stadt standort) {
		this.owner = owner;
		this.kap = kap;
		this.standort = standort;

		this.lager = new Lager(this.kap);
	}

	public static void createKontor(Player owner, Stadt standort) {
		Kontor kontor = new Kontor(owner, MAXKAPKONTOR, standort);
		standort.Kontoren.put(owner, kontor);
	}

	public int einkauf(Gut gut, int anzahl) {
		int r = 0;

		return r;
	}

	@Override
	public String toString() {
		String tmp = "Kontor in " + this.standort.getName() + " \n";
		tmp += this.lager.toString();
		return tmp;
	}

}
