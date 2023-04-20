package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.PositionSlider;
import Components.TextBoxes.DisplacementVolume;
import Components.TextBoxes.PositionSliderValue;

public class PositionChangeListener implements ChangeListener {

	private DisplacementVolume displacementVolume;
	private PositionSliderValue value;

	public PositionChangeListener(DisplacementVolume displacementVolume, PositionSliderValue value) {
		this.displacementVolume = displacementVolume;
		this.value = value;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		PositionSlider positionSlider = (PositionSlider) e.getSource(); // get the calling object

		displacementVolume.setVolume(positionSlider.getStart(), positionSlider.getStop());

		value.setValue(positionSlider.getStart(), positionSlider.getStop());
	}

}
