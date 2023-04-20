package Components.Panels;

import javax.swing.JPanel;

import Components.TextBoxes.DisplacementVolume;
import Components.TextBoxes.DisplacementVolumeTitle;

public class DisplacementPanel extends JPanel {

	private DisplacementVolumeTitle title;
	private DisplacementVolume value;

	public final static int PANEL_WIDTH = 350;
	public final static int PANEL_HEIGHT = 200;

	public final static int TITLE_X = 0; // relative to panel
	public final static int TITLE_Y = 0;

	// relative to panel
	public final static int VALUE_X = DisplacementVolumeTitle.WIDTH + TITLE_X + 5; // + 5 for padding
	public final static int VALUE_Y = (DisplacementVolumeTitle.HEIGHT - DisplacementVolume.HEIGHT) / 2;

	public DisplacementPanel() {

		setOpaque(false);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);

		setLayout(null);

		title = new DisplacementVolumeTitle();
		title.setLocation(TITLE_X, TITLE_Y);
		title.setTitle("Displacement\nVolume(ml)");
		add(title);

		// Value Display
		value = new DisplacementVolume();
		value.setLocation(VALUE_X, VALUE_Y);
		add(value);

	}

	public DisplacementVolume getDisplacementVolume() {
		return value;
	}

}