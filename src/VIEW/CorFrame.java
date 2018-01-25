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


import DAO.CorDAO;


import ENTIDADE.Cor;

import MODEL.CorTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPasswordField;


public class CorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfCor;
	private Cor corEdicao;
	private CorDAO corDAO = new CorDAO();
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
					CorFrame frame = new CorFrame();
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
	public CorFrame() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setType(Type.POPUP);
		setTitle("Cadastro de Cor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Cor");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(8, 74, 83, 20);
		contentPane.add(lblUsuario);
		
		tfCor = new JTextField();
		tfCor.setEditable(false);
		tfCor.setEnabled(false);
		tfCor.setBounds(10, 98, 218, 20);
		contentPane.add(tfCor);
		tfCor.setColumns(10);
		
		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corEdicao = null;

				tfCor.setText("");
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
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Save\\Save_16x16.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfCor.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe a Marca!");
					tfCor.requestFocus();
					return;
	

					
				}//Novo registro
				if (corEdicao == null) {
					corEdicao= new Cor();
					//usuarioEdicao.setCodigo(Integer.parseInt(tfCodigo.getText()));
					corEdicao.setDescricao(tfCor.getText());
					
					if (corDAO.insert(corEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, 
								"COR INSERIDO COM SUCESSO!");
						corEdicao = null;
						tfCor.setText("");
						tfCodigo.setText("");
						table.setModel(new CorTableModel(corDAO.select()));
			
					} else { // Se False
						JOptionPane.showMessageDialog(null, 
								"PROBLEMAS NA INSERÇÃO!");
						
					}
				} else {//Altera Registro
					//corEdicao.setCodigo(Integer.parseInt(tfCodigo.getText()));
					corEdicao.setDescricao(tfCor.getText());
					
					

					if (corDAO.update(corEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, 
								"ALTERADO COM SUCESSO");
						corEdicao = null;
						tfCor.setText("");
						
						tfCodigo.setText("");
						table.setModel(new CorTableModel(corDAO.select()));
					} else { // Se False
						JOptionPane.showMessageDialog(null, 
								"PROBLEMAS NA ALTERAÇÃO!");
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
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Delete\\Delete_16x16.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, 
						"Deseja realmente excluir esta Cor?") 
						== JOptionPane.YES_OPTION) {
					
					CorTableModel modelo = (CorTableModel) table.getModel();
					corEdicao = modelo.getCorPorLinha(table.getSelectedRow());
					
					if (corDAO.delete(corEdicao.getCod_cor())) {
						JOptionPane.showMessageDialog(null, 
								"EXCLUÍDO COM SUCESSO");
						corEdicao = null;
						tfCor.setText("");
						
						table.setModel(new CorTableModel(corDAO.select()));
					} else {
						JOptionPane.showMessageDialog(null, 
								"PROBLEMAS NA EXCLUSÃO");
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
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Cancel\\Cancel_16x16.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				corEdicao = null;
				tfCor.setText("");
				
				tfCor.requestFocus();
				
				
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
					 //Cast
					CorTableModel modelo = (CorTableModel) table.getModel();


					corEdicao = modelo.getCorPorLinha(table.getSelectedRow());



					tfCor.setText(corEdicao.getDescricao());
					tfCodigo.setText(String.valueOf(corEdicao.getCod_cor()));
					tfCor.requestFocus();
					
					btnNovo.setEnabled(false);
					btnSalvar.setEnabled(true);
					btnCancelar.setEnabled(true);
					btnExcluir.setEnabled(true);
					 
					

				
				}

			}
		});

		scrollPane.setViewportView(table);

		table.setModel(new CorTableModel(corDAO.select()));
		
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
