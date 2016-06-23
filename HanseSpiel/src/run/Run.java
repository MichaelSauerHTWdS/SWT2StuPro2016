package run;

import player.Player;
import tui.Manager;
import tui.Menues;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Run {

	public static void main(String[] args) {

		Manager manager = new Manager();
		Menues menues = new Menues(manager);

		// ------------------------------ Testerstellung ---

		// ------------------------------ Normal Game---
		menues.beforeStart();

		boolean next = true;

		while (next == true) {

			//
			manager.intialEvents();
			manager.executeEvents();

			//
			manager.moveAll();

			//
			manager.searchForDeadShips();

			// Spieler kommen nach einaderdran
			for (Player p : manager.players) {
				menues.showWorldMenue(p);
			}

			if (manager.players.isEmpty()) {
				next = false;
			}

		}

		Menues.println("Die Partie ist vorbei Auswertung: ");

		// TODO Statistik

	}

}
