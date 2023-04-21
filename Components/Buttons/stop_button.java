package Components.Buttons;

import java.awt.Color;

import javax.swing.JButton;

import Listeners.Buttons.StopListener;
import app.Arduino;

public class stop_button extends JButton {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;
	private StopListener listener;

	public stop_button() {
		super("STOP");

		setSize(WIDTH, HEIGHT);
		this.setBackground(Color.RED);

		listener = new StopListener();

		addActionListener(listener);
	}

	public void addArduino(Arduino arduino) {
		listener.addArduino(arduino);
	}
}
