package Components.Buttons;

import java.awt.Color;

import javax.swing.JButton;

import Listeners.Buttons.StartListener;
import app.Arduino;

public class start_button extends JButton {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;

	StartListener listener;

	public start_button() {
		super("START");

		setSize(WIDTH, HEIGHT);
		this.setBackground(Color.GREEN);

		listener = new StartListener();

		addActionListener(listener);
	}

	public void addArduino(Arduino arduino) {
		listener.addArduino(arduino);
	}
}
