package hanse.kontor2016.kontor;

import hanse.kontor2016.Definitionen;
import hanse.kontor2016.kaufmann.Kaufmann;

public class Kontor {
	private Ware lokaleware;
	Lager lager = new Lager(Definitionen.lagerKapazitaetKontor);

	public void wareImportieren(Kaufmann kaufmann, Ware ware, int menge) {
		if (ware == lokaleware) { //Ware wird nur in Geld umgewandelt, da sie nicht gelagert wird
			kaufmann.zahleBetragEin(menge*Definitionen.preisRegionalesGut);
		} else {
			//TODO ware einlagern, geld an Kaufmann zahlen, Warenpreis ggf. anpassen.
		}
	}
}
