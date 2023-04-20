package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.StrokeDurationSlider;
import Components.TextBoxes.StrokeDurationValue;

public class StrokeDurationChangeListener implements ChangeListener {

	private StrokeDurationValue value;

	public StrokeDurationChangeListener(StrokeDurationValue value) {
		this.value = value;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		StrokeDurationSlider durationSlider = (StrokeDurationSlider) e.getSource(); // get the calling object

		value.setValue(durationSlider.getValue());
	}

}
