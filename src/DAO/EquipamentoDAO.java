//package DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.w3c.dom.ls.LSInput;
//
//import BD.Conexao;
//import ENTIDADE.Equipamento;
//import ENTIDADE.Modelo;
//
//public class EquipamentoDAO {
//
//	public boolean insert(Equipamento Equipamento){
//		Connection con = null;
//		PreparedStatement ps= null;
//		
//		try{
//			con = Conexao.getConexao();
//			ps = con.prepareStatement(
//					"INSERT INTO EQUIPAMENTO ( DATA_COMPRA, DESCRICAO, "
//					+ " COD_MODELO, COD_MARCA,SERIE,  COD_COR ,QUANTIDADE ,OBSERVACOES)VALUES (?,?,?,?,?,?,?,?)");
//			ps.setString(1, Equipamento.getData_compra());
//			ps.setString(2, Equipamento.getDescricao());
//			ps.setInt(3, Equipamento.getModelo().getCod_modelo());
//			ps.setInt(4, Equipamento.getCod_marca());
//			ps.setString(5, Equipamento.getUf().getCod_uf());
//			ps.setString(6, Equipamento.getCidade());
//			ps.setString(7, Equipamento.getCep());
//			ps.setString(8, Equipamento.getBairro());
//			ps.setString(10, Equipamento.getInsc_es());
//			ps.setString(9, Equipamento.getEmail());
//			ps.execute();
//			return true;
//			
//		}catch(SQLException e){
//		  e.printStackTrace();
//			
//		}finally{
//			try{
//				ps.close();
//				con.close();
//			}catch(SQLException ex){
//			}
//		}
//		return false;
//		
//	}
//
//	public boolean update (Equipamento Equipamento){
//		Connection con = null;
//		PreparedStatement ps= null;
//		try{
//			con = Conexao.getConexao();
//			ps = con.prepareStatement(
//					"UPDATE Equipamento SET  NOME_Equipamento = ?,"
//					+ " TEL_Equipamento = ?, CNPJ = ?, ENDERECO = ?, "
//					+ "BAIRRO = ?, COD_UF = ?, CEP = ?, EMAIL = ?, INSC_ES = ?,  WHERE CCOD_Equipamento = ?");
//		
//			ps.setString(1, Equipamento.getNome_Equipamento());
//			ps.setString(2, Equipamento.getTel_Equipamento());
//			ps.setString(3, Equipamento.getCnpj());
//			ps.setString(4, Equipamento.getEndereco());
//			ps.setString(5, Equipamento.getBairro());
//			ps.setInt(6, Equipamento.getUf().getCod_uf());
//			ps.setString(7, Equipamento.getCep());
//			ps.setString(8, Equipamento.getEmail());
//			ps.setString(9, Equipamento.getInsc_es());
//			ps.setInt(10,Equipamento.getCod_Equipamento());
//			
//			ps.executeUpdate();
//			return true;
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			try{
//
//				ps.close();
//				con.close();
//			}catch(SQLException ex){
//			}
//		}
//		
//		
//		return false;	
//	}
//	
//	 public boolean delete(int codigo){
//
//	    Connection con = null;
//		PreparedStatement ps= null;
//		
//		try{
//		con = Conexao.getConexao();
//		ps = con.prepareStatement(
//				"DELETE FROM Equipamento WHERE COD_Equipamento = ?");
//		ps.setInt(1, codigo);
//		
//		if (ps.executeUpdate() > 0){
//			return true;
//		}else {
//			return false;
//		}
//		//////////////
//		}catch(SQLException e){
//			return false;
//		}finally{
//			try{
//
//				ps.close();
//				con.close();
//			}catch(SQLException ex){
//			}
//		}
//				}
//	 
//	 public ArrayList<Equipamento> select(){
//			ArrayList<Equipamento> lista = new ArrayList<Equipamento>();
//
//			try {
//
//				Connection con = Conexao.getConexao();
//				PreparedStatement ps = con.prepareStatement(
//						"SELECT * FROM Equipamento");
//				ResultSet rs = ps.executeQuery();
//
//				//0
//				while (rs.next()) {
//					Equipamento f = new Equipamento();
//					f.setCod_Equipamento(rs.getInt("COD_Equipamento"));
//					f.setNome_Equipamento(rs.getString("NOME_Equipamento"));
//					f.setTel_Equipamento(rs.getString("TEL_Equipamento"));
//					f.setCnpj(rs.getString("CNPJ"));
//					f.setBairro(rs.getString("BAIRRO"));
//					f.setCidade(rs.getString("CIDADE"));
//				    f.setCep(rs.getString("CEP"));
//				    f.setEndereco(rs.getString("ENDERECO"));
//				    f.setEmail(rs.getString("EMAIL"));
//				    f.setInsc_es(rs.getString("INSC_ES"));
//				   
//				    Uf uf = new Uf();
//				    uf.setCod_uf(rs.getInt("COD_UF"));
//				    
//				    f.setUf(uf);
//					lista.add(f);
//				}
//				return lista;
//			}catch (SQLException e){
//				e.printStackTrace();
//				return lista;	
//
//			}
//
//		}
//	 public ArrayList<Equipamento> buscarEquipamentoPorNome(String nome){
//	         ArrayList<Equipamento> lista = new ArrayList<Equipamento>();
//	        try {
//	        	Connection  con = Conexao.getConexao();
//	            PreparedStatement ps = con.prepareStatement(
//	            		"SELECT * FROM Equipamento WHERE NOME_Equipamento LIKE ?");
//	            ps.setString(1, nome + "%");
//            	ResultSet rs = ps.executeQuery();
//
//	            while(rs.next()){
//	            	Equipamento f = new Equipamento();
//					f.setCod_Equipamento(rs.getInt("COD_Equipamento"));
//					f.setNome_Equipamento(rs.getString("NOME_Equipamento"));
//					f.setTel_Equipamento(rs.getString("TEL_Equipamento"));
//					f.setCnpj(rs.getString("CNPJ"));
//					f.setBairro(rs.getString("BAIRRO"));
//					f.setCidade(rs.getString("CIDADE"));
//				    f.setCep(rs.getString("CEP"));
//				    f.setEndereco(rs.getString("ENDERECO"));
//				    f.setEmail(rs.getString("EMAIL"));
//				    f.setInsc_es(rs.getString("INSC_ES"));
//				    Uf uf = new Uf();
//				    uf.setDescricao(rs.getString("UF"));
//				    
//				    f.setUf(uf);
//				    lista.add(f);
//	            }
//	          
//	        } catch (SQLException e) {       	
//	          e.printStackTrace();
//	        }
//			return lista;
//
//	    }
//}
//
