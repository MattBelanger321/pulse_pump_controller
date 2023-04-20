package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;

import UI.Text.StrokeDurationTitleDocument;

public class StrokeDurationTitle extends JTextPane {

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 100;
	public final static int HEIGHT = 55;

	private StrokeDurationTitleDocument doc;

	private Font font;

	public StrokeDurationTitle() {

		doc = new StrokeDurationTitleDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		setFont(font);
	}

	public void setTitle(String title) {
		doc.setMessage(title);
	}

}
