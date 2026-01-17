package thermostat;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// Senses the current temperature
		// Thermometer nach Singleton-Pattern
		Thermometer thermometer = Thermometer.getInstance();

		Observer heatingSystem = new HeatingSystem();
		Observer temperatureReader = new TemperatureReader();
		Observer freezeNotifier = new FreezeNotifier();

		// "Abonniere" Observer zum Thermometer
		thermometer.addObserver(heatingSystem);
		thermometer.addObserver(temperatureReader);
		thermometer.addObserver(freezeNotifier);

		thermometer.start();
	}

}
