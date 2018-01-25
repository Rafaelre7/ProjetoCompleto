package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Cliente;
import ENTIDADE.FormaPagamento;
import ENTIDADE.Itens;
import ENTIDADE.Produtos;
import ENTIDADE.Uf;
import ENTIDADE.Usuario;
import ENTIDADE.Venda;

public class VendasDAO {

	public boolean insert(Venda venda){
		Connection con = null;
		PreparedStatement ps= null;
		try {
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"INSERT INTO VENDAS (DATA_COMPRA , CLIENTE , "
							+ "FORMA_PAGAMENTO , USUARIO , DESCONTO , TOTAL) VALUES (?,?,?,?,?,?)");
			ps.setDate(1, new java.sql.Date(venda.getData_Compra().getTime()));
			ps.setString(2, venda.getCliente().getNome());
			ps.setString(3, venda.getFormaPagamento().getDescricao());
			ps.setInt(4, venda.getUsuario().getCod_usuario());
			ps.setDouble(5, venda.getDesconto());
			ps.setDouble(6, venda.getTotal());
			ps.execute();

			// Codigo para recuperar o id gerado para a ultima venda inserida

			if(!venda.getIntensList().isEmpty()){
				for(Itens i : venda.getIntensList()){//Existem Intens
					try{
						ps = con.prepareStatement(
								"INSERT INTO ITENS (COD_VENDA, DESCRICAO, VALOR_VENDA , QUANTIDADE , "
										+ "VALOR_TOTAL) VALUES(?,?,?,?,?)");
						ps.setInt(1, i.getCod_venda());
						ps.setString(2, i.getDescricao());
						ps.setDouble(3, i.getValor_venda());
						ps.setInt(4, i.getQuantidade());
						ps.setDouble(5, i.getValor_total());
						ps.execute();
						ps.close();
					}catch(SQLException ex){
						ex.printStackTrace();
					}

				}
			}//final
			return true;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			try{

				ps.close();
				con.close();
			}catch(SQLException ex){
			}
		}
	}

	public ArrayList<Venda> select(){
		ArrayList<Venda> lista = new ArrayList<Venda>();

		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"SELECT V.CODIGO , V.DATA_COMPRA , "
					+ "V.TOTAL, C.NOME, L.USUARIO "
					+ "FROM VENDAS V "
					+ "INNER JOIN CLIENTE C ON C.NOME = V.CLIENTE"
					+ "   INNER JOIN LOGIN L ON L.USUARIO =  V.USUARIO");
			ResultSet rs = ps.executeQuery();

			//0
			while (rs.next()) {
				Venda v = new Venda();
				v.setCodigo(rs.getInt("CODIGO"));
				v.setData_Compra(rs.getDate("DATA_COMPRA"));
				v.setTotal(rs.getDouble("TOTAL"));

				Cliente c = new Cliente();
				c.setNome(rs.getString("NOME"));

//				Usuario u = new Usuario();
//				u.setUsuario(rs.getString("USUARIO"));

				v.setCliente(c);
		//		v.setUsuario(u);
				lista.add(v);

			}
			return lista;
		}catch (SQLException e){
			e.printStackTrace();
			return lista;	

		}

	}
	public ArrayList<Venda> pesquisarPorNome(String nome) {
		ArrayList<Venda> lista = new ArrayList<Venda>();
		
		try {
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con
					.prepareStatement("SELECT V.CODIGO , V.DATA_COMPRA , "
							+ "V.TOTAL, C.NOME, L.USUARIO "
							+ "FROM VENDAS V "
							+ "INNER JOIN CLIENTE C ON C.NOME = V.CLIENTE"
							+ "   INNER JOIN LOGIN L ON L.USUARIO =  V.USUARIO WHERE C.NOME LIKE ?");
			ps.setString(1, nome + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Venda v = new Venda();
				v.setCodigo(rs.getInt("CODIGO"));
				v.setData_Compra(rs.getDate("DATA_COMPRA"));
				v.setTotal(rs.getDouble("TOTAL"));
				Cliente c = new Cliente();
				c.setNome(rs.getString("NOME"));

//				Usuario1 u = new Usuario1();
//				u.setUsuario(rs.getString("USUARIO"));

				v.setCliente(c);
				//v.setUsuario(u); 
				
				lista.add(v);
			}
			
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}