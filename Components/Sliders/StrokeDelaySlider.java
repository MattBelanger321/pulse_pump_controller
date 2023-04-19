package Components.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

public class StrokeDelaySlider extends JSlider {
	public final static int STROKE_DELAY_MAX = 150;
	public final static int STROKE_DELAY_MIN = 0;

	public final static int STROKE_DURATION_WIDTH = 250;
	public final static int STROKE_DURATION_HEIGHT = 30;

	public StrokeDelaySlider() {
		super(STROKE_DELAY_MIN, STROKE_DELAY_MAX);

		setSize(STROKE_DURATION_WIDTH, STROKE_DURATION_HEIGHT);

		setBackground(Color.blue);
	}
}
