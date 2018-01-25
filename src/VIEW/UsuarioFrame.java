//package VIEW;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import DAO.ClienteDAO;
//import DAO.PerfilDAO;
//import DAO.UsuarioDAO;
//import ENTIDADE.Cliente;
//import ENTIDADE.Perfil;
//import ENTIDADE.Pessoa;
//import ENTIDADE.Uf;
//import ENTIDADE.Usuario;
//import MODEL.ClienteTableModel;
//import MODEL.PerfilComboBoxModel;
//import MODEL.PessoaComboBoxModel;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.JButton;
//import javax.swing.ImageIcon;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class UsuarioFrame extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField tfCodigo;
//	private JTextField tfNome;
//	private JTextField tfEmail;
//	private JTextField tfCpf;
//	private JTextField tfConfSenha;
//	private JTextField tfSenha;
//	private JButton btnNovo;
//	private JButton btnSalvar;
//	private JButton btnCancelar;
//	private JButton btnExcluir;
//	private JComboBox cbPerfil;
//	private PerfilDAO perfilDAO = new PerfilDAO();
//	private UsuarioDAO dao = new UsuarioDAO();
//	private Usuario usuarioEdicao;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UsuarioFrame frame = new UsuarioFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public UsuarioFrame() {
//		setTitle("CADASTRO DE USUARIOS");
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 574, 327);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		setLocationRelativeTo(null);
//
//		JLabel lblCodigo = new JLabel("CODIGO ..:");
//		lblCodigo.setBounds(10, 11, 63, 14);
//		contentPane.add(lblCodigo);
//
//		tfCodigo = new JTextField();
//		tfCodigo.setEditable(false);
//		tfCodigo.setBounds(71, 8, 55, 20);
//		contentPane.add(tfCodigo);
//		tfCodigo.setColumns(10);
//
//		JLabel lblNomeCompleto = new JLabel("NOME COMPLETO ..:");
//		lblNomeCompleto.setBounds(10, 46, 116, 14);
//		contentPane.add(lblNomeCompleto);
//
//		tfNome = new JTextField();
//		tfNome.setBounds(123, 43, 421, 20);
//		contentPane.add(tfNome);
//		tfNome.setColumns(10);
//
//		JLabel lblEmaillogin = new JLabel("EMAIL/LOGIN ..:");
//		lblEmaillogin.setBounds(10, 77, 87, 14);
//		contentPane.add(lblEmaillogin);
//
//		tfEmail = new JTextField();
//		tfEmail.setBounds(98, 74, 445, 20);
//		contentPane.add(tfEmail);
//		tfEmail.setColumns(10);
//
//		JLabel lblCpf = new JLabel("CPF ..:");
//		lblCpf.setBounds(10, 114, 46, 14);
//		contentPane.add(lblCpf);
//
//		tfCpf = new JTextField();
//		tfCpf.setBounds(50, 111, 148, 20);
//		contentPane.add(tfCpf);
//		tfCpf.setColumns(10);
//
//		JLabel lblPerfil = new JLabel("PERFIL ..:");
//		lblPerfil.setBounds(326, 111, 63, 14);
//		contentPane.add(lblPerfil);
//
//		cbPerfil = new JComboBox();
//		cbPerfil.setBounds(386, 108, 158, 20);
//		contentPane.add(cbPerfil);
//		cbPerfil.setModel(new PerfilComboBoxModel(perfilDAO.select()));
//
//		JLabel lblSenha = new JLabel("SENHA ..:");
//		lblSenha.setBounds(10, 153, 55, 14);
//		contentPane.add(lblSenha);
//
//		tfSenha = new JTextField();
//		tfSenha.setColumns(10);
//		tfSenha.setBounds(76, 150, 138, 20);
//		contentPane.add(tfSenha);
//
//		JLabel lblConfirmaoSenha = new JLabel("CONFIRMA\u00C7\u00C3O SENHA ..:");
//		lblConfirmaoSenha.setBounds(224, 150, 159, 20);
//		contentPane.add(lblConfirmaoSenha);
//
//		tfConfSenha = new JTextField();
//		tfConfSenha.setColumns(10);
//		tfConfSenha.setBounds(386, 147, 158, 20);
//		contentPane.add(tfConfSenha);
//
//		btnNovo = new JButton("NOVO");
//		btnNovo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				//LIMPANDO CAMPOS
//				tfCodigo.setText("");
//				tfNome.setText("");
//				tfEmail.setText("");
//				tfCpf.setText("");
//				//LIMPANDO E ATUALIZANDO COMBO BOX
//				cbPerfil.setSelectedItem(null);
//				cbPerfil.repaint();
//				tfSenha.setText("");
//				tfConfSenha.setText("");
//				// APOS LIMPAR TUDO IRA VOLTAR AO CODIGO
//				tfCodigo.requestFocus();
//				
//				//TRATANDO EVENTOS DOS BOT�ES
//				btnNovo.setEnabled(false);
//				btnSalvar.setEnabled(true);
//				btnCancelar.setEnabled(true);
//				btnExcluir.setEnabled(false);
//
//			}
//		});
//		btnNovo.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\ProjetoCompleto\\IMG\\New\\New_16x16.png"));
//		btnNovo.setBounds(18, 254, 116, 23);
//		contentPane.add(btnNovo);
//
//		btnSalvar = new JButton("SALVAR");
//		btnSalvar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				if(tfNome.getText().isEmpty()){
//					JOptionPane.showMessageDialog(null, "Informe o nome!");
//					tfNome.requestFocus();
//					return;
//				}if(tfSenha.getText().isEmpty()){
//					JOptionPane.showMessageDialog(null, "Informe a senha!");
//					tfSenha.requestFocus();
//					return;
//				}if(tfConfSenha.getText().isEmpty()){
//					JOptionPane.showMessageDialog(null, "Informe a confirma��o de sua senha!");
//					tfConfSenha.requestFocus();
//					return;
//                }
//				
//				//Novo registro
//				if (usuarioEdicao == null) {
//					usuarioEdicao = new Usuario();
//					
//					usuarioEdicao.setNome_usuario(tfNome.getText());
//					usuarioEdicao.setEmail_login(tfEmail.getText());
//					usuarioEdicao.setCpf(tfCpf.getText());
//					usuarioEdicao.setPerfil((Perfil)cbPerfil.getSelectedItem());
//					cbPerfil.repaint();
//					usuarioEdicao.setSenha(tfSenha.getText());
//					usuarioEdicao.setConf_senha(tfConfSenha.getText());
//
//					if (dao.insert(usuarioEdicao)) { // Se True
//						JOptionPane.showMessageDialog(null, 
//								"USUARIO INSERIDO COM SUCESSO!");
//						btnCancelar.doClick();
//						usuarioEdicao = null;
//						table.setModel(new ClienteTableModel(dao.select()));
//					}else{//se false
//						JOptionPane.showMessageDialog(null, 
//								"PLOBLEMAS NA INSERC�O!");
//						btnCancelar.doClick();
//
//
//					}
//				} else {//Altera Registro
//					usuarioEdicao.setNome(tfNome.getText());
//					usuarioEdicao.setEndereco(tfEndereco.getText());
//					usuarioEdicao.setBairro(tfBairro.getText());
//					usuarioEdicao.setCidade(tfCidade.getText());
//					usuarioEdicao.setUf((Uf)cbUf.getSelectedItem());
//					cbUf.repaint();
//					usuarioEdicao.setCep(tfCep.getText());
//					usuarioEdicao.setCpf(tfCpf.getText());
//					usuarioEdicao.setRg(tfRg.getText());
//					usuarioEdicao.setTel_Cliente(tfTelefone.getText());
//					usuarioEdicao.setPessoa((Pessoa)cbPessoa.getSelectedItem());
//					usuarioEdicao.setCel_Cliente(tfCelular.getText());
//					usuarioEdicao.setEmail(tfEmail.getText());
//
//					if (dao.update(usuarioEdicao)) { // Se True
//						JOptionPane.showMessageDialog(null, 
//								"ALTERADO COM SUCESSO");
//						usuarioEdicao = null;
//						tfCodigo.setText("");
//						tfNome.setText("");
//						tfEndereco.setText("");
//						tfBairro.setText("");
//						tfCidade.setText("");
//						cbUf.setSelectedItem(null); 
//						cbUf.repaint();
//						tfCep.setText("");
//						tfCpf.setText("");
//						tfRg.setText("");
//						tfTelefone.setText("");
//						tfNome.requestFocus();
//						cbPessoa.setSelectedItem(null);
//						cbPessoa.repaint();
//						tfEmail.setText("");
//						tfCelular.setText("");
//						
//						table.setModel(new ClienteTableModel(dao.select()));
//						
//					} else { // Se False
//						JOptionPane.showMessageDialog(null, 
//								"PROBLEMAS NA ALTERA��O!");
//					}
//					
////					btnNovo.setEnabled(true);
////					btnSalvar.setEnabled(false);
////					btnCancelar.setEnabled(false);
////					btnExcluir.setEnabled(false);
////					tfNome.setEnabled(false);
////					
////					tfEndereco.setEnabled(false);
////					tfBairro.setEnabled(false);
////					tfCidade.setEnabled(false);
////					tfCidade.setEnabled(false);
////					cbUf.setEnabled(false);
////					tfCep.setEditable(false);
////					tfCpf.setEnabled(false);
////					tfRg.setEnabled(false);
////					tfTelefone.setEnabled(false);
//				}
//			}
//
//
//		});
//		btnSalvar.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\ProjetoCompleto\\IMG\\Save\\Save1.png"));
//		btnSalvar.setBounds(286, 254, 116, 23);
//		contentPane.add(btnSalvar);
//
//		btnCancelar = new JButton("CANCELAR");
//		btnCancelar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				//LIMPANDO CAMPOS
//				tfCodigo.setText("");
//				tfNome.setText("");
//				tfEmail.setText("");
//				tfCpf.setText("");
//				//LIMPANDO E ATUALIZANDO COMBO BOX
//				cbPerfil.setSelectedItem(null);
//				cbPerfil.repaint();
//				tfSenha.setText("");
//				tfConfSenha.setText("");
//				// APOS LIMPAR TUDO IRA VOLTAR AO CODIGO
//				tfCodigo.requestFocus();
//				
//				//TRATANDO EVENTOS DOS BOT�ES
//				btnNovo.setEnabled(true);
//				btnSalvar.setEnabled(true);
//				btnCancelar.setEnabled(false);
//				btnExcluir.setEnabled(true);
//			}
//		});
//		btnCancelar.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\ProjetoCompleto\\IMG\\Cancel\\Cancel1.png"));
//		btnCancelar.setBounds(152, 254, 116, 23);
//		contentPane.add(btnCancelar);
//
//		btnExcluir = new JButton("EXCLUIR");
//		btnExcluir.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnExcluir.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\ProjetoCompleto\\IMG\\Delete\\Delete1.png"));
//		btnExcluir.setBounds(420, 254, 116, 23);
//		contentPane.add(btnExcluir);
//	}
//}
