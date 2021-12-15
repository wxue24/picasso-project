package picasso.view.commands;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.InputPanel;

/**
 * Save the chosen file and expression
 * 
 * @author Robert C Duvall
 */
public class Writer extends FileCommand<Pixmap> {
	InputPanel input;

	public Writer(InputPanel input) {
		super(JFileChooser.SAVE_DIALOG);
		this.input = input;
	}

	@Override
	public void execute(Pixmap target) {
		if (saveExpression()) {
			// Saves expression
			String fileName = getFileName();
			if (fileName != null) {
				input.write(fileName);
			}
		}

		// Saves image
		if (saveImage()) {
			// Saves expression
			String fileName = getFileName();
			if (fileName != null) {
				target.write(fileName);
			}
		}
	}

	/**
	 * Prompts user to save expression
	 * 
	 * @return
	 */
	public boolean saveExpression() {
		int reply = JOptionPane.showConfirmDialog(null, "Do you want to save this expression?", "Save Expression",
				JOptionPane.YES_NO_OPTION);
		return (reply == JOptionPane.YES_OPTION ? true : false);
	}

	/**
	 * Prompts user to save image
	 * 
	 * @return
	 */
	public boolean saveImage() {
		int reply = JOptionPane.showConfirmDialog(null, "Do you want to save this image?", "Save Image",
				JOptionPane.YES_NO_OPTION);
		return (reply == JOptionPane.YES_OPTION ? true : false);
	}
}
