package objekt;

import java.util.ArrayList;

import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Stadt implements GeoObjekt {
	
	public ArrayList<Schiff> schiffe = new ArrayList<Schiff>();
	private String name;
	

	public Stadt(String name) {
		this.name = name;
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
