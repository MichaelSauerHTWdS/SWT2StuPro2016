package player;

import java.util.ArrayList;

import objekt.Stadt;
import schiff.Schiff;
import schiff.SchiffsTyp;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Player {

	String name;
	ArrayList<Schiff> schiffe;
	Konto konto;

	public Player(String name, int kapital) {
		this.name = name;
		this.schiffe = new ArrayList<Schiff>();
		this.konto = new Konto(kapital);
	}

	void buyShip(Stadt stadt, SchiffsTyp typ) {

	}

}
