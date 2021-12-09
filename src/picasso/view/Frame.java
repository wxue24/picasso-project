package picasso.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.Evaluater;
import picasso.view.commands.Reader;
import picasso.view.commands.Writer;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		// create input field
		InputPanel input = new InputPanel();

		// create variables panel
		VariablesPanel variablesPanel = new VariablesPanel();

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluater(input)));
		commands.add("Save", new Writer());

		// add panel to hold commands, input, and canvas
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(commands);
		mainPanel.add(input);
		mainPanel.add(canvas);

		// add our panels to Frame and show it
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		getContentPane().add(mainPanel);
		getContentPane().add(variablesPanel);
		pack();
	}
}
