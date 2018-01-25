 package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

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

import DAO.EstabelecimentoDAO;
import DAO.FornecedorDAO;
import DAO.UfDAO;
import ENTIDADE.Estabelecimento;
import ENTIDADE.Fornecedor;
import ENTIDADE.Uf;
import MODEL.FornecedorTableModel;
import MODEL.UfComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class EstabelecimentoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;
	private JTextField NomeTextField;
	private Estabelecimento estabelecimentoEdicao;
	private EstabelecimentoDAO dao = new EstabelecimentoDAO();
	private UfDAO ufdao = new UfDAO();
	private JTextField enderecoTextField;
	private JTextField bairroTextField;
	private JTextField cidadeTextField;
	private JButton btnCancelar;
	private JButton btnExcluir;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JComboBox cbUf;
	private JFormattedTextField cepTextField,CNPJtextField,telTextField ;
	private MaskFormatter msCEP,msCNPJ,msTel,msIe;
	private JTextField emailTextField;
	private JTextField tfIe;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstabelecimentoFrame frame = new EstabelecimentoFrame();
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
	public EstabelecimentoFrame() {
		setTitle("Cadastro de Fornecedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 387);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JLabel lblId = new JLabel("Codigo..:");
		lblId.setBounds(10, 94, 63, 14);
		contentPane.add(lblId);
		
		IDtextField = new JTextField();
		IDtextField.setBackground(SystemColor.controlHighlight);
		IDtextField.setBounds(10, 113, 63, 20);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome/Raz\u00E3o Social..:");
		lblNome.setBounds(83, 94, 121, 14);
		contentPane.add(lblNome);
		
		NomeTextField = new JTextField();
		NomeTextField.setBounds(83, 113, 286, 20);
		contentPane.add(NomeTextField);
		NomeTextField.setColumns(10);
		 
		
			
		 
		   
		    JLabel lbIe = new JLabel("Incri\u00E7\u00E3o Estadual..:");
		    lbIe.setBounds(332, 192, 154, 14);
		    contentPane.add(lbIe);
		    try {
				msIe = new MaskFormatter("###.###.###.###");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		    tfIe = new JFormattedTextField(msIe);
		    tfIe.setEnabled(false);
		    tfIe.setBounds(329, 208, 135, 20);
		    contentPane.add(tfIe);
		    tfIe.setColumns(10);
		    
		    JLabel lblTelefone = new JLabel("Telefone..:");
		lblTelefone.setBounds(10, 239, 70, 14);
		contentPane.add(lblTelefone);
		try {
			msTel = new MaskFormatter("(##)####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
		
		telTextField = new JFormattedTextField(msTel);
		telTextField.setBounds(10, 257, 135, 20);
		contentPane.add(telTextField);
		telTextField.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ..:");
		lblCnpj.setBounds(379, 94, 58, 14);
		contentPane.add(lblCnpj);
		
		try {
			msCNPJ = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CNPJtextField = new JFormattedTextField(msCNPJ);
		CNPJtextField.setBounds(379, 113, 199, 20);
		contentPane.add(CNPJtextField);
		CNPJtextField.setColumns(10);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Save\\Save_16x16.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(estabelecimentoEdicao == null){
					
					estabelecimentoEdicao =  new Estabelecimento();
					estabelecimentoEdicao.setNome_estabelecimento(NomeTextField.getText());
					estabelecimentoEdicao.setTel_estabelecimento(telTextField.getText());
					estabelecimentoEdicao.setCnpj(CNPJtextField.getText());
					estabelecimentoEdicao.setEndereco(enderecoTextField.getText());
					estabelecimentoEdicao.setBairro(bairroTextField.getText());
					estabelecimentoEdicao.setCidade(cidadeTextField.getText());
					estabelecimentoEdicao.setUf((Uf)cbUf.getSelectedItem());
					cbUf.repaint();
					estabelecimentoEdicao.setEmail(emailTextField.getText());
					estabelecimentoEdicao.setInsc_es(tfIe.getText());
					estabelecimentoEdicao.setCep(cepTextField.getText());	
					
					
					IDtextField.setText("");
					NomeTextField.setText("");
					CNPJtextField.setText("");
					enderecoTextField.setText("");
					bairroTextField.setText("");
					cidadeTextField.setText("");
					cepTextField.setText("");
					telTextField.setText("");
					emailTextField.setText("");
					tfIe.setText("");
					cbUf.setSelectedItem(null);
					cbUf.repaint();
					
					
				if(dao.insert(estabelecimentoEdicao)){
					JOptionPane.showMessageDialog(null, 
							"INSERIDO COM SUCESSO");
				}else{
					 JOptionPane.showMessageDialog(null, "PROBLEMAS NA INSERÇÃO");
				}
					
				}
				else{
					estabelecimentoEdicao.setNome_estabelecimento(NomeTextField.getText());
					estabelecimentoEdicao.setTel_estabelecimento(telTextField.getText());
					estabelecimentoEdicao.setCnpj(CNPJtextField.getText());
					estabelecimentoEdicao.setEndereco(enderecoTextField.getText());
					estabelecimentoEdicao.setBairro(bairroTextField.getText());
					estabelecimentoEdicao.setCidade(cidadeTextField.getText());
					estabelecimentoEdicao.setUf((Uf)cbUf.getSelectedItem());
					cbUf.repaint();
					estabelecimentoEdicao.setEmail(emailTextField.getText());
					estabelecimentoEdicao.setInsc_es(tfIe.getText());
					estabelecimentoEdicao.setCep(cepTextField.getText());
			        
					
				if(dao.update(estabelecimentoEdicao)){
					JOptionPane.showMessageDialog(null, 
							"ALTERADO COM SUCESSO");
					
				}else{
					 JOptionPane.showMessageDialog(null, "PROBLEMAS NA ALTERAÇÃO");
					 IDtextField.setText("");
						NomeTextField.setText("");
						CNPJtextField.setText("");
						enderecoTextField.setText("");
						bairroTextField.setText("");
						cidadeTextField.setText("");
						cbUf.setSelectedItem(null);
						cbUf.repaint();
						cepTextField.setText("");
						telTextField.setText("");
						emailTextField.setText("");
						tfIe.setText("");
				
				}
				}
				
				
				btnNovo.setEnabled(true);
				    btnSalvar.setEnabled(false);
				    btnCancelar.setEnabled(false);
				    btnExcluir.setEnabled(false);
				    
					IDtextField.setText("");
					NomeTextField.setText("");
					CNPJtextField.setText("");
					enderecoTextField.setText("");
					bairroTextField.setText("");
					emailTextField.setText("");
					tfIe.setText("");
					cidadeTextField.setText("");
					cepTextField.setText("");
					telTextField.setText("");
				    IDtextField.requestFocus();
			}
		});
		btnSalvar.setBounds(124, 288, 104, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o..:");
		lblEndereo.setBounds(10, 144, 86, 14);
		contentPane.add(lblEndereo);
		
		enderecoTextField = new JTextField();
		enderecoTextField.setBounds(10, 159, 286, 20);
		contentPane.add(enderecoTextField);
		enderecoTextField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro..:");
		lblBairro.setBounds(308, 144, 63, 14);
		contentPane.add(lblBairro);
		
		bairroTextField = new JTextField();
		bairroTextField.setBounds(308, 159, 270, 20);
		contentPane.add(bairroTextField);
		bairroTextField.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade..:");
		lblCidade.setBounds(10, 192, 63, 14);
		contentPane.add(lblCidade);
		
		cidadeTextField = new JTextField();
		cidadeTextField.setBounds(10, 208, 230, 20);
		contentPane.add(cidadeTextField);
		cidadeTextField.setColumns(10);
		
		JLabel lblUf = new JLabel("UF..:");
		lblUf.setBounds(254, 192, 46, 14);
		contentPane.add(lblUf);
		
	    cbUf = new JComboBox();
		cbUf.setBounds(254, 208, 63, 20);
		contentPane.add(cbUf);
		cbUf.setModel(new UfComboBoxModel(ufdao.select()));
		
		
		try {
			msCEP = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cepTextField = new JFormattedTextField(msCEP);
		cepTextField.setBounds(474, 208, 104, 20);
		contentPane.add(cepTextField);
		cepTextField.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP..:");
		lblCep.setBounds(489, 190, 64, 14);
		contentPane.add(lblCep);
		
		btnNovo = new JButton("NOVO");
		btnNovo.setMnemonic(KeyEvent.VK_ENTER);
		btnNovo.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				estabelecimentoEdicao = null;
				
				IDtextField.setText("");
				NomeTextField.setText("");
				CNPJtextField.setText("");
				enderecoTextField.setText("");
				bairroTextField.setText("");
				cidadeTextField.setText("");
				cbUf.setSelectedItem(null);
				cbUf.repaint();
				cepTextField.setText("");
				telTextField.setText("");
				emailTextField.setText("");
				tfIe.setText("");
			    NomeTextField.requestFocus();
			    
			    
			    IDtextField.setEnabled(false);
			    NomeTextField.setEnabled(true);
			    telTextField.setEnabled(true);
			    CNPJtextField.setEnabled(true);
			    cepTextField.setEnabled(true);
			    enderecoTextField.setEnabled(true);
			    bairroTextField.setEnabled(true);
			    cidadeTextField.setEnabled(true);
			    cbUf.setEnabled(true);
			    emailTextField.setEnabled(true);
			    tfIe.setEnabled(true);
			    btnNovo.setEnabled(false);
			    btnSalvar.setEnabled(true);
			    btnCancelar.setEnabled(true);
			    btnExcluir.setEnabled(false);
			    
			}
		});
		btnNovo.setBounds(10, 288, 104, 23);
		contentPane.add(btnNovo);
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Delete\\Delete_16x16.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (JOptionPane.showConfirmDialog(null, 
						"Deseja excluir o aluno com o código informado?") 
						== JOptionPane.YES_OPTION){
					if(dao.delete(estabelecimentoEdicao.getCod_estabelecimento())){
						JOptionPane.showMessageDialog(null, "Fornecedor Excluido com Sucesso");
						btnCancelar.doClick();
					}else{
						JOptionPane.showMessageDialog(null, "Fornecedor Excluido com Sucesso");
						btnCancelar.doClick();
					}

				}
			
				IDtextField.setText("");
				NomeTextField.setText("");
				CNPJtextField.setText("");
				enderecoTextField.setText("");
				bairroTextField.setText("");
				cidadeTextField.setText("");
				cepTextField.setText("");
				telTextField.setText("");
				emailTextField.setText("");
				tfIe.setText("");
				cbUf.setSelectedItem(null);
				cbUf.repaint();
				
				btnNovo.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnCancelar.setEnabled(false);
				btnExcluir.setEnabled(true);
		    
		    
			}
		});
		btnExcluir.setBounds(356, 288, 108, 23);
		contentPane.add(btnExcluir);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Cancel\\Cancel_16x16.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				estabelecimentoEdicao = null;
				
				IDtextField.setText("");
				NomeTextField.setText("");
				CNPJtextField.setText("");
				enderecoTextField.setText("");
				bairroTextField.setText("");
		        cidadeTextField.setText("");
				cepTextField.setText("");
				telTextField.setText("");
				emailTextField.setText("");
				tfIe.setText("");
				cbUf.setSelectedItem(null);
			    cbUf.repaint();
				IDtextField.requestFocus();
			    
			    
			    IDtextField.setEnabled(false);
			    NomeTextField.setEnabled(false);
			    telTextField.setEnabled(false);
			    CNPJtextField.setEnabled(false);
			    cepTextField.setEnabled(false);
			    enderecoTextField.setEnabled(false);
			    bairroTextField.setEnabled(false);
			    cidadeTextField.setEnabled(false);
			    cbUf.setEnabled(false);
			    emailTextField.setEnabled(false);
			    tfIe.setEnabled(false);
			    btnNovo.setEnabled(true);
			    btnSalvar.setEnabled(false);
			    btnCancelar.setEnabled(false);
			    btnExcluir.setEnabled(false);
			}
		});
		btnCancelar.setBounds(238, 288, 108, 23);
		contentPane.add(btnCancelar);
		 
		    	btnNovo.setEnabled(true);
		    	btnSalvar.setEnabled(false);
		    	btnCancelar.setEnabled(false);
		    	btnExcluir.setEnabled(false);
		    
		    	IDtextField.setEnabled(false);
		    	NomeTextField.setEnabled(false);
		    	telTextField.setEnabled(false);
		    	CNPJtextField.setEnabled(false);
		    	cepTextField.setEnabled(false);
		    	enderecoTextField.setEnabled(false);
		    	bairroTextField.setEnabled(false);
		    	cidadeTextField.setEnabled(false);
		    	tfIe.setEnabled(false);
		    	cbUf.setEnabled(false);
		    	cbUf.repaint();
		    
		    JLabel lblEmail = new JLabel("Email..:");
		    lblEmail.setBounds(155, 239, 46, 14);
		    contentPane.add(lblEmail);
		    
		    emailTextField = new JTextField();
		    emailTextField.setEnabled(false);
		    emailTextField.setBounds(155, 257, 230, 20);
		    contentPane.add(emailTextField);
		    emailTextField.setColumns(10);
		    
		    JPanel panel_1 = new JPanel();
		    panel_1.setBackground(SystemColor.activeCaption);
		    panel_1.setBounds(0, 0, 644, 73);
		    contentPane.add(panel_1);
		    
		    JLabel lblFornecedor = new JLabel("ESTABELECIMENTO");
		    lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 40));
		    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		    gl_panel_1.setHorizontalGroup(
		    	gl_panel_1.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_panel_1.createSequentialGroup()
		    			.addGap(134)
		    			.addComponent(lblFornecedor, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
		    			.addContainerGap(271, Short.MAX_VALUE))
		    );
		    gl_panel_1.setVerticalGroup(
		    	gl_panel_1.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_panel_1.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(lblFornecedor)
		    			.addContainerGap(13, Short.MAX_VALUE))
		    );
		    panel_1.setLayout(gl_panel_1);
		    
		   
		  
		
		    
		   
	}
}
