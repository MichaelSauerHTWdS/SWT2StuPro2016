package objekt;

import java.util.ArrayList;
import java.util.HashMap;

import gueter.Gut;
import player.Kontor;
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

	public Gut regionalGut;

	public HashMap<Gut, Integer> preisListe;

	public Stadt(String name, Gut regionalGut) {
		this.name = name;
		this.SeeRouten = new ArrayList<SeeRoute>();
		this.Kontoren = new HashMap<Player, Kontor>();
		this.regionalGut = regionalGut;
		this.preisListe = new HashMap<Gut, Integer>();

		for (Gut gut : Gut.values()) {
			if (gut != this.regionalGut) {
				this.preisListe.put(gut, gut.getMaxPreis());
			}
		}
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
