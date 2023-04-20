package Components.Buttons;

import java.awt.Color;

import javax.swing.JButton;

import app.Arduino;

public class home_button extends JButton {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;

	public home_button() {
		super("HOME");

		setSize(WIDTH, HEIGHT);
		this.setBackground(Color.cyan);
	}

	public void addArduino(Arduino arduino) {
		// create button listener
	}
}
