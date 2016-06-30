package run;

import player.Player;
import tui.Manager;
import tui.MenuesTUI;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Run {

	public static void main(String[] args) {

		Manager manager = new Manager();
		MenuesTUI menues = new MenuesTUI(manager);

		// ------------------------------ Testerstellung ---

		// ------------------------------ Normal Game---
		menues.beforeStart();

		manager.createKontors();

		boolean next = true;

		while (next == true) {

			//
			manager.intialEvents();
			manager.executeEvents();

			manager.stadtVerbrauchUPreis();
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

		MenuesTUI.println("Die Partie ist vorbei Auswertung: ");

		// TODO Statistik

	}

}
