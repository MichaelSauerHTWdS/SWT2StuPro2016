package gueter;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Lager {

	HashMap<Gut, Integer> gueter;

	private int kapazitaet;
	private int MAXKAPAZITAET;

	private boolean unedlich;

	/**
	 * Constructor
	 * 
	 * @param kapazitaet
	 */
	public Lager(int kapazitaet) {
		gueter = new HashMap<Gut, Integer>();
		this.kapazitaet = kapazitaet;
		this.MAXKAPAZITAET = kapazitaet;
		this.unedlich = false;

		if (this.MAXKAPAZITAET == -1) {
			this.unedlich = true;
		}

	}

	/**
	 * Entfernt alle Güter aus dem Lager
	 */
	public void clearLager() {
		this.gueter.clear();
		this.kapazitaet = this.MAXKAPAZITAET;
	}

	/**
	 * Entnimmt eine bestimmte Menge eines gutes aus dem Lager
	 * 
	 * @param gut
	 * @param request
	 * @return -1 wenn nicht genug Gueter im Lager sind
	 * @throws LagerException
	 */
	public int auslagern(Gut gut, int request) throws LagerException {
		Integer bestand = gueter.get(gut);

		if (bestand == null) {
			throw new LagerException("Lager -> Gut nicht vorhanden", request, gut, -1);
		}

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
			throw new LagerException("Lager -> nicht genug vorhanden", request, gut, bestand);
		}
	}

	/**
	 * Lagert bestimmte Menge eines Gutes im Lager
	 * 
	 * @param gut
	 * @param menge
	 * @return -1 wenn Lager Menge nicht aufnehmen kann
	 * @throws LagerException
	 */
	public int lagern(Gut gut, int menge) throws LagerException {

		// Ueberpruefen ob noch kapazitaet da ist
		if (menge <= this.kapazitaet || this.unedlich) {
			// Kann zugeladen werden
			this.kapazitaet -= menge;

			// Ueberpruefen ob das gut schon da ist
			if (this.gueter.containsKey(gut)) {
				this.gueter.replace(gut, this.gueter.get(gut) + menge);
			} else {
				this.gueter.put(gut, menge);
			}
			return this.kapazitaet;
		} else {
			throw new LagerException("Lager -> Kein Platz", menge, gut, this.kapazitaet);
		}
	}

	public String toString() {
		String tmp = "";
		for (Entry<Gut, Integer> i : this.gueter.entrySet()) {
			tmp += i.getKey().toString() + "  -  " + i.getValue() + "\n";
		}

		return tmp;
	}

	public int getKapazitaet() {
		return kapazitaet;
	}

	/**
	 * Look: [Gut] -> [Menge]
	 * 
	 * @return String[]
	 */
	public String[] gutListe() {
		String gutListe[] = new String[Gut.ANZAHL];
		int i = 0;
		for (Gut gut : Gut.values()) {
			gutListe[i] = gut.getName();
			gutListe[i] += " -> ";

			Integer menge = this.gueter.get(gut);
			if (menge == null) {
				gutListe[i] += 0;
			} else {
				gutListe[i] += menge;
			}
			i++;
		}
		return gutListe;
	}

}
