package UI.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

public class StopSlider extends JSlider {
	public StopSlider() {
		super(0, 150);

		setSize(250, 30);

		setBackground(Color.red);
	}
}
