package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Cliente;
import ENTIDADE.Uf;



public class UfDAO {
 


	public boolean insert(Uf uf){
		Connection con = null;
		PreparedStatement ps= null;
		try {
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"INSERT INTO UF VALUES (?,?)");
			ps.setInt(1, uf.getCod_uf());
			ps.setString(2, uf.getDescricao());
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


	public boolean update (Uf uf) {
		try{
			Connection con = Conexao.getConexao();
		
			PreparedStatement ps = con.prepareStatement(
					"UPDATE UF SET  DESCRICAO = ? WHERE COD_UF = ?");
			ps.setInt(1, uf.getCod_uf());
			ps.setString(2, uf.getDescricao());
			ps.executeUpdate();

			
			return true;
		}catch (SQLException e){
			e.printStackTrace();
			return false;

		}
	}
	
	public boolean delete (int codigo){
		//Abre a conexao com o banco de dados
		try (Connection con = Conexao.getConexao()){
			//Exclusão do aluno
			try(PreparedStatement ps = con.prepareStatement(
					"DELETE FROM UF WHERE COD_UF = ?")){
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
	public ArrayList<Uf> select(){
		ArrayList<Uf> lista = new ArrayList<Uf>();

		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM UF");
			ResultSet rs = ps.executeQuery();

			//0
			while (rs.next()) {
				Uf uf = new Uf();
				uf.setCod_uf(rs.getInt("COD_UF"));
				uf.setDescricao(rs.getString("DESCRICAO"));
				 lista.add(uf);
						
			}
			return lista;
		}catch (SQLException e){
			e.printStackTrace();
			return lista;	

		}

	}
}