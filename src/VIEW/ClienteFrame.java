package VIEW;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PseudoColumnUsage;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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

import java.awt.Color;

import javax.swing.border.TitledBorder;

import java.awt.Window.Type;
import java.awt.Font;

import javax.swing.JSeparator;

import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ClienteFrame extends JFrame {

	private JTable table;
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfBairro;
	
	private JTextField tfCidade;
	private JFormattedTextField tfRg , tfCpf, tfCep , tfTelefone,tfCelular;
	private MaskFormatter msRg, msCpf, msCep, msTelefone,msCelular;
	private Cliente clienteEdicao;
	private ClienteDAO dao = new ClienteDAO();
	private JComboBox cbUf;
	private JComboBox cbPessoa;
	private PessoaDAO pessoadao = new PessoaDAO();
	private UfDAO ufdao = new UfDAO();
	private JButton btnCancelar;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnNewButton;
	private JTextField tfBuscar;
	private JLabel lblCelular;
	private JTextField tfEmail;

	/**
	 * Create the frame.
	 */
	public ClienteFrame() {
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 858, 613);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome..:");
		lblNome.setBounds(85, 84, 46, 14);

		JLabel lblCodigo = new JLabel("Codigo..:");
		lblCodigo.setBounds(21, 84, 53, 14);

		JLabel lblEndereo = new JLabel("Endere\u00E7o..:");
		lblEndereo.setBounds(21, 132, 64, 14);

		JLabel lblNewLabel = new JLabel("Bairro..:");
		lblNewLabel.setBounds(292, 132, 46, 14);

		JLabel lblTelefone = new JLabel("Telefone...:");
		lblTelefone.setBounds(21, 174, 64, 14);

		tfCodigo = new JTextField();
		tfCodigo.setEnabled(false);
		tfCodigo.setBackground(SystemColor.controlHighlight);
		tfCodigo.setBounds(21, 101, 53, 20);
		tfCodigo.setColumns(10);

		tfNome = new JTextField();
		tfNome.setBounds(84, 101, 369, 20);
		tfNome.setColumns(10);

		tfEndereco = new JTextField();
		tfEndereco.setBounds(21, 148, 261, 20);
		tfEndereco.setColumns(10);

		tfBairro = new JTextField();
		tfBairro.setBounds(292, 148, 238, 20);
		tfBairro.setColumns(10);

		cbUf = new JComboBox();
		cbUf.setBounds(690, 148, 53, 20);
		contentPane.add(cbUf);
		cbUf.setModel(new UfComboBoxModel(ufdao.select()));
		
	try{
		msTelefone = new MaskFormatter("(##)####-####");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		tfTelefone = new JFormattedTextField(msTelefone);
		tfTelefone.setBounds(21, 191, 137, 20);
		tfTelefone.setColumns(10);
		
		try{
			msCpf = new MaskFormatter("##############");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		tfCpf = new JFormattedTextField(msCpf);
		tfCpf.setBounds(591, 101, 122, 20);
		tfCpf.setColumns(10);

		JLabel lblCep = new JLabel("Cep...:");
		lblCep.setBounds(558, 174, 46, 14);

		try{
			msCep = new MaskFormatter("#####-###");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		
		tfCep = new JFormattedTextField(msCep);

		
		 
		btnNovo = new JButton("Novo");
		btnNovo = new JButton(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Add\\Add1.png"));
		btnNovo.setText("Novo");
		btnNovo.setBounds(16, 231, 96, 25);
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
				tfCelular.setEnabled(true);
				tfEmail.setEnabled(true);
				cbPessoa.setEnabled(true);
			}

		});


		btnSalvar = new JButton("Salvar");
		btnSalvar = new JButton(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Save\\Save1.png"));
		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(122, 231, 97, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if(tfNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe o nome!");
					tfNome.requestFocus();
					return;
				}if(tfTelefone.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe o telefone!");
					tfTelefone.requestFocus();
					return;
				}if(tfCpf.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe o cpf!");
					tfCpf.requestFocus();
					return;
                }
				
				//Novo registro
				if (clienteEdicao == null) {
					clienteEdicao = new Cliente();
					
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
					clienteEdicao.setPessoa((Pessoa)cbPessoa.getSelectedItem());
				/*	if(cbPessoa.()){

					       JOptionPane.showMessageDialog(null,"O sexo Masculino foi selecionado");

					       }else if(cbPessoa.isSelected()){

					       JOptionPane.showMessageDialog(null,"O sexo Feminino foi selecionado");

					       }*/
					clienteEdicao.setCel_Cliente(tfCelular.getText());
					clienteEdicao.setEmail(tfEmail.getText());

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
					clienteEdicao.setPessoa((Pessoa)cbPessoa.getSelectedItem());
					clienteEdicao.setCel_Cliente(tfCelular.getText());
					clienteEdicao.setEmail(tfEmail.getText());

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
						tfNome.requestFocus();
						cbPessoa.setSelectedItem(null);
						cbPessoa.repaint();
						tfEmail.setText("");
						tfCelular.setText("");
						
						table.setModel(new ClienteTableModel(dao.select()));
						
					} else { // Se False
						JOptionPane.showMessageDialog(null, 
								"PROBLEMAS NA ALTERAÇÃO!");
					}
					
					btnNovo.setEnabled(true);
					btnSalvar.setEnabled(false);
					btnCancelar.setEnabled(false);
					btnExcluir.setEnabled(false);
					tfNome.setEnabled(false);
					
					tfEndereco.setEnabled(false);
					tfBairro.setEnabled(false);
					tfCidade.setEnabled(false);
					tfCidade.setEnabled(false);
					cbUf.setEnabled(false);
					tfCep.setEditable(false);
					tfCpf.setEnabled(false);
					tfRg.setEnabled(false);
					tfTelefone.setEnabled(false);
				}
			}


		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Cancel\\Cancel1.png"));
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
				cbPessoa.setSelectedItem(null);
				cbPessoa.repaint();
				tfCep.setText("");
				tfCpf.setText("");
				tfRg.setText("");
				tfTelefone.setText("");
				tfEmail.setText("");
				tfCelular.setText("");
				tfNome.requestFocus();

				
				
				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				tfNome.setEnabled(false);
				tfEndereco.setEnabled(false);
				tfBairro.setEnabled(false);
				tfCidade.setEnabled(false);
				tfCidade.setEnabled(false);
				cbUf.setEnabled(false);
				tfCep.setEditable(false);
				tfCpf.setEnabled(false);
				tfRg.setEnabled(false);
				tfTelefone.setEnabled(false);
				tfCelular.setEnabled(false);
				tfEmail.setEnabled(false);
				cbPessoa.setEnabled(false);
				

			}
		});
		btnCancelar.setBounds(229, 232, 107, 23);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Delete\\Delete1.png"));
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
								"PROBLEMAS NA EXCLUSÂO!");
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
					tfEmail.setText("");
					tfCelular.setText("");
					tfNome.requestFocus();
					
					btnNovo.setEnabled(true);
				    btnSalvar.setEnabled(false);
				    btnCancelar.setEnabled(false);
				    btnExcluir.setEnabled(false);
				    
					tfNome.setEnabled(false);
					tfEndereco.setEnabled(false);
					tfBairro.setEnabled(false);
					tfCidade.setEnabled(false);
					tfCidade.setEnabled(false);
					cbUf.setEnabled(false);
					tfCep.setEditable(false);
					tfCpf.setEnabled(false);
					tfRg.setEnabled(false);
					tfTelefone.setEnabled(false);
					tfCelular.setEnabled(false);
					tfEmail.setEnabled(false);
					cbPessoa.setEnabled(false);				
				}
				
				
			}
		});
		btnExcluir.setBounds(346, 233, 97, 23);



		JLabel lblCpf = new JLabel("CPF/CNPJ..:");
		lblCpf.setBounds(591, 84, 75, 14);

		tfCidade = new JTextField();
		tfCidade.setBounds(540, 149, 140, 20);
		tfCidade.setColumns(10);

		JLabel lblRg = new JLabel("RG...:");
		lblRg.setBounds(723, 84, 46, 14);

		try{
			msRg = new MaskFormatter("##.###.###-#");
		}catch(ParseException e1){
			e1.printStackTrace();
		}
		tfRg = new JFormattedTextField(msRg);
	    tfRg.setBounds(723, 101, 97, 20);
		tfRg.setColumns(10);



		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 323, 791, 176);
		contentPane.add(scrollPane);
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
					tfNome.requestFocus();
					cbPessoa.setSelectedItem(clienteEdicao.getPessoa());
					cbPessoa.repaint();
					tfCelular.setText(clienteEdicao.getCel_Cliente());
					tfEmail.setText(clienteEdicao.getEmail());

					btnNovo.setEnabled(false);
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
					cbPessoa.setEnabled(true);
					tfEmail.setEnabled(true);
					tfCelular.setEnabled(true);
   
				}

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new ClienteTableModel(dao.select()));

		btnNovo.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnExcluir.setEnabled(false);
		
		tfNome.setEnabled(false);
		tfEndereco.setEnabled(false);
		tfBairro.setEnabled(false);
		tfCidade.setEnabled(false);
		tfCidade.setEnabled(false);
		cbUf.setEnabled(false);
		tfCep.setEditable(false);
		tfCpf.setEnabled(false);
		tfRg.setEnabled(false);
		tfTelefone.setEnabled(false);
		
		

		JLabel lblCidade = new JLabel("Cidade..:");
		lblCidade.setBounds(540, 132, 53, 14);

		
		
		tfCep.setBounds(558, 191, 107, 20);
		tfCep.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblCodigo);
		contentPane.add(tfCodigo);
		contentPane.add(lblNome);
		contentPane.add(tfNome);
		contentPane.add(lblEndereo);
		contentPane.add(tfEndereco);
		contentPane.add(lblNewLabel);
		contentPane.add(tfBairro);
		contentPane.add(lblCep);
		contentPane.add(tfCep);
		contentPane.add(lblCpf);
		contentPane.add(lblCidade);
		contentPane.add(tfCpf);
		contentPane.add(tfRg);
		contentPane.add(lblRg);
		contentPane.add(lblTelefone);
		contentPane.add(tfTelefone);
		contentPane.add(tfCidade);
		contentPane.add(btnNovo);
		contentPane.add(btnSalvar);
		contentPane.add(btnCancelar);
		contentPane.add(btnExcluir);
		contentPane.add(scrollPane);

		JLabel lblUf = new JLabel("UF...:");
		lblUf.setBounds(690, 131, 46, 14);
		contentPane.add(lblUf);
		
		btnNewButton = new JButton("Nova Venda");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\New\\New_16x16.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendasFrame v = new VendasFrame();
				v.setVisible(true);
			}
		});
		btnNewButton.setBounds(16, 540, 127, 24);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Busca por nome:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 267, 810, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCliqueNoNome = new JLabel("Clique duas vezes no nome para carregar os dados");
		lblCliqueNoNome.setBounds(10, 237, 315, 14);
		panel.add(lblCliqueNoNome);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(10, 22, 339, 23);
		panel.add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Search\\Search_16x16.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Cliente> f = dao.buscarFornecedorPorNome(tfBuscar.getText());
				table.setModel(new ClienteTableModel(f));
			}
		});
		btnNewButton_1.setBounds(359, 22, 43, 23);
		panel.add(btnNewButton_1);
		
		lblCelular = new JLabel("Celular..:");
		lblCelular.setBounds(172, 174, 53, 14);
		contentPane.add(lblCelular);
		
		try{
			msCelular = new MaskFormatter("(##)#####-####");
			}catch(ParseException e1){
				e1.printStackTrace();
			}
		tfCelular = new JFormattedTextField(msCelular);
		tfCelular.setEnabled(false);
		tfCelular.setBounds(172, 191, 137, 20);
		contentPane.add(tfCelular);
		tfCelular.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email..:");
		lblEmail.setBounds(319, 174, 52, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setEnabled(false);
		tfEmail.setBounds(319, 191, 229, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblPessoa = new JLabel("Pessoa..:");
		lblPessoa.setBounds(467, 84, 81, 14);
		contentPane.add(lblPessoa);
		
	    cbPessoa = new JComboBox();
	    cbPessoa.setEnabled(false);
		cbPessoa.setBounds(467, 101, 114, 20);
		contentPane.add(cbPessoa);
		cbPessoa.setModel(new PessoaComboBoxModel(pessoadao.select()));
//		if (cbPessoa.equals(1) ){
//			try{
//				msCpf = new MaskFormatter("##############");
//			}catch(ParseException e1){
//				e1.printStackTrace();
//			}
//		}else{
//			
//		}
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 842, 73);
		contentPane.add(panel_1);
		
		JLabel lblCliente = new JLabel("          Cadastro de Clientes");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(92)
					.addComponent(lblCliente)
					.addContainerGap(259, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCliente)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		
	}
}
