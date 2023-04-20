package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.StrokeDurationSlider;
import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDurationValue;
import app.Arduino;

public class StrokeDurationChangeListener implements ChangeListener {

	private StrokeDurationValue value;
	private BPM bpm;

	public StrokeDurationChangeListener(StrokeDurationValue value, BPM bpm) {
		this.value = value;
		this.bpm = bpm;
	}

	public StrokeDurationChangeListener(StrokeDurationValue value) {
		this.value = value;
		this.bpm = null;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		StrokeDurationSlider durationSlider = (StrokeDurationSlider) e.getSource(); // get the calling object

		value.setValue(durationSlider.getValue());

		if (bpm != null) {
			bpm.setDuration(durationSlider.getValue());
		}
	}

	public void setBPM(BPM bpm) {
		this.bpm = bpm;
	}

	public void addArduino(Arduino arduino) {
	}

}
