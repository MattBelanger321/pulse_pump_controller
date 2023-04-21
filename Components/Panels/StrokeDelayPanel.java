package Components.Panels;

import javax.swing.JPanel;

import Components.Sliders.StrokeDelaySlider;
import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDelayTitle;
import Components.TextBoxes.StrokeDelayValue;
import app.Arduino;

public class StrokeDelayPanel extends JPanel {

	private StrokeDelaySlider strokeSlider;
	private StrokeDelayTitle strokeTitle;
	private StrokeDelayValue strokeValue;

	public final static int DEFAULT_DELAY = StrokeDelaySlider.DEFAULT_DELAY;

	public final static int PANEL_WIDTH = 500;
	public final static int PANEL_HEIGHT = 100;

	public final static int TITLE_X = 0;
	public final static int TITLE_Y = 0;

	public final static int SLIDER_X = StrokeDelayTitle.WIDTH + 5;
	public final static int SLIDER_Y = (StrokeDelayTitle.HEIGHT - StrokeDelaySlider.HEIGHT) / 2;

	public final static int VALUE_X = StrokeDelaySlider.WIDTH + SLIDER_X + 5; // + 5 for padding
	public final static int VALUE_Y = (StrokeDelayTitle.HEIGHT - StrokeDelayValue.HEIGHT) / 2;

	public StrokeDelayPanel() {

		setOpaque(false);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);

		setLayout(null);

		strokeTitle = new StrokeDelayTitle();
		strokeTitle.setLocation(TITLE_X, TITLE_Y);
		strokeTitle.setTitle("Stroke\nDelay (ms)");
		add(strokeTitle);

		// Start Stop Pos Slider
		strokeSlider = new StrokeDelaySlider();
		strokeSlider.setLocation(SLIDER_X, SLIDER_Y);
		add(strokeSlider);

		// Value Display
		strokeValue = new StrokeDelayValue(strokeSlider.getValue());
		strokeValue.setLocation(VALUE_X, VALUE_Y);
		strokeValue.setValue(strokeSlider.getValue());
		add(strokeValue);

		strokeSlider.addDelayValueChangeListener(strokeValue);

	}

	public void registerBPMTracker(BPM bpm) {
		strokeSlider.addBPMTracker(bpm);
	}

	public void addArduino(Arduino arduino) {
		strokeSlider.addArduino(arduino);
	}
}