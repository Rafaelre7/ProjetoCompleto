
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import BD.Conexao;
import ENTIDADE.Marca;

public class MarcaDAO {
	public boolean insert(Marca marca) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO MARCA (DESCRICAO) VALUES (?)");
			ps.setString(1, marca.getDescricao());
			ps.execute();

			//ps.close();
			//con.close();

			return true;
		} catch (SQLException sql) {
			sql.printStackTrace();

			return false;
		}
	}

	public boolean update(Marca marca) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("UPDATE MARCA SET DESCRICAO = ? WHERE COD_MARCA  = ?");
			ps.setString(1, marca.getDescricao());
			ps.setInt(2, marca.getCod_marca());

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
					.prepareStatement("DELETE FROM MARCA WHERE COD_MARCA = ?");
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
	public ArrayList<Marca> select() {
		ArrayList<Marca> lista = new ArrayList<Marca>();
		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM MARCA");
			ResultSet rs = ps.executeQuery();

			// 0
			while (rs.next()) {
				Marca m = new Marca();
				m.setCod_marca(rs.getInt("COD_MARCA"));
				m.setDescricao(rs.getString("DESCRICAO"));
				
				

				lista.add(m);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return lista;

		}

	}
	
	
}
