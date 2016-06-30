package gueter;

import objekt.Stadt;
import player.Player;

/**
 * 
 * @author davidbaldauf Erweitert die Klasse Lager. Stellt den Spieler Kontor in
 *         einer Stadt da
 */
public class Kontor extends Lager {

	static final int MAXKAPKONTOR = 1000;

	private Player owner;
	private int kap;

	private Stadt standort;

	/**
	 * 
	 * @param owner
	 * @param kap
	 * @param standort
	 */
	public Kontor(Player owner, int kap, Stadt standort) {
		super(kap);
		this.owner = owner;
		this.kap = kap;
		this.standort = standort;

	}

	public static void createKontor(Player owner, Stadt standort) {
		Kontor kontor = new Kontor(owner, MAXKAPKONTOR, standort);
		standort.Kontoren.put(owner, kontor);
	}

	public Player getOwner() {
		return owner;
	}

	public int getKap() {
		return kap;
	}

	public Stadt getStandort() {
		return standort;
	}

	@Override
	public String toString() {
		String tmp = "Kontor in " + this.standort.getName() + " \n";
		tmp += super.toString();
		return tmp;
	}

}
