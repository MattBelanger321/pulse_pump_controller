package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.StrokeDelaySlider;
import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDelayValue;

public class StrokeDelayChangeListener implements ChangeListener {

	private StrokeDelayValue value;
	private BPM bpm;

	public StrokeDelayChangeListener(StrokeDelayValue value, BPM bpm) {
		this.value = value;
		this.bpm = bpm;
	}

	public StrokeDelayChangeListener(StrokeDelayValue value) {
		this.value = value;
		this.bpm = null;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		StrokeDelaySlider strokeDelaySlider = (StrokeDelaySlider) e.getSource(); // get the calling object

		value.setValue(strokeDelaySlider.getValue());

		if (bpm != null) {
			bpm.setDelay(strokeDelaySlider.getValue());
		}
	}

	public void setBPM(BPM bpm) {
		this.bpm = bpm;
	}

}
