package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.StrokeDelaySlider;
import Components.TextBoxes.StrokeDelayValue;

public class StrokeDelayChangeListener implements ChangeListener {

	private StrokeDelayValue value;

	public StrokeDelayChangeListener(StrokeDelayValue value) {
		this.value = value;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		StrokeDelaySlider positionSlider = (StrokeDelaySlider) e.getSource(); // get the calling object

		value.setValue(positionSlider.getValue());
	}

}
