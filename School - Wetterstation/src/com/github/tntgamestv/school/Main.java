package com.github.tntgamestv.school;

/**
 * @author Finn Tegeler
 */
public class Main {

	/* Main-void */
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();

		WeatherApp weatherApp = new WeatherApp();

		weatherStation.setTemperature(20);

		weatherStation.registerUser(weatherApp);

		weatherStation.setHumidity(10);
		weatherStation.setPressure(20);

		weatherApp.update();
	}
}
