
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import BD.Conexao;
import ENTIDADE.Cor;

public class CorDAO {
	public boolean insert(Cor cor) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO COR (DESCRICAO) VALUES (?)");
			ps.setString(1, cor.getDescricao());
			ps.execute();

			//ps.close();
			//con.close();

			return true;
		} catch (SQLException sql) {
			sql.printStackTrace();

			return false;
		}
	}

	public boolean update(Cor cor) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("UPDATE COR SET DESCRICAO = ? WHERE COD_COR  = ?");
			ps.setString(1, cor.getDescricao());
			ps.setInt(2, cor.getCod_cor());

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
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM Cor WHERE COD_COR = ?");
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
	public ArrayList<Cor> select() {
		ArrayList<Cor> lista = new ArrayList<Cor>();
		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM COR");
			ResultSet rs = ps.executeQuery();

			// 0
			while (rs.next()) {
				Cor c = new Cor();
				c.setCod_cor(rs.getInt("COD_COR"));
				c.setDescricao(rs.getString("NOME_COR"));
				
				

				lista.add(c);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return lista;

		}

	}
	
	
}
