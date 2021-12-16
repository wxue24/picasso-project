/**
 * 
 */
package picasso.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Panel for showing history of expressions
 * 
 * @author wxue
 *
 */
public class ExpressionHistoryPanel extends JPanel {
	private List<String> expressions;
	private JPanel history;

	public ExpressionHistoryPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(new JLabel("History"));

		Dimension size = new Dimension(250, 400);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		super.setSize(size);

		expressions = new ArrayList<>();

		history = new JPanel();
		history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));

		JScrollPane scroll = new JScrollPane(history);
		scroll.setSize(new Dimension(250, 350));
		add(scroll);
	}

	/**
	 * Adds new expression to history
	 * 
	 * @param exp
	 */
	public void addExpression(String exp) {
		if (expressions.contains(exp)) {
			removeExpression(exp);
		}
		expressions.add(exp);
		refresh();
	}

	/**
	 * Help method to remove expression
	 * 
	 * @param exp
	 */
	private void removeExpression(String exp) {
		expressions.remove(exp);
	}

	/**
	 * Helper method to create individual expression panel
	 * 
	 * @param exp
	 * @return
	 */
	private JPanel createExpressionPanel(String exp) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(new JLabel(exp));
		JButton evaluateButton = new JButton("Set current expression");
		evaluateButton.addActionListener(e -> {
			// Sets main input to expression
			InputPanel.setText(exp);
		});
		p.add(evaluateButton);
		return p;
	}

	/**
	 * Removes expressions
	 */
	private void clear() {
		// reset panel
		expressions = new ArrayList<>();
		refresh();

	}

	public void refresh() {
		history.removeAll();
		for (int i = expressions.size() - 1; i >= 0; i--) {
			history.add(createExpressionPanel(expressions.get(i)));
		}
		this.revalidate();
		this.repaint();
	}

}
