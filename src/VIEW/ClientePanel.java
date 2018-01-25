package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.ClienteDAO;
import DAO.PessoaDAO;
import DAO.UfDAO;
import ENTIDADE.Cliente;
import ENTIDADE.Pessoa;
import ENTIDADE.Telefone;
import ENTIDADE.Uf;
import MODEL.ClienteTableModel;
import MODEL.PessoaComboBoxModel;
import MODEL.UfComboBoxModel;


public class ClientePanel extends JPanel {

	private JTable table;
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfBairro;

	private JTextField tfCidade;
	private JFormattedTextField tfRg , tfCpf, tfCep;
	private MaskFormatter msRg, msCpf, msCep, msTelefone;
	private Cliente clienteEdicao;
	private ArrayList<Telefone> telefoneList = 
			new ArrayList<Telefone>();
	private ClienteDAO dao = new ClienteDAO();
	private PessoaDAO pessoadao = new PessoaDAO();
	private JComboBox cbPessoa;
	private JComboBox cbUf;
	private UfDAO ufdao = new UfDAO();
	private JButton btnCancelar;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnNewButton;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JTextField tfCelular;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientePanel frame = new ClientePanel();
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
	public ClientePanel() {
		//setTitle("                                                       Cadastro de Clientes");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 575);
		//setLocationRelativeTo(null);
		//contentPane = new JPanel();
		setForeground(new Color(0, 0, 0));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);

		//setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome..:");
		lblNome.setBounds(74, 11, 46, 14);

		JLabel lblCodigo = new JLabel("Codigo..:");
		lblCodigo.setBounds(10, 11, 53, 14);

		JLabel lblEndereo = new JLabel("Endere\u00E7o..:");
		lblEndereo.setBounds(10, 59, 64, 14);

		JLabel lblNewLabel = new JLabel("Bairro..:");
		lblNewLabel.setBounds(281, 59, 46, 14);

		tfCodigo = new JTextField();
		tfCodigo.setEnabled(false);
		tfCodigo.setBackground(new Color(25, 25, 112));
		tfCodigo.setBounds(10, 28, 53, 20);
		tfCodigo.setColumns(10);

		tfNome = new JTextField();
		tfNome.setBounds(73, 28, 277, 20);
		tfNome.setColumns(10);

		tfEndereco = new JTextField();
		tfEndereco.setBounds(10, 75, 261, 20);
		tfEndereco.setColumns(10);

		tfBairro = new JTextField();
		tfBairro.setBounds(281, 75, 209, 20);
		tfBairro.setColumns(10);

		
		
	
		cbUf = new JComboBox();
		cbUf.setBounds(161, 126, 53, 20);
		add(cbUf);
		cbUf.setModel(new UfComboBoxModel(ufdao.select()));

		try{
			msTelefone = new MaskFormatter("(##)####-####");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		try{
			msCpf = new MaskFormatter("###.###.###-##");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		tfCpf = new JFormattedTextField(msCpf);
		tfCpf.setBounds(10, 174, 107, 20);
		tfCpf.setColumns(10);

		JLabel lblCep = new JLabel("Cep...:");
		lblCep.setBounds(225, 101, 46, 14);

		try{
			msCep = new MaskFormatter("#####-###");
		}catch(ParseException e1){
			e1.printStackTrace();
		}

		tfCep = new JFormattedTextField(msCep);



		btnNovo = new JButton("Novo");
		btnNovo = new JButton(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnNovo.setText("Novo");
		btnNovo.setBounds(10, 234, 96, 25);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteEdicao = null;
				tfCodigo.setText("");
				tfNome.setText("");
				tfEndereco.setText("");
				tfBairro.setText("");
				tfCidade.setText("");
				cbUf.setSelectedItem(null); 
				cbUf.repaint();
				cbPessoa.setSelectedItem(null);
				cbPessoa.repaint();
				tfCep.setText("");
				tfCpf.setText("");
				tfRg.setText("");
				tfTelefone.setText("");
				tfEmail.setText("");
				tfCelular.setText("");
				tfNome.requestFocus();
				
				btnNovo.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(false);
				tfNome.setEnabled(true);
				tfEndereco.setEnabled(true);
				tfBairro.setEnabled(true);
				tfCidade.setEnabled(true);
				tfCidade.setEnabled(true);
				cbUf.setEnabled(true);
				tfCep.setEditable(true);
				tfCpf.setEnabled(true);
				tfRg.setEnabled(true);
				tfTelefone.setEnabled(true);


			}

		});


