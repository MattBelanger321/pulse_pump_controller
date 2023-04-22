package Components.Panels;

import javax.swing.JPanel;

import Components.TextBoxes.MainTitle;

public class MainTitlePanel extends JPanel {

	private MainTitle title;

	public final static int PANEL_WIDTH = 1280;
	public final static int PANEL_HEIGHT = 200;

	public final static int TITLE_X = 0; // relative to panel
	public final static int TITLE_Y = 0;

	public MainTitlePanel() {

		setSize(PANEL_WIDTH, PANEL_HEIGHT);

		setLayout(null);

		title = new MainTitle();
		title.setLocation(TITLE_X, TITLE_Y);
		title.setTitle("PULSE PUMP CONTROLLER");
		add(title);

	}
}