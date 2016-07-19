package player;

public class KontoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getFehler() {
		return fehler;
	}

	public int getPreis() {
		return preis;
	}

	public int getKontostand() {
		return kontostand;
	}

	String fehler;
	int preis;
	int kontostand;

	public KontoException(String fehler, int preis, int kontostand) {
		this.fehler = fehler;
		this.preis = preis;
		this.kontostand = kontostand;
	}

}
