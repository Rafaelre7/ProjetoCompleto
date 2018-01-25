//package VIEW;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import DAO.EstabelecimentoDAO;
//import ENTIDADE.Estabelecimento;
//import MODEL.EstabelecimentoComboBoxModel;
//
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.JButton;
//import javax.swing.JScrollPane;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//
//public class OrcFrame extends JFrame {
//	private JTextField tfCodOs;
//	private JTextField tfDataEntrada;
//	private JTextField tfDataEmissao;
//	private JTextField tfCor;
//	private JTextField tfSerie;
//	private JTextField tfImetro;
//	private JTextField tfDefeito;
//	private JTextField tfValorVenda;
//	private JTextField tfQuantidade;
//	private JTextField tfValorTotal;
//	private JTextField tfPe�as;
//	private JTextField tfMaoDeObra;
//	private JTextField tfTotal;
//	private JTextField tfModelo;
//	private JComboBox cbEstabelecimento;
//	private JTextField textField;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrcFrame frame = new OrcFrame();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
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
//	public OrcFrame() {
//		setTitle("                                                                             Cadastro de Or\u00E7amento");
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 653, 686);
//		getContentPane().setLayout(null);
//	
//		
//		JLabel lblCodos = new JLabel("Cod_OS..:");
//		lblCodos.setBounds(10, 21, 58, 14);
//		getContentPane().add(lblCodos);
//		
//		JLabel lblEstabelecimento = new JLabel("Cliente..:");
//		lblEstabelecimento.setBounds(78, 21, 99, 14);
//		getContentPane().add(lblEstabelecimento);
//		
//		JLabel lblDataDeEntrada = new JLabel("Data de entrada..:");
//		lblDataDeEntrada.setBounds(361, 21, 107, 14);
//		getContentPane().add(lblDataDeEntrada);
//		
//		JLabel lblDataEmisso = new JLabel("Data emiss\u00E3o..:");
//		lblDataEmisso.setBounds(478, 21, 82, 14);
//		getContentPane().add(lblDataEmisso);
//		
//		tfCodOs = new JTextField();
//		tfCodOs.setEditable(false);
//		tfCodOs.setBounds(10, 40, 50, 20);
//		getContentPane().add(tfCodOs);
//		tfCodOs.setColumns(10);
//		
//		tfDataEntrada = new JTextField();
//		tfDataEntrada.setBounds(361, 40, 90, 20);
//		getContentPane().add(tfDataEntrada);
//		tfDataEntrada.setColumns(10);
//		
//		tfDataEmissao = new JTextField();
//		tfDataEmissao.setColumns(10);
//		tfDataEmissao.setBounds(478, 40, 90, 20);
//		getContentPane().add(tfDataEmissao);
//		
//		JLabel lblProduto = new JLabel("Equipamento..:");
//		lblProduto.setBounds(10, 71, 76, 14);
//		getContentPane().add(lblProduto);
//		
//		JLabel lblMarca = new JLabel("Marca..:");
//		lblMarca.setBounds(172, 71, 46, 14);
//		getContentPane().add(lblMarca);
//		
//		JLabel label_1 = new JLabel("Produto..:");
//		label_1.setBounds(392, 99, -98, 14);
//		getContentPane().add(label_1);
//		
//		JComboBox cbMarca = new JComboBox();
//		cbMarca.setBounds(172, 93, 114, 20);
//		getContentPane().add(cbMarca);
//		
//		JLabel lblCor = new JLabel("Cor..:");
//		lblCor.setBounds(305, 71, 46, 14);
//		getContentPane().add(lblCor);
//		
//		tfCor = new JTextField();
//		tfCor.setColumns(10);
//		tfCor.setBounds(304, 93, 96, 20);
//		getContentPane().add(tfCor);
//		
//		JLabel lblSrie = new JLabel("S\u00E9rie..:");
//		lblSrie.setBounds(10, 124, 36, 14);
//		getContentPane().add(lblSrie);
//		
//		JLabel lblImetro = new JLabel("Observa\u00E7\u00F5es..:");
//		lblImetro.setBounds(331, 124, 107, 14);
//		getContentPane().add(lblImetro);
//		
//		JLabel lblSetor = new JLabel("Setor..:");
//		lblSetor.setBounds(192, 124, 46, 14);
//		getContentPane().add(lblSetor);
//		
//		tfSerie = new JTextField();
//		tfSerie.setColumns(10);
//		tfSerie.setBounds(10, 144, 172, 20);
//		getContentPane().add(tfSerie);
//		
//		tfImetro = new JTextField();
//		tfImetro.setColumns(10);
//		tfImetro.setBounds(331, 149, 224, 40);
//		getContentPane().add(tfImetro);
//		
//		JComboBox cbSetor = new JComboBox();
//		cbSetor.setBounds(192, 144, 114, 20);
//		getContentPane().add(cbSetor);
//		
//		/*
//		cbProduto.setModel(new ProdutosComboBoxModel(produtosDAO.select()));
//*/
//	    cbEstabelecimento = new JComboBox();
//		cbEstabelecimento.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Estabelecimento e = (Estabelecimento) cbEstabelecimento.getSelectedItem();
//				}
//		});
//		
//		cbEstabelecimento.setBounds(78, 40, 273, 20);
//		getContentPane().add(cbEstabelecimento);
//		//cbEstabelecimento.setModel(new EstabelecimentoComboBoxModel(EstabelecimentoDAO.select()));
//		JLabel lblDefeito = new JLabel("Defeito");
//		lblDefeito.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblDefeito.setBounds(10, 175, 76, 14);
//		getContentPane().add(lblDefeito);
//		
//		tfDefeito = new JTextField();
//		tfDefeito.setBounds(10, 194, 593, 71);
//		getContentPane().add(tfDefeito);
//		tfDefeito.setColumns(10);
//		
//		JComboBox cbPecas = new JComboBox();
//		cbPecas.setBounds(10, 315, 194, 20);
//		getContentPane().add(cbPecas);
//		
//		JLabel lblPeas = new JLabel("Pe\u00E7as");
//		lblPeas.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblPeas.setBounds(10, 286, 58, 28);
//		getContentPane().add(lblPeas);
//		
//		JLabel lblValorVenda = new JLabel("Valor venda..:");
//		lblValorVenda.setBounds(222, 300, 90, 14);
//		getContentPane().add(lblValorVenda);
//		
//		JLabel lblQuantidade = new JLabel("Quantidade..:");
//		lblQuantidade.setBounds(318, 300, 82, 14);
//		getContentPane().add(lblQuantidade);
//		
//		JLabel lblValorTotal = new JLabel("Valor Total..:");
//		lblValorTotal.setBounds(410, 300, 69, 14);
//		getContentPane().add(lblValorTotal);
//		
//		tfValorVenda = new JTextField();
//		tfValorVenda.setColumns(10);
//		tfValorVenda.setBounds(222, 315, 72, 20);
//		getContentPane().add(tfValorVenda);
//		
//		tfQuantidade = new JTextField();
//		tfQuantidade.setColumns(10);
//		tfQuantidade.setBounds(317, 315, 69, 20);
//		getContentPane().add(tfQuantidade);
//		
//		tfValorTotal = new JTextField();
//		tfValorTotal.setColumns(10);
//		tfValorTotal.setBounds(410, 315, 69, 20);
//		getContentPane().add(tfValorTotal);
//		
//		JButton btnCheck = new JButton("");
//		btnCheck.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Check\\Check_24x24.png"));
//		btnCheck.setBounds(489, 300, 50, 37);
//		getContentPane().add(btnCheck);
//		
//		JButton btnCancel = new JButton("");
//		btnCancel.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Cancel\\Cancel_24x24.png"));
//		btnCancel.setBounds(549, 300, 50, 37);
//		getContentPane().add(btnCancel);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 342, 593, 108);
//		getContentPane().add(scrollPane);
//		
//		JLabel lblUsuario = new JLabel("Usuario..:");
//		lblUsuario.setBounds(10, 462, 76, 14);
//		getContentPane().add(lblUsuario);
//		
//		JComboBox cbUsuario = new JComboBox();
//		cbUsuario.setBounds(10, 479, 125, 20);
//		getContentPane().add(cbUsuario);
//		
//		JLabel lblS = new JLabel("Valor Total");
//		lblS.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblS.setBounds(366, 549, 114, 14);
//		getContentPane().add(lblS);
//		
//		JLabel lblValorPeas = new JLabel("Pe\u00E7as");
//		lblValorPeas.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblValorPeas.setBounds(397, 461, 58, 37);
//		getContentPane().add(lblValorPeas);
//		
//		JLabel lblValorMoDe = new JLabel("M\u00E3o de Obra");
//		lblValorMoDe.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblValorMoDe.setBounds(357, 510, 99, 14);
//		getContentPane().add(lblValorMoDe);
//		
//		tfPe�as = new JTextField();
//		tfPe�as.setColumns(10);
//		tfPe�as.setBounds(470, 468, 69, 27);
//		getContentPane().add(tfPe�as);
//		
//		tfMaoDeObra = new JTextField();
//		tfMaoDeObra.setColumns(10);
//		tfMaoDeObra.setBounds(470, 506, 69, 27);
//		getContentPane().add(tfMaoDeObra);
//		
//		tfTotal = new JTextField();
//		tfTotal.setEditable(false);
//		tfTotal.setColumns(10);
//		tfTotal.setBounds(470, 545, 69, 27);
//		getContentPane().add(tfTotal);
//		
//		JButton btnNovo = new JButton("Novo");
//		btnNovo.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Add\\Add1.png"));
//		btnNovo.setBounds(43, 587, 114, 37);
//		getContentPane().add(btnNovo);
//		
//		JButton btnGravar = new JButton("Gravar ");
//		btnGravar.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Save\\Save1.png"));
//		btnGravar.setBounds(237, 587, 114, 37);
//		getContentPane().add(btnGravar);
//		
//		JButton btnExcluir = new JButton("Excluir");
//		btnExcluir.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Delete\\Delete1.png"));
//		btnExcluir.setBounds(410, 587, 114, 37);
//		getContentPane().add(btnExcluir);
//		
//		JLabel lblModelo = new JLabel("Modelo..:");
//		lblModelo.setBounds(433, 71, 46, 14);
//		getContentPane().add(lblModelo);
//		
//		tfModelo = new JTextField();
//		tfModelo.setColumns(10);
//		tfModelo.setBounds(433, 93, 135, 20);
//		getContentPane().add(tfModelo);
//		
//		textField = new JTextField();
//		textField.setColumns(10);
//		textField.setBounds(10, 93, 135, 20);
//		getContentPane().add(textField);
//	}
//}
