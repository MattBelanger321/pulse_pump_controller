package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;

import UI.Text.BPMTitleDocument;

public class BPMTitle extends JTextPane {

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 150;
	public final static int HEIGHT = 55;

	private BPMTitleDocument doc;

	private Font font;

	public BPMTitle() {

		doc = new BPMTitleDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		font = new Font(Font.SANS_SERIF, Font.PLAIN, 35);
		setFont(font);
	}

	public void setTitle(String title) {
		doc.setMessage(title);
	}

}
