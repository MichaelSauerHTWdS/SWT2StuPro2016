package hanse.kontor2016;

public class Definitionen {
	public static final int anzahlRunden = 50;
	public static final int anzahlErfolge = 2;
	// Rundkurs
	// def#4
	public static final int anzahlLasten = 5000;
	public static final int barvermoegen = 100000;
	public static final int anzahlSchiffe = 10;
	public static final int mindesZustand = 80;
	public static final int preisRegionalesGut = 5;
	public static final int lagerKapazitaetKontor = 1000;
	// 11. Maximalpreis importiertes Gut:
	public static final int maxPreisBier = 25;
	public static final int maxPreisKupfer = 100;
	public static final int maxPreisPelze = 80;
	public static final int maxPreisSalz = 70;
	public static final int maxPreisStockfisch = 10;
	public static final int maxPreisTuche = 50;
	public static final int maxPreisWein = 40;
	public static final int maxPreisZinn = 90;
	// 12. Preise Liegegebühren:
	public static final int liegePreisSchnigge = 50;
	public static final int liegePreisKogge = 60;
	public static final int liegePreisHolk = 70;
	public static final int liegePreisKraweel = 80;
	public static final int liegePreisKracke = 90;
	public static final int liegePreisLinienschiff = 150;
	// 13. Preise Schiffsbau, -aufrüstung und -reparatur:
	public static final int bauPreisSchnigge = 250;
	public static final int aufPreisSchnigge = 200;
	public static final int repPreisSchnigge = 3; // pro Prozent

	public static final int bauPreisKogge = 400;
	public static final int aufPreisKogge = 350;
	public static final int repPreisKogge = 5; // pro Prozent

	public static final int bauPreisHolk = 700;
	public static final int aufPreisHolk = 500;
	public static final int repPreisHolk = 8; // pro Prozent

	public static final int bauPreisKraweel = 1500;
	public static final int aufPreisKraweel = 600;
	public static final int repPreisKraweel = 20; // pro Prozent

	public static final int bauPreisKaracke = 2000;
	public static final int aufPreisKaracke = 400;
	public static final int repPreisKaracke = 25; // pro Prozent

	public static final int bauPreisLinienschiff = 2500;
	int repPreisLinienschiff = 30; // pro Prozent

	public static final int abnutzung = -1; // % pro Strecke

	// Wetter Wahrscheinlichkeiten
	public static final double brise = 0.7;
	public static final double sturm = 0.17;
	public static final double schwSturm = 0.1;
	public static final double orkan = 0.03;
	
	public static final int faktorSturm = -10;
	public static final int faktorschwSturm = -15;
	public static final int faktorOrkan = -20;
	
	public static final int mindestZustandSchiff = 50;
	public static final int mindestLadungSchiff = 40;
	public static final int gehaltCommis = 100;
}
