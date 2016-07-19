package objekt;

import java.util.ArrayList;
import java.util.HashMap;

import gueter.Gut;
import gueter.Kontor;
import gueter.Markt;
import player.Player;
import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Stadt extends GeoObjekt {

	private String name;
	public ArrayList<SeeRoute> SeeRouten;
	public HashMap<Player, Kontor> Kontoren;

	public Markt markt;

	public Stadt(String name, Gut regionalGut) {
		this.name = name;
		this.SeeRouten = new ArrayList<SeeRoute>();
		this.Kontoren = new HashMap<Player, Kontor>();
		this.markt = new Markt(regionalGut);
	}

	public SeeRoute getASeeRouteByStadt(String zStadt) {
		for (SeeRoute s : this.SeeRouten) {
			if (zStadt.equals(s.stadt_1.getName())) {
				return s;
			}
			if (zStadt.equals(s.stadt_2.getName())) {
				return s;
			}
		}
		return null;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		String tmp = "------" + this.name + "------\n";
		int i = 0;
		for (Schiff s : this.schiffe) {
			tmp += i++ + " - " + s.toString() + "\n";
		}
		return tmp;
	}
}
