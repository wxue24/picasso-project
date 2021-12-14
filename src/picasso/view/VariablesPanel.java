/**
 * 
 */
package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.Variables;
import picasso.parser.tokens.IdentifierToken;

/**
 * A panel containing the variables the user adds
 * 
 * @author wxue cbassi
 *
 */
public class VariablesPanel extends JPanel {

	private JPanel variablesPanel;
	private Variables variables;

	public VariablesPanel(ExpressionHistoryPanel exphist) {
		variables = Variables.getInstance();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Dimension size = new Dimension(250, 800);
		setPreferredSize(size);
		setMaximumSize(size);
		super.setSize(size);

		add(new JLabel("Variables"));
		add(showVariablesPanel());

		add(exphist);

	}

	/**
	 * Helper method to create panel to display current variables
	 * 
	 * @return JPanel
	 */
	private JPanel showVariablesPanel() {

		variablesPanel = new JPanel();
		variablesPanel.setLayout(new BoxLayout(variablesPanel, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(variablesPanel);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scrollPane);
		panel.setPreferredSize(new Dimension(100, 200));
		return panel;

	}

	/**
	 * Helper method to create every variable entry
	 * 
	 * @param name - name of variable
	 * @param exp  - expression of variable
	 */
	private JPanel createEntry(IdentifierToken n, ExpressionTreeNode e) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel(n.getName() + " = " + e.toString());
		panel.add(label);

//		Remove Button 
		JButton removeVariableButton = new JButton("Remove");
		removeVariableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				variables.removeVariable(n);
				refresh();
			};
		});

		panel.add(removeVariableButton);
		return panel;
	}

	@Override
	public void setSize(Dimension size) {
		setPreferredSize(size);
		setMinimumSize(size);
		super.setSize(size);
	}

	public void refresh() {
		variablesPanel.removeAll();
		for (Entry<IdentifierToken, ExpressionTreeNode> e : variables.getAll()) {
			variablesPanel.add(createEntry(e.getKey(), e.getValue()));
		}
		this.revalidate();
		this.repaint();
	}

}
