package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.PositionSlider;
import Components.TextBoxes.DisplacementVolume;
import Components.TextBoxes.PositionValue;
import app.Arduino;

public class PositionChangeListener implements ChangeListener {

	private DisplacementVolume displacementVolume;
	private PositionValue value;

	Arduino arduino;

	public PositionChangeListener(DisplacementVolume displacementVolume, PositionValue value) {
		this.displacementVolume = displacementVolume;
		this.value = value;

		arduino = null;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		PositionSlider positionSlider = (PositionSlider) e.getSource(); // get the calling object

		int start = positionSlider.getStart();
		int stop = positionSlider.getStop();

		displacementVolume.setVolume(start, stop);

		value.setValue(start, stop);

		if (arduino != null) {
			arduino.sendPosition(start, stop);
		}

	}

	public void addArduino(Arduino arduino) {
		this.arduino = arduino;
	}

}
