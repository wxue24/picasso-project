/**
 * 
 */
package picasso.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import picasso.parser.language.Variables;

/**
 * A panel containing the variables the user adds
 * 
 * @author wxue cbassi
 *
 */
public class VariablesPanel extends JPanel {

	private JPanel variablesPanel;
	private ErrorWindow errorWindow;
	private Variables variables;

	public VariablesPanel(ErrorWindow ew) {
		variables = Variables.getInstance();
		errorWindow = ew;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("Variables"));
		add(addVariablePanel());
		add(showVariablesPanel());
	}

	/**
	 * Helper method to create a panel to add new variables
	 * 
	 * @return JPanel
	 */
	private JPanel addVariablePanel() {

		JTextField input = new JTextField(20);
		JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputPanel.add(input);

		JButton addVariableButton = new JButton("Add");
		addVariableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] v = variables.addVariable(input.getText());
					variablesPanel.add(createEntry(v[0], v[1]));
					variablesPanel.revalidate();

				} catch (IllegalArgumentException exception) {
					errorWindow.showError(exception.getMessage());
				}

			}
		});
		addVariableButton.setAlignmentX(CENTER_ALIGNMENT);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(addVariableButton);

//		JPanel Input = new JPanel();
//		Input.setLayout(new BoxLayout(Input, BoxLayout.Y_AXIS));
//		Input.add(inputPanel);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(inputPanel);
		panel.add(buttonPanel);

		return panel;
	}

	/**
	 * Helper method to create panel to display current variables
	 * 
	 * @return JPanel
	 */
	private JPanel showVariablesPanel() {

		variablesPanel = new JPanel();
		variablesPanel.setLayout(new BoxLayout(variablesPanel, BoxLayout.Y_AXIS));

		// Populate panel with variables
		for (Map.Entry<String, String> entry : variables.getVariablesMapping().entrySet()) {
			variablesPanel.add(createEntry(entry.getKey(), entry.getValue()));
		}

		JScrollPane scrollPane = new JScrollPane(variablesPanel);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scrollPane);
		return panel;

	}

	/**
	 * Helper method to create every variable entry
	 * 
	 * @param name - name of variable
	 * @param exp  - expression of variable
	 */
	private JPanel createEntry(String name, String exp) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel(name + " = " + exp);
		panel.add(label);

//		Remove Button 
		JButton removeVariableButton = new JButton("Remove");
		removeVariableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				variables.removeVariable(name);
				variablesPanel.remove(panel);
				variablesPanel.revalidate();
				variablesPanel.repaint();
			};
		});

		panel.add(removeVariableButton);
		return panel;
	}

}
