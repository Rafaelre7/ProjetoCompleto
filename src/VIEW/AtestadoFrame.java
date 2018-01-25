package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtestadoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtestadoFrame frame = new AtestadoFrame();
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
	public AtestadoFrame() {
		setTitle("                                    Atestado de Manute\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 506);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocal = new JLabel("Local..:");
		lblLocal.setBounds(20, 54, 58, 14);
		contentPane.add(lblLocal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 51, 232, 20);
		contentPane.add(comboBox);
		
		JLabel lblCnpj = new JLabel("Cnpj..:");
		lblCnpj.setBounds(328, 54, 36, 14);
		contentPane.add(lblCnpj);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(304, 220, 87, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Data sa\u00EDda..:");
		lblNewLabel.setBounds(233, 226, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("Modelo..:");
		lblModelo.setBounds(20, 113, 58, 14);
		contentPane.add(lblModelo);
		
		JLabel lblSrie = new JLabel("S\u00E9rie..:");
		lblSrie.setBounds(275, 138, 58, 14);
		contentPane.add(lblSrie);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(374, 51, 123, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(72, 110, 165, 20);
		contentPane.add(textField_2);
		
		JLabel lblImetro = new JLabel("Port Imetro..:");
		lblImetro.setBounds(20, 138, 86, 14);
		contentPane.add(lblImetro);
		
		JLabel lblInventario = new JLabel("Inventario..:");
		lblInventario.setBounds(265, 113, 75, 14);
		contentPane.add(lblInventario);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(343, 110, 154, 20);
		contentPane.add(textField_3);
		
		JLabel lblLacreRetirado = new JLabel("Lacre Colocado..:");
		lblLacreRetirado.setBounds(20, 193, 86, 14);
		contentPane.add(lblLacreRetirado);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(99, 137, 75, 20);
		contentPane.add(textField_4);
		
		JLabel lblLacreColocado = new JLabel("Lacre Retirado..:");
		lblLacreColocado.setBounds(20, 168, 94, 14);
		contentPane.add(lblLacreColocado);
		
		JLabel lblObsevaes = new JLabel("Obseva\u00E7\u00F5es..:");
		lblObsevaes.setBounds(20, 251, 86, 14);
		contentPane.add(lblObsevaes);
		
		JLabel lblSelo = new JLabel("Selo..:");
		lblSelo.setBounds(353, 138, 36, 14);
		contentPane.add(lblSelo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(393, 135, 42, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(20, 276, 434, 127);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton button = new JButton("Novo");
		button.setEnabled(true);
		button.setBounds(8, 414, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setEnabled(false);
		button_1.setBounds(225, 414, 94, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Cancelar");
		button_2.setEnabled(false);
		button_2.setBounds(113, 415, 101, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Excluir");
		button_3.setEnabled(false);
		button_3.setBounds(332, 414, 93, 23);
		contentPane.add(button_3);
		
		JLabel lblCodigo = new JLabel("Codigo..:");
		lblCodigo.setBounds(20, 11, 58, 14);
		contentPane.add(lblCodigo);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(70, 8, 42, 20);
		contentPane.add(textField_8);
		
		JLabel lblDataEntrada = new JLabel("Data entrada..:");
		lblDataEntrada.setBounds(316, 11, 86, 14);
		contentPane.add(lblDataEntrada);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(410, 5, 87, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblAparelho = new JLabel("Aparelho..:");
		lblAparelho.setBounds(20, 79, 58, 14);
		contentPane.add(lblAparelho);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(78, 79, 173, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblMarca = new JLabel("Marca..:");
		lblMarca.setBounds(282, 79, 58, 14);
		contentPane.add(lblMarca);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(342, 79, 155, 20);
		contentPane.add(comboBox_3);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(110, 190, 114, 20);
		contentPane.add(textField_9);
		
		JLabel lblUsuario = new JLabel("Tecnico..:");
		lblUsuario.setBounds(20, 226, 86, 14);
		contentPane.add(lblUsuario);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(79, 220, 135, 20);
		contentPane.add(comboBox_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(109, 165, 115, 20);
		contentPane.add(textField_5);
	}
}
