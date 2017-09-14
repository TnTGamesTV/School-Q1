package com.github.tntgamestv.school;

import java.util.ArrayList;
import java.util.List;

import com.github.tntgamestv.school.exceptions.UserAlreadyRegisteredException;
import com.github.tntgamestv.school.exceptions.UserNeverRegisteredException;
import com.github.tntgamestv.school.result.ResultFactory;

/**
 * @author Finn Tegeler
 */
public class WeatherStation {

	/* Users & Listener */
	private List<User>	users;

	private double		pressure;
	private double		humidity;
	private double		temperature;

	public WeatherStation() {
		this.users = new ArrayList<>();

		this.pressure = 0;
		this.humidity = 0;
		this.temperature = 0;
	}

	public WeatherStation(double pressure, double humidity, double temperature) {
		this.users = new ArrayList<>();

		this.pressure = pressure;
		this.humidity = humidity;
		this.temperature = temperature;
	}

	/* User and listener registration */
	public void registerUser(User user) {
		if (!users.contains(user)) {
			users.add(user);

			user.onPropertyUpdate(ResultFactory.buildInitResult(this));
		} else {
			throw new UserAlreadyRegisteredException("User is already registered!");
		}
	}

	public void unregisterUser(User user) {
		if (users.contains(user)) {
			users.remove(user);
		} else {
			throw new UserNeverRegisteredException("User was never registered!");
		}
	}

	/**
	 * @return the pressure
	 */
	public double getPressure() {
		return pressure;
	}

	/**
	 * @param pressure
	 *            the pressure to set
	 */
	public void setPressure(double pressure) {
		this.pressure = pressure;

		users.stream().forEach(u -> u.onPropertyChange(ResultFactory.buildPressureResult(this)));
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity
	 *            the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;

		users.stream().forEach(u -> u.onPropertyChange(ResultFactory.buildHumidityResult(this)));
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature
	 *            the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;

		users.stream().forEach(u -> u.onPropertyChange(ResultFactory.buildTemperatureResult(this)));
	}
}
