package run;

import gueter.Gut;
import player.Player;
import schiff.Schiff;
import schiff.SchiffsTyp;
import tui.Manager;
import tui.Menues;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Run {

	public static void main(String[] args) {

		Manager manager = new Manager();
		Menues menues = new Menues(manager);

		Player player_1 = new Player("Oli", 1000);

		Schiff schiff_1 = new Schiff("Koeln 1", manager.getCityByName("Koeln"), SchiffsTyp.Kogge, player_1);
		Schiff schiff_2 = new Schiff("Koeln 2", manager.getCityByName("Koeln"), SchiffsTyp.Linienschiff, player_1);

		player_1.schiffe.add(schiff_1);
		player_1.schiffe.add(schiff_2);

		schiff_1.beladen(Gut.Bier, 50);
		schiff_1.beladen(Gut.Kupfer, 20);
		schiff_1.beladen(Gut.Kupfer, 20);
		schiff_1.beladen(Gut.Pelze, 10);

		// System.out.println(manager.toString());

		manager.addAShipToRoute("Novgorod", schiff_1);
		manager.addAShipToRoute("Visby", schiff_2);

		boolean next = true;
		while (next == true) {

			manager.intialEvents();
			manager.executeEvents();

			manager.moveAll();

			menues.showWorldMenue(player_1);

		}

		// schiff_1.lager.entladen(Gut.Bier, 60);

	}

}
