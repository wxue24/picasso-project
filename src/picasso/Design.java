package picasso;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Design extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Design frame = new Design();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Expression");
		panel_2.add(lblNewLabel_1);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(30);

		JPanel panel = new JPanel();
		panel_3.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JTextPane textPane = new JTextPane();
		panel.add(textPane);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		JLabel lblNewLabel = new JLabel("Variables");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_4.add(lblNewLabel);

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);

		textField_1 = new JTextField();
		panel_7.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_3 = new JButton("Add");
		panel_4.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.PAGE_AXIS));

		JPanel panel_6_2 = new JPanel();
		panel_6.add(panel_6_2);
		panel_6_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_2_2 = new JLabel("Key");
		panel_6_2.add(lblNewLabel_2_2);

		JLabel lblNewLabel_3_2 = new JLabel("Value");
		panel_6_2.add(lblNewLabel_3_2);

		JButton btnNewButton_4_2 = new JButton("Remove");
		panel_6_2.add(btnNewButton_4_2);

		JPanel panel_6_2_3 = new JPanel();
		panel_6.add(panel_6_2_3);

		JLabel lblNewLabel_2_2_3 = new JLabel("Key");
		panel_6_2_3.add(lblNewLabel_2_2_3);

		JLabel lblNewLabel_3_2_3 = new JLabel("Value");
		panel_6_2_3.add(lblNewLabel_3_2_3);

		JButton btnNewButton_4_2_3 = new JButton("Remove");
		panel_6_2_3.add(btnNewButton_4_2_3);

		JPanel panel_6_2_4 = new JPanel();
		panel_6.add(panel_6_2_4);

		JLabel lblNewLabel_2_2_4 = new JLabel("Key");
		panel_6_2_4.add(lblNewLabel_2_2_4);

		JLabel lblNewLabel_3_2_4 = new JLabel("Value");
		panel_6_2_4.add(lblNewLabel_3_2_4);

		JButton btnNewButton_4_2_4 = new JButton("Remove");
		panel_6_2_4.add(btnNewButton_4_2_4);

		JPanel panel_6_2_5 = new JPanel();
		panel_6.add(panel_6_2_5);

		JLabel lblNewLabel_2_2_5 = new JLabel("Key");
		panel_6_2_5.add(lblNewLabel_2_2_5);

		JLabel lblNewLabel_3_2_5 = new JLabel("Value");
		panel_6_2_5.add(lblNewLabel_3_2_5);

		JButton btnNewButton_4_2_5 = new JButton("Remove");
		panel_6_2_5.add(btnNewButton_4_2_5);

		JPanel panel_6_2_6 = new JPanel();
		panel_6.add(panel_6_2_6);

		JLabel lblNewLabel_2_2_6 = new JLabel("Key");
		panel_6_2_6.add(lblNewLabel_2_2_6);

		JLabel lblNewLabel_3_2_6 = new JLabel("Value");
		panel_6_2_6.add(lblNewLabel_3_2_6);

		JButton btnNewButton_4_2_6 = new JButton("Remove");
		panel_6_2_6.add(btnNewButton_4_2_6);
	}

}
