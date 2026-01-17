package thermostat;

public class TemperatureReader implements Observer {

	private void readOutTemperature(int temperature) {
		System.out.println("TemperatureReader: It is currently " + temperature + " degrees celsius! 🌡️");
	}

	@Override
	public void update(int temperature) {
		readOutTemperature(temperature);
	}
}
