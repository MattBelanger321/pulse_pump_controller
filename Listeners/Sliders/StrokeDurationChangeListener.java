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
	private Arduino arduino;

	public StrokeDurationChangeListener(StrokeDurationValue value, BPM bpm) {
		this.value = value;
		this.bpm = bpm;

		arduino = null;
	}

	public StrokeDurationChangeListener(StrokeDurationValue value) {
		this.value = value;
		this.bpm = null;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		StrokeDurationSlider durationSlider = (StrokeDurationSlider) e.getSource(); // get the calling object

		int duration = durationSlider.getValue();

		value.setValue(duration);

		if (bpm != null) {
			bpm.setDuration(duration);
		}

		if (arduino != null) {
			arduino.sendDuration(duration);
		}
	}

	public void setBPM(BPM bpm) {
		this.bpm = bpm;
	}

	public void addArduino(Arduino arduino) {
		this.arduino = arduino;
	}
}
