package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Atestado;
import ENTIDADE.Estabelecimento;
import ENTIDADE.Equipamento;
import ENTIDADE.Marca;
import ENTIDADE.Uf;

public class AtestadoDAO {



	public boolean insert(Atestado atestado){
		Connection con = null;
		PreparedStatement ps= null;
		try {
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"INSERT INTO ATESTADO (NOME , ENDERECO , BAIRRO , CIDADE , COD_UF ,TEL_CLIENTE, "
							+ "CEL_CLIENTE , COD_PESSOA , EMAIL , CPF, RG, CEP)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			//ps.setString(1, atestado.getNome());
		
			ps.execute();

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


	public boolean update (Atestado atestado) {

		try{
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE CLIENTE SET  NOME = ?, ENDERECO = ?,"
							+ "BAIRRO = ?, CIDADE = ?, RG = ?,TEL_CLIENTE = ?, CEP = ?, "
							+ "CPF = ?, COD_UF = ?,CEL_CLIENTE = ?, EMAIL = ?, COD_PESSOA  = ? WHERE COD_CLIENTE = ?");
			//ps.setString(1, atestado.getNome());
			

			if (ps.executeUpdate() > 0){
				return true;
			}else{
				return false;
			}
		}catch (SQLException ex){
			ex.printStackTrace();
			return false;

		}
	}

	public boolean delete (int codigo){
		//Abre a conexao com o banco de dados
		try (Connection con = Conexao.getConexao()){

			//Exclusão do aluno
			try(PreparedStatement ps = con.prepareStatement(
					"DELETE FROM CLIENTE WHERE COD_ATESTADO= ?")){
				ps.setInt(1, codigo);	

				if (ps.executeUpdate() > 0){
					return true;
				}else {
					return false;
				}
			}

		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Atestado> select(){
		ArrayList<Atestado> lista = new ArrayList<Atestado>();

		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM ATESTADO");
			ResultSet rs = ps.executeQuery();

			//0
			while (rs.next()) {
				Atestado a = new Atestado();
				//e.setCod_atestado(rs.getInt("COD_ATESTADO"));
				

				Estabelecimento e = new Estabelecimento();
				e.setCod_estabelecimento(rs.getInt("COD_PESSOA"));
			
				
				
//				Marca marca = new Marca();
//				marca.setCod_uf(rs.getInt("COD_UF"));
			
//				c.set
//				c.setUf(uf);
				//lista.add(c);		
			}
			return lista;
		}catch (SQLException e){
			e.printStackTrace();
			return lista;	

		}
	//}
//	public ArrayList<Cliente> buscarFornecedorPorNome(String nome){
//		ArrayList<Cliente> lista = new ArrayList<Cliente>();
//		try {
//			Connection  con = Conexao.getConexao();
//			PreparedStatement ps = con.prepareStatement(
//					"SELECT * FROM CLIENTE WHERE NOME LIKE ?");
//			ps.setString(1, nome + "%");
//			ResultSet rs = ps.executeQuery();
//
//			while(rs.next()){
//				Cliente c = new Cliente();
//				c.setCod_Cliente(rs.getInt("COD_CLIENTE"));
//				c.setNome(rs.getString("NOME"));
//				c.setEndereco(rs.getString("ENDERECO"));
//				c.setBairro(rs.getString("BAIRRO"));
//				c.setCidade(rs.getString("CIDADE"));
//				c.setCep(rs.getString("CEP"));
//				c.setCpf(rs.getString("CPF"));
//				c.setRg(rs.getString("RG"));
//				c.setTel_Cliente(rs.getString("TEL_CLIENTE"));
//				c.setCel_Cliente(rs.getString("CEL_CLIENTE"));
//				c.setEmail(rs.getString("EMAIL"));


//				Pessoa p = new Pessoa();
//				p.setCod_pessoa(rs.getInt("COD_PESSOA"));

				/*Uf uf = new Uf();
				uf.setCod_uf(rs.getInt(""));*/

				//c.setPessoa(p);
				//c.setUf(uf);
//				lista.add(c);		
//			}
//
//		} catch (SQLException e) {       	
//			e.printStackTrace();
//		}
		//return lista;

	}

}