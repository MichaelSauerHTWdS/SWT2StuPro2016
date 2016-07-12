package hanse.kontor2016.kontor;

public class Lager {
	private int kapazitaet;
	private int lagerMenge = 0;
	private int tuchMenge = 0;
	private int stockFischMenge = 0;
	private int bierMenge = 0;
	private int weinMenge = 0;
	private int zinnMenge = 0;
	private int salzMenge = 0;
	private int pelzMenge = 0;
	private int kupferMenge = 0;

	public Lager(int kapazitaet) {
		super();
		this.kapazitaet = kapazitaet;
	}

	public int getKapazitaet() {
		return kapazitaet;
	}

	private void checkMenge(int menge) throws LagerException {
		if (menge < 0) {
			throw new LagerException("Menge darf nicht negativ sein!");
		}
	}

	private void checkMengeEin(int mengeEin) throws LagerException {
		checkMenge(mengeEin);
		if (lagerMenge + mengeEin > kapazitaet) {
			throw new LagerException("Nicht genug Kapazitaet zum einlagern!");
		}
	}

	private void checkMengeAus(int mengeAus, int mengeDa) throws LagerException {
		checkMenge(mengeAus);
		if (mengeAus > mengeDa) {
			throw new LagerException("Es wird mehr ausgelagert als vorhanden!");
		}
	}

	public void tucheEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		tuchMenge += mengeEin;
	}

	public void tucheAuslagern(int mengeAus) throws LagerException {
		checkMengeAus(mengeAus, tuchMenge);
		tuchMenge -= mengeAus;
	}

	public void stockFischEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		stockFischMenge += mengeEin;
	}
	
	public void stockFischAuslagern(int mengeAus) throws LagerException{
		checkMengeAus(mengeAus, stockFischMenge);
		stockFischMenge-= mengeAus;
	}
	
	public void bierEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		bierMenge += mengeEin;
	}
	
	public void bierAuslagern(int mengeAus) throws LagerException{
		checkMengeAus(mengeAus, bierMenge);
		bierMenge-= mengeAus;
	}
	
	public void weinEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		weinMenge += mengeEin;
	}
	
	public void weinAuslagern(int mengeAus) throws LagerException{
		checkMengeAus(mengeAus, weinMenge);
		weinMenge-= mengeAus;
	}
	
	public void zinnEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		zinnMenge += mengeEin;
	}
	
	public void zinnAuslagern(int mengeAus) throws LagerException{
		checkMengeAus(mengeAus, zinnMenge);
		zinnMenge-= mengeAus;
	}
	
	public void salzEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		salzMenge += mengeEin;
	}
	
	public void salzAuslagern(int mengeAus) throws LagerException{
		checkMengeAus(mengeAus, salzMenge);
		salzMenge-= mengeAus;
	}
	
	public void pelzeEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		pelzMenge += mengeEin;
	}
	
	public void pelzeAuslagern(int mengeAus) throws LagerException{
		checkMengeAus(mengeAus, pelzMenge);
		pelzMenge-= mengeAus;
	}
	
	public void kupferEinlagern(int mengeEin) throws LagerException {
		checkMengeEin(mengeEin);
		kupferMenge += mengeEin;
	}
	
	public void kupferAuslagern(int mengeAus) throws LagerException{
		checkMengeAus(mengeAus, kupferMenge);
		kupferMenge-= mengeAus;
	}
	
	

}
