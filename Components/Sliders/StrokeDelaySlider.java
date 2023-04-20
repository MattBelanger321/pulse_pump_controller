package Components.Sliders;

import java.awt.Color;

import javax.swing.JSlider;
import Components.TextBoxes.StrokeDelayValue;
import Listeners.Sliders.StrokeDelayChangeListener;

public class StrokeDelaySlider extends JSlider {
	public final static int MAXVAL = 150;
	public final static int MINVAL = 0;

	public final static int WIDTH = 250;
	public final static int HEIGHT = 30;

	public StrokeDelaySlider() {
		super(MINVAL, MAXVAL);

		setSize(WIDTH, HEIGHT);

		setBackground(Color.blue);
	}

	public void addDelayValueChangeListener(StrokeDelayValue value) {
		addChangeListener(new StrokeDelayChangeListener(value));
	}
}
