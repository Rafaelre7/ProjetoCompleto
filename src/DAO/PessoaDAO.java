package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Pessoa;
import ENTIDADE.Uf;

public class PessoaDAO {
	public ArrayList<Pessoa> select(){
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM PESSOA");
			ResultSet rs = ps.executeQuery();

			//0
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setCod_pessoa(rs.getInt("COD_PESSOA"));
				p.setDescricao(rs.getString("DESCRICAO"));
				lista.add(p);
						
			}
			return lista;
		}catch (SQLException e){
			e.printStackTrace();
			return lista;	

		}

	}
}
