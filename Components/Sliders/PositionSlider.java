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

	}

	public int getStop() {
		return getValue();
	}

	public int getStart() {
		return getUpperValue();
	}

	public void addPositionChangeListener(PositionChangeListener listener) {
		addChangeListener(listener);
	}
}
