
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BD.Conexao;
import ENTIDADE.Cliente;
import ENTIDADE.Perfil;
import ENTIDADE.Usuario;

public class UsuarioDAO {
	public boolean insert(Usuario usuario) {
		try {
			Connection con = Conexao.getConexao();
		
			PreparedStatement ps = con.prepareStatement("INSERT INTO LOGIN (nome_usuario,email_login,cpf,cod_perfil,senha,conf_senha) "
					+ "VALUES (?,?,?,?,?,?)");
			
			ps.setString(1,  usuario.getNome_usuario());
			ps.setString(2,  usuario.getEmail_login());
			ps.setString(3 , usuario.getCpf());
			ps.setInt(4,     usuario.getPerfil().getCod_perfil());
			ps.setString(5,  usuario.getSenha());
			ps.setString(6,  usuario.getConf_senha());
			ps.execute();

			

			return true;
		} catch (SQLException sql) {
			sql.printStackTrace();

			return false;
		}
	}

	public boolean update(Usuario usuario) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement("UPDATE LOGIN SET nome_usuario = ? , email_login = ?, cpf = ?"
					+" cod_perfil = ? ,senha = ? ,conf_senha = ? WHERE cod_usuario  = ? " );
		 
			 
			ps.setString(1,  usuario.getNome_usuario());
			ps.setString(2,  usuario.getEmail_login());
			ps.setString(3 , usuario.getCpf());
			ps.setInt(4,     usuario.getPerfil().getCod_perfil());
			ps.setString(5,  usuario.getSenha());
			ps.setString(6,  usuario.getConf_senha());
			ps.setInt(7, usuario.getCod_usuario());

			if (ps.executeUpdate() > 0) {
				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int codigo) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(" delete from login where cod_usuario = ?");
			ps.setInt(1, codigo);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Usuario> select() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM LOGIN");
			ResultSet rs = ps.executeQuery();

			// 0
			while (rs.next()) {
			
				Usuario u = new Usuario();
				
				u.setNome_usuario(rs.getString("NOME_USUARIO"));
				u.setEmail_login(rs.getString("EMAIL_LOGIN"));
				u.setCpf(rs.getString("CPF"));
				u.setSenha(rs.getString("SENHA"));
				u.setConf_senha(rs.getString("CONF_SENHA"));
				u.setCod_usuario(rs.getInt("COD_USUARIO"));

				Perfil pe = new Perfil();
				
				pe.setCod_perfil(rs.getInt("COD_PERFIL"));
				
				u.setPerfil(pe);
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return lista;

		}

	}

//	public Usuario buscarUsuario(String usuario, String senha) {
//		try (Connection conex = Conexao.getConexao();
//				PreparedStatement sqlSelect = conex
//						.prepareStatement("SELECT * FROM LOGIN " + "WHERE USUARIO = ? AND SENHA = ?")) {
//			sqlSelect.setString(1, usuario);
//			sqlSelect.setString(2, senha);
//			try (ResultSet sqlResult = sqlSelect.executeQuery()) {
//				while (sqlResult.next()) {
//					Usuario usu = new Usuario();
//					usu.setUsuario(sqlResult.getString("USUARIO"));
//					usu.setSenha(sqlResult.getString("SENHA"));
//					return usu;
//				}
//			}
//			return null;
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			return null;
//
//		}
//	}
//
//	public static void main(String[] args) {
//		UsuarioDAO uDAO = new UsuarioDAO();
//		Usuario usuario = null;
//		usuario = uDAO.buscarUsuario("RAFA", "RAFA");
//		if (usuario == null) {
//			JOptionPane.showMessageDialog(null, "Usuario ou senha ivalidos!");
//		} else {
//			JOptionPane.showMessageDialog(null, "Usuario encontrado");
//		}
//	}
}