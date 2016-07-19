package event;

import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class PiratEvent extends Event {

	private final static int chance = 10;

	private boolean activ;

	public PiratEvent() {
		this.activ = false;
	}

	@Override
	public void executeEvent(Schiff schiff) {
		if (activ) {
			schiff.lager.clearLager();
			schiff.eventLog.add("Von Piraten überfallen! - Alle Güter wurden Gestohlen");
		}
	}

	@Override
	public void intialEvent() {
		int rand = Event.random.nextInt(100);

		if (rand < PiratEvent.chance) {
			this.activ = true;
		} else {
			this.activ = false;
		}

	}

	public String toString() {
		String tmp = "";
		if (this.activ) {
			tmp = "Pirat";
		}

		return tmp;
	}

}