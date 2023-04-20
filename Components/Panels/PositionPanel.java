package Components.Panels;

import javax.swing.JPanel;

import Components.Sliders.PositionSlider;
import Components.TextBoxes.DisplacementVolume;
import Components.TextBoxes.PositionTitle;
import Components.TextBoxes.PositionValue;
import Listeners.Sliders.PositionChangeListener;;

public class PositionPanel extends JPanel {

	private PositionSlider positionSlider;
	private PositionTitle sliderTitle;
	private PositionValue sliderValue;

	public final static int PANEL_WIDTH = 500;
	public final static int PANEL_HEIGHT = 100;

	public final static int TITLE_X = 0; // relative to panel
	public final static int TITLE_Y = 0;

	public final static int SLIDER_X = PositionTitle.WIDTH + 5; // relative to panel
	public final static int SLIDER_Y = (PositionTitle.HEIGHT - PositionSlider.POSITION_HEIGHT) / 2;

	// relative to panel
	public final static int VALUE_X = PositionSlider.POSITION_WIDTH + SLIDER_X + 5; // + 5 for padding
	public final static int VALUE_Y = (PositionTitle.HEIGHT - PositionValue.HEIGHT) / 2;

	public PositionPanel() {

		setOpaque(false);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);

		setLayout(null);

		sliderTitle = new PositionTitle();
		sliderTitle.setLocation(TITLE_X, TITLE_Y);
		sliderTitle.setTitle("Position (mm)");
		add(sliderTitle);

		// Start Stop Pos Slider
		positionSlider = new PositionSlider();
		positionSlider.setLocation(SLIDER_X, SLIDER_Y);
		add(positionSlider);

		// Value Display
		sliderValue = new PositionValue(positionSlider.getStart(), positionSlider.getStop());
		sliderValue.setLocation(VALUE_X, VALUE_Y);
		add(sliderValue);

	}

	public void registerDisplacementTracker(DisplacementVolume tracker) {
		positionSlider.addPositionChangeListener(new PositionChangeListener(tracker, sliderValue));
	}

}