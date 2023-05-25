package Components.Sliders;

import java.awt.Color;

import Components.TextBoxes.DisplacementVolume;
import Components.TextBoxes.PositionValue;
import Listeners.Sliders.PositionChangeListener;
import app.Arduino;

public class PositionSlider extends RangeSlider {
	public final static int POSITION_MAX = 145;
	public final static int POSITION_MIN = 0;

	public final static int POSITION_WIDTH = 200;
	public final static int POSITION_HEIGHT = 25;

	public final static int DEFAULT_START = 0;
	public final static int DEFAULT_STOP = 145;

	PositionChangeListener displacementListener;
	PositionChangeListener durationListener;

	public PositionSlider() {
		super(POSITION_MIN, POSITION_MAX);

		setSize(POSITION_WIDTH, POSITION_HEIGHT);

		setBackground(Color.BLACK);

		setStop(DEFAULT_STOP);
		setStart(DEFAULT_START);

	}

	public void setStop(int stop) {
		setUpperValue(stop);
	}

	public void setStart(int start) {
		setValue(start);
	}

	public int getStop() {
		return getUpperValue();
	}

	public int getStart() {
		return getValue();
	}

	public void registerDisplacementTracker(DisplacementVolume tracker, PositionValue sliderValue) {
		displacementListener = new PositionChangeListener(tracker, sliderValue);

		addChangeListener(displacementListener);
	}

	public void registerDurationCalculator(StrokeDurationSlider slider) {
		durationListener = new PositionChangeListener(slider);

		addChangeListener(durationListener);
	}

	public void addArduino(Arduino arduino) {
		displacementListener.addArduino(arduino);
	}
}
