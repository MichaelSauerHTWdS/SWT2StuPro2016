package player;

import java.util.ArrayList;

import objekt.Stadt;
import schiff.Schiff;
import schiff.SchiffsTyp;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Player {

	String name;
	public ArrayList<Schiff> schiffe;
	Konto konto;

	public Player(String name, int kapital) {
		this.name = name;
		this.schiffe = new ArrayList<Schiff>();

		this.konto = new Konto(kapital);
	}

	void buyShip(Stadt stadt, SchiffsTyp typ) throws KontoException {
		konto.auszahlung(typ.getKaufpreis());

		Schiff schiff = new Schiff("", stadt, typ, this);
		stadt.schiffe.add(schiff);
		this.schiffe.add(schiff);
	}

	public String getName() {
		return this.name;
	}

	public int getKontostand() {
		return this.konto.kontostand;
	}

	public int bezahlen(int kosten) throws KontoException {
		return this.konto.auszahlung(kosten);
	}

	public void einzahlen(int einzahlung) {
		this.konto.einzahlung(einzahlung);
	}

	public void setGuthaben(int guthaben) {
		this.konto.kontostand = guthaben;
	}

	@Override
	public boolean equals(Object anObject) {
		if (anObject instanceof Player) {
			if (this.name.equals(((Player) anObject).name)) {
				return true;
			}
		}
		return false;
	}

}
