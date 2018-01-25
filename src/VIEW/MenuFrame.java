package VIEW;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.h2.tools.Server;

import BD.Conexao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UTIL.RelatorioUtil;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Window.Type;
import java.awt.Panel;
import javax.swing.JTextField;

public class MenuFrame extends JFrame {
 
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmSair;
	private JMenu mnCadastros;
	private JMenuItem mntmClientes;
	private JMenuItem mntmFornecedor;
	private JMenuItem mntmProdutos;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmRelatorioDeVendas;
	private JMenuItem mntmRelatorioDeClientes;
	private JMenuItem mntmRelatorioDeProdutos;
	private JMenuItem mntmBuscarVenda;
	private JMenuItem mntmNovaVenda;
	private JMenu mnSobre;
	private JMenuItem mntmLeiame;
	private JButton btnRelatorioDeVendas;
	private JButton btnCadastrarUsuarios;
	private JButton btnFechamentoDeCaixa;
	private JMenuItem mntmOramento;
	private JMenuItem mntmRelatorioDeOramentos;
	private JMenuItem mntmRelatorioDeAtestado;
	private JMenuItem  mntmEstabelecimento;
	private JMenu mnPeas_1;
	private JMenuItem mntmNovoEquipamento;
	private JMenuItem mntmBuscarQuipamento;
	private JMenuItem mntmCadastroDeCor;
	private JMenuItem mntmCadastroDeMarcas;
	private JMenuItem mntmMovimentaoDeEstoque;
	private JMenuItem mntmContasAReceber;
	private JMenuItem mntmContaGerencial;
	private JMenuItem mntmUnidadeDeMedida;
	private JMenuItem mntmServios;
	private JMenuItem mntmTipoDePagamento;
	private JMenuItem mntmConsultaDeEstoqu;
	private JMenuItem mntmTipoDeEstocagem;
	private JMenu mnEmpresa;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmFuncionarios;
	private JMenuItem mntmUsuarios_1;
	private JMenu mnInventario;
	public static boolean versaoDev = false;
	/**
	 * Launch the application.
	 */
	   public  static  void main ( String args []) {
	   
	   
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
						MenuFrame frame = new MenuFrame();
					
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
	public MenuFrame() {
		setTitle("SYSTECH SYSTECMAS AUTOMA\u00C7\u00C3O COMERCIAL LDTA - ME\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 635);
		setLocationRelativeTo(null);
		//setExtendedState( MAXIMIZED_BOTH );
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastros = new JMenu("Cadastros");
		mnCadastros.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Add\\Add1.png"));
		mnCadastros.setMnemonic('C');
		menuBar.add(mnCadastros);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteFrame  c = new ClienteFrame();
				c.setVisible(true);
			}
		});
		mntmClientes.setMnemonic('L');
		mnCadastros.add(mntmClientes);
		
		mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FornecedorFrame f = new FornecedorFrame();
				f.setVisible(true);
			}
		});
		mntmFornecedor.setMnemonic('F');
		mnCadastros.add(mntmFornecedor);
		
		
		mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutosFrame p = new ProdutosFrame();
				p.setVisible(true);
			}
		});
		mntmProdutos.setMnemonic('P');
		mnCadastros.add(mntmProdutos);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	UsuarioFrame u = new UsuarioFrame();
				u.setVisible(true);
			*/}
		});
		mntmUsuarios.setMnemonic('U');
		mnCadastros.add(mntmUsuarios);
		
		mntmOramento = new JMenuItem("Or\u00E7amento");
		mntmOramento.setMnemonic('O');
		mntmOramento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	OrcFrame o = new OrcFrame();
			//	o.setVisible(true);
			}
		});
		mnCadastros.add(mntmOramento);
		
		 mntmEstabelecimento = new JMenuItem("Estabelecimento");
		mntmEstabelecimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstabelecimentoFrame e = new EstabelecimentoFrame();
				e.setVisible(true);
			}
		});
		mntmEstabelecimento.setMnemonic('E');
		mnCadastros.add(mntmEstabelecimento);
		
		JMenuItem mntmMarca = new JMenuItem("Marca");
		mntmMarca.setMnemonic('L');
		mnCadastros.add(mntmMarca);
		
		JMenuItem mntmSetor = new JMenuItem("Setor");
		mntmSetor.setMnemonic('L');
		mnCadastros.add(mntmSetor);
		
		mntmUnidadeDeMedida = new JMenuItem("Unidade de medida");
		mnCadastros.add(mntmUnidadeDeMedida);
		
		mntmServios = new JMenuItem("Servi\u00E7os");
		mnCadastros.add(mntmServios);
		
		mntmTipoDePagamento = new JMenuItem("Tipo de pagamento");
		mnCadastros.add(mntmTipoDePagamento);
		
		JMenu mnFinanceiro = new JMenu("Financeiro");
		mnFinanceiro.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Edit\\Edit_16x16.png"));
		menuBar.add(mnFinanceiro);
		
		JMenuItem mntmFluxoDeCaixa = new JMenuItem("Fluxo de caixa");
		mnFinanceiro.add(mntmFluxoDeCaixa);
		
		JMenuItem mntmContaCorrente = new JMenuItem("Conta corrente");
		mnFinanceiro.add(mntmContaCorrente);
		
		JMenuItem mntmPagamentos = new JMenuItem("Contas a pagar");
		mnFinanceiro.add(mntmPagamentos);
		
		mntmContasAReceber = new JMenuItem("Contas a receber");
		mnFinanceiro.add(mntmContasAReceber);
		
		mntmContaGerencial = new JMenuItem("Conta gerencial");
		mnFinanceiro.add(mntmContaGerencial);
		
		mnPeas_1 = new JMenu("Estoque");
		mnPeas_1.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Stock Index Up\\Stock Index Up_16x16.png"));
		mnPeas_1.setMnemonic('C');
		menuBar.add(mnPeas_1);
		
		mntmNovoEquipamento = new JMenuItem("Cadastro de produtos");
		mntmNovoEquipamento.setMnemonic('L');
		mnPeas_1.add(mntmNovoEquipamento);
		
		mntmCadastroDeMarcas = new JMenuItem("Cadastro de marcas");
		mntmCadastroDeMarcas.setMnemonic('L');
		mnPeas_1.add(mntmCadastroDeMarcas);
		
		mntmMovimentaoDeEstoque = new JMenuItem("Movimenta\u00E7\u00E3o de estoque");
		mntmMovimentaoDeEstoque.setMnemonic('L');
		mnPeas_1.add(mntmMovimentaoDeEstoque);
		
		mntmCadastroDeCor = new JMenuItem("Cadastro de cor");
		mntmCadastroDeCor.setMnemonic('L');
		mnPeas_1.add(mntmCadastroDeCor);
		
		mntmBuscarQuipamento = new JMenuItem(" Buscar produtos");
		mntmBuscarQuipamento.setMnemonic('F');
		mnPeas_1.add(mntmBuscarQuipamento);
		
		mntmConsultaDeEstoqu = new JMenuItem("Consulta de estoque");
		mnPeas_1.add(mntmConsultaDeEstoqu);
		
		mntmTipoDeEstocagem = new JMenuItem("Tipo de estocagem");
		mnPeas_1.add(mntmTipoDeEstocagem);
		
		mnEmpresa = new JMenu("Empresa");
		mnEmpresa.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Globe\\Globe_16x16.png"));
		menuBar.add(mnEmpresa);
		
		mntmNewMenuItem_2 = new JMenuItem("Dados gerais");
		mnEmpresa.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Endere\u00E7os");
		mnEmpresa.add(mntmNewMenuItem_3);
		
		mntmFuncionarios = new JMenuItem("Funcionarios");
		mnEmpresa.add(mntmFuncionarios);
		
		mntmUsuarios_1 = new JMenuItem("Usuarios");
		mntmUsuarios_1.setIcon(null);
		mnEmpresa.add(mntmUsuarios_1);
		
		mnInventario = new JMenu("Inventario");
		mnInventario.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Archive\\Archive_16x16.png"));
		menuBar.add(mnInventario);
		
		JMenuItem mntmBancoH = new JMenuItem("Banco H2");
		mntmBancoH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if (versaoDev){
			            Thread t = new Thread(new Runnable() {
			                @Override
			                public void run() {
			                    try {
			                        Server.startWebServer(Conexao.getConexao());
			                    } catch (Exception e) {
			                        e.printStackTrace();
			                    }
			                }
			            });
			            t.start();
			        }else{
			            try {
			                Server.openBrowser("http://localhost:8082");
			            } catch (Exception e) {
			            }
			        }
			}
		});
		mnInventario.add(mntmBancoH);
		
		JMenu mnVendas = new JMenu("Vendas");
		mnVendas.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_24x24.png"));
		mnVendas.setMnemonic('V');
		menuBar.add(mnVendas);
		
		mntmNovaVenda = new JMenuItem("Nova Venda");
		mntmNovaVenda.setMnemonic('A');
		mntmNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VendasFrame v = new VendasFrame ();
				v.setVisible(true);
				
			}
		});
		mnVendas.add(mntmNovaVenda);
		
		mntmBuscarVenda = new JMenuItem("Buscar Venda");
		mntmBuscarVenda.setMnemonic('B');
		mntmBuscarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVendasFrame c = new ConsultaVendasFrame();
				c.setVisible(true);
				}
		});
		
		

		
			
		mnVendas.add(mntmBuscarVenda);
		
		JMenu mnPeas = new JMenu("Or\u00E7amento");
		mnPeas.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\New\\New_24x24.png"));
		mnPeas.setMnemonic('C');
		menuBar.add(mnPeas);
		
		JMenuItem mntmNovaPea = new JMenuItem("Nova Or\u00E7amento");
		mntmNovaPea.setMnemonic('L');
		mnPeas.add(mntmNovaPea);
		
		JMenuItem mntmBuscarAtestado = new JMenuItem(" Buscar Or\u00E7amento");
		mntmBuscarAtestado.setMnemonic('F');
		mnPeas.add(mntmBuscarAtestado);
		
		JMenu mnBalanas = new JMenu("Balan\u00E7as");
		mnBalanas.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Paste\\Paste_24x24.png"));
		mnBalanas.setMnemonic('C');
		menuBar.add(mnBalanas);
		
		JMenuItem mntmNovaBalana = new JMenuItem("Nova balan\u00E7a");
		mntmNovaBalana.setMnemonic('L');
		mnBalanas.add(mntmNovaBalana);
		
		JMenuItem mntmBuscarBalanas = new JMenuItem(" Buscar balan\u00E7as");
		mntmBuscarBalanas.setMnemonic('F');
		mnBalanas.add(mntmBuscarBalanas);
		
		JMenu mnRelatorios = new JMenu("Relatorio");
		mnRelatorios.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Print\\Print_16x16.png"));
		mnRelatorios.setMnemonic('R');
		menuBar.add(mnRelatorios);
		
		mntmRelatorioDeVendas = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RelatorioUtil.executarRelatorio("vendas.jasper", null);
			}
		});
		
		mntmRelatorioDeProdutos = new JMenuItem("Relatorio de Produtos");
		mntmRelatorioDeProdutos.setMnemonic('P');
		mntmRelatorioDeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioUtil.executarRelatorio("Produtos.jasper", null);
			}
		});
		mnRelatorios.add(mntmRelatorioDeProdutos);
		
		mntmRelatorioDeClientes = new JMenuItem("Relatorio de Clientes");
		mntmRelatorioDeClientes.setMnemonic('C');
		mntmRelatorioDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RelatorioUtil.executarRelatorio("Clientes.jasper", null);
			}
		});
		mnRelatorios.add(mntmRelatorioDeClientes);
		mntmRelatorioDeVendas.setMnemonic('V');
		mnRelatorios.add(mntmRelatorioDeVendas);
		
		mntmRelatorioDeOramentos = new JMenuItem("Relatorio de Or\u00E7amentos");
		mnRelatorios.add(mntmRelatorioDeOramentos);
		
		mntmRelatorioDeAtestado = new JMenuItem("Relatorio de Balan\u00E7as");
		mnRelatorios.add(mntmRelatorioDeAtestado);
		
		JMenuItem mntmRelatorioDeEquipamentos = new JMenuItem("Relatorio de Estoque");
		mnRelatorios.add(mntmRelatorioDeEquipamentos);
		
		mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Help\\Help_16x16.png"));
		mnSobre.setMnemonic('S');
		menuBar.add(mnSobre);
		
		mntmLeiame = new JMenuItem("Leia-me");
		mntmLeiame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeiaFrame L = new LeiaFrame();
				L.setVisible(true);
				
			}
		});
		mnSobre.add(mntmLeiame);
		
		mnNewMenu = new JMenu("Sair");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Delete\\Delete1.png"));
		mnNewMenu.setMnemonic('S');
		menuBar.add(mnNewMenu);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setMnemonic('A');
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Cadastro de Cliente");
		btnNewButton.setBounds(10, 24, 197, 58);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteFrame c = new ClienteFrame();
				c.setVisible(true);
				}
		});
		contentPane.setLayout(null);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Add\\Add_48x48.png"));
		contentPane.add(btnNewButton);
		
		btnRelatorioDeVendas = new JButton("Relatorio de Vendas");
		btnRelatorioDeVendas.setBounds(10, 93, 197, 58);
		btnRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioUtil.executarRelatorio("vendas.jasper", null);
				
			}
		});
		btnRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Print\\Print_48x48.png"));
		contentPane.add(btnRelatorioDeVendas);
		
		btnCadastrarUsuarios = new JButton("Cadastrar Usuarios");
		btnCadastrarUsuarios.setBounds(10, 171, 197, 58);
		btnCadastrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/*	UsuarioFrame u = new UsuarioFrame();
			u.setVisible(true);*/
			}
		});
		btnCadastrarUsuarios.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Copy v2\\Copy v2_48x48.png"));
		contentPane.add(btnCadastrarUsuarios);
		
		btnFechamentoDeCaixa = new JButton("Fechamento de Caixa");
		btnFechamentoDeCaixa.setBounds(10, 240, 197, 58);
		btnFechamentoDeCaixa.setIcon(new ImageIcon("C:\\Users\\Rafael Master\\Desktop\\Programa\u00E7\u00E3o T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Key\\Key_48x48.png"));
		contentPane.add(btnFechamentoDeCaixa);
		
		JMenu mnOrdensDeServios = new JMenu("Ordens de servi\u00E7os");
		mnOrdensDeServios.setBounds(71, 39, 127, 19);
		contentPane.add(mnOrdensDeServios);
		mnOrdensDeServios.setIcon(new ImageIcon("C:\\Users\\rafae\\Documents\\Rafael Java\\TCC_SENAI\\Img\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Paste\\Paste_16x16.png"));
		
		JMenuItem mntmNewMenuItem = new JMenuItem("+ Nova OS");
		mnOrdensDeServios.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar OSs");
		mnOrdensDeServios.add(mntmNewMenuItem_1);
		
	}
}
