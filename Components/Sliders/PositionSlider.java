package Components.Sliders;

import java.awt.Color;

public class PositionSlider extends RangeSlider {
	public final static int POSITION_MAX = 150;
	public final static int POSITION_MIN = 0;

	public final static int POSITION_WIDTH = 250;
	public final static int POSITION_HEIGHT = 30;

	public PositionSlider() {
		super(0, 150);

		setSize(POSITION_WIDTH, POSITION_HEIGHT);

		setBackground(Color.BLACK);
	}

	public int getStop() {
		return getValue();
	}

	public int getStart() {
		return getUpperValue();
	}
}
