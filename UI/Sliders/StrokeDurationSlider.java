package UI.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

public class StrokeDurationSlider extends JSlider {
	public StrokeDurationSlider() {
		super(0, 150);

		setSize(250, 30);

		setBackground(Color.CYAN);
	}
}
