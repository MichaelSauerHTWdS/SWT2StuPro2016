package gueter;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public enum Gut {

	Bier("Bier", 25), Kupfer("Kupfer", 100), Pelze("Pelze", 80), Salz("Salz", 70), Stockfisch("Stockfisch",
			10), Tuch("Tuch", 50), Wein("Wein", 40), Zinn("Zinn", 90);

	private String name;
	private int maxPreis;

	public static final int ANZAHL = 8;

	private Gut(String name, int preis) {
		this.name = name;
		this.maxPreis = preis;
	}

	public int getMaxPreis() {
		return this.maxPreis;
	}

	public String getName() {
		return this.name;
	}
}
