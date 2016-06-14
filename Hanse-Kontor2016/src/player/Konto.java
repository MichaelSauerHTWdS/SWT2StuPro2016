package player;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Konto {

	int kontostand;

	public Konto(int kapital) {
		this.kontostand = kapital;
	}

	/**
	 * Auszhalung vom Konto
	 * 
	 * @param zahlung
	 * @return neuer Kontostand wenn genug Geld da ist ,sonst -1
	 */
	public int auszahlung(int zahlung) {
		if (this.kontostand < zahlung) {
			return -1;
		} else {
			this.kontostand -= zahlung;
		}

		return kontostand;
	}

	/**
	 * Einzahlung auf's Konto
	 * 
	 * @param zahlung
	 * @return neuer Kontostand
	 */
	public int einzahlung(int zahlung) {
		return this.kontostand += zahlung;
	}
}
