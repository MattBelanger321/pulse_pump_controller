package app;

import javax.swing.*;

import Components.Buttons.*;
import Components.Sliders.*;
import Components.TextBoxes.*;
import Listeners.Sliders.PositionListener;

import java.awt.Color;

public class main_frame extends JFrame {

	private start_button startButton;
	private stop_button stopButton;
	private home_button homeButton;

	private PositionSlider positionSlider;
	private StrokeDelaySlider strokeDelaySlider;
	private StrokeDurationSlider strokeDurationSlider;

	private DisplacementVolume displacementVolume;

	public main_frame() {
		super("Pulse Pump Controller");
		setSize(1280, 720);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);

		// BUTTONS

		// START
		startButton = new start_button();
		startButton.setLocation(10, 100);
		add(startButton);

		// STOP
		stopButton = new stop_button();
		stopButton.setLocation(10, 200);
		add(stopButton);

		// HOME
		homeButton = new home_button();
		homeButton.setLocation(10, 300);
		add(homeButton);

		// Sliders

		// Start Stop Pos Slider
		positionSlider = new PositionSlider();
		positionSlider.setLocation(200, 100);
		add(positionSlider);

		// Stroke Delay
		strokeDelaySlider = new StrokeDelaySlider();
		strokeDelaySlider.setLocation(200, 200);
		add(strokeDelaySlider);

		// Stroke Duration
		strokeDurationSlider = new StrokeDurationSlider();
		strokeDurationSlider.setLocation(200, 300);
		add(strokeDurationSlider);

		// Value Boxes
		displacementVolume = new DisplacementVolume();
		displacementVolume.setLocation(200, 500);
		displacementVolume.setVolume(positionSlider.getStart(), positionSlider.getStop());
		add(displacementVolume);

		positionSlider.addChangeListener(new PositionListener(displacementVolume));

		setVisible(true);
	}
}
