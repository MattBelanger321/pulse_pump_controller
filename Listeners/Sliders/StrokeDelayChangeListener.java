package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.StrokeDelaySlider;
import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDelayValue;
import app.Arduino;

public class StrokeDelayChangeListener implements ChangeListener {

	private StrokeDelayValue value;
	private BPM bpm;
	private Arduino arduino;

	public StrokeDelayChangeListener(StrokeDelayValue value, BPM bpm) {
		this.value = value;
		this.bpm = bpm;

		arduino = null;
	}

	public StrokeDelayChangeListener(StrokeDelayValue value) {
		this.value = value;
		this.bpm = null;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		StrokeDelaySlider strokeDelaySlider = (StrokeDelaySlider) e.getSource(); // get the calling object

		int delay = strokeDelaySlider.getValue();

		value.setValue(delay);

		if (bpm != null) {
			bpm.setDelay(delay);
		}

		if (arduino != null) {
			arduino.sendDelay(delay);
		}
	}

	public void setBPM(BPM bpm) {
		this.bpm = bpm;
	}

	public void addArduino(Arduino arduino) {
		this.arduino = arduino;
	}

}
