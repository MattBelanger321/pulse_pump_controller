package app;

import javax.swing.*;

import Components.Buttons.*;
import Components.Panels.DisplacementPanel;
import Components.Panels.PositionPanel;
import Components.Panels.StrokeDelayPanel;
import Components.Panels.StrokeDurationPanel;
import Components.TextBoxes.MainTitle;

import java.awt.Color;

public class main_frame extends JFrame {

	private MainTitle title;

	private start_button startButton;
	private stop_button stopButton;
	private home_button homeButton;

	private PositionPanel positionPanel;

	private StrokeDelayPanel strokeDelayPanel;

	private DisplacementPanel displacementPanel;
	private StrokeDurationPanel strokeDurationPanel;

	public main_frame() {
		super("Pulse Pump Controller");
		setSize(1280, 720);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);

		title = new MainTitle();
		title.setLocation(0, 0);
		add(title);

		// BUTTONS

		// START
		startButton = new start_button();
		startButton.setLocation(10, 200);
		add(startButton);

		// STOP
		stopButton = new stop_button();
		stopButton.setLocation(10, 300);
		add(stopButton);

		// HOME
		homeButton = new home_button();
		homeButton.setLocation(10, 400);
		add(homeButton);

		// Panels

		// Position Panel
		positionPanel = new PositionPanel();
		positionPanel.setLocation(200, 200);
		add(positionPanel);

		// Stroke Delay Panel
		strokeDelayPanel = new StrokeDelayPanel();
		strokeDelayPanel.setLocation(200, 300);
		add(strokeDelayPanel);

		// Stroke Duration
		strokeDurationPanel = new StrokeDurationPanel();
		strokeDurationPanel.setLocation(200, 400);
		add(strokeDurationPanel);

		displacementPanel = new DisplacementPanel();
		displacementPanel.setLocation(200, 600);
		add(displacementPanel);

		positionPanel.registerDisplacementTracker(displacementPanel.getDisplacementVolume());

		setVisible(true);
	}
}
