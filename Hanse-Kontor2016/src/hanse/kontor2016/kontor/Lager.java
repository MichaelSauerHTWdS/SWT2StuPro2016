package hanse.kontor2016.kontor;

public class Lager {
	private int kapazitaet;
	private int[] waren = new int[Ware.values().length];

	public Lager(int kapazitaet) {
		super();
		this.kapazitaet = kapazitaet;
		for (int i = 0; i < waren.length; i++) {
			waren[i] = 0;
		}
	}

	public int getKapazitaet() {
		return kapazitaet;
	}


}
