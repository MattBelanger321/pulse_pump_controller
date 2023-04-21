package Listeners.Buttons;

import app.Arduino;
import java.awt.event.*;

public class StartListener implements ActionListener {
	private Arduino arduino;

	public void addArduino(Arduino arduino) {
		this.arduino = arduino;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (arduino != null) {
			arduino.sendStart();
		}
	}
}
