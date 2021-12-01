package picasso.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

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
		Input input = new Input();
		
		// create error window
		ErrorWindow errorWindow = new ErrorWindow();
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluater(input, errorWindow)));
		commands.add("Save", new Writer());
		
		// add panel to hold input and commands
		JPanel inputCommands = new JPanel();
		inputCommands.setLayout(new BoxLayout(inputCommands, BoxLayout.Y_AXIS));
		inputCommands.add(commands);
		inputCommands.add(input);

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(inputCommands, BorderLayout.NORTH);
		pack();
	}
}
