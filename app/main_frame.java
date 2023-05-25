package app;

import javax.swing.*;

import Components.Buttons.*;
import Components.Panels.BPMPanel;
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
	private StrokeDurationPanel strokeDurationPanel;
	private StrokeDelayPanel strokeDelayPanel;

	private DisplacementPanel displacementPanel;
	private BPMPanel bpm;

	public static final int TITLE_X = 0;
	public static final int TITLE_Y = 0;

	// BUTTON COORDINATES
	public static final int START_BUTTON_X = 10;
	public static final int STOP_BUTTON_X = START_BUTTON_X;
	public static final int HOME_BUTTON_X = START_BUTTON_X;

	public static final int START_BUTTON_Y = 150;
	public static final int STOP_BUTTON_Y = START_BUTTON_Y + start_button.HEIGHT + 25;
	public static final int HOME_BUTTON_Y = STOP_BUTTON_Y + stop_button.HEIGHT + 25;

	// SLIDER COORDINATES
	public static final int POSITION_X = 200;
	public static final int DELAY_X = POSITION_X;
	public static final int DURATION_X = POSITION_X;

	public static final int POSITION_Y = 150;
	public static final int DELAY_Y = POSITION_Y + PositionPanel.PANEL_HEIGHT;
	public static final int DURATION_Y = DELAY_Y + StrokeDelayPanel.PANEL_HEIGHT;

	// Formula Output corrdinates
	public static final int DISPLACEMENT_X = POSITION_X;
	public static final int DISPLACEMENT_Y = DURATION_Y + StrokeDurationPanel.PANEL_HEIGHT;

	public static final int BPM_X = POSITION_X;
	public static final int BPM_Y = DISPLACEMENT_Y + DisplacementPanel.PANEL_HEIGHT;

	private Arduino arduino;

	public main_frame(Arduino arduino) {
		super("Pulse Pump Controller");

		this.arduino = arduino;

		setSize(1280, 720);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);

		title = new MainTitle();
		title.setLocation(TITLE_X, TITLE_Y);
		add(title);

		// BUTTONS

		// START
		startButton = new start_button();
		startButton.setLocation(START_BUTTON_X, START_BUTTON_Y);
		add(startButton);

		// STOP
		stopButton = new stop_button();
		stopButton.setLocation(STOP_BUTTON_X, STOP_BUTTON_Y);
		add(stopButton);

		// HOME
		homeButton = new home_button();
		homeButton.setLocation(HOME_BUTTON_X, HOME_BUTTON_Y);
		add(homeButton);

		// Sliders

		// Position Panel
		positionPanel = new PositionPanel();
		positionPanel.setLocation(POSITION_X, POSITION_Y);
		add(positionPanel);

		// Stroke Delay Panel
		strokeDelayPanel = new StrokeDelayPanel();
		strokeDelayPanel.setLocation(DELAY_X, DELAY_Y);
		add(strokeDelayPanel);

		// Stroke Duration
		strokeDurationPanel = new StrokeDurationPanel();
		strokeDurationPanel.setLocation(DURATION_X, DURATION_Y);
		add(strokeDurationPanel);

		// FORMULA OUTPUTS

		displacementPanel = new DisplacementPanel();
		displacementPanel.setLocation(DISPLACEMENT_X, DISPLACEMENT_Y);
		add(displacementPanel);

		bpm = new BPMPanel();
		bpm.setLocation(BPM_X, BPM_Y);
		add(bpm);

		positionPanel.registerDisplacementTracker(displacementPanel.getDisplacementVolume());
		positionPanel.registerDurationCalculator(strokeDurationPanel.getSlider());

		strokeDelayPanel.registerBPMTracker(bpm.getBPM());
		strokeDurationPanel.registerBPMTracker(bpm.getBPM());

		startButton.addArduino(this.arduino);
		stopButton.addArduino(this.arduino);
		homeButton.addArduino(this.arduino);
		positionPanel.addArduino(this.arduino);
		strokeDelayPanel.addArduino(this.arduino);
		strokeDurationPanel.addArduino(this.arduino);

		if (this.arduino.isOpen()) {
			this.arduino.sendPosition(PositionPanel.DEFAULT_START,
					PositionPanel.DEFAULT_STOP);
			this.arduino.sendDelay(StrokeDelayPanel.DEFAULT_DELAY);
			this.arduino.sendDuration(StrokeDurationPanel.DEFAULT_DURATION);
		}

		setVisible(true);
	}
}
