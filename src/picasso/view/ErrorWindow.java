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
	private String errorMessage;
	private static ErrorWindow ourInstance;
	private JFrame frame;

	/**
	 * Make sure there is only one instance
	 * 
	 * @return the ErrorWindow instance
	 */
	public static ErrorWindow getInstance() {
		if (ourInstance == null) {
			ourInstance = new ErrorWindow();
		}
		return ourInstance;
	}

	private ErrorWindow() {
		frame = new JFrame();
	}

	/**
	 * Show the error
	 * 
	 * @param e - error message
	 */
	public void showError(String e) {
		showMessageDialog(frame, e, "Something went wrong", JOptionPane.ERROR_MESSAGE);
	}

}
