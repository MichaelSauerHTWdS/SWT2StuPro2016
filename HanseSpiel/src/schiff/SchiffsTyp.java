package schiff;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public enum SchiffsTyp {
	Schnigge(250, 200, 3, 50, 40), // --
	Kogge(400, 350, 5, 60, 100), // --
	Holk(700, 500, 8, 70, 150), // --
	Kraweel(1500, 600, 20, 80, 400), // --
	Karacke(2000, 600, 25, 90, 600), // --
	Linienschiff(2500, -1, 25, 150, 1000);

	int kaufpreis;
	int upgrade;
	int reperatur;
	int gebuehr;
	int lagerKap;

	private SchiffsTyp(int buy, int upgrade, int rep, int gebuehr, int lagerKap) {
		this.kaufpreis = buy;
		this.upgrade = upgrade;
		this.reperatur = rep;
		this.gebuehr = gebuehr;
		this.lagerKap = lagerKap;
	}

	/**
	 * 
	 * @return SchiffsTyp oder NULL
	 */
	public SchiffsTyp upgrade() {
		SchiffsTyp newSchiffsTyp;

		switch (this) {
		case Schnigge:
			newSchiffsTyp = Kogge;
			break;
		case Kogge:
			newSchiffsTyp = Holk;
			break;
		case Holk:
			newSchiffsTyp = Kraweel;
			break;
		case Kraweel:
			newSchiffsTyp = Karacke;
			break;
		case Karacke:
			newSchiffsTyp = Linienschiff;
			break;
		default:
			newSchiffsTyp = null;
			break;
		}
		return newSchiffsTyp;
	}

	public int getKaufpreis() {
		return kaufpreis;
	}

	public int getUpgrade() {
		return upgrade;
	}

	public int getReperatur() {
		return reperatur;
	}

	public int getGebuehr() {
		return gebuehr;
	}

	public int getLagerKap() {
		return lagerKap;
	}

}
