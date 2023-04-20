package Components.Buttons;

import java.awt.Color;

import javax.swing.JButton;

import app.Arduino;

public class stop_button extends JButton {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;

	public stop_button() {
		super("STOP");

		setSize(WIDTH, HEIGHT);
		this.setBackground(Color.RED);
	}

	public void addArduino(Arduino arduino) {
		// create button listener
	}
}
