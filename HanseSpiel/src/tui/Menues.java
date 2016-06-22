package tui;

import java.util.HashMap;
import java.util.Scanner;

import objekt.Stadt;
import player.Player;
import schiff.Schiff;

public class Menues {

	Manager manager;
	Scanner read = new Scanner(System.in);

	public Menues(Manager manager) {
		this.manager = manager;

	}

	public void showWorldMenue(Player player) {
		this.showPlayerLog(player);
		boolean endTurn = false;
		while (endTurn == false) {
			this.showPlayerKonto(player);

			System.out.println(0 + " - Beende Zug");
			System.out.println("");
			int eingabe = showStaedte();

			if (eingabe == 0) {
				endTurn = true;
				return;
			} else {
				this.stadtMenue(this.manager.staedte.get(eingabe - 1), player);
			}

		}
	}

	private int showStaedte() {
		System.out.println("------------------Städte------------------");
		int i = 1;
		for (Stadt s : manager.staedte) {
			System.out.println(i++ + "  -  " + s.getName());
		}
		System.out.println("------------------------------------------");

		int eingabe = -1;
		try {
			eingabe = Integer.valueOf(read.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Eingabe konnte nicht erkannt werden!!");
		}
		return eingabe;
	}

	private void showPlayerLog(Player player) {

		for (Schiff s : player.schiffe) {
			System.out.println("---------------------------------------");
			if (s.getTravelTime() == 0) {
				System.out.println(
						"Schiffs Log von  -> " + s.getName() + " liegt in " + ((Stadt) s.getPosition()).getName());
			} else {
				System.out.println("Schiffs Log von  -> " + s.getName() + " fährt nach " + s.getTarget().getName());
				System.out.println("Dauer noch : " + s.getTravelTime());
			}
			for (String log : s.eventLog) {
				System.out.println("		" + log);
			}
			s.eventLog.clear();

		}
		System.out.println("---------------------------------------");
	}

	private void showPlayerKonto(Player player) {
		System.out.println("-----------------------------------------------");
		System.out.println(player.getName() + " : ");
		System.out.println("						" + player.getKontostand());
		System.out.println("-----------------------------------------------");
	}

	private void stadtMenue(Stadt stadt, Player player) {
		boolean back = false;
		while (back == false) {
			System.out.println("------------------" + stadt.getName() + "------------------");
			System.out.println(1 + " - Zum Hafen gehen");
			System.out.println(2 + " - Kontor Besuschen"); // TODO

			System.out.println(0 + " - Zurueck zur Weltkarte");

			int eingabe = -1;
			try {
				eingabe = Integer.valueOf(read.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Eingabe konnte nicht erkannt werden!!");
			}

			switch (eingabe) {
			case 1:
				this.hafenMenue(stadt, player);
				break;
			case 2:
				// showKontorMenue
				break;
			case 0:
				back = true;
				break;
			}
		}
	}

	private void hafenMenue(Stadt stadt, Player player) {
		boolean back = false;

		HashMap<Integer, Schiff> playerShips = new HashMap<Integer, Schiff>();
		while (back == false) {
			System.out.println("--------------Hafen--------------");
			int i = 1;
			for (Schiff s : stadt.schiffe) {

				if (s.getOwner().equals(player)) {
					playerShips.put(i, s);
					System.out.println(i++ + " - " + s.getName() + "   Status: " + s.getSchadenpunkte());
				}
			}

			System.out.println(0 + " - Zurueck zur Stadtuebersicht");
			int eingabe = -1;
			try {
				eingabe = Integer.valueOf(read.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Eingabe konnte nicht erkannt werden!!");
			}
			if (eingabe == 0) {
				return; // In Stadt Menue zurück
			}

			Schiff s = playerShips.get(eingabe);

			if (s != null) {
				this.schiffMenue(s, player);
			}
		}
	}

	private void schiffMenue(Schiff schiff, Player player) {
		boolean back = false;
		while (back == false) {
			System.out.println("Schiffs Infos - " + schiff.getName() + " :");
			System.out.println("				Status : " + schiff.getSchadenpunkte());
			System.out.println("Lager :");
			System.out.println(schiff.lager.toString());
			System.out.println("---------------------------------------------");
			System.out.println(1 + " - Entsenden");
			System.out.println(2 + " - Reparieren (Kosten:  " + schiff.getRepaturkosten() + ")");
			System.out.println(3 + " - Aufrüsten");

			System.out.println(0 + " - Zurück zum Hafen");

			int eingabe = -1;
			try {

				eingabe = Integer.valueOf(read.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Eingabe konnte nicht erkannt werden!!");
			}

			switch (eingabe) {
			case 1:
				System.out.println(0 + " - Zurück");

				eingabe = this.showStaedteUndEntfernung((Stadt) schiff.getPosition());

				if (eingabe == 0) {

				} else {
					((Stadt) schiff.getPosition()).getASeeRouteByStadt(manager.staedte.get(eingabe - 1).getName())
							.addShipToRoute(schiff, (Stadt) schiff.getPosition());
					System.out.println(schiff.getName() + " faehrt nach " + schiff.getTarget().getName());
					return;
				}

				break;
			case 2:
				if (player.bezahlen(schiff.getRepaturkosten()) == -1) {
					System.out.println("-- !! -- Sie haben nicht genug Geld -- !! --");
				}
				break;
			case 3:
				// TODO Aufrüsten
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}

	private int showStaedteUndEntfernung(Stadt stadt) {
		System.out.println("------------------Städte------------------");
		int i = 1;
		for (Stadt s : manager.staedte) {
			System.out.println(i++ + "  -  " + s.getName() + "\t\t Entfernung: "
					+ stadt.getASeeRouteByStadt(s.getName()).getLaenge());
		}
		System.out.println("------------------------------------------");

		int eingabe = -1;
		try {
			eingabe = Integer.valueOf(read.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Eingabe konnte nicht erkannt werden!!");
		}
		return eingabe;
	}

}
