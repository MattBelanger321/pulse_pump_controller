package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;

import UI.Text.StrokeDurationValueDocument;

public class StrokeDurationValue extends JTextPane {

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 100;
	public final static int HEIGHT = 35;

	private StrokeDurationValueDocument doc;

	private Font font;

	public StrokeDurationValue() {
		this(0);
	}

	public StrokeDurationValue(int value) {

		doc = new StrokeDurationValueDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		setFont(font);

		setValue(value);
	}

	public void setValue(int value) {
		doc.setMessage(String.format("%dus", value));
	}

}
