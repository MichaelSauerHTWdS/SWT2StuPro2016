package objekt;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class SeeRoute {

	// FROM
	Stadt stadt_1; // -1
	// TO
	Stadt stadt_2; // +1

	ArrayList<Wasser> route = new ArrayList<Wasser>();

	int laenge;

	public SeeRoute(Stadt stadt_1, Stadt stadt_2, int laenge) {

		this.laenge = laenge;
		this.stadt_1 = stadt_1;
		this.stadt_2 = stadt_2;

		stadt_1.SeeRouten.add(this);
		stadt_2.SeeRouten.add(this);

		for (int i = 0; i < laenge; i++) {
			route.add(new Wasser(i));
		}

	}

	/**
	 * Verteilt die Events auf die Wasserfläche.
	 */
	public void intialEvents() {
		for (Wasser w : route) {
			w.intialEvents();
		}
	}

	public void executEvents() {
		for (Wasser w : route) {
			w.executeEvents();
		}

	}

	/**
	 * Bewege alle Schiffe auf dieser Seeroute
	 */
	public void moveShips() {
		LinkedHashMap<Schiff, Wasser> toMove = new LinkedHashMap<Schiff, Wasser>();

		for (Wasser w : route) {
			for (int i = 0; i < w.schiffe.size(); i++) {
				Schiff s = w.schiffe.get(i);
				// Prüfen ob das Schiff sich diese Runde schon bewegt hat
				if (s.hasMoved() == false) {
					toMove.put(s, w);
				} else {
					// Das Schiff war diese Runde schon unterwegs
				}
			}
		}

		for (Schiff s : toMove.keySet()) {
			move(toMove.get(s), s);
		}
	}

	/**
	 * Bewegt eine einzeles Schiff von einem Abschnitt zum nächsten.
	 * 
	 * @param w
	 * @param s
	 */
	private void move(Wasser w, Schiff s) {
		if (s.getTarget().equals(stadt_1)) {
			// Schiff kommt von Stadt-2
			w.schiffe.remove(s);
			if (w.positon == 0) {
				// Schiff erreicht Stadt (Wasser to Stadt)
				stadt_1.schiffe.add(s);
				s.move(this.stadt_1);
			} else {
				// Schiff wird verschoben (Wasser to Wasser)
				route.get(w.positon - 1).schiffe.add(s);
				s.move(this.route.get(w.positon - 1));
			}
		} else {
			// Schiff kommt von Stadt-1
			w.schiffe.remove(s);
			if (w.positon > this.laenge - 2) {
				// Schiff erreicht Stadt (Wasser to Stadt)
				stadt_2.schiffe.add(s);
				s.move(this.stadt_2);
			} else {
				// Schiff wird verschoben (Wasser to Wasser)
				route.get(w.positon + 1).schiffe.add(s);
				s.move(this.route.get(w.positon + 1));
			}
		}
	}

	public void resetMoveAll() {
		for (Wasser w : this.route) {
			w.resetMove();
		}
	}

	/**
	 * Fügt einer Route ein Schiff hinzu
	 * 
	 * @param s
	 * @param start
	 */
	public void addShipToRoute(Schiff s, Stadt start) {
		// Position wo das schiff eingefügt wird
		int position = 0;
		start.schiffe.remove(s);
		if (start.equals(this.stadt_1)) {
			s.setTarget(this.stadt_2);
			this.route.get(0).schiffe.add(s);
			position = 0;
		} else {
			s.setTarget(this.stadt_1);
			this.route.get(this.laenge - 1).schiffe.add(s);
			position = this.laenge - 1;
		}
		s.inSeeStechen(this.route.get(position), this.laenge);
	}

	@Override
	public String toString() {
		String tmp = "--- Route from " + this.stadt_1.getName() + " to " + this.stadt_2.getName() + "---\n";
		tmp += this.stadt_1.toString();

		for (Wasser w : this.route) {
			tmp += w.toString();
		}

		tmp += this.stadt_2.toString();
		return tmp;
	}

	public int getLaenge() {
		return this.laenge;
	}

}
