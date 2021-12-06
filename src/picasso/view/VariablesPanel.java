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
 * @author wxue
 *
 */
public class VariablesPanel extends JPanel {

	private JPanel AddVariable;
	private JPanel ShowVariables;
	private JPanel variablesPanel;
	private JTextField newVariable;
	private ErrorWindow errorWindow;
	private Variables variables;

	public VariablesPanel(ErrorWindow ew) {
		variables = Variables.getInstance();
		errorWindow = ew;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("Variables"));
		addVariablePanel();
		showVariablesPanel();
		add(AddVariable);
		add(ShowVariables);
	}

	/**
	 * Helper method to create a panel to add new variables
	 */
	private void addVariablePanel() {

		newVariable = new JTextField(20);
		JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputPanel.add(newVariable);

		JButton addVariableButton = new JButton("Add");
		addVariableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] inputKV = Variables.getInstance().parse(newVariable.getText());
					if (inputKV != null) {
						variables.addVariable(inputKV[0], inputKV[1]);
						variablesPanel.add(createEntry(inputKV[0], inputKV[1]));
						variablesPanel.revalidate();
					}
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

		AddVariable = new JPanel();
		AddVariable.setLayout(new BoxLayout(AddVariable, BoxLayout.Y_AXIS));
		AddVariable.add(inputPanel);
		AddVariable.add(buttonPanel);
	}

	/**
	 * Helper method to create panel to display current variables
	 */
	private void showVariablesPanel() {

		variablesPanel = new JPanel();
		variablesPanel.setLayout(new BoxLayout(variablesPanel, BoxLayout.Y_AXIS));
		if (variables.getVariablesMapping() != null) {
			for (Map.Entry<String, String> entry : variables.getVariablesMapping().entrySet()) {
				variablesPanel.add(createEntry(entry.getKey(), entry.getValue()));
			}
		}

		JScrollPane variablesScrollPane = new JScrollPane(variablesPanel);

		ShowVariables = new JPanel();
		ShowVariables.setLayout(new BorderLayout());
		ShowVariables.add(variablesScrollPane);

	}

	/**
	 * Helper method to create every variable entry
	 * 
	 * @param name       - name of variable
	 * @param expression - expression of variable
	 */
	private JPanel createEntry(String name, String expression) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel(name + " = " + expression));
		panel.add(new JButton("Remove"));
		return panel;
	}

}
