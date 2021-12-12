/**
 * 
 */
package picasso.view;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Scrollable text area for user input
 * 
 * @author Will Xue
 *
 */
public class InputPanel extends JPanel {

	private JTextArea text;

	public InputPanel() {
		setLayout(new FlowLayout());
		add(new JLabel("Expression"));
		text = new JTextArea(3, 30);
		JScrollPane scroll = new JScrollPane(text);
		add(scroll);
	}

	/**
	 * 
	 * @return text from text area
	 */
	public String getText() {
		return text.getText();
	}

	/**
	 * Creates a new file for input expression
	 * 
	 * @param filename
	 */
	public void write(String filename) {
		try {
			// Create file
			File myObj = new File(filename);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
			// Write expression to file
			FileWriter myWriter = new FileWriter(filename);
			System.out.println(text.getText());
			myWriter.write(text.getText());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
