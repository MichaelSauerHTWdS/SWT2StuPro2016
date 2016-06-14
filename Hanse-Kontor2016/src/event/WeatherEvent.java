package event;

import java.util.Random;

import schiff.Schiff;

/**
 * 
 * @author davidbaldauf (ki.dbaldauf@htwsaar.de)
 *
 */
public class WeatherEvent extends Event {

	String name;
	WeatherTyp wetterTyp;

	private enum WeatherTyp {
		Brise(70, 0), Sturm(17, 10), SchwererSturm(10, 15), Orkan(3, 20);

		private int chance;
		private int dmg;

		private WeatherTyp(int chance, int dmg) {
			this.setChance(chance);
			this.dmg = dmg;
		}

		public int getDmg() {
			return this.dmg;
		}

		public int getChance() {
			return chance;
		}

		public void setChance(int chance) {
			this.chance = chance;
		}
	}

	public WeatherEvent() {
		this.wetterTyp = WeatherTyp.Brise;
	}

	private void changeWeather() {
		int rand = WeatherEvent.random.nextInt(100);

		if (rand < WeatherTyp.Brise.getChance()) {
			this.wetterTyp = WeatherTyp.Brise;
			return;
		}

		rand -= WeatherTyp.Brise.getChance();

		if (rand < WeatherTyp.Sturm.getChance()) {
			this.wetterTyp = WeatherTyp.Sturm;
			return;
		}

		rand -= WeatherTyp.Sturm.getChance();

		if (rand < WeatherTyp.SchwererSturm.getChance()) {
			this.wetterTyp = WeatherTyp.SchwererSturm;
			return;
		}

		rand -= WeatherTyp.SchwererSturm.getChance();

		if (rand < WeatherTyp.Orkan.getChance()) {
			this.wetterTyp = WeatherTyp.Orkan;
			return;
		}
	}

	public String toString() {
		return this.wetterTyp.name();
	}

	@Override
	public void executeEvent(Schiff schiff) {

		schiff.dmgSchiff(this.wetterTyp.getDmg());

	}

	@Override
	public void intialEvent() {
		this.changeWeather();
	}
}
