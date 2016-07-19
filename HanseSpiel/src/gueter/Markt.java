package gueter;

import java.util.HashMap;

import player.KontoException;
import player.Player;

public class Markt extends Lager {

	HashMap<Gut, Integer> preisliste;
	int verbrauch = 5;
	Gut regionalesGut;

	public Markt(Gut regionalesGut) {
		super(-1);
		this.regionalesGut = regionalesGut;

		this.preisliste = new HashMap<Gut, Integer>();

		for (Gut g : Gut.values()) {
			if (g.equals(regionalesGut)) {
				this.preisliste.put(regionalesGut, 10);
			} else {
				this.preisliste.put(g, g.getMaxPreis());
			}
		}

	}

	/**
	 * Der Stadt verbrauch von Gütern.
	 */
	public void verbrauch() {

	}

	/**
	 * Berechnet der Gutpreis je nach dem wie viel Vorrätig ist in der Stadt.
	 * Ausser Regionales Gut.
	 * 
	 * @param gut
	 */
	public void preisNeuBerechnen(Gut gut) {
		if (gut.equals(this.regionalesGut)) {
			return; // Der Preis des regionalen Gutes bleibt immer gleich!!
		}

		double tmp = this.gueter.get(gut) / this.verbrauch;

		if (tmp <= 1) {
			this.preisliste.replace(gut, gut.getMaxPreis());

		} else {
			this.preisliste.replace(gut, (int) (gut.getMaxPreis() / tmp));
		}
	}

	/**
	 * Berechnet alle Güter Preise neue. Ausser Regionales Gut.
	 */
	public void allePreiseNeuBerechnen() {
		for (Gut gut : this.gueter.keySet()) {
			this.preisNeuBerechnen(gut);
		}
	}

	/**
	 * Verkauft das Regionale Gut an einen Spieler-Kontor.
	 * 
	 * @param menge
	 * @param kontor
	 * @param player
	 * @throws LagerException
	 * @throws KontoException
	 */
	public void regionalesGutVerkaufen(int menge, Kontor kontor, Player player) throws LagerException, KontoException {
		int preis = menge * 10;

		player.bezahlen(preis);
		try {
			kontor.lagern(this.regionalesGut, menge);
		} catch (LagerException e) {
			// Konto wird zurück gerollt
			player.einzahlen(preis);
			throw e;
		}
	}

	/**
	 * Gibt eine HashMap zuück Key Gut ; Value IntegerArray [0] -> preis ; [1]
	 * -> menge;
	 * 
	 * @return
	 */
	public HashMap<Gut, Integer[]> getPreisLagerListe() {
		HashMap<Gut, Integer[]> preisLagerList = new HashMap<Gut, Integer[]>();

		for (Gut g : Gut.values()) {
			int preis = this.preisliste.get(g);
			Integer menge = this.gueter.get(g);
			if (menge == null) {
				menge = 0;
			}

			Integer[] tmp = { preis, menge };

			preisLagerList.put(g, tmp);
		}

		return preisLagerList;
	}

	/**
	 * Der Markt kauft ein bestimmtes Gut an. Der Spieler bekommt das Geld
	 * dirket gutgeschrieben. Die Waren werden aus dem Kontor entfernt.
	 * 
	 * @param gut
	 * @param menge
	 * @param kontor
	 * @param player
	 * @throws LagerException
	 */
	public int gutAnkauf(Gut gut, int menge, Kontor kontor, Player player) throws LagerException {
		kontor.auslagern(gut, menge);
		int preis = this.preisliste.get(gut) * menge;
		try {
			this.lagern(gut, menge);
		} catch (LagerException e) {
			e.printStackTrace();
		}
		player.einzahlen(preis);
		this.preisNeuBerechnen(gut);
		return preis;
	}

	public Gut getRegionalesGut() {
		return regionalesGut;
	}
}
