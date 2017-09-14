package com.github.tntgamestv.school;

import com.github.tntgamestv.school.result.HumidityResult;
import com.github.tntgamestv.school.result.PressureResult;
import com.github.tntgamestv.school.result.Result;
import com.github.tntgamestv.school.result.TemperatureResult;

/**
 * @author Finn Tegeler
 */
public class WeatherApp extends User {

	public WeatherApp() {
		super("WeatherApp");
	}

	@Override
	public void update() {
		System.out.println();
		System.out.println(this.name + " - Humidity: " + this.lastFetchedHumidity);
		System.out.println(this.name + " - Temperature: " + this.lastFetchedTemperature);
		System.out.println(this.name + " - Pressure: " + this.lastFetchedPressure);
	}

	@Override
	public void onPropertyChange(Result result) {
		if (result instanceof HumidityResult) {
			System.out.println(this.name + " - Humidity: " + result.getValue());
			this.lastFetchedHumidity = result.getValue();
		} else if (result instanceof TemperatureResult) {
			System.out.println(this.name + " - Temperature: " + result.getValue());
			this.lastFetchedTemperature = result.getValue();
		} else if (result instanceof PressureResult) {
			System.out.println(this.name + " - Pressure: " + result.getValue());
			this.lastFetchedPressure = result.getValue();
		}
	}
}
