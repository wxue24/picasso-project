/**
 * 
 */
package picasso.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Window for showing error messages
 * 
 * @author wxue
 *
 */
public class ErrorWindow extends JOptionPane {
	private JFrame frame;
	private String errorMessage;

	public ErrorWindow() {
		frame = new JFrame();
	}

	public void showError(String e) {
		showMessageDialog(frame, e, "Something went wrong", JOptionPane.ERROR_MESSAGE);
	}

}
