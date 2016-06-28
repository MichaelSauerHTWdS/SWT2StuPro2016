package player;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
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
	 * @throws KontoException
	 */
	public int auszahlung(int zahlung) throws KontoException {
		if (this.kontostand < zahlung) {
			throw new KontoException("Nicht genung Geld", zahlung, this.kontostand);
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
