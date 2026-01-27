package thermostat;

import java.util.Random;

public class HardwareSensor {

	private static boolean isSensorBound = false;
	private Random rand = new Random();

	public HardwareSensor() {
		if (isSensorBound) {
			throw new Error("ERR: HardwareSensor is already bound! Did you create a second instance of Thermometer?");
		} else {
			isSensorBound = true;
		}
	}

	public int senseNewTemperature() {
		return rand.nextInt((40) + 1) + 0;
	}

}
