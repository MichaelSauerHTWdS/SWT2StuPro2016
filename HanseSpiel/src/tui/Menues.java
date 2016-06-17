package tui;

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

	public void showPlayerLog(Player player) {

		for (Schiff s : player.schiffe) {
			System.out.println("---------------------------------------");
			System.out.println("Schiffs Log von  -> " + s.getName() + " fährt nach " + s.getTarget().getName()); // TODO
																													// Wenn
																													// in
																													// stadt
																													// ist
			for (String log : s.eventLog) {
				System.out.println("		" + log);
			}
			s.eventLog.clear();
			System.out.println("Dauer noch : " + s.getTravelTime());
		}
		System.out.println("---------------------------------------");
	}

	public void showWorldMenue(Player player) {
		this.showPlayerLog(player);
		boolean endTurn = false;
		while (endTurn == false) {
			this.showPlayerKonto(player);

			System.out.println("------------------Städte------------------");
			int i = 1;
			for (Stadt s : manager.staedte) {
				System.out.println(i++ + "  -  " + s.getName());
			}
			System.out.println("------------------------------------------");
			System.out.println(0 + " - Beende Zug");

			int eingabe = Integer.valueOf(read.nextLine());

			if (eingabe == 0) {
				endTurn = true;
				return;
			} else {
				this.stadtMenue(this.manager.staedte.get(eingabe - 1), player);
			}

		}
	}

	public void showPlayerKonto(Player player) {
		System.out.println("-----------------------------------------------");
		System.out.println(player.getName() + " : ");
		System.out.println("						" + player.getKontostand());
		System.out.println("-----------------------------------------------");
	}

	public void stadtMenue(Stadt stadt, Player player) {
		boolean back = false;
		while (back == false) {
			System.out.println("------------------" + stadt.getName() + "------------------");
			System.out.println(1 + " - Zum Hafen gehen");
			System.out.println(2 + " - Kontor Besuschen"); // TODO

			System.out.println(0 + " - Zurueck zur Weltkarte");

			int eingabe = Integer.valueOf(read.nextLine());

			switch (eingabe) {
			case 1:
				// showHafenMenue
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

}
