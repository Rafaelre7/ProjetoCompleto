package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.ScrollPane;

public class FormulariodeDespesas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormulariodeDespesas frame = new FormulariodeDespesas();
					frame.setVisible(true);
					frame.setExtendedState(FormulariodeDespesas.MAXIMIZED_BOTH); //Iera setar o frame em tela cheia 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormulariodeDespesas() {
		setTitle("Formulario de despesas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768
				);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormularioDeDespesas = new JLabel("Formulario de Despesas");
		lblFormularioDeDespesas.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblFormularioDeDespesas.setBounds(27, 11, 498, 84);
		contentPane.add(lblFormularioDeDespesas);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rafae\\Pictures\\logo-01 fff.png"));
		lblNewLabel.setBounds(27, 84, 350, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N \u00BA Relatorio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(27, 234, 124, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(27, 271, 234, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblReembolsavel = new JLabel("Reembolsavel");
		lblReembolsavel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReembolsavel.setBounds(311, 234, 124, 26);
		contentPane.add(lblReembolsavel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(311, 271, 445, 20);
		contentPane.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(807, 271, 222, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(1045, 271, 222, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDataInicio.setBounds(807, 234, 124, 26);
		contentPane.add(lblDataInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDataFim.setBounds(1045, 234, 124, 26);
		contentPane.add(lblDataFim);
		
		JLabel lblNewLabel_2 = new JLabel("_________________________________");
		lblNewLabel_2.setBounds(27, 250, 234, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("________________________________________");
		label.setBounds(311, 250, 244, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("____________________");
		label_1.setBounds(980, 250, 124, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("____________________");
		label_2.setBounds(1143, 250, 124, 20);
		contentPane.add(label_2);
		
		JLabel lblTipoDePagamento = new JLabel("Tipo de pagamento ");
		lblTipoDePagamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipoDePagamento.setBounds(25, 318, 186, 26);
		contentPane.add(lblTipoDePagamento);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 352, 729, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData.setBounds(805, 318, 124, 26);
		contentPane.add(lblData);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(805, 352, 186, 20);
		contentPane.add(dateChooser_2);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValor.setBounds(1043, 318, 124, 26);
		contentPane.add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1043, 352, 224, 20);
		contentPane.add(textField_2);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmpresa.setBounds(27, 406, 91, 26);
		contentPane.add(lblEmpresa);
		
		JLabel lblCentroDeCusto = new JLabel("Centro de custo ");
		lblCentroDeCusto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCentroDeCusto.setBounds(422, 406, 244, 26);
		contentPane.add(lblCentroDeCusto);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(422, 440, 334, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblLocalizaoDaDespesa = new JLabel("Localiza\u00E7\u00E3o da despesa");
		lblLocalizaoDaDespesa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLocalizaoDaDespesa.setBounds(806, 406, 269, 26);
		contentPane.add(lblLocalizaoDaDespesa);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(807, 440, 460, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(27, 443, 364, 20);
		contentPane.add(comboBox_3);
	}
}
