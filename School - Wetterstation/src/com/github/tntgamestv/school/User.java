package com.github.tntgamestv.school;

import com.github.tntgamestv.school.result.InitiatingResult;
import com.github.tntgamestv.school.result.Result;

/**
 * @author Finn Tegeler
 */
public class User implements PropertyChangeListener {

	/* Name */
	public String	name;

	public double	lastFetchedHumidity		= -1;
	public double	lastFetchedTemperature	= -1;
	public double	lastFetchedPressure		= -1;

	public User(String name) {
		this.name = name;
	}

	/**
	 * Called when a new value was recieved
	 */
	public void update() {}

	/*
	 * @see
	 * com.github.tntgamestv.school.PropertyChangeListener#onPropertyChange(com.
	 * github.tntgamestv.school.result.Result)
	 */
	@Override
	public void onPropertyChange(Result result) {}

	/*
	 * Called when the user has registered and is recieving his first values
	 * 
	 * @see
	 * com.github.tntgamestv.school.PropertyChangeListener#onPropertyUpdate(com.
	 * github.tntgamestv.school.result.InitiatingResult)
	 */
	@Override
	public void onPropertyUpdate(InitiatingResult result) {
		this.lastFetchedHumidity = result.humidity;
		this.lastFetchedTemperature = result.temperature;
		this.lastFetchedPressure = result.pressure;

		System.out.println("Recieved initiating result @" + this.name);
	}
}
