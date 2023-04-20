package Components.Sliders;

import java.awt.Color;

import Listeners.Sliders.PositionChangeListener;

public class PositionSlider extends RangeSlider {
	public final static int POSITION_MAX = 150;
	public final static int POSITION_MIN = 0;

	public final static int POSITION_WIDTH = 200;
	public final static int POSITION_HEIGHT = 25;

	public PositionSlider() {
		super(POSITION_MIN, POSITION_MAX);

		setSize(POSITION_WIDTH, POSITION_HEIGHT);

		setBackground(Color.BLACK);

		setStop(150);
		setStart(0);

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

	public void addPositionChangeListener(PositionChangeListener listener) {
		addChangeListener(listener);
	}
}
