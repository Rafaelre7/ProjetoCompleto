package VIEW;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.MarcaDAO;

import ENTIDADE.Marca;

import MODEL.ClienteTableModel;
import MODEL.MarcaTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class MarcaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfMarca;
	private Marca marcaEdicao;
	private MarcaDAO marcaDAO = new MarcaDAO();
	private JTable table;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JTextField tfCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcaFrame frame = new MarcaFrame();
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
	public MarcaFrame() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setType(Type.POPUP);
		setTitle("Cadastro de Marcas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Marca");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(8, 74, 83, 20);
		contentPane.add(lblUsuario);

		tfMarca = new JTextField();
		tfMarca.setBounds(10, 98, 218, 20);
		contentPane.add(tfMarca);
		tfMarca.setColumns(10);

		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(
				"C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marcaEdicao = null;

				tfMarca.setText("");
				tfCodigo.setText("");
				tfCodigo.requestFocus();

				btnNovo.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(false);

			}
		});
		btnNovo.setBounds(8, 129, 104, 23);
		contentPane.add(btnNovo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(
				"C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Save\\Save_16x16.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfMarca.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a Marca!");
					tfMarca.requestFocus();
					return;

				} // Novo registro
				if (marcaEdicao == null) {
					marcaEdicao = new Marca();
					// usuarioEdicao.setCodigo(Integer.parseInt(tfCodigo.getText()));
					marcaEdicao.setDescricao(tfMarca.getText());

					if (marcaDAO.insert(marcaEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, "MARCA INSERIDO COM SUCESSO!");
						marcaEdicao = null;
						tfMarca.setText("");
						tfCodigo.setText("");
						table.setModel(new MarcaTableModel(marcaDAO.select()));

					} else { // Se False
						JOptionPane.showMessageDialog(null, "PROBLEMAS NA INSERÇÃO!");

					}
				} else {// Altera Registro
					// marcaEdicao.setCodigo(Integer.parseInt(tfCodigo.getText()));
					marcaEdicao.setDescricao(tfMarca.getText());

					if (marcaDAO.update(marcaEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, "ALTERADO COM SUCESSO");
						marcaEdicao = null;
						tfMarca.setText("");

						tfCodigo.setText("");
						table.setModel(new MarcaTableModel(marcaDAO.select()));
					} else { // Se False
						JOptionPane.showMessageDialog(null, "PROBLEMAS NA ALTERAÇÃO!");
					}
					btnNovo.setEnabled(true);
					btnSalvar.setEnabled(false);
					btnCancelar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}

		});
		btnSalvar.setBounds(120, 129, 104, 23);
		contentPane.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(
				"C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Delete\\Delete_16x16.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir esta Marca?") == JOptionPane.YES_OPTION) {

					MarcaTableModel modelo = (MarcaTableModel) table.getModel();
					marcaEdicao = modelo.getMarcaPorLinha(table.getSelectedRow());

					if (marcaDAO.delete(marcaEdicao.getCod_marca())) {
						JOptionPane.showMessageDialog(null, "EXCLUÍDO COM SUCESSO");
						marcaEdicao = null;
						tfMarca.setText("");

						table.setModel(new MarcaTableModel(marcaDAO.select()));
					} else {
						JOptionPane.showMessageDialog(null, "PROBLEMAS NA EXCLUSÃO");
					}
				}
				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});

		btnExcluir.setBounds(346, 129, 104, 23);
		contentPane.add(btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(
				"C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Cancel\\Cancel_16x16.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcaEdicao = null;
				tfMarca.setText("");

				tfMarca.requestFocus();

				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnCancelar.setBounds(236, 129, 104, 23);
		contentPane.add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 163, 442, 200);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					// Cast
					MarcaTableModel modelo = (MarcaTableModel) table.getModel();

					marcaEdicao = modelo.getMarcaPorLinha(table.getSelectedRow());

					tfMarca.setText(marcaEdicao.getDescricao());
					tfCodigo.setText(String.valueOf(marcaEdicao.getCod_marca()));
					tfMarca.requestFocus();

					btnNovo.setEnabled(false);
					btnSalvar.setEnabled(true);
					btnCancelar.setEnabled(true);
					btnExcluir.setEnabled(true);

				}

			}
		});

		scrollPane.setViewportView(table);

		table.setModel(new MarcaTableModel(marcaDAO.select()));

		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setEnabled(false);
		tfCodigo.setBackground(SystemColor.controlHighlight);
		tfCodigo.setBounds(10, 43, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(8, 20, 68, 23);
		contentPane.add(lblNewLabel);

		btnNovo.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnCancelar.setEnabled(false);

	}
}
