package Components.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDurationValue;
import Listeners.Sliders.StrokeDurationChangeListener;
import app.Arduino;

public class StrokeDurationSlider extends JSlider {

	public static final int DEFAULT_DURATION = 3000;

	private int min = 3000;
	private int max = 24000;

	public final static int WIDTH = 250;
	public final static int HEIGHT = 30;

	StrokeDurationChangeListener listener;

	public StrokeDurationSlider() {
		super(3000, 24000); // in ms

		setSize(WIDTH, HEIGHT);

		setBackground(Color.CYAN);
		setValue(DEFAULT_DURATION);
	}

	public StrokeDurationSlider(int min, int max) {
		super(min, max); // in ms

		this.min = min;
		this.max = max;

		setSize(WIDTH, HEIGHT);

		setBackground(Color.CYAN);
		setValue(min);
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
