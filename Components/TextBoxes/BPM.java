package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;
import UI.Text.*;

public class BPM extends JTextPane {
	private double bpm; // beats/min

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 100;
	public final static int HEIGHT = 25;

	private Font font;
	private static final int FONT_SIZE = 16;

	private int strokeDelay;
	private int strokeDuration;

	private BPMDocument doc;

	public BPM() {

		doc = new BPMDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		font = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE);
		setFont(font);

		strokeDelay = 0;
		strokeDuration = 0;
		setBPM(strokeDelay, strokeDuration);
	}

	public void setDelay(int delay) {
		strokeDelay = delay;

		setBPM(strokeDelay, strokeDuration);
	}

	public void setDuration(int duration) {
		strokeDuration = duration;

		setBPM(strokeDelay, strokeDuration);
	}

	public void setBPM(int stroke_delay, int stroke_duration) {
		bpm = calculateBPM(strokeDelay, strokeDuration);

		doc.setMessage(String.format("%.3f", bpm));
	}

	private double calculateBPM(int strokeDelay, int strokeDuration) {

		if (strokeDelay == 0 && strokeDuration == 0) {
			return 0;
		}

		return 60000 / (double) (strokeDelay + (2 * strokeDuration)); // a beat is 2 strokes plus delay
	}
}
