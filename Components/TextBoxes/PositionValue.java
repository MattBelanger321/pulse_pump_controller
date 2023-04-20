package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;

import UI.Text.PositionValueDocument;

public class PositionValue extends JTextPane {

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 175;
	public final static int HEIGHT = 35;

	private PositionValueDocument doc;

	private Font font;

	public PositionValue() {
		this(0, 0);
	}

	public PositionValue(int start, int stop) {

		doc = new PositionValueDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		setFont(font);

		setValue(start, stop);
	}

	public void setValue(int start, int stop) {
		doc.setMessage(String.format("[ %dmm , %dmm ]", start, stop));
	}

}
