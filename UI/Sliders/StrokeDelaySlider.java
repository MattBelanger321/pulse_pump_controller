package UI.Sliders;

import java.awt.Color;

import javax.swing.JSlider;

public class StrokeDelaySlider extends JSlider {
	public StrokeDelaySlider() {
		super(0, 150);

		setSize(250, 30);

		setBackground(Color.blue);
	}
}
