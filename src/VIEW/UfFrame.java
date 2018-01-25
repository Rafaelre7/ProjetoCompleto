package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UfFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UfFrame frame = new UfFrame();
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
	public UfFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoduf = new JLabel("Cod_uf");
		lblCoduf.setBounds(10, 11, 46, 14);
		contentPane.add(lblCoduf);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(10, 40, 46, 14);
		contentPane.add(lblUf);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
