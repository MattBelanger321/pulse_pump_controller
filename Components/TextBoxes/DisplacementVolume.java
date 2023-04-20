package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;
import UI.Text.*;

public class DisplacementVolume extends JTextPane {

	private final static double VOLUME_FORMULA_CONSTANT = 493.95;

	private double displacementVolume; // in ml

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 75;
	public final static int HEIGHT = 25;

	private Font font;

	private DisplacementVolumeDocument doc;

	public DisplacementVolume() {

		doc = new DisplacementVolumeDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		setVolume(0, 0);
	}

	public void setVolume(int start, int stop) {
		displacementVolume = calculateVolume(start, stop);

		doc.setMessage(String.format("%.4f", displacementVolume) + "ml");
	}

	private double calculateVolume(int start, int stop) {
		return Math.PI * VOLUME_FORMULA_CONSTANT * (start - stop) / 1000.00;
	}
}
