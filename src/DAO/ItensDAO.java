package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Itens;
import ENTIDADE.Produtos;

public class ItensDAO {
	
	public ArrayList<Itens> select(){
		ArrayList<Itens> lista = new ArrayList<Itens>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		
		try{
		con = Conexao.getConexao();
		ps  = con.prepareStatement("SELECT V.COD_VENDA , P.COD_PRODUTO, P.DESCRICAO,"
				+ "I.QUANTIDADE, I.VENDA_TOTAL FROM ITENS I INNER JOIN P PRODUTOS ON");
		rs = ps.executeQuery();
		while (rs.next()) {
			Itens i = new Itens();
			
			
		}
		
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}

}
