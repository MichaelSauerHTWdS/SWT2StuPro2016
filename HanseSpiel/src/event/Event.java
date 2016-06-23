package event;

import java.util.Random;

import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public abstract class Event {

	static Random random = new Random();

	public abstract void executeEvent(Schiff schiff);

	public abstract void intialEvent();

}
