package run;

import gui.CreateGUI;
import player.Player;
import tui.MenuesTUI;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Run {

	public static void main(String[] args) {

		Manager manager = new Manager();
		MenuesTUI tui = new MenuesTUI(manager);
		CreateGUI gui = new CreateGUI(manager);

		// ------------------------------ Testerstellung ---

		// ------------------------------ Normal Game---

		gui.setVisible(true);

		tui.beforeStart();
		if (manager.players.isEmpty()) {
			MenuesTUI.println("Fehler ! - Kein Spieler Eingetragen -> Spiel Beendet!!");

			return;
		}

		manager.actPlayer = manager.players.get(0);
		gui.fill();
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
			gui.update();
			// Spieler kommen nach einaderdran
			for (Player p : manager.players) {
				manager.actPlayer = p;
				gui.update();
				tui.showWorldMenue(p);
			}

			if (manager.players.isEmpty()) {
				next = false;
			}
			manager.actPlayer = manager.players.get(0);
		}

		MenuesTUI.println("Die Partie ist vorbei Auswertung: ");

		// TODO Statistik

	}

}
