package Components.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

public class StrokeDurationSlider extends JSlider {
	public final static int STROKE_DURATION_MAX = 10000;
	public final static int STROKE_DURATION_MIN = 0;

	public final static int STROKE_DURATION_WIDTH = 250;
	public final static int STROKE_DURATION_HEIGHT = 30;

	public StrokeDurationSlider() {
		super(STROKE_DURATION_MIN, STROKE_DURATION_MAX); // in ms

		setSize(STROKE_DURATION_WIDTH, STROKE_DURATION_HEIGHT);

		setBackground(Color.CYAN);
	}
}
