package gueter;

public class LagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4606626494407988626L;

	private String fehler;
	private int menge;
	private Gut gut;
	private int platz;

	public LagerException(String fehler, int menge, Gut gut, int platz) {
		this.fehler = fehler;
		this.menge = menge;
		this.gut = gut;
		this.platz = platz;

	}

	public String getFehler() {
		return fehler;
	}

	public int getMenge() {
		return menge;
	}

	public Gut getGut() {
		return gut;
	}

	public int getPlatz() {
		return platz;
	}

	public String toString() {
		return this.fehler;
	}
}
