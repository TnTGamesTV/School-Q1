package com.github.tntgamestv.school.result;

import com.github.tntgamestv.school.WeatherStation;

/**
 * @author Finn Tegeler
 */
public class ResultFactory {

	public static PressureResult buildPressureResult(WeatherStation weatherStation) {
		return new PressureResult(weatherStation.getPressure());
	}

	public static HumidityResult buildHumidityResult(WeatherStation weatherStation) {
		return new HumidityResult(weatherStation.getHumidity());
	}

	public static TemperatureResult buildTemperatureResult(WeatherStation weatherStation) {
		return new TemperatureResult(weatherStation.getTemperature());
	}

	public static InitiatingResult buildInitResult(WeatherStation weatherStation) {
		InitiatingResult result = new InitiatingResult(weatherStation.getPressure(), weatherStation.getHumidity(),
				weatherStation.getTemperature());

		return result;
	}
}
