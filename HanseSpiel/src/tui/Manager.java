package tui;

import java.util.ArrayList;

import objekt.SeeRoute;
import objekt.Stadt;
import player.Player;
import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Manager {

	public ArrayList<Player> players;
	public ArrayList<SeeRoute> seeRouten;
	public ArrayList<Stadt> staedte;

	int startGuthaben = 100000;
	int startSchiffe = 2;

	public Manager() {
		players = new ArrayList<Player>();
		seeRouten = new ArrayList<SeeRoute>();
		staedte = new ArrayList<Stadt>();

		this.buildCity();

		this.buildSeeRouten();
	}

	void buildCity() {
		String[] namen = { "Koeln", "Bruegge", "Hamburg", "Luebeck", "Visby", "Novgorod", "Bergen", "London" };

		for (int i = 0; i < namen.length; i++) {
			staedte.add(new Stadt(namen[i]));
			// System.out.println(i + " - " + namen[i]);
		}
	}

	public Stadt getCityByName(String name) {

		// System.out.println("Input : " + name);

		for (Stadt s : this.staedte) {

			if (name.equals(s.getName())) {

				return s;
			}

		}
		return null;
	}

	public void addAShipToRoute(String ZStadt, Schiff s) {
		Stadt sSt = (Stadt) s.getPosition();
		sSt.getASeeRouteByStadt(ZStadt).addShipToRoute(s, sSt);
	}

	void buildSeeRouten() {

		Stadt stadt = this.getCityByName("Koeln");
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Bruegge"), 1));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Hamburg"), 4));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Visby"), 13));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Novgorod"), 19));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Luebeck"), 10));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Bergen"), 8));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("London"), 2));

		stadt = this.getCityByName("Bruegge");
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Hamburg"), 3));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Visby"), 12));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Novgorod"), 18));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Luebeck"), 9));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Bergen"), 7));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("London"), 1));

		stadt = this.getCityByName("Hamburg");
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Visby"), 9));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Novgorod"), 15));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Luebeck"), 6));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Bergen"), 5));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("London"), 4));

		stadt = this.getCityByName("Visby");
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Novgorod"), 6));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Luebeck"), 3));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Bergen"), 9));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("London"), 10));

		stadt = this.getCityByName("Novgorod");
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Luebeck"), 9));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Bergen"), 15));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("London"), 19));

		stadt = this.getCityByName("Luebeck");
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("Bergen"), 6));
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("London"), 10));

		stadt = this.getCityByName("Bergen");
		this.seeRouten.add(new SeeRoute(stadt, this.getCityByName("London"), 6));
	}

	public void intialEvents() {
		for (SeeRoute s : this.seeRouten) {
			s.intialEvents();
		}
	}

	public void executeEvents() {
		for (SeeRoute s : this.seeRouten) {
			s.executEvents();
		}
	}

	public void moveAll() {
		for (SeeRoute s : this.seeRouten) {
			s.moveShips();
		}
		for (SeeRoute s : this.seeRouten) {
			s.resetMoveAll();
		}
	}

	public void searchForDeadShips() {

		for (Player p : this.players) {
			for (Schiff s : p.schiffe) {
				if (s.getSchadenpunkte() < 0) {
					s.eventLog.add("Schiff ist versunken im Meer!!");
					s.setDead();
				}
			}
		}
	}

	public String toString() {
		String tmp = "";

		for (SeeRoute s : this.seeRouten) {
			tmp += s.toString();
		}

		return tmp;
	}

	public void setStartGuthaben(int startGuthaben) {
		this.startGuthaben = startGuthaben;
		for (Player p : this.players) {
			p.setGuthaben(startGuthaben);
		}
	}

}
