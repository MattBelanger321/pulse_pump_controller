package UI.Text;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class StrokeDelayValueDocument extends DefaultStyledDocument {

	private SimpleAttributeSet center;
	private String message;

	public StrokeDelayValueDocument() {

		message = "";

		center = new SimpleAttributeSet();

		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		setParagraphAttributes(0, getLength(), center, false);
	}

	public void setMessage(String message) {
		try {
			remove(0, this.message.length());
			insertString(0, message, center);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		this.message = message;
	}
}
