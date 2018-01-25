package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.w3c.dom.ls.LSInput;

import BD.Conexao;
import ENTIDADE.Estabelecimento;
import ENTIDADE.Uf;

public class EstabelecimentoDAO {

	public boolean insert(Estabelecimento estabelecimento){
		Connection con = null;
		PreparedStatement ps= null;
		
		try{
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"INSERT INTO ESTABELECIMENTO ( NOME_ESTABELECIMENTO, TEL_ESTABELECIMENTO, "
					+ " CNPJ, ENDERECO, COD_UF ,CIDADE ,CEP,BAIRRO,EMAIL,INSC_ES)VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, estabelecimento.getNome_estabelecimento());
			ps.setString(2, estabelecimento.getTel_estabelecimento());
			ps.setString(3, estabelecimento.getCnpj());
			ps.setString(4, estabelecimento.getEndereco());
			ps.setInt(5, estabelecimento.getUf().getCod_uf());
			ps.setString(6, estabelecimento.getCidade());
			ps.setString(7, estabelecimento.getCep());
			ps.setString(8, estabelecimento.getBairro());
			ps.setString(10, estabelecimento.getInsc_es());
			ps.setString(9, estabelecimento.getEmail());
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

	public boolean update (Estabelecimento estabelecimento){
		Connection con = null;
		PreparedStatement ps= null;
		try{
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"UPDATE ESTABELECIMENTO SET  NOME_ESTABELECIMENTO = ?,"
					+ " TEL_ESTABELECIMENTO = ?, CNPJ = ?, ENDERECO = ?, "
					+ "BAIRRO = ?, COD_UF = ?, CEP = ?, EMAIL = ?, INSC_ES = ?,  WHERE CCOD_ESTABELECIMENTO = ?");
		
			ps.setString(1, estabelecimento.getNome_estabelecimento());
			ps.setString(2, estabelecimento.getTel_estabelecimento());
			ps.setString(3, estabelecimento.getCnpj());
			ps.setString(4, estabelecimento.getEndereco());
			ps.setString(5, estabelecimento.getBairro());
			ps.setInt(6, estabelecimento.getUf().getCod_uf());
			ps.setString(7, estabelecimento.getCep());
			ps.setString(8, estabelecimento.getEmail());
			ps.setString(9, estabelecimento.getInsc_es());
			ps.setInt(10,estabelecimento.getCod_estabelecimento());
			
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
				"DELETE FROM ESTABELECIMENTO WHERE COD_ESTABELECIMENTO = ?");
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
	 
	 public ArrayList<Estabelecimento> select(){
			ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();

			try {

				Connection con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(
						"SELECT * FROM ESTABELECIMENTO");
				ResultSet rs = ps.executeQuery();

				//0
				while (rs.next()) {
					Estabelecimento f = new Estabelecimento();
					f.setCod_estabelecimento(rs.getInt("COD_ESTABELECIMENTO"));
					f.setNome_estabelecimento(rs.getString("NOME_ESTABELECIMENTO"));
					f.setTel_estabelecimento(rs.getString("TEL_ESTABELECIMENTO"));
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
	 public ArrayList<Estabelecimento> buscarEstabelecimentoPorNome(String nome){
	         ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();
	        try {
	        	Connection  con = Conexao.getConexao();
	            PreparedStatement ps = con.prepareStatement(
	            		"SELECT * FROM ESTABELECIMENTO WHERE NOME_ESTABELECIMENTO LIKE ?");
	            ps.setString(1, nome + "%");
            	ResultSet rs = ps.executeQuery();

	            while(rs.next()){
	            	Estabelecimento f = new Estabelecimento();
					f.setCod_estabelecimento(rs.getInt("COD_ESTABELECIMENTO"));
					f.setNome_estabelecimento(rs.getString("NOME_ESTABELECIMENTO"));
					f.setTel_estabelecimento(rs.getString("TEL_ESTABELECIMENTO"));
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

