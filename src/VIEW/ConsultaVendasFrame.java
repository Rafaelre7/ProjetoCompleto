package VIEW;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.VendasDAO;
import ENTIDADE.Venda;
import MODEL.ClienteTableModel;
import MODEL.RelatorioVendasTableModel;
import UTIL.RelatorioUtil;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ConsultaVendasFrame extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblCliente;
	private JLabel lblNewLabel_1;
	private JLabel lblUsuario;
	private JLabel lblNewLabel_2;
	private JTextField tfCodigo;
	private JTextField tfCliente;
	private JTextField tfUsuario;
	private JTextField tfTotal;
	private Venda vendaEdicao;
	private VendasDAO dao = new VendasDAO();
	private JTextField tfDate;
	private JButton btnNewButton;
	private JTextField tfPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVendasFrame frame = new ConsultaVendasFrame();
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
	public ConsultaVendasFrame() {
		setTitle("                                                               Relatorio Vendas");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 194, 708, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					//Cast
					RelatorioVendasTableModel modelo = (RelatorioVendasTableModel) table.getModel();
					
					vendaEdicao = modelo.getRelatorioVendasPorLinha(table.getSelectedRow());
					

					tfCodigo.setText(String.valueOf(vendaEdicao.getCodigo()));
					tfDate.setText(String.valueOf(vendaEdicao.getData_Compra()));
					tfCliente.setText(vendaEdicao.getCliente().getNome());
			//		tfUsuario.setText(vendaEdicao.getUsuario().getUsuario());
					tfTotal.setText(String.valueOf(vendaEdicao.getTotal()));
					


				}

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new RelatorioVendasTableModel(dao.select()));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
				
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(10, 29, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblCliente = new JLabel("Data");
		lblCliente.setBounds(160, 29, 46, 14);
		contentPane.add(lblCliente);
		
		lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setBounds(10, 69, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 101, 55, 14);
		contentPane.add(lblUsuario);
		
		lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setBounds(10, 135, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(64, 29, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfCliente = new JTextField();
		tfCliente.setBounds(64, 69, 267, 20);
		contentPane.add(tfCliente);
		tfCliente.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(64, 101, 86, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfTotal = new JTextField();
		tfTotal.setBounds(64, 132, 86, 20);
		contentPane.add(tfTotal);
		tfTotal.setColumns(10);
		
		tfDate = new JTextField();
		tfDate.setBounds(193, 29, 86, 20);
		contentPane.add(tfDate);
		tfDate.setColumns(10);
		
		btnNewButton = new JButton("Buscar por Nome");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Venda> v = dao.pesquisarPorNome(tfPesquisa.getText());
				table.setModel(new RelatorioVendasTableModel(v));
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Search\\Search_24x24.png"));
		btnNewButton.setBounds(370, 52, 169, 33);
		contentPane.add(btnNewButton);
		
		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(549, 54, 169, 29);
		contentPane.add(tfPesquisa);
		tfPesquisa.setColumns(10);
	}
}
