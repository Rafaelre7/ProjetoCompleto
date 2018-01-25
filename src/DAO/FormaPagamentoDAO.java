
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.FormaPagamento;

public class FormaPagamentoDAO {
	
	public ArrayList<FormaPagamento> select() {
		ArrayList<FormaPagamento> lista = new ArrayList<FormaPagamento>();
		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM FORMA_PAGAMENTO");
			ResultSet rs = ps.executeQuery();

			// 0
			while (rs.next()) {
				FormaPagamento f = new FormaPagamento();
				f.setCodigo(rs.getInt("CODIGO"));
				f.setDescricao(rs.getString("DESCRICAO"));
				
				

				lista.add(f);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return lista;

		}

	}
	

}