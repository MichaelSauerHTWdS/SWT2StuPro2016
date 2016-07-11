package hanse.kontor2016.schiff;

public enum Schiffstyp {
	SCHNIGGE, KOGGE, HOLK, KRAWEEL, KARACKE, LINIENSCHIFF;
	public static Schiffstyp getUpgrade(Schiffstyp schiffstyp){
		switch (schiffstyp) {
		case SCHNIGGE: return KOGGE;
		case KOGGE: return HOLK;
		case HOLK: return KRAWEEL;
		case KRAWEEL: return KARACKE;
		case KARACKE: return LINIENSCHIFF;
		case LINIENSCHIFF: return LINIENSCHIFF;
		default:
			return null;
		}
	}
	public static int getKapazitaet(Schiffstyp schiffstyp){
		switch (schiffstyp) {
		case SCHNIGGE: return 40;
		case KOGGE: return 100;
		case HOLK: return 150;
		case KRAWEEL: return 400;
		case KARACKE: return 600;
		case LINIENSCHIFF: return 1000;
		default:
			return 0;
		}
	}
}
