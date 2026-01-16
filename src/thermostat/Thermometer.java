package thermostat;

import java.util.ArrayList;
import java.util.List;

public class Thermometer extends Subject {

	private int currentTemperature;
	private HardwareSensor sensor = new HardwareSensor();
	private List<Observer> observers = new ArrayList<>();

	public void start() {
		while (true) {
			readInNewTemperature();
			System.out.println(currentTemperature);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("ERR: Failed to wait for new thermostat readings!");
			}
		}
	}

	private void readInNewTemperature() {
		this.currentTemperature = sensor.senseNewTemperature();
		// Observer über Temperaturänderungen informieren
		notifyObservers();
	}

	public int getCurrentTemperature() {
		return currentTemperature;
	}

	@Override
	void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(currentTemperature);
		}
	}
}
