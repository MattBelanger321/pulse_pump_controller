package Components.Buttons;

import java.awt.Color;

import javax.swing.JButton;

import app.Arduino;

public class start_button extends JButton {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;

	public start_button() {
		super("START");

		setSize(WIDTH, HEIGHT);
		this.setBackground(Color.GREEN);
	}

	public void addArduino(Arduino arduino) {
		// create button listener
	}
}
