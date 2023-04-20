package Components.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDurationValue;
import Listeners.Sliders.StrokeDurationChangeListener;
import app.Arduino;

public class StrokeDurationSlider extends JSlider {
	public final static int MAX = 10000;
	public final static int MIN = 0;

	public final static int WIDTH = 250;
	public final static int HEIGHT = 30;

	StrokeDurationChangeListener listener;

	public StrokeDurationSlider() {
		super(MIN, MAX); // in ms

		setSize(WIDTH, HEIGHT);

		setBackground(Color.CYAN);
		setValue(0);
	}

	public void addDurationValueChangeListener(StrokeDurationValue value) {
		listener = new StrokeDurationChangeListener(value);

		addChangeListener(listener);
	}

	public void addBPMTracker(BPM bpm) {
		listener.setBPM(bpm);
	}

	public void addArduino(Arduino arduino) {
		listener.addArduino(arduino);
	}
}
