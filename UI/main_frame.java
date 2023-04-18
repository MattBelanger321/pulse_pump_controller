package UI;

import javax.swing.*;
import java.awt.Color;

public class main_frame extends JFrame {

	private start_button start_button;
	private stop_button stop_button;
	private home_button home_button;

	public main_frame() {
		super("Pulse Pump Controller");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.GRAY);

		// BUTTONS

		// START
		start_button = new start_button();
		start_button.setLocation(10, 100);
		this.add(start_button);

		// STOP
		stop_button = new stop_button();
		stop_button.setLocation(10, 200);
		this.add(stop_button);

		// HOME
		home_button = new home_button();
		home_button.setLocation(10, 300);
		this.add(home_button);

		this.setVisible(true);
	}
}
