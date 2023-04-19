package Listeners.Sliders;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Sliders.PositionSlider;
import Components.TextBoxes.DisplacementVolume;

public class PositionListener implements ChangeListener {

	private DisplacementVolume displacementVolume;

	public PositionListener(DisplacementVolume displacementVolume) {
		this.displacementVolume = displacementVolume;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		PositionSlider positionSlider = (PositionSlider) e.getSource(); // get the calling object

		displacementVolume.setVolume(positionSlider.getStart(), positionSlider.getStop());
	}

}
