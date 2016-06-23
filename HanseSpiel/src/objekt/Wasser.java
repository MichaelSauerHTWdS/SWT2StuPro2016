package objekt;

import event.PiratEvent;
import event.WeatherEvent;
import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.david.baldauf@htw-saarland.de)
 *
 */
public class Wasser extends GeoObjekt {

	int positon;

	WeatherEvent weather;
	PiratEvent pirat;

	public Wasser(int position) {
		this.positon = position;
		this.weather = new WeatherEvent();
		this.pirat = new PiratEvent();
	}

	public void executeEvents() {
		for (Schiff s : schiffe) {
			weather.executeEvent(s);
			pirat.executeEvent(s);
		}
	}

	public void intialEvents() {
		weather.intialEvent();
		pirat.intialEvent();
	}

	public void resetMove() {
		for (Schiff s : this.schiffe) {
			s.resetMove();
		}
	}

	@Override
	public String toString() {
		String tmp = "----  " + this.positon + " -  " + weather.toString() + " - " + pirat.toString() + "--\n";
		int i = 0;
		for (Schiff s : schiffe) {
			tmp += i++ + " - " + s.toString() + "\n";
		}
		return tmp;
	}
}
