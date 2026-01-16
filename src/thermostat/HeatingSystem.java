package thermostat;

public class HeatingSystem implements Observer {

	private void performAction(int temperature) {
		if (temperature < 20) {
			System.out.println("HeatingSystem: Temperature is low. Turning up the heater! 🔥");
		} else if (temperature > 30) {
			System.out.println("HeatingSystem: Temperature is high. Turning on the A/C! 🧊");
		}
	}

	@Override
	public void update(int temperature) {
		performAction(temperature);
	}
}
