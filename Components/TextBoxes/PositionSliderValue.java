package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;

import UI.Text.PositionSliderTitleDocument;
import UI.Text.PositionSliderValueDocument;

public class PositionSliderValue extends JTextPane {

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 100;
	public final static int HEIGHT = 35;

	private PositionSliderValueDocument doc;

	private Font font;

	public PositionSliderValue() {
		this(0, 0);
	}

	public PositionSliderValue(int start, int stop) {

		doc = new PositionSliderValueDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		font = new Font(Font.SANS_SERIF, 1, 18);
		setFont(font);

		setValue(start, stop);
	}

	public void setValue(int start, int stop) {
		doc.setMessage(String.format("[ %d , %d ]", start, stop));
	}

}
