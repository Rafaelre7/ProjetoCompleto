package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Perfil;

public class PerfilDAO {
	
	public ArrayList<Perfil> select(){
		ArrayList<Perfil> lista = new ArrayList<Perfil>();

		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM PERFIL");
			ResultSet rs = ps.executeQuery();

			//0
			while (rs.next()) {
				Perfil p = new Perfil();
				p.setCod_perfil(rs.getInt("COD_PERFIL"));
				p.setNome_perfil(rs.getString("NOME_PERFIL"));
				lista.add(p);
						
			}
			return lista;
		}catch (SQLException e){
			e.printStackTrace();
			return lista;	

		}

	}
}
