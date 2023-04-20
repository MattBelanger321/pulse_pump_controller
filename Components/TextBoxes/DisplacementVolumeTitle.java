package Components.TextBoxes;

import java.awt.Font;

import javax.swing.JTextPane;

import UI.Text.DisplacementVolumeTitleDocument;

public class DisplacementVolumeTitle extends JTextPane {

	public final static int ROWS = 1;
	public final static int COLS = 50;

	public final static int WIDTH = 150;
	public final static int HEIGHT = 55;

	private DisplacementVolumeTitleDocument doc;

	private Font font;

	public DisplacementVolumeTitle() {

		doc = new DisplacementVolumeTitleDocument();

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
