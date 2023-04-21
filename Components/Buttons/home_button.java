package Components.Buttons;

import java.awt.Color;

import javax.swing.JButton;

import Listeners.Buttons.HomeListener;
import app.Arduino;

public class home_button extends JButton {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;
	private HomeListener listener;

	public home_button() {
		super("HOME");

		setSize(WIDTH, HEIGHT);
		this.setBackground(Color.cyan);

		listener = new HomeListener();

		addActionListener(listener);
	}

	public void addArduino(Arduino arduino) {
		listener.addArduino(arduino);
	}
}
