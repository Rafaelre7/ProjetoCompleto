package VIEW;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import DAO.FornecedorDAO;
import DAO.ProdutosDAO;
import ENTIDADE.Fornecedor;
import ENTIDADE.Produtos;
import ENTIDADE.Uf;
import MODEL.FornComboBoxModel;
import MODEL.FornecedorTableModel;
import MODEL.ProdutosTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

public class ProdutosFrame extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;
	private JTextField VCtextField;
	private JTextField VVtextField;
	private JTable table;
	private Produtos produtosEdicao; 
	private JTextField descricaoTextField;
	private JComboBox comboBox;
	private FornecedorDAO dao2 = new FornecedorDAO();
	private ProdutosDAO dao = new ProdutosDAO();
	private JButton btnNovo;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JLabel lblCod;
	private JTextField tfCod_Barras;
	private JTextField buscarTextField;
	private JLabel label;
	private JPanel panel;
	private MaskFormatter msCod_Barras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosFrame frame = new ProdutosFrame();
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
	public ProdutosFrame() {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 586);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblId = new JLabel("Codigo..:");
		lblId.setBounds(14, 84, 58, 14);
		contentPane.add(lblId);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o..:");
		lblDescrio.setBounds(113, 84, 86, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblFornecedor = new JLabel("Fornecedor..:");
		lblFornecedor.setBounds(14, 176, 93, 14);
		contentPane.add(lblFornecedor);
		
		JLabel lblValorDaCompra = new JLabel("Pre\u00E7o de compra:");
		lblValorDaCompra.setBounds(158, 176, 123, 14);
		contentPane.add(lblValorDaCompra);
		
		JLabel lblValorDaVenda = new JLabel("Pre\u00E7o de Venda:");
		lblValorDaVenda.setBounds(291, 176, 102, 14);
		contentPane.add(lblValorDaVenda);
		
		IDtextField = new JTextField();
		IDtextField.setBackground(SystemColor.controlHighlight);
		IDtextField.setBounds(14, 99, 86, 20);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		descricaoTextField = new JTextField();
		descricaoTextField.setBounds(113, 99, 219, 20);
		contentPane.add(descricaoTextField);
		descricaoTextField.setColumns(10);
		
		VCtextField = new JTextField();
		VCtextField.setBounds(158, 191, 86, 20);
		contentPane.add(VCtextField);
		VCtextField.setColumns(10);
		
		VVtextField = new JTextField();
		VVtextField.setBounds(291, 191, 86, 20);
		contentPane.add(VVtextField);
		VVtextField.setColumns(10);
		
		btnSalvar  = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Save\\Save_16x16.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(produtosEdicao == null){
					
					produtosEdicao = new Produtos();
		
					produtosEdicao.setDescricao(descricaoTextField.getText());
					produtosEdicao.setFornecedor((Fornecedor)comboBox.getSelectedItem());
					produtosEdicao.setValor_compra(Integer.parseInt(VCtextField.getText()));
					produtosEdicao.setValor_venda(Integer.parseInt(VVtextField.getText()));
					produtosEdicao.setCod_barras(tfCod_Barras.getText());
				
					if(dao.insert(produtosEdicao)){
						JOptionPane.showMessageDialog(null, 
								"INSERIDO COM SUCESSO");
					}else{
						JOptionPane.showMessageDialog(null, 
								"PROBLEMAS NA INSERÇÃO");
					}
					
				}else{
					produtosEdicao.setDescricao(descricaoTextField.getText());
					produtosEdicao.setFornecedor((Fornecedor)comboBox.getSelectedItem());
					produtosEdicao.setValor_compra(Integer.parseInt(VCtextField.getText()));
					produtosEdicao.setValor_venda(Integer.parseInt(VVtextField.getText()));
					produtosEdicao.setCod_barras(tfCod_Barras.getText());
				if(dao.update(produtosEdicao)){
					JOptionPane.showMessageDialog(null, 
							"ALTERADO COM SUCESSO");
				}else{
					 JOptionPane.showMessageDialog(null, "PROBLEMAS NA ALTERAÇÃO");
				}
				
				}
                    
				IDtextField.setText("");
				descricaoTextField.setText("");
				comboBox.setSelectedItem(null);
				VCtextField.setText("");
				VVtextField.setText("");
				tfCod_Barras.setText("");
				IDtextField.requestFocus();
				
				IDtextField.setEnabled(false);
				descricaoTextField.setEnabled(false);
				comboBox.setEnabled(false);
				VCtextField.setEnabled(false);
				VVtextField.setEnabled(false);
				tfCod_Barras.setEnabled(false);
				
			    	btnNovo.setEnabled(true);
			 	    btnSalvar.setEnabled(false);
				    btnCancelar.setEnabled(false);
				    btnExcluir.setEnabled(false);
				table.setModel(new ProdutosTableModel(dao.select()));
			}
		});
		btnSalvar.setBounds(137, 222, 111, 23);
		contentPane.add(btnSalvar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEdicao = null;
				
				IDtextField.setText("");
				descricaoTextField.setText("");
				comboBox.setSelectedItem(null);
				VCtextField.setText("");
				VVtextField.setText("");
				tfCod_Barras.setText("");
				descricaoTextField.requestFocus();
				

				

				IDtextField.setEnabled(false);
				descricaoTextField.setEnabled(true);
				comboBox.setEnabled(true);
				VCtextField.setEnabled(true);
				VVtextField.setEnabled(true);
				tfCod_Barras.setEnabled(true);
			
			    btnNovo.setEnabled(false);
			    btnSalvar.setEnabled(true);
			    btnCancelar.setEnabled(true);
			    btnExcluir.setEnabled(false);
			}
		});
		btnNovo.setBounds(16, 222, 111, 23);
		contentPane.add(btnNovo);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Delete\\Delete_16x16.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (JOptionPane.showConfirmDialog(null, 
						"Deseja excluir o aluno com o código informado?") 
						== JOptionPane.YES_OPTION){
				if(dao.delete(produtosEdicao.getCod_produto())){
					JOptionPane.showMessageDialog(null, "Fornecedor Excluido com Sucesso");
					btnCancelar.doClick();
				}else{
					JOptionPane.showMessageDialog(null, "Fornecedor Excluido com Sucesso");
					btnCancelar.doClick();
				}
				}
				
				table.setModel(new ProdutosTableModel(dao.select()));
				IDtextField.setText("");
				descricaoTextField.setText("");
				comboBox.setSelectedItem(null);
				VCtextField.setText("");
				VVtextField.setText("");
				tfCod_Barras.setText("");
				IDtextField.requestFocus();
				
				btnNovo.setEnabled(true);
			    btnSalvar.setEnabled(false);
			    btnCancelar.setEnabled(false);
			    btnExcluir.setEnabled(false);
			}
		});
		btnExcluir.setBounds(379, 222, 111, 23);
		contentPane.add(btnExcluir);
		
		btnCancelar  = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Cancel\\Cancel_16x16.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                produtosEdicao = null;
				
				IDtextField.setText("");
				descricaoTextField.setText("");
				comboBox.setSelectedItem(null);
				VCtextField.setText("");
				VVtextField.setText("");
				tfCod_Barras.setText("");
				IDtextField.requestFocus();
				
				IDtextField.setEnabled(false);
				descricaoTextField.setEnabled(false);
				comboBox.setEnabled(false);
				VCtextField.setEnabled(false);
				tfCod_Barras.setEnabled(false);
				VVtextField.setEnabled(false);
				
			    btnNovo.setEnabled(true);
			    btnSalvar.setEnabled(false);
			    btnCancelar.setEnabled(false);
			    btnExcluir.setEnabled(false);
			}
		});
		btnCancelar.setBounds(258, 222, 111, 23);
		
		contentPane.add(btnCancelar);
		
		
	    comboBox = new JComboBox();
		comboBox.setBounds(14, 191, 123, 20);
		contentPane.add(comboBox);
		comboBox.setModel(new FornComboBoxModel(dao2.select()));
		

		IDtextField.setEnabled(false);
		descricaoTextField.setEnabled(false);
		//tfCod_Barras.setEnabled(false);
		comboBox.setEnabled(false);
		VCtextField.setEnabled(false);
		VVtextField.setEnabled(false);
		
		
	    btnNovo.setEnabled(true);
	    btnSalvar.setEnabled(false);
	    btnCancelar.setEnabled(false);
	    btnExcluir.setEnabled(false);
	    
	    lblCod = new JLabel("C\u00F3d. Barra:");
	    lblCod.setBounds(14, 130, 69, 14);
	    contentPane.add(lblCod);
	    try{
	    	msCod_Barras = new MaskFormatter("#############");
	    }catch(ParseException e1){
	    	e1.printStackTrace();
	    }
	    tfCod_Barras = new JFormattedTextField(msCod_Barras);
	    tfCod_Barras.setEnabled(false);
	    tfCod_Barras.setBounds(14, 145, 219, 20);
	    contentPane.add(tfCod_Barras);
	    tfCod_Barras.setColumns(10);
	
	    
	    panel = new JPanel();
	    panel.setBorder(new TitledBorder(null, "Busca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel.setBounds(10, 253, 671, 281);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 48, 654, 193);
	    panel.add(scrollPane);
	    
	    table = new JTable();
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
                ProdutosTableModel modelo = (ProdutosTableModel) table.getModel();
	    		
	    		produtosEdicao = modelo.getProdutoPorLinha(table.getSelectedRow());
	    		
	    		IDtextField.setText(String.valueOf(produtosEdicao.getCod_produto()));
	    		descricaoTextField.setText(produtosEdicao.getDescricao());
	    		VCtextField.setText(String.valueOf(produtosEdicao.getValor_compra()));
	    		VVtextField.setText(String.valueOf(produtosEdicao.getValor_venda()));
	    		tfCod_Barras.setText(produtosEdicao.getCod_barras());
	    		
	    		  btnNovo.setEnabled(false);
	    		  btnSalvar.setEnabled(true);
	    		  btnCancelar.setEnabled(true);
	    		  btnExcluir.setEnabled(true);
	    		  
	    		IDtextField.setEnabled(false);
	    		descricaoTextField.setEnabled(true);
	    		comboBox.setEnabled(true);
	    		VCtextField.setEnabled(true);
	    		tfCod_Barras.setEnabled(true);
	    		VVtextField.setEnabled(true);
	    	}
	    });
	    scrollPane.setViewportView(table);
	    table.setModel(new ProdutosTableModel(dao.select()));
	    
	    label = new JLabel("Clique no nome para carregar os dados");
	    label.setBounds(14, 252, 246, 14);
	    panel.add(label);
	    
	    buscarTextField = new JTextField();
	    buscarTextField.setBounds(10, 23, 313, 20);
	    panel.add(buscarTextField);
	    buscarTextField.setColumns(10);
	    
	    JButton btnNewButton = new JButton("Buscar");
	    btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Search\\Search_16x16.png"));
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ArrayList<Produtos> p = dao.buscarFornecedorPorNome(buscarTextField.getText());
	    		table.setModel(new ProdutosTableModel(p));
	    	}
	    });
	    btnNewButton.setBounds(333, 22, 102, 23);
	    panel.add(btnNewButton);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(SystemColor.activeCaption);
	    panel_1.setBounds(0, 0, 687, 73);
	    contentPane.add(panel_1);
	    
	    JLabel lblProdutos = new JLabel("Produtos");
	    lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 40));
	    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
	    gl_panel_1.setHorizontalGroup(
	    	gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGap(0, 842, Short.MAX_VALUE)
	    		.addGroup(gl_panel_1.createSequentialGroup()
	    			.addGap(23)
	    			.addComponent(lblProdutos)
	    			.addContainerGap(700, Short.MAX_VALUE))
	    );
	    gl_panel_1.setVerticalGroup(
	    	gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGap(0, 73, Short.MAX_VALUE)
	    		.addGroup(gl_panel_1.createSequentialGroup()
	    			.addGap(7)
	    			.addComponent(lblProdutos)
	    			.addContainerGap(17, Short.MAX_VALUE))
	    );
	    panel_1.setLayout(gl_panel_1);
	    
	    JButton btnSalvar = new JButton("Salvar");
	    btnSalvar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Save\\Save_16x16.png"));
	    btnSalvar.setBounds(137, 222, 111, 23);
	    contentPane.add(btnSalvar);
    
	}
}
