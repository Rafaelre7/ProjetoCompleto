
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import BD.Conexao;
import ENTIDADE.Modelo;

public class ModeloDAO {
	public boolean insert(Modelo MODELO) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO MODELO (DESCRICAO) VALUES (?)");
			ps.setString(1, MODELO.getDescricao());
			ps.execute();

			//ps.close();
			//con.close();

			return true;
		} catch (SQLException sql) {
			sql.printStackTrace();

			return false;
		}
	}

	public boolean update(Modelo MODELO) {
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("UPDATE MODELO SET DESCRICAO = ? WHERE COD_MODELO  = ?");
			ps.setString(1, MODELO.getDescricao());
			ps.setInt(2, MODELO.getCod_modelo());

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
					.prepareStatement("DELETE FROM MODELO WHERE COD_MODELO = ?");
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
	public ArrayList<Modelo> select() {
		ArrayList<Modelo> lista = new ArrayList<Modelo>();
		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM MODELO");
			ResultSet rs = ps.executeQuery();

			// 0
			while (rs.next()) {
				Modelo m = new Modelo();
				m.setCod_modelo(rs.getInt("COD_MODELO"));
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
