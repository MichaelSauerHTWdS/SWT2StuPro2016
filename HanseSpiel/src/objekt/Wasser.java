package objekt;

import java.util.ArrayList;

import event.PiratEvent;
import event.WeatherEvent;
import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class Wasser implements GeoObjekt {

	int positon;

	WeatherEvent weather;
	PiratEvent pirat;

	ArrayList<Schiff> schiffe = new ArrayList<Schiff>();

	public Wasser(int position) {
		this.positon = position;
		this.weather = new WeatherEvent();
		this.pirat = new PiratEvent();
	}

	public void executeEvents() {
		for (Schiff s : this.schiffe) {
			weather.executeEvent(s);
			pirat.executeEvent(s);
		}
	}

	public void intialEvents() {
		weather.intialEvent();
		pirat.intialEvent();
	}

	@Override
	public String toString() {
		String tmp = "----  " + this.positon + " -  " + weather.toString() + " - " + pirat.toString() + "--\n";
		int i = 0;
		for (Schiff s : this.schiffe) {
			tmp += i++ + " - " + s.toString() + "\n";
		}
		return tmp;
	}
}
