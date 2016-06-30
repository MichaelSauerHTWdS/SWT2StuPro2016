package tui;

import java.util.HashMap;
import java.util.Scanner;

import gueter.Gut;
import gueter.Kontor;
import gueter.LagerException;
import objekt.Stadt;
import player.KontoException;
import player.Player;
import schiff.Schiff;
import schiff.SchiffsTyp;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class MenuesTUI {

	Manager manager;
	Scanner read = new Scanner(System.in);

	public MenuesTUI(Manager manager) {
		this.manager = manager;

	}

	/**
	 * Gibt den Text auf der CommandoZeile aus
	 * 
	 * @param text
	 */
	public static void println(String text) {
		System.out.println(text);
	}

	/**
	 * Liest eine Zahl aus der CommandoZeile ein
	 * 
	 * @return
	 */
	private int intEinlesen() {
		int eingabe = -1;
		try {
			eingabe = Integer.valueOf(read.nextLine());
		} catch (NumberFormatException e) {
			println("Eingabe konnte nicht erkannt werden!!");
		}
		return eingabe;
	}

	/**
	 * 
	 * @param player
	 */
	public void showWorldMenue(Player player) {
		this.showPlayerKonto(player);
		this.showPlayerLog(player);

		boolean endTurn = false;
		while (endTurn == false) {
			println(0 + " - Beende Zug");
			println("");
			int eingabe = showStaedte();

			if (eingabe == 0) {
				endTurn = true;
				return;
			} else {
				this.stadtMenue(this.manager.staedte.get(eingabe - 1), player);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private int showStaedte() {
		println("------------------Städte------------------");
		int i = 1;
		for (Stadt s : manager.staedte) {
			println(i++ + "  -  " + s.getName());
		}
		println("------------------------------------------");

		int eingabe = intEinlesen();
		return eingabe;
	}

	/**
	 * 
	 * @param player
	 */
	private void showPlayerLog(Player player) {

		for (Schiff s : player.schiffe) {
			println("------------------ Event Log ------------------");
			if (s.getTravelTime() == 0) {
				println("Schiffs Log von  -> " + s.getName() + " liegt in " + ((Stadt) s.getPosition()).getName());
			} else {
				println("Schiffs Log von  -> " + s.getName() + " fährt nach " + s.getTarget().getName());
				println("Dauer noch : " + s.getTravelTime());
				s.removeShip();
			}
			for (String log : s.eventLog) {
				println("		" + log);
			}
			s.eventLog.clear();

		}
		println("---------------------------------------");
	}

	/**
	 * 
	 * @param player
	 */
	private void showPlayerKonto(Player player) {
		println("-----------------------------------------------");
		println(player.getName() + " : ");
		println("						" + player.getKontostand());
		println("-----------------------------------------------");
	}

	/**
	 * 
	 * @param stadt
	 * @param player
	 */
	private void stadtMenue(Stadt stadt, Player player) {
		boolean back = false;
		while (back == false) {
			println("------------------" + stadt.getName() + "------------------");
			println(1 + " - Zum Hafen gehen");
			println(2 + " - Kontor Besuschen"); // TODO

			println(0 + " - Zurueck zur Weltkarte");

			int eingabe = intEinlesen();

			switch (eingabe) {
			case 1:
				this.hafenMenue(stadt, player);
				break;
			case 2:
				this.showKontorMenue(stadt, stadt.Kontoren.get(player), player);
				break;
			case 0:
				back = true;
				break;
			}
		}
	}

	/**
	 * 
	 * @param stadt
	 * @param player
	 */
	private void hafenMenue(Stadt stadt, Player player) {
		boolean back = false;

		HashMap<Integer, Schiff> playerShips = new HashMap<Integer, Schiff>();
		while (back == false) {
			println("--------------Hafen--------------");
			int i = 1;
			for (Schiff s : stadt.schiffe) {

				if (s.getOwner().equals(player)) {
					playerShips.put(i, s);
					println(i++ + " - " + s.getName() + "   Status: " + s.getSchadenpunkte());
				}
			}

			println(0 + " - Zurueck zur Stadtuebersicht");
			int eingabe = intEinlesen();
			if (eingabe == 0) {
				return; // In Stadt Menue zurück
			}

			Schiff s = playerShips.get(eingabe);

			if (s != null) {
				this.schiffMenue(s, player);
			}
		}
	}

	/**
	 * 
	 * @param schiff
	 * @param player
	 */
	private void schiffMenue(Schiff schiff, Player player) {
		boolean back = false;
		while (back == false) {
			println("Schiffs Infos - " + schiff.getName() + " :");
			println("				Status : " + schiff.getSchadenpunkte());
			println("Lager :");
			println(schiff.lager.toString());
			println("---------------------------------------------");
			println(1 + " - Entsenden");
			println(2 + " - Reparieren (Kosten:  " + schiff.getRepaturkosten() + ")");
			println(3 + " - Aufrüsten");

			println(4 + " - Be-/Entladen");

			println(0 + " - Zurück zum Hafen");

			int eingabe = intEinlesen();

			switch (eingabe) {
			case 1:
				println(0 + " - Zurück");

				eingabe = this.showStaedteUndEntfernung((Stadt) schiff.getPosition());

				if (eingabe == 0) {

				} else {
					((Stadt) schiff.getPosition()).getASeeRouteByStadt(manager.staedte.get(eingabe - 1).getName())
							.addShipToRoute(schiff, (Stadt) schiff.getPosition());
					println(schiff.getName() + " faehrt nach " + schiff.getTarget().getName());
					return;
				}

				break;
			case 2:
				try {
					player.bezahlen(schiff.getRepaturkosten());
					schiff.repair();
					println("Das Schiff " + schiff.getName() + " wurde repariert!");
				} catch (KontoException e) {
					println("-- !! -- Sie haben nicht genug Geld -- !! --");
				}
				break;
			case 3:
				// TODO Aufrüsten
				break;
			case 4:
				this.showVerladeMenue(schiff, ((Stadt) schiff.getPosition()).Kontoren.get(player));
				break;
			case 0:
				back = true;
			default:
				break;
			}
		}
	}

	/**
	 * 
	 * @param stadt
	 * @return
	 */
	private int showStaedteUndEntfernung(Stadt stadt) {
		println("------------------Städte------------------");
		int i = 1;
		for (Stadt s : manager.staedte) {
			println(i++ + "  -  " + s.getName() + "\t\t Entfernung: "
					+ stadt.getASeeRouteByStadt(s.getName()).getLaenge());
		}
		println("------------------------------------------");

		int eingabe = intEinlesen();
		return eingabe;
	}

	/**
	 * Ermöglicht vor Spielbeginn einstellung vorzunehmen.
	 */
	public void beforeStart() {
		boolean start = false;
		while (start == false) {
			println("------------ Spiel-Eintsellung ------------");
			println(1 + " - Start-Kapital -> " + manager.startGuthaben + " Mark");
			println(2 + " - Start-Schiffe -> " + manager.startSchiffe + " Schiffe");
			println("-------------------------------------------");
			println(3 + " - Spieler hinzufügen (Momentan " + manager.players.size() + " )");
			println("-------------------------------------------");
			println(4 + " - Spiel Starten ");
			int eingabe = this.intEinlesen();
			switch (eingabe) {
			case 1:
				println("Neues Start-Kapital eingeben: ");
				eingabe = this.intEinlesen();
				if (eingabe <= 0) {
					println("Das Start-Kapital kann nicht <= 0 sein!!!");
				} else {
					manager.setStartGuthaben(eingabe);
				}
				break;
			case 2:
				println("Neue Anzahl an Start-Schiffen: ");
				eingabe = intEinlesen();
				if (eingabe <= 0) {
					println("Die Start-Schiff anzahl muss größer 0 sein!!!");
				} else {
					manager.startSchiffe = eingabe;
				}
				break;
			case 3:
				println("Spieler-Name eingeben: ");
				String name = this.read.nextLine();
				this.manager.players.add(new Player(name, this.manager.startGuthaben));
				break;
			case 4:
				this.schiffeVerteilen();
				println("Spiel wird vorbreitet-");
				start = true;
				break;
			default:
				break;
			}
		}
	}

	private void schiffeVerteilen() {
		for (Player p : manager.players) {
			while (p.schiffe.size() < manager.startSchiffe) {
				println(p.getName() + " bitte verteile deine Schiffe ");
				println("Zu verteilende Schiffe: " + (manager.startSchiffe - p.schiffe.size()));

				int eingabe = this.showStaedte();

				Stadt stadt = manager.staedte.get(eingabe - 1);

				if (stadt != null) {
					println("Bitte Schiffsname eingeben: ");
					String name = this.read.nextLine();

					new Schiff(name, stadt, SchiffsTyp.Kogge, p);
				}
			}
		}
	}

	private void showVerladeMenue(Schiff schiff, Kontor kontor) {

		boolean way = true; // way = true (toShip) - false (toKontor)
		String toShip = "  <<--<<  ";
		String toKontor = "  >>-->>  ";
		String to = toShip;

		boolean exit = false;

		while (exit == false) {
			String[] schiffsLager = schiff.lager.gutListe();
			String[] kontorLager = kontor.gutListe();

			println(" - Schiff - " + to + " - Kontor - ");
			for (int i = 0; i < Gut.ANZAHL; i++) {
				println(schiffsLager[i] + to + kontorLager[i]);
			}
			println("------------------------------------------");
			println("12 - Change Way");
			println("13 - GoBack");
			String einlesen = this.read.nextLine();

			if (einlesen.equals("12")) {
				if (way) {
					// Waren sollen jetzt in den Kontor gelegt werden
					to = toKontor;
					way = false;
				} else {
					// Warem sollen jetzt ans Schiff gehen
					to = toShip;
					way = true;
				}
			} else if (einlesen.equals("12")) {
				exit = true;
			} else {
				try {
					Gut gut = Gut.stringToGut(einlesen);
					println("Wie viel " + gut.getName() + "??");
					int menge = this.intEinlesen();
					try {
						if (way) {
							kontor.auslagern(gut, menge);
							schiff.beladen(gut, menge);
						} else {
							schiff.entladen(gut, menge);
							kontor.lagern(gut, menge);
						}
					} catch (LagerException e) {
						println(e.toString());
					}
				} catch (LagerException e) {
					e.getMessage();
				}
			}
		}
	}

	private void showKontorMenue(Stadt stadt, Kontor kontor, Player player) {

		boolean back = false;
		while (back == false) {
			println(1 + " - Kaufe regionales Gut (" + stadt.markt.getRegionalesGut().getName() + ")");
			println(2 + " - Zeige Preis/Lager - Liste der Stadt " + stadt.getName());
			println(3 + " - Zeige Kontor Bestand (Lager)");
			println(4 + " - Verkaufe Gut aus dem Kontor ");

			int eingabe = this.intEinlesen();

			switch (eingabe) {
			case 1:
				println("Wie viel  " + stadt.markt.getRegionalesGut().getName() + " soll gekauft werden??");
				eingabe = this.intEinlesen();
				try {
					stadt.markt.regionalesGutVerkaufen(eingabe, kontor, player);
				} catch (KontoException e) {
					println("Nicht genung Geld um " + eingabe + " zukaufen.");
					println("Kontostand : " + e.getKontostand() + "Kosten: " + e.getPreis());
				} catch (LagerException e) {
					println("Nicht genung Platz um " + eingabe + " zulagern.");
					println("Freier Lager Platz: " + e.getPlatz());
				}
				break;
			case 2:
				println("Preis Lager Liste");
				println("Gut\t\t" + "\tLager-Menge\t" + "\tKaufPreis");
				HashMap<Gut, Integer[]> preisLagerList = stadt.markt.getPreisLagerListe();
				for (Gut g : Gut.values()) {
					if (g.equals(Gut.Stockfisch)) {
						println(g.getName() + "\t\t\t" + preisLagerList.get(g)[1] + "\t\t" + preisLagerList.get(g)[0]);
					} else {
						println(g.getName() + "\t\t\t\t" + preisLagerList.get(g)[1] + "\t\t"
								+ preisLagerList.get(g)[0]);
					}
				}
				break;
			case 3:
				println(kontor.toString());
				break;
			case 4:
				println("Name des Gutes eingeben: ");
				String name = this.read.nextLine();
				try {
					Gut gut = Gut.stringToGut(name);
					println("Wie viel " + gut.getName() + " soll verkauft werden? (" + kontor.getBestand(gut) + ")");
					eingabe = this.intEinlesen();
					int umsatz = stadt.markt.gutAnkauf(gut, eingabe, kontor, player);

					println(eingabe + " " + gut.getName() + " wurden verkauft ,dafür erhaltest du: " + umsatz
							+ " Mark");
				} catch (LagerException e) {
					println(e.getMessage());
				}
				break;
			case 0:
				back = true;
				break;
			default:
				break;
			}
		}
	}
}
