package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
//import MODEL.ProdutosComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.ClienteDAO;
import DAO.FormaPagamentoDAO;
import DAO.ItensDAO;
import DAO.ProdutosDAO;
import DAO.UsuarioDAO;
import DAO.VendasDAO;
import ENTIDADE.Cliente;
import ENTIDADE.FormaPagamento;
import ENTIDADE.Itens;
import ENTIDADE.Produtos;
import ENTIDADE.Venda;
import MODEL.ClienteComboBoxModel;
import MODEL.FormaPagamentoComboBoxModel;
import MODEL.ItensTableModel;
import MODEL.ProdutosComboBoxModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;

public class VendasFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField tfCodigo;
	private JTextField tfVlrVenda;
	private JLabel lblCliente;
	private JLabel lblProduto;
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ProdutosDAO produtosDAO = new ProdutosDAO();
	private JLabel lblData;
	private JTextField tfCod_Cliente;
	private JLabel lblQuantidade_1;
	private JTextField tfQuantidade;
	private JButton btnComfirma;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblFormaDePagamento;
	private JComboBox cbPagamento;
	private JLabel lblFuncionrio;
	private JComboBox cbUsuario;
	private JButton btnNovo;
	private JButton btnGravar;
	private JButton btnCancelar;
	private JLabel lblValorVenda;
	private JTextField tfValorVenda;
	private JLabel lblDesconto;
	private JTextField tfDesconto;
	private JLabel lblTotal;
	private JTextField tfTotal;
	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private FormaPagamentoDAO formaPagamentoDao = new FormaPagamentoDAO();
	private ClienteDAO clienteDao = new ClienteDAO();
	private VendasDAO vendasDAO = new VendasDAO();
	private ItensDAO itensDAO = new ItensDAO();
	private Venda vendasEdicao;
	private JDateChooser dtCompra;
	private JComboBox cbCliente;
	private JComboBox cbProduto;
	private JButton btnCadastrarCliente;
	private ArrayList<Itens> itensList = new ArrayList<Itens>();
	private JButton btnRe;
	private JLabel lblValorTotal;
	private JTextField tfVlrTotal;
	private JLabel lblSubtotal;
	private JTextField tfSubTotal;
	
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendasFrame frame = new VendasFrame();
					
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
	public VendasFrame() {
		setTitle("                                                                                                                                        Nova Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1038, 712);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 24, 64, 14);
		contentPane.add(lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBackground(new Color(0, 0, 128));
		tfCodigo.setBounds(10, 43, 73, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 82, 79, 14);
		contentPane.add(lblCliente);
		
	
		lblProduto = new JLabel("Produto");
		lblProduto.setBounds(10, 161, 60, 14);
		contentPane.add(lblProduto);
		
		lblData = new JLabel("Data Compra");
		lblData.setBounds(124, 24, 101, 14);
		contentPane.add(lblData);
		
		tfCod_Cliente = new JTextField();
		tfCod_Cliente.setBounds(10, 103, 73, 20);
		contentPane.add(tfCod_Cliente);
		tfCod_Cliente.setColumns(10);
		
		lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSubtotal.setBounds(848, 468, 120, 38);
		contentPane.add(lblSubtotal);
		
		tfSubTotal = new JTextField();
		tfSubTotal.setBounds(844, 517, 110, 44);
		contentPane.add(tfSubTotal);
		tfSubTotal.setColumns(10);	
		
		tfVlrTotal = new JTextField();
		tfVlrTotal.setEnabled(false);
		tfVlrTotal.setBounds(667, 182, 86, 20);
		contentPane.add(tfVlrTotal);
		tfVlrTotal.setColumns(10);
		
		
		
		lblQuantidade_1 = new JLabel("Quantidade");
		lblQuantidade_1.setBounds(562, 161, 79, 14);
		contentPane.add(lblQuantidade_1);
		
		tfQuantidade = new JTextField();
		tfQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyReleased(KeyEvent arg0) {
				double vlrIntem = Double.parseDouble(tfValorVenda.getText());
				int qtd = Integer.parseInt(tfQuantidade.getText());
				
				double vlrTotal = vlrIntem * qtd;
				tfVlrTotal.setText(String.valueOf(vlrTotal));
			}
		});
		tfQuantidade.setBounds(562, 182, 86, 20);
		contentPane.add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		btnComfirma = new JButton("");
		btnComfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Itens i = new Itens();
				i.setProdutos((Produtos)cbProduto.getSelectedItem());
				i.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
				i.setValor_venda(Double.parseDouble(tfValorVenda.getText()));
				i.setValor_total(Double.parseDouble(tfVlrTotal.getText()));
				itensList.add(i);
				
				cbProduto.setModel(new ProdutosComboBoxModel(produtosDAO.select()));
				tfValorVenda.setText("");
				tfQuantidade.setText("");
				tfVlrTotal.setText("");
				
				float soma = 0;
				for(int a=0; a < table.getRowCount();a++ )//pegar os numeros de linha
				{
					float valor = Float.parseFloat(String.valueOf(table.getValueAt(a, 3)));
					soma += valor;
				}
			String novoValor  = String.valueOf(soma);
			tfSubTotal.setText(novoValor);
				
				table.setModel(new ItensTableModel(itensList));
			}
		});
		btnComfirma.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Check\\Check_24x24.png"));
		btnComfirma.setBounds(773, 170, 64, 32);
		contentPane.add(btnComfirma);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 244, 998, 228);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					//Cast
					ItensTableModel modelo = (ItensTableModel) table.getModel();


				//vendasEdicao = modelo.getItensPorLinha(table.getSelectedRow());


					tfCodigo.setText(String.valueOf(vendasEdicao.getCodigo()));
					dtCompra.setDate(vendasEdicao.getData_Compra());
					cbCliente.setSelectedItem(vendasEdicao.getCliente());
					
					cbPagamento.setSelectedItem(vendasEdicao.getFormaPagamento());
					cbPagamento.repaint();
					cbUsuario.setSelectedItem(vendasEdicao.getUsuario());
					cbUsuario.repaint();
					tfDesconto.setText(String.valueOf(vendasEdicao.getDesconto()));
					tfTotal.setText(String.valueOf(vendasEdicao.getTotal()));
					tfCodigo.requestFocus();

					btnNovo.setEnabled(true);
					btnGravar.setEnabled(true);
					btnCancelar.setEnabled(true);

				}

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new ItensTableModel(itensList));
		//table.setModel(new ItensTableModel(itensDAO.select()));

		
		lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setBounds(10, 484, 120, 14);
		contentPane.add(lblFormaDePagamento);
		
		cbPagamento = new JComboBox();
		cbPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		cbPagamento.setBounds(10, 502, 141, 20);
		contentPane.add(cbPagamento);
		cbPagamento.setModel(new FormaPagamentoComboBoxModel(formaPagamentoDao.select()));
		
		lblFuncionrio = new JLabel("Usuario");
		lblFuncionrio.setBounds(10, 533, 64, 14);
		contentPane.add(lblFuncionrio);
		
		cbUsuario = new JComboBox();
		cbUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		cbUsuario.setBounds(10, 550, 141, 20);
		contentPane.add(cbUsuario);

		
		
		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_24x24.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vendasEdicao = null;
				tfCodigo.setText("");
				dtCompra.setDate(null);
				tfCod_Cliente.setText("");
				tfValorVenda.setText("");
				tfQuantidade.setText("");
				itensList = new ArrayList<Itens>();
				table.setModel(
						new ItensTableModel(itensList));
				
				tfVlrTotal.setText("");
				tfDesconto.setText("");
				tfSubTotal.setText("");
				tfTotal.setText("");
				tfSubTotal.setText("");
				tfCodigo.requestFocus();
				
				btnNovo.setEnabled(false);
				btnGravar.setEnabled(true);
				btnCancelar.setEnabled(true);
				tfCodigo.setEnabled(true);
				dtCompra.setEnabled(true);
				tfCod_Cliente.setEnabled(true);
				tfValorVenda.setEnabled(true);
				tfQuantidade.setEnabled(true);
				tfVlrTotal.setEnabled(true);
				tfDesconto.setEnabled(true);
				tfSubTotal.setEnabled(true);
				tfTotal.setEnabled(true);
			}
		});
		btnNovo.setBounds(10, 597, 120, 49);
		contentPane.add(btnNovo);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Save\\Save_24x24.png"));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Novo registro
				if (vendasEdicao == null) {
					vendasEdicao = new Venda();
					vendasEdicao.setData_Compra(dtCompra.getDate());
					vendasEdicao.setCliente((Cliente)cbCliente.getSelectedItem());
					cbCliente.repaint();
					vendasEdicao.setIntensList(itensList);
					//vendasEdicao.setUsuario((Usuario1) cbUsuario.getSelectedItem());
					cbUsuario.repaint();
					vendasEdicao.setFormaPagamento((FormaPagamento) cbPagamento.getSelectedItem());
					cbPagamento.repaint();
				    vendasEdicao.setDesconto(Double.parseDouble(tfDesconto.getText()));
					vendasEdicao.setTotal(Double.parseDouble(tfTotal.getText()));
					if (vendasDAO.insert(vendasEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, 
								"VENDA SALVA COM SUCESSO!");
						btnCancelar.doClick();
						vendasEdicao = null;
						
			
					}else{//se false
						JOptionPane.showMessageDialog(null, 
								"PLOBLEMAS NA VENDA!");
						btnCancelar.doClick();


					}
				} else {//Altera Registro

					vendasEdicao.setData_Compra(dtCompra.getDate());
					vendasEdicao.setCliente((Cliente)cbCliente.getSelectedItem());
					cbCliente.repaint();
					vendasEdicao.setIntensList(itensList);
				//	vendasEdicao.setUsuario((Usuario1) cbUsuario.getSelectedItem());
					cbUsuario.repaint();
					vendasEdicao.setFormaPagamento((FormaPagamento) cbPagamento.getSelectedItem());
					cbPagamento.repaint();
				    vendasEdicao.setDesconto(Double.parseDouble(tfDesconto.getText()));
					vendasEdicao.setTotal(Double.parseDouble(tfTotal.getText()));

					
						vendasEdicao = null;
						vendasEdicao = null;
						tfCodigo.setText("");
						dtCompra.setDate(null);
						tfCod_Cliente.setText("");
						cbCliente.setSelectedItem(null);
					 	cbCliente.repaint();
						cbProduto.setSelectedItem(null);
						cbProduto.repaint(); 
						tfQuantidade.setText("");
						tfValorVenda.setText("");
						tfVlrTotal.setText("");
						cbPagamento.setSelectedItem(null);
						cbPagamento.repaint();
						cbUsuario.setSelectedItem(null);
						cbUsuario.repaint();
						tfDesconto.setText("");
						tfTotal.setText("");
						tfSubTotal.setText("");
						tfCodigo.requestFocus();

					
				}
			}


		});
		btnGravar.setBounds(146, 597, 120, 49);
		contentPane.add(btnGravar);
		
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Cancel\\Cancel_24x24.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vendasEdicao = null;
				tfCodigo.setText("");
				dtCompra.setDate(null);
				tfCod_Cliente.setText("");
				cbCliente.setSelectedItem(null);
			 	cbCliente.repaint();
				cbProduto.setSelectedItem(null);
				cbProduto.repaint(); 
				tfValorVenda.setText("");
				tfQuantidade.setText("");
				tfVlrTotal.setText("");
				cbPagamento.setSelectedItem(null);
				cbPagamento.repaint();
				cbUsuario.setSelectedItem(null);
				cbUsuario.repaint();
				tfDesconto.setText("");
				tfSubTotal.setText("");
				tfTotal.setText("");
				tfCodigo.requestFocus();
				
				btnNovo.setEnabled(true);
				btnGravar.setEnabled(false);
				btnCancelar.setEnabled(true);
			}
		});
		btnCancelar.setBounds(276, 597, 120, 49);
		contentPane.add(btnCancelar);
		
		lblValorVenda = new JLabel("Valor Venda");
		lblValorVenda.setBounds(456, 161, 79, 14);
		contentPane.add(lblValorVenda);
		
		tfValorVenda = new JTextField();
		tfValorVenda.setBounds(456, 182, 86, 20);
		contentPane.add(tfValorVenda);
		tfValorVenda.setColumns(10);
		
		lblDesconto = new JLabel("Desconto%");
		lblDesconto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDesconto.setBounds(568, 484, 163, 22);
		contentPane.add(lblDesconto);
		
		tfDesconto = new JTextField();
		tfDesconto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			int desc = Integer.parseInt(tfDesconto.getText());
			double subtotal = Double.parseDouble(tfSubTotal.getText());
			double total;
			total = subtotal - (subtotal*desc)/100;
			
			tfTotal.setText(String.valueOf(total));
			}
		});
		tfDesconto.setBounds(562, 517, 150, 44);
		contentPane.add(tfDesconto);
		tfDesconto.setColumns(10);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotal.setBounds(854, 572, 64, 32);
		contentPane.add(lblTotal);
		
		tfTotal = new JTextField();
		tfTotal.setBounds(847, 615, 101, 48);
		contentPane.add(tfTotal);
		tfTotal.setColumns(10);
		
		dtCompra = new JDateChooser();
		dtCompra.setBounds(124, 43, 98, 20);
		contentPane.add(dtCompra);
		
		
		
		cbCliente = new JComboBox();
		cbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = (Cliente) cbCliente.getSelectedItem();
				
				tfCod_Cliente.setText(String.valueOf(c.getCod_Cliente()));
				
			}
		});
		cbCliente.setBounds(93, 103, 351, 20);
		contentPane.add(cbCliente);
		cbCliente.setModel(new ClienteComboBoxModel(clienteDao.select()));
	
		
		cbProduto = new JComboBox();
		cbProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produtos p = (Produtos) cbProduto.getSelectedItem();
				tfValorVenda.setText(String.valueOf(p.getValor_venda()));
			}
		});
		cbProduto.setBounds(10, 179, 433, 20);
		contentPane.add(cbProduto);
		cbProduto.setModel(new ProdutosComboBoxModel(produtosDAO.select()));
		tfCodigo.setEnabled(false);
		dtCompra.setEnabled(false);
		tfCod_Cliente.setEnabled(false);
		cbCliente.setSelectedItem(false);
		cbCliente.repaint();
		cbProduto.setSelectedItem(false);
		cbProduto.repaint();
		tfValorVenda.setEnabled(false);
		tfQuantidade.setEnabled(false);
		tfVlrTotal.setEnabled(false);
		cbPagamento.setSelectedItem(false);
		cbPagamento.repaint();
		cbUsuario.setSelectedItem(false);
		cbUsuario.repaint();
		tfDesconto.setEnabled(false);
		tfSubTotal.setEnabled(false);
		tfTotal.setEnabled(false);
		
		btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientePanel cp = new ClientePanel();
				JDialog dlg = new JDialog();
				dlg.getContentPane().add(cp);
				dlg.setSize(528, 575);
				dlg.setModal(true);
				dlg.setLocationRelativeTo(null);
				dlg.setVisible(true);
				
				cbCliente.setModel(new ClienteComboBoxModel(clienteDao.select()));
				
			}
		});
		btnCadastrarCliente.setBounds(460, 102, 169, 23);
		contentPane.add(btnCadastrarCliente);
		
		btnRe = new JButton("");
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItensTableModel model = (ItensTableModel) table.getModel();
				Itens i = model.getItensPorLinha(
						table.getSelectedRow());
				//Percorre a lista de telefone e se um telefone da lista (t1) for o mesmo da variavel t,
				//então ele sera removido
				for(Itens it : itensList){
					if(it.equals(it)){
						itensList.remove(it);
						table.setModel(new ItensTableModel(
								itensList));
						break;
					}

				}
			}});
		btnRe.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Delete\\Delete_24x24.png"));
		btnRe.setBounds(847, 170, 64, 32);
		contentPane.add(btnRe);
		
		lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(667, 161, 64, 14);
		contentPane.add(lblValorTotal);
		
		
		
		
	}
}
