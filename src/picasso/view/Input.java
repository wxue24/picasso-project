/**
 * 
 */
package picasso.view;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.Document;

/**
 * Scrollable text area for user input
 * @author Will Xue
 *
 */
public class Input extends JScrollPane {
	
	JTextArea textArea;

	/**
	 * 
	 */
	public Input(int rows) {
		createTextArea(rows);
		// Adds textArea to scrollPane
		setViewportView(textArea);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	private void createTextArea(int rows) {
		textArea = new JTextArea();
		textArea.setRows(rows);
		textArea.setLineWrap(true);
	}



}
