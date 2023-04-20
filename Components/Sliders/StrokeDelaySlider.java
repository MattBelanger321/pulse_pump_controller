package Components.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDelayValue;
import Listeners.Sliders.StrokeDelayChangeListener;
import app.Arduino;

public class StrokeDelaySlider extends JSlider {
	public final static int MAXVAL = 150;
	public final static int MINVAL = 0;

	public final static int WIDTH = 250;
	public final static int HEIGHT = 30;

	StrokeDelayChangeListener listener;

	public StrokeDelaySlider() {
		super(MINVAL, MAXVAL);

		setSize(WIDTH, HEIGHT);

		setBackground(Color.blue);

		setValue(0);
	}

	public void addDelayValueChangeListener(StrokeDelayValue value) {
		listener = new StrokeDelayChangeListener(value);

		addChangeListener(listener);
	}

	public void addArduino(Arduino arduino) {
		listener.addArduino(arduino);
	}

	public void addBPMTracker(BPM bpm) {
		listener.setBPM(bpm);
	}
}
