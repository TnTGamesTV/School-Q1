package com.github.tntgamestv.school;

import com.github.tntgamestv.school.result.InitiatingResult;
import com.github.tntgamestv.school.result.Result;

/**
 * @author Finn Tegeler
 */
public interface PropertyChangeListener {

	public void onPropertyChange(Result result);

	public void onPropertyUpdate(InitiatingResult result);
}
