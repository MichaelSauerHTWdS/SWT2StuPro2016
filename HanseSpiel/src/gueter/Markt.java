package gueter;

import java.util.HashMap;

import player.KontoException;
import player.Kontor;
import player.Player;

public class Markt {
	Lager warenLager;

	HashMap<Gut, Integer> preisliste;
	int verbrauch = 5;
	Gut regionalesGut;

	public Markt(Gut regionalesGut) {
		this.regionalesGut = regionalesGut;
		this.warenLager = new Lager(-1);
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

		double tmp = this.warenLager.gueter.get(gut) / this.verbrauch;

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
		for (Gut gut : Gut.values()) {

			this.preisNeuBerechnen(gut);
		}
	}

	public void regionalesGutVerkaufen(int menge, Kontor kontor, Player player) throws LagerException, KontoException {
		int preis = menge * 10;

		player.bezahlen(preis);
		try {
			kontor.lager.lagern(this.regionalesGut, menge);
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
			Integer menge = this.warenLager.gueter.get(g);
			if (menge == null) {
				menge = 0;
			}

			Integer[] tmp = { preis, menge };

			preisLagerList.put(g, tmp);
		}

		return preisLagerList;
	}

	public void gutAnkauf(Gut gut, int menge, Kontor kontor, Player player) throws LagerException {
		kontor.lager.auslagern(gut, menge);
		int preis = this.preisliste.get(gut) * menge;
		try {
			this.warenLager.lagern(gut, menge);
		} catch (LagerException e) {
			e.printStackTrace();
		}
		player.einzahlen(preis);
	}

	public Gut getRegionalesGut() {
		return regionalesGut;
	}
}
