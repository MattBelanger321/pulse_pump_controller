package Components.Panels;

import javax.swing.JPanel;

import Components.TextBoxes.BPM;
import Components.TextBoxes.BPMTitle;

public class BPMPanel extends JPanel {

	private BPMTitle title;
	private BPM value;

	public final static int PANEL_WIDTH = 350;
	public final static int PANEL_HEIGHT = 100;

	public final static int TITLE_X = 0; // relative to panel
	public final static int TITLE_Y = 0;

	// relative to panel
	public final static int VALUE_X = BPMTitle.WIDTH + TITLE_X + 5; // + 5 for padding
	public final static int VALUE_Y = (BPMTitle.HEIGHT - BPM.HEIGHT) / 2;

	public BPMPanel() {

		setOpaque(false);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);

		setLayout(null);

		title = new BPMTitle();
		title.setLocation(TITLE_X, TITLE_Y);
		title.setTitle("BPM");
		add(title);

		// Value Display
		value = new BPM();
		value.setLocation(VALUE_X, VALUE_Y);
		add(value);

	}

	public BPM getBPM() {
		return value;
	}

}