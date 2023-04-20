package Components.Panels;

import javax.swing.JPanel;

import Components.Sliders.StrokeDurationSlider;
import Components.TextBoxes.StrokeDurationTitle;
import Components.TextBoxes.StrokeDurationValue;

public class StrokeDurationPanel extends JPanel {

	private StrokeDurationSlider strokeSlider;
	private StrokeDurationTitle strokeTitle;
	private StrokeDurationValue strokeValue;

	public final static int PANEL_WIDTH = 1000;
	public final static int PANEL_HEIGHT = 200;

	public final static int TITLE_X = 0;
	public final static int TITLE_Y = 0;

	public final static int SLIDER_X = 105;
	public final static int SLIDER_Y = (StrokeDurationTitle.HEIGHT - StrokeDurationSlider.HEIGHT) / 2;

	public final static int VALUE_X = StrokeDurationSlider.WIDTH + SLIDER_X + 5; // + 5 for padding
	public final static int VALUE_Y = 10;

	public StrokeDurationPanel() {

		setOpaque(false);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);

		setLayout(null);

		strokeTitle = new StrokeDurationTitle();
		strokeTitle.setLocation(TITLE_X, TITLE_Y);
		strokeTitle.setTitle("Stroke\nDuration (ms)");
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
}