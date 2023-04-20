package Components.TextBoxes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;

import UI.Text.MainTitleDocument;

public class MainTitle extends JTextPane {

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 1280;
	public final static int HEIGHT = 100;

	private MainTitleDocument doc;

	private Font font;

	public MainTitle() {

		doc = new MainTitleDocument();

		setSize(WIDTH, HEIGHT);
		setEditable(false);

		setStyledDocument(doc);

		font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		setTitle("PULSE PUMP CONTROLLER");
		setFont(font);

		setBackground(Color.DARK_GRAY);
		setForeground(Color.white);
	}

	public void setTitle(String title) {
		doc.setMessage(title);
	}

}
