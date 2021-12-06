/**
 * 
 */
package picasso.view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Scrollable text area for user input
 * 
 * @author Will Xue
 *
 */
public class InputPanel extends JPanel {

	JTextField text;

	public InputPanel() {
		setLayout(new FlowLayout());
		add(new JLabel("Expression"));
		text = new JTextField(30);
		add(text);
	}

	/**
	 * 
	 * @return text from text area
	 */
	public String getText() {
		return text.getText();
	}

}
