package objekt;

import java.util.ArrayList;

import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Stadt extends GeoObjekt {

	private String name;
	public ArrayList<SeeRoute> SeeRouten;

	public Stadt(String name) {
		this.name = name;
		this.SeeRouten = new ArrayList<SeeRoute>();
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
