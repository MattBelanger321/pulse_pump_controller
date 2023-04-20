package Components.Panels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import Components.Sliders.PositionSlider;
import Components.TextBoxes.DisplacementVolume;
import Components.TextBoxes.PositionSliderTitle;
import Components.TextBoxes.PositionSliderValue;
import Listeners.Sliders.PositionChangeListener;;

public class PositionPanel extends JPanel {

	private PositionSlider positionSlider;
	private PositionSliderTitle sliderTitle;
	private PositionSliderValue sliderValue;

	public final static int SLIDER_X = 105;
	public final static int SLIDER_Y = (PositionSliderTitle.HEIGHT - PositionSlider.POSITION_HEIGHT) / 2;

	public final static int VALUE_X = PositionSlider.POSITION_WIDTH + SLIDER_X + 5; // + 5 for padding
	public final static int VALUE_Y = 10;

	public PositionPanel() {

		setOpaque(false);
		setSize(500, 200);

		setLayout(null);

		sliderTitle = new PositionSliderTitle();
		sliderTitle.setLocation(0, 0);
		sliderTitle.setTitle("Position\nSlider");
		add(sliderTitle);

		// Start Stop Pos Slider
		positionSlider = new PositionSlider();
		positionSlider.setLocation(SLIDER_X, SLIDER_Y);
		add(positionSlider);

		// Value Display
		sliderValue = new PositionSliderValue(positionSlider.getStart(), positionSlider.getStop());
		sliderValue.setLocation(VALUE_X, VALUE_Y);
		add(sliderValue);

	}

	public void registerDisplacementTracker(DisplacementVolume tracker) {
		positionSlider.addPositionChangeListener(new PositionChangeListener(tracker, sliderValue));
	}

}