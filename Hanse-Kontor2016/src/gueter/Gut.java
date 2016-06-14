package gueter;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public enum Gut {

	Bier("Bier", 25), Kupfer("Kupfer", 100), Pelze("Pelze", 80), Salz("Salz", 70), Stockfisch("Stockfisch",
			10), Tuch("Tuch", 50), Wein("Wein", 40), Zinn("Zinn", 90);

	private String name;
	private int preis;

	private Gut(String name, int preis) {
		this.name = name;
		this.preis = preis;
	}

	public int getPreis() {
		return this.preis;
	}

	public String getName() {
		return this.name;
	}
}
