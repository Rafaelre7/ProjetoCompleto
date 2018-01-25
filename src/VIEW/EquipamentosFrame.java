package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JComboBox;

public class EquipamentosFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipamentosFrame frame = new EquipamentosFrame();
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
	public EquipamentosFrame() {
		setTitle("Cadastro de Equipamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(76, 84, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo..:");
		lblNewLabel.setBounds(10, 87, 46, 14);
		contentPane.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(472, 84, 108, 20);
		contentPane.add(dateChooser);
		
		JLabel lblDataCompra = new JLabel("Data Compra..:");
		lblDataCompra.setBounds(387, 87, 75, 14);
		contentPane.add(lblDataCompra);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 626, 78);
		contentPane.add(panel);
		
		JLabel lblC = new JLabel("Cadastro de Equipamentos");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panel.add(lblC);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o..:");
		lblDescrio.setBounds(10, 115, 75, 14);
		contentPane.add(lblDescrio);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 112, 161, 20);
		contentPane.add(textField_1);
		
		JLabel lblMarca = new JLabel("Marca..:");
		lblMarca.setBounds(408, 115, 75, 14);
		contentPane.add(lblMarca);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(459, 115, 121, 20);
		contentPane.add(comboBox);
		
		JLabel lblModelo = new JLabel("Modelo..:");
		lblModelo.setBounds(244, 115, 75, 14);
		contentPane.add(lblModelo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(291, 112, 108, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblSrie = new JLabel("S\u00E9rie..:");
		lblSrie.setBounds(10, 146, 46, 14);
		contentPane.add(lblSrie);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 143, 152, 20);
		contentPane.add(textField_2);
		
		JLabel lblCor = new JLabel("Cor..:");
		lblCor.setBounds(244, 146, 75, 14);
		contentPane.add(lblCor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(273, 143, 99, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es..:");
		lblObservaes.setBounds(10, 184, 75, 14);
		contentPane.add(lblObservaes);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.info);
		textField_3.setBounds(10, 200, 598, 109);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblImetro = new JLabel("Quantidade..:");
		lblImetro.setBounds(408, 146, 86, 14);
		contentPane.add(lblImetro);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(486, 143, 94, 20);
		contentPane.add(textField_4);
	}
}
