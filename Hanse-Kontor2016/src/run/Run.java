package run;

import java.util.Scanner;

import gueter.Gut;
import objekt.SeeRoute;
import objekt.Stadt;
import schiff.Schiff;
import schiff.SchiffsTyp;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Run {

	public static void main(String[] args) {

		Stadt stadt_1 = new Stadt("Berlin");
		Stadt stadt_2 = new Stadt("Waron");

		Schiff schiff_1 = new Schiff("VonBerlin", stadt_1, SchiffsTyp.Kogge);
		Schiff schiff_2 = new Schiff("VonWaron", stadt_2, SchiffsTyp.Linienschiff);

		schiff_1.beladen(Gut.Bier, 50);
		schiff_1.beladen(Gut.Kupfer, 20);
		schiff_1.beladen(Gut.Kupfer, 20);
		schiff_1.beladen(Gut.Pelze, 10);

		SeeRoute BerlinNachWaron = new SeeRoute(stadt_1, stadt_2, 4);

		stadt_1.schiffe.add(schiff_1);
		stadt_2.schiffe.add(schiff_2);

		System.out.println(BerlinNachWaron.toString());

		BerlinNachWaron.addShipToRoute(schiff_1, stadt_1);
		BerlinNachWaron.addShipToRoute(schiff_2, stadt_2);

		System.out.println(BerlinNachWaron.toString());

		Scanner leser = new Scanner(System.in);
		boolean next = true;
		while (next == true) {

			BerlinNachWaron.intialEvents();

			BerlinNachWaron.executEvents();

			System.out.println(BerlinNachWaron.toString());

			System.out.println("Weiter??(j/n)");

			String tmp = leser.nextLine();
			if (tmp.equals("n")) {
				next = false;
			}
		}

		schiff_1.lager.entladen(Gut.Bier, 60);

		System.out.println(BerlinNachWaron.toString());

		leser.close();

	}

}
