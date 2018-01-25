package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JInternalFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JScrollPane;

public class LeiaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeiaFrame frame = new LeiaFrame();
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
	public LeiaFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\master.jpg"));
		setTitle("                     Sobre RM.Software");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vers\u00E3o : 1.0.2  Para Windows");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(113, 23, 193, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Atualiza\u00E7\u00E3o : 13/11/2015");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(112, 59, 179, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblInformaesDaLicena = new JLabel("Informa\u00E7\u00F5es da Licen\u00E7a");
		lblInformaesDaLicena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformaesDaLicena.setBounds(53, 99, 179, 25);
		contentPane.add(lblInformaesDaLicena);
		
		JLabel lblRestamDias = new JLabel("Restam 365 Dias");
		lblRestamDias.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRestamDias.setBounds(100, 125, 117, 25);
		contentPane.add(lblRestamDias);
		
		JLabel lblInformaesDaEmpresa = new JLabel("Informa\u00E7\u00F5es da Empresa");
		lblInformaesDaEmpresa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformaesDaEmpresa.setBounds(53, 151, 179, 25);
		contentPane.add(lblInformaesDaEmpresa);
		
		JLabel lblWwwmastermaisautomacaocombr = new JLabel("www.mastermaisautomacao.com.br");
		lblWwwmastermaisautomacaocombr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWwwmastermaisautomacaocombr.setBounds(63, 190, 213, 25);
		contentPane.add(lblWwwmastermaisautomacaocombr);
		
		JLabel lblCopyrightcombr = new JLabel("\u00A9 2014 - 2015  Copyright  RM SOFTWARE");
		lblCopyrightcombr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCopyrightcombr.setBounds(38, 226, 236, 25);
		contentPane.add(lblCopyrightcombr);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Bslsn\u00E7s\\Desktop\\Programa\u00E7\u00E3o\\Novo Projeto\\icones\\logomastermais3.jpg"));
		label.setBounds(15, 11, 88, 77);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 102, 213, 48);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
	}
}