		btnSalvar = new JButton("Salvar");
		btnSalvar = new JButton(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Save\\Save_16x16.png"));
		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(138, 234, 97, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(tfNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe o nome!");
					tfNome.requestFocus();
					return;
				}if(tfTelefone.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe o telefone!");
					tfNome.requestFocus();
					return;
				}if(tfCidade.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe o cpf!");
					tfNome.requestFocus();
					return;


				}//Novo registro
				if (clienteEdicao == null) {
					clienteEdicao = new Cliente();

					clienteEdicao.setNome(tfNome.getText());
					clienteEdicao.setEndereco(tfEndereco.getText());
					clienteEdicao.setBairro(tfBairro.getText());
					clienteEdicao.setCidade(tfCidade.getText());
					clienteEdicao.setUf((Uf)cbUf.getSelectedItem());
					cbUf.repaint();
					clienteEdicao.setPessoa((Pessoa)cbPessoa.getSelectedItem());
					cbPessoa.repaint();
					clienteEdicao.setCep(tfCep.getText());
					clienteEdicao.setCpf(tfCpf.getText());
					clienteEdicao.setRg(tfRg.getText());
					clienteEdicao.setTel_Cliente(tfTelefone.getText());

					if (dao.insert(clienteEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, 
								"CLIENTE INSERIDO COM SUCESSO!");
						btnCancelar.doClick();
						clienteEdicao = null;
						table.setModel(new ClienteTableModel(dao.select()));
					}else{//se false
						JOptionPane.showMessageDialog(null, 
								"PLOBLEMAS NA INSERCÂO!");
						btnCancelar.doClick();


					}
				} else {//Altera Registro
					clienteEdicao.setNome(tfNome.getText());
					clienteEdicao.setEndereco(tfEndereco.getText());
					clienteEdicao.setBairro(tfBairro.getText());
					clienteEdicao.setCidade(tfCidade.getText());
					clienteEdicao.setUf((Uf)cbUf.getSelectedItem());
					cbUf.repaint();
					clienteEdicao.setCep(tfCep.getText());
					clienteEdicao.setCpf(tfCpf.getText());
					clienteEdicao.setRg(tfRg.getText());
					clienteEdicao.setTel_Cliente(tfTelefone.getText());

					if (dao.update(clienteEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, 
								"ALTERADO COM SUCESSO");
						clienteEdicao = null;
						tfCodigo.setText("");
						tfNome.setText("");
						tfEndereco.setText("");
						tfBairro.setText("");
						tfCidade.setText("");
						cbUf.setSelectedItem(null); 
						cbUf.repaint();
						tfCep.setText("");
						tfCpf.setText("");
						tfRg.setText("");
						tfTelefone.setText("");
						tfCodigo.requestFocus();
						table.setModel(new ClienteTableModel(dao.select()));
					} else { // Se False
						JOptionPane.showMessageDialog(null, 
								"PROBLEMAS NA ALTERAÇÃO!");
					}
				}
			}


		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Cancel\\Cancel_16x16.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteEdicao = null;
				tfCodigo.setText("");
				tfNome.setText("");
				tfEndereco.setText("");
				tfBairro.setText("");
				tfCidade.setText("");
				cbUf.setSelectedItem(null); 
				cbUf.repaint();
				tfCep.setText("");
				tfCpf.setText("");
				tfRg.setText("");
				tfTelefone.setText("");
				cbPessoa.setSelectedItem(null);
				cbPessoa.repaint();
				tfCodigo.requestFocus();

				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(true);

			}
		});
		btnCancelar.setBounds(256, 236, 107, 23);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Delete\\Delete_16x16.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				if(JOptionPane.showConfirmDialog(null, 
						"Deseja realmente excluir o Cliente ?")
						== JOptionPane.YES_NO_OPTION){

					if(dao.delete(clienteEdicao.getCod_Cliente())){
						JOptionPane.showMessageDialog(null, 
								"CLIENTE EXCLUIDO COM SUCESSO!");
						btnCancelar.doClick();
					}else{
						JOptionPane.showMessageDialog(null, 
								"PLOBLEMAS NA EXCLUSÂO!");
						btnCancelar.doClick();
					}
					table.setModel(new ClienteTableModel(dao.select()));
					clienteEdicao = null;
					tfCodigo.setText("");
					tfNome.setText("");
					tfEndereco.setText("");
					tfBairro.setText("");
					tfCidade.setText("");
					cbUf.setSelectedItem(null); 
					cbUf.repaint();
					cbPessoa.setSelectedItem(null);
					cbPessoa.repaint();
					tfCep.setText("");
					tfCpf.setText("");
					tfRg.setText("");
					tfTelefone.setText("");
					tfCodigo.requestFocus();

					btnNovo.setEnabled(true);
					btnSalvar.setEnabled(false);
					btnCancelar.setEnabled(false);
					btnExcluir.setEnabled(false);

				}


			}
		});
		btnExcluir.setBounds(375, 236, 97, 23);



		JLabel lblCpf = new JLabel("CPF..:");
		lblCpf.setBounds(10, 157, 46, 14);

		tfCidade = new JTextField();
		tfCidade.setBounds(10, 126, 140, 20);
		tfCidade.setColumns(10);

		JLabel lblRg = new JLabel("RG...:");
		lblRg.setBounds(161, 157, 46, 14);

		try{
			msRg = new MaskFormatter("##.###.###-#");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		tfRg = new JFormattedTextField(msRg);
		tfRg.setBounds(161, 174, 97, 20);
		tfRg.setColumns(10);



		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 293, 667, 191);
		add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					//Cast
					ClienteTableModel modelo = (ClienteTableModel) table.getModel();


					clienteEdicao = modelo.getClientePorLinha(table.getSelectedRow());


					tfCodigo.setText(String.valueOf(clienteEdicao.getCod_Cliente()));
					tfNome.setText(clienteEdicao.getNome());
					tfEndereco.setText(clienteEdicao.getEndereco());
					tfBairro.setText(clienteEdicao.getBairro());
					tfCidade.setText(clienteEdicao.getCidade());
					cbUf.setSelectedItem(clienteEdicao.getUf());
					cbUf.repaint();
					tfCep.setText(clienteEdicao.getCep());
					tfCpf.setText(clienteEdicao.getCpf());
					tfRg.setText(clienteEdicao.getRg());
					tfTelefone.setText(clienteEdicao.getTel_Cliente());
					tfCodigo.requestFocus();

					btnNovo.setEnabled(true);
					btnSalvar.setEnabled(true);
					btnCancelar.setEnabled(true);
					btnExcluir.setEnabled(true);
					tfNome.setEnabled(true);
					tfEndereco.setEnabled(true);
					tfBairro.setEnabled(true);
					tfCidade.setEnabled(true);
					tfCidade.setEnabled(true);
					cbUf.setEnabled(true);
					tfCep.setEditable(true);
					tfCpf.setEnabled(true);
					tfRg.setEnabled(true);
					tfTelefone.setEnabled(true);




				}

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new ClienteTableModel(dao.select()));

		btnNovo.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnExcluir.setEnabled(true);
		tfNome.setEnabled(false);
		tfEndereco.setEnabled(false);
		tfBairro.setEnabled(false);
		tfCidade.setEnabled(false);
		tfCidade.setEnabled(false);
		cbUf.setEnabled(false);
		tfCep.setEditable(false);
		tfCpf.setEnabled(false);
		tfRg.setEnabled(false);

		JLabel lblCidade = new JLabel("Cidade..:");
		lblCidade.setBounds(10, 106, 53, 14);



		tfCep.setBounds(224, 126, 107, 20);
		tfCep.setColumns(10);
		//		contentPane.setLayout(null);
		add(lblCodigo);
		add(tfCodigo);
		add(lblNome);
		add(tfNome);
		add(lblEndereo);
		add(tfEndereco);
		add(lblNewLabel);
		add(tfBairro);
		add(lblCep);
		add(tfCep);
		add(lblCpf);
		add(lblCidade);
		add(tfCpf);
		add(tfRg);
		add(lblRg);
		add(tfCidade);
		add(btnNovo);
		add(btnSalvar);
		add(btnCancelar);
		add(btnExcluir);
		add(scrollPane);

		JLabel lblUf = new JLabel("UF...:");
		lblUf.setBounds(161, 101, 46, 14);
		add(lblUf);

		btnNewButton = new JButton("Nova Venda");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendasFrame v = new VendasFrame();
				v.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 503, 127, 23);
		add(btnNewButton);

		JComboBox cbPessoa = new JComboBox();
		cbPessoa.setBounds(360, 28, 114, 20);
		add(cbPessoa);
		cbPessoa.setModel(new PessoaComboBoxModel(pessoadao.select()));

		JLabel lblPessoa = new JLabel("Pessoa..:");
		lblPessoa.setBounds(358, 11, 64, 14);
		add(lblPessoa);

		JLabel label = new JLabel("Telefone...:");
		label.setBounds(341, 101, 64, 14);
		add(label);



		try{
			msTelefone = new MaskFormatter("(##)####-####");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		tfTelefone = new JFormattedTextField(msTelefone);
		tfTelefone.setBounds(341, 126, 137, 20);
		tfTelefone.setColumns(10);
		add(tfTelefone);
		
		JLabel lblEmail = new JLabel("Email..:");
		lblEmail.setBounds(267, 157, 46, 14);
		add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(267, 174, 235, 20);
		add(tfEmail);


	}
}
