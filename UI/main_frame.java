package UI;

import javax.swing.*;

import UI.Buttons.*;
import UI.Sliders.*;

import java.awt.Color;

public class main_frame extends JFrame {

	private start_button startButton;
	private stop_button stopButton;
	private home_button homeButton;

	private StartSlider startSlider;
	private StopSlider stopSlider;
	private StrokeDelaySlider strokeDelaySlider;
	private StrokeDurationSlider strokeDurationSlider;

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

		// Start Slider
		startSlider = new StartSlider();
		startSlider.setLocation(200, 100);
		add(startSlider);

		stopSlider = new StopSlider();
		stopSlider.setLocation(200, 200);
		add(stopSlider);

		strokeDelaySlider = new StrokeDelaySlider();
		strokeDelaySlider.setLocation(200, 300);
		add(strokeDelaySlider);

		strokeDurationSlider = new StrokeDurationSlider();
		strokeDurationSlider.setLocation(200, 400);
		add(strokeDurationSlider);

		setVisible(true);
	}
}
