package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Cliente;
import ENTIDADE.Fornecedor;
import ENTIDADE.Produtos;
import ENTIDADE.Uf;

public class ProdutosDAO {

	public boolean insert (Produtos produtos){
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
		con = Conexao.getConexao();
		ps = con.prepareStatement(
				"INSERT INTO PRODUTOS (DESCRICAO, COD_BARRAS, COD_FORNECEDOR,"
				+ " VALOR_COMPRA ,VALOR_VENDA) VALUES (?,?,?,?,?)");
		
		ps.setString(1, produtos.getDescricao());
		ps.setString(2, produtos.getCod_barras());
		ps.setInt(3, produtos.getFornecedor().getCod_fornecedor());
		ps.setInt(4, produtos.getValor_compra());
		ps.setInt(5, produtos.getValor_venda());
		ps.execute();
		return true;
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
    
	public boolean update (Produtos produtos){
		Connection con = null;
		PreparedStatement sqlUpdate = null;
		
		try{
			con = Conexao.getConexao();
			sqlUpdate = con.prepareStatement(
					"UPDATE PRODUTOS SET DESCRICAO = ?,COD_BARRAS = ?,  COD_FORNECEDOR = ?,"
					+ " VALOR_COMPRA = ?, VALOR_VENDA = ? WHERE COD_PRODUTO = ?");
			sqlUpdate.setString(1, produtos.getDescricao());
			sqlUpdate.setString(2, produtos.getCod_barras());
			sqlUpdate.setInt(3, produtos.getFornecedor().getCod_fornecedor());
			sqlUpdate.setInt(4, produtos.getValor_compra());
			sqlUpdate.setInt(5, produtos.getValor_venda());
			sqlUpdate.setInt(6, produtos.getCod_produto());
			
			if(sqlUpdate.executeUpdate() > 0){
				return true;	
			}
			else{
				return false;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean delete(int codigo){
		Connection con = null;
		PreparedStatement sqlDelete = null;
		
		try{
			con = Conexao.getConexao();
			sqlDelete = con.prepareCall(
					"DELETE FROM PRODUTOS WHERE COD_PRODUTO = ?");
			
			sqlDelete.setInt(1, codigo);
			
			if(sqlDelete.executeUpdate() > 0){
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
		
	}

	public ArrayList<Produtos> select(){
		ArrayList<Produtos> lista = new ArrayList<Produtos>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			con = Conexao.getConexao();
			ps  = con.prepareStatement(
					"SELECT * FROM PRODUTOS");
			 rs = ps.executeQuery();

			//0
			while (rs.next()) {
				Produtos p = new Produtos();
				p.setCod_produto(rs.getInt("COD_PRODUTO"));
				p.setDescricao(rs.getString("DESCRICAO"));
				p.setCod_barras(rs.getString("COD_BARRAS"));
				p.setValor_compra(rs.getInt("VALOR_COMPRA"));
				p.setValor_venda(rs.getInt("VALOR_VENDA"));
				
				Fornecedor f = new Fornecedor();
				f.setCod_fornecedor(rs.getInt("COD_FORNECEDOR"));
			
				
				p.setFornecedor(f);

				lista.add(p);
			}
			return lista;
		}catch (SQLException e){
			e.printStackTrace();
			return lista;	

		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if( ps != null){
					ps.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

	}
	 public ArrayList<Produtos> buscarFornecedorPorNome(String descricao){
         ArrayList<Produtos> lista = new ArrayList<Produtos>();
        try {
        	Connection  con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(
            		"SELECT P.COD_PRODUTO, P.DESCRICAO, COD_BARRAS , P.VALOR_COMPRA, P.VALOR_VENDA,"
        					+ "F.COD_FORNECEDOR, F.NOME_FORNECEDOR, F.TEL_FORNECEDOR, F.CNPJ "
        					+ "FROM PRODUTOS P INNER JOIN FORNECEDOR F ON P.COD_FORNECEDOR = F.COD_FORNECEDOR WHERE DESCRICAO LIKE ?");
            ps.setString(1, descricao + "%");
        	ResultSet rs = ps.executeQuery();

            while(rs.next()){
            	Produtos p = new Produtos();
				p.setCod_produto(rs.getInt("COD_PRODUTO"));
				p.setDescricao(rs.getString("DESCRICAO"));
				p.setCod_barras(rs.getString("COD_BARRAS"));
				p.setValor_compra(rs.getInt("VALOR_COMPRA"));
				p.setValor_venda(rs.getInt("VALOR_VENDA"));
				
				Fornecedor f = new Fornecedor();
				f.setCod_fornecedor(rs.getInt("COD_FORNECEDOR"));
				f.setNome_fornecedor(rs.getString("NOME_FORNECEDOR"));
				f.setTel_fornecedor(rs.getString("TEL_FORNECEDOR"));
				f.setCnpj(rs.getString("CNPJ"));
				p.setFornecedor(f);

				lista.add(p);
            }
          
        } catch (SQLException e) {       	
          e.printStackTrace();
        }
		return lista;

    }

}
