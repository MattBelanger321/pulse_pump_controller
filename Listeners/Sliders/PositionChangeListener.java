package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.PositionSlider;
import Components.Sliders.StrokeDurationSlider;
import Components.TextBoxes.DisplacementVolume;
import Components.TextBoxes.PositionValue;
import app.Arduino;

public class PositionChangeListener implements ChangeListener {

	private DisplacementVolume displacementVolume;
	private PositionValue value;
	private StrokeDurationSlider durationSlider;

	Arduino arduino;

	public PositionChangeListener(DisplacementVolume displacementVolume, PositionValue value) {
		this.displacementVolume = displacementVolume;
		this.value = value;
		this.durationSlider = null;

		arduino = null;
	}

	public PositionChangeListener(StrokeDurationSlider slider) {
		this.durationSlider = slider;

		this.displacementVolume = null;
		this.value = null;
		arduino = null;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		PositionSlider positionSlider = (PositionSlider) e.getSource(); // get the calling object

		int start = positionSlider.getStart();
		int stop = positionSlider.getStop();

		if (displacementVolume != null) {
			displacementVolume.setVolume(start, stop);
		}

		if (value != null) {
			value.setValue(start, stop);
		}

		if (arduino != null) {
			arduino.sendPosition(start, stop);
		}

		if (durationSlider != null) {
			durationSlider.setMinimum((int) ((stop - start) / (float) 100 * 4000));
		}

	}

	public void addArduino(Arduino arduino) {
		this.arduino = arduino;
	}

}
