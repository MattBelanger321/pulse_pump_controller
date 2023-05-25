package Components.Panels;

import javax.swing.JPanel;

import Components.Sliders.StrokeDurationSlider;
import Components.TextBoxes.BPM;
import Components.TextBoxes.StrokeDurationTitle;
import Components.TextBoxes.StrokeDurationValue;
import app.Arduino;

public class StrokeDurationPanel extends JPanel {
	private StrokeDurationSlider strokeSlider;
	private StrokeDurationTitle strokeTitle;
	private StrokeDurationValue strokeValue;

	public static final int DEFAULT_DURATION = 3000;

	public final static int PANEL_WIDTH = 1000;
	public final static int PANEL_HEIGHT = 100;

	public final static int TITLE_X = 0;
	public final static int TITLE_Y = 0;

	public final static int SLIDER_X = StrokeDurationTitle.WIDTH + 5;
	public final static int SLIDER_Y = (StrokeDurationTitle.HEIGHT - StrokeDurationSlider.HEIGHT) / 2;

	public final static int VALUE_X = StrokeDurationSlider.WIDTH + SLIDER_X + 5; // + 5 for padding
	public final static int VALUE_Y = (StrokeDurationTitle.HEIGHT - StrokeDurationValue.HEIGHT) / 2;;

	public StrokeDurationPanel() {

		setOpaque(false);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);

		setLayout(null);

		strokeTitle = new StrokeDurationTitle();
		strokeTitle.setLocation(TITLE_X, TITLE_Y);
		add(strokeTitle);

		// Start Stop Pos Slider
		strokeSlider = new StrokeDurationSlider();
		strokeSlider.setLocation(SLIDER_X, SLIDER_Y);
		add(strokeSlider);

		// Value Display
		strokeValue = new StrokeDurationValue(strokeSlider.getValue());
		strokeValue.setLocation(VALUE_X, VALUE_Y);
		strokeValue.setValue(strokeSlider.getValue());
		add(strokeValue);

		strokeSlider.addDurationValueChangeListener(strokeValue);

	}

	public StrokeDurationSlider getSlider() {
		return strokeSlider;
	}

	public void registerBPMTracker(BPM bpm) {
		strokeSlider.addBPMTracker(bpm);
	}

	public void addArduino(Arduino arduino) {
		strokeSlider.addArduino(arduino);
	}
}