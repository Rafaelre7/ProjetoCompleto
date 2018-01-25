package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.w3c.dom.ls.LSInput;

import BD.Conexao;
import ENTIDADE.Fornecedor;
import ENTIDADE.Uf;

public class FornecedorDAO {

	public boolean insert(Fornecedor fornecedor){
		Connection con = null;
		PreparedStatement ps= null;
		
		try{
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"INSERT INTO FORNECEDOR (NOME_FORNECEDOR, TEL_FORNECEDOR, "
					+ " CNPJ, ENDERECO, COD_UF ,CIDADE ,CEP,BAIRRO,EMAIL,INSC_ES)VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, fornecedor.getNome_fornecedor());
			ps.setString(2, fornecedor.getTel_fornecedor());
			ps.setString(3, fornecedor.getCnpj());
			ps.setString(4, fornecedor.getEndereco());
			ps.setInt(5, fornecedor.getUf().getCod_uf());
			ps.setString(6, fornecedor.getCidade());
			ps.setString(7, fornecedor.getCep());
			ps.setString(8, fornecedor.getBairro());
			ps.setString(10, fornecedor.getInsc_es());
			ps.setString(9, fornecedor.getEmail());
			ps.execute();
			return true;
			
		}catch(SQLException e){
		  e.printStackTrace();
			
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException ex){
			}
		}
		return false;
		
	}

	public boolean update (Fornecedor fornecedor){
		Connection con = null;
		PreparedStatement ps= null;
		try{
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"UPDATE FORNECEDOR SET  NOME_FORNECEDOR = ?,"
					+ " TEL_FORNECEDOR = ?, CNPJ = ?, ENDERECO = ?, "
					+ "BAIRRO = ?, COD_UF = ?, CEP = ?, EMAIL = ?, INSC_ES = ? WHERE COD_FORNECEDOR = ?");
			
			ps.setString(1, fornecedor.getNome_fornecedor());
			ps.setString(2, fornecedor.getTel_fornecedor());
			ps.setString(3, fornecedor.getCnpj());
			ps.setString(4, fornecedor.getEndereco());
			ps.setString(5, fornecedor.getBairro());
			ps.setInt(6, fornecedor.getUf().getCod_uf());
			ps.setString(7, fornecedor.getCep());
			ps.setString(8, fornecedor.getEmail());
			ps.setString(9, fornecedor.getInsc_es());
			ps.setInt(10,fornecedor.getCod_fornecedor());
			
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{

				ps.close();
				con.close();
			}catch(SQLException ex){
			}
		}
		
		
		return false;	
	}
	
	 public boolean delete(int codigo){

	    Connection con = null;
		PreparedStatement ps= null;
		
		try{
		con = Conexao.getConexao();
		ps = con.prepareStatement(
				"DELETE FROM FORNECEDOR WHERE COD_FORNECEDOR = ?");
		ps.setInt(1, codigo);
		
		if (ps.executeUpdate() > 0){
			return true;
		}else {
			return false;
		}
		//////////////
		}catch(SQLException e){
			return false;
		}finally{
			try{

				ps.close();
				con.close();
			}catch(SQLException ex){
			}
		}
				}
	 
	 public ArrayList<Fornecedor> select(){
			ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

			try {

				Connection con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(
						"SELECT * FROM FORNECEDOR");
				ResultSet rs = ps.executeQuery();

				//0
				while (rs.next()) {
					Fornecedor f = new Fornecedor();
					f.setCod_fornecedor(rs.getInt("COD_FORNECEDOR"));
					f.setNome_fornecedor(rs.getString("NOME_FORNECEDOR"));
					f.setTel_fornecedor(rs.getString("TEL_FORNECEDOR"));
					f.setCnpj(rs.getString("CNPJ"));
					f.setBairro(rs.getString("BAIRRO"));
					f.setCidade(rs.getString("CIDADE"));
				    f.setCep(rs.getString("CEP"));
				    f.setEndereco(rs.getString("ENDERECO"));
				    f.setEmail(rs.getString("EMAIL"));
				    f.setInsc_es(rs.getString("INSC_ES"));
				   
				    Uf uf = new Uf();
				    uf.setCod_uf(rs.getInt("COD_UF"));
				    
				    f.setUf(uf);
					lista.add(f);
				}
				return lista;
			}catch (SQLException e){
				e.printStackTrace();
				return lista;	

			}

		}
	 public ArrayList<Fornecedor> buscarFornecedorPorNome(String nome){
	         ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
	        try {
	        	Connection  con = Conexao.getConexao();
	            PreparedStatement ps = con.prepareStatement(
	            		"SELECT * FROM FORNECEDOR WHERE NOME_FORNECEDOR LIKE ?");
	            ps.setString(1, nome + "%");
            	ResultSet rs = ps.executeQuery();

	            while(rs.next()){
	            	Fornecedor f = new Fornecedor();
					f.setCod_fornecedor(rs.getInt("COD_FORNECEDOR"));
					f.setNome_fornecedor(rs.getString("NOME_FORNECEDOR"));
					f.setTel_fornecedor(rs.getString("TEL_FORNECEDOR"));
					f.setCnpj(rs.getString("CNPJ"));
					f.setBairro(rs.getString("BAIRRO"));
					f.setCidade(rs.getString("CIDADE"));
				    f.setCep(rs.getString("CEP"));
				    f.setEndereco(rs.getString("ENDERECO"));
				    f.setEmail(rs.getString("EMAIL"));
				    f.setInsc_es(rs.getString("INSC_ES"));
				    Uf uf = new Uf();
				    uf.setDescricao(rs.getString("UF"));
				    
				    f.setUf(uf);
				    lista.add(f);
	            }
	          
	        } catch (SQLException e) {       	
	          e.printStackTrace();
	        }
			return lista;

	    }
}

