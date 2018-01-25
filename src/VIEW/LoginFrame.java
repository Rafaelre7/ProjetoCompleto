package VIEW;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import ENTIDADE.Usuario;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JTextField tfUsuario;
	private JButton btnLogar;
	private JButton btnSair;
	private	UsuarioDAO uDAO = new UsuarioDAO ();
	private JPasswordField passwordField;
	private JLabel lblLoginDoUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("SYSTECH SISTEMAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 344);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setIcon(new ImageIcon(LoginFrame.class.getResource("/IMG/Open/Open_16x16.png")));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(241, 97, 86, 14);
		contentPane.add(lblUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setIcon(new ImageIcon(LoginFrame.class.getResource("/IMG/Key/Key_16x16.png")));
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(241, 153, 86, 19);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(333, 95, 256, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogar.setIcon(new ImageIcon("C:\\Users\\rafae\\Desktop\\Rafael T.I\\Projetos java\\Icones\\icones\\must_have_icons_icons_pack_120704\\must_have_icon_set\\Log Out\\Log Out_16x16.png"));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = tfUsuario.getText();
				String senha = new String(passwordField.getPassword());
				
				Usuario usu= null;
	//			usu = uDAO.buscarUsuario(usuario, senha);
				if(usu == null){
					JOptionPane.showMessageDialog(null, "Usuario ou senha ivalidos!");
				}else{
					MenuFrame mf = new MenuFrame();
					mf.setVisible(true);
					
					setVisible(false);
				}
				
				
			}
		});
		btnLogar.setBounds(164, 226, 107, 36);
		contentPane.add(btnLogar);
		
		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(LoginFrame.class.getResource("/IMG/Delete/Delete_24x24.png")));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		btnSair.setBounds(435, 226, 97, 36);
		contentPane.add(btnSair);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(333, 153, 260, 20);
		contentPane.add(passwordField);
		
		lblLoginDoUsuario = new JLabel("Login");
		lblLoginDoUsuario.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\must_have_icon_set\\Log Out\\Log Out_16x16.png"));
		lblLoginDoUsuario.setForeground(Color.BLACK);
		lblLoginDoUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoginDoUsuario.setBounds(255, 11, 73, 50);
		contentPane.add(lblLoginDoUsuario);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rafae\\Desktop\\Sys c\u00F3pia.PNG"));
		lblNewLabel.setBounds(30, 32, 207, 175);
		contentPane.add(lblNewLabel);
	}
}
