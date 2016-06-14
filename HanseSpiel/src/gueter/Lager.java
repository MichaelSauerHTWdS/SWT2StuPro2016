package gueter;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Lager {

	HashMap<Gut, Integer> gueter;

	private int kapazitaet;
	private int MAXKAPAZITAET;

	/**
	 * Constructor
	 * 
	 * @param kapazitaet
	 */
	public Lager(int kapazitaet) {
		gueter = new HashMap<Gut, Integer>();
		this.kapazitaet = kapazitaet;
		this.MAXKAPAZITAET = kapazitaet;
	}

	public int getKapazitaet() {
		return kapazitaet;
	}

	public void clearLager() {
		this.gueter.clear();
		this.kapazitaet = this.MAXKAPAZITAET;
	}

	public int entladen(Gut gut, int request) {
		int bestand = gueter.get(gut);

		// Ueberpruefen ob die Anzahl des Gutes da ist.
		if (request <= bestand) {
			// Ist da
			bestand -= request;

			// Kapazitaet setzen
			this.kapazitaet += request;

			if (bestand == 0) {
				// Wenn Gut leer ist entfernen
				this.gueter.remove(gut);
			} else {
				// neuer Lagerbestand setzen
				this.gueter.replace(gut, bestand);
			}

			return request;
		} else {
			// TODO Es sind nicht genuegend Gueter im Lager.
		}

		return -1;
	}

	public int beladen(Gut gut, int menge) {

		// Ueberpruefen ob noch kapazitaet da ist
		if (menge <= this.kapazitaet) {
			// Kann zugeladen werden
			this.kapazitaet -= menge;

			// Ueberpruefen ob das gut schon da ist
			if (this.gueter.containsKey(gut)) {
				this.gueter.replace(gut, this.gueter.get(gut) + menge);
			} else {
				this.gueter.put(gut, menge);
			}
		} else {
			// TODO wenn nicht genug platz im Laget ist
		}

		return -1;
	}

	public String toString() {
		String tmp = "";
		for (Entry<Gut, Integer> i : this.gueter.entrySet()) {
			tmp += i.getKey().toString() + "  -  " + i.getValue() + "\n";
		}

		return tmp;
	}

}
