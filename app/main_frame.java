package app;

import javax.swing.*;

import Components.Buttons.*;
import Components.Panels.PositionPanel;
import Components.Panels.StrokeDelayPanel;
import Components.Panels.StrokeDurationPanel;
import Components.Sliders.*;
import Components.TextBoxes.*;
import Listeners.Sliders.PositionChangeListener;

import java.awt.Color;

public class main_frame extends JFrame {

	private start_button startButton;
	private stop_button stopButton;
	private home_button homeButton;

	private PositionPanel positionPanel;

	private StrokeDelayPanel strokeDelayPanel;

	private DisplacementVolume displacementVolume;
	private StrokeDurationPanel strokeDurationPanel;

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

		// Panels

		// Position Panel
		positionPanel = new PositionPanel();
		positionPanel.setLocation(200, 100);
		add(positionPanel);

		// Stroke Delay Panel
		strokeDelayPanel = new StrokeDelayPanel();
		strokeDelayPanel.setLocation(200, 200);
		add(strokeDelayPanel);

		// Stroke Duration
		strokeDurationPanel = new StrokeDurationPanel();
		strokeDurationPanel.setLocation(200, 300);
		add(strokeDurationPanel);

		// Value Boxes
		displacementVolume = new DisplacementVolume();
		displacementVolume.setLocation(200, 500);
		add(displacementVolume);

		positionPanel.registerDisplacementTracker(displacementVolume);

		setVisible(true);
	}
}
