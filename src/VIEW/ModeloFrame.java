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


import DAO.ModeloDAO;

import ENTIDADE.Modelo;

import MODEL.ModeloTableModel;
import MODEL.ModeloTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPasswordField;


public class ModeloFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfModelo;
	private Modelo modeloEdicao;
	private ModeloDAO modeloDAO = new ModeloDAO();
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
					ModeloFrame frame = new ModeloFrame();
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
	public ModeloFrame() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setType(Type.POPUP);
		setTitle("Cadastro de Modelos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Modelo");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(8, 74, 83, 20);
		contentPane.add(lblUsuario);
		
		tfModelo = new JTextField();
		tfModelo.setBounds(10, 98, 218, 20);
		contentPane.add(tfModelo);
		tfModelo.setColumns(10);
		
		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Add\\Add_16x16.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloEdicao = null;

				tfModelo.setText("");
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
				if(tfModelo.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Informe a Marca!");
					tfModelo.requestFocus();
					return;
	

					
				}//Novo registro
				if (modeloEdicao == null) {
					modeloEdicao= new Modelo();
					//usuarioEdicao.setCodigo(Integer.parseInt(tfCodigo.getText()));
					modeloEdicao.setDescricao(tfModelo.getText());
					
					if (modeloDAO.insert(modeloEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, 
								"MODELO INSERIDO COM SUCESSO!");
						modeloEdicao = null;
						tfModelo.setText("");
						tfCodigo.setText("");
						table.setModel(new ModeloTableModel(modeloDAO.select()));
			
					} else { // Se False
						JOptionPane.showMessageDialog(null, 
								"PROBLEMAS NA INSERÇÃO!");
						
					}
				} else {//Altera Registro
					//modeloEdicao.setCodigo(Integer.parseInt(tfCodigo.getText()));
					modeloEdicao.setDescricao(tfModelo.getText());
					
					

					if (modeloDAO.update(modeloEdicao)) { // Se True
						JOptionPane.showMessageDialog(null, 
								"ALTERADO COM SUCESSO");
						modeloEdicao = null;
						tfModelo.setText("");
						
						tfCodigo.setText("");
						table.setModel(new ModeloTableModel(modeloDAO.select()));
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
						"Deseja realmente excluir este Modelo?") 
						== JOptionPane.YES_OPTION) {
					
					ModeloTableModel modelo = (ModeloTableModel) table.getModel();
					modeloEdicao = modelo.getModeloPorLinha(table.getSelectedRow());
					
					if (modeloDAO.delete(modeloEdicao.getCod_modelo())) {
						JOptionPane.showMessageDialog(null, 
								"EXCLUÍDO COM SUCESSO");
						modeloEdicao = null;
						tfModelo.setText("");
						
						table.setModel(new ModeloTableModel(modeloDAO.select()));
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
				modeloEdicao = null;
				tfModelo.setText("");
				
				tfModelo.requestFocus();
				
				
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
					ModeloTableModel modelo = (ModeloTableModel) table.getModel();


					modeloEdicao = modelo.getModeloPorLinha(table.getSelectedRow());



					tfModelo.setText(modeloEdicao.getDescricao());
					tfCodigo.setText(String.valueOf(modeloEdicao.getCod_modelo()));
					tfModelo.requestFocus();
					
					btnNovo.setEnabled(false);
					btnSalvar.setEnabled(true);
					btnCancelar.setEnabled(true);
					btnExcluir.setEnabled(true);
					 
					

				
				}

			}
		});

		scrollPane.setViewportView(table);

		table.setModel(new ModeloTableModel(modeloDAO.select()));
		
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
