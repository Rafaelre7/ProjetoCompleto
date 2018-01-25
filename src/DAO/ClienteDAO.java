package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conexao;
import ENTIDADE.Cliente;
import ENTIDADE.Fornecedor;
import ENTIDADE.Pessoa;
import ENTIDADE.Uf;

public class ClienteDAO {



	public boolean insert(Cliente cliente){
		Connection con = null;
		PreparedStatement ps= null;
		try {
			con = Conexao.getConexao();
			ps = con.prepareStatement(
					"INSERT INTO CLIENTE (NOME , ENDERECO , BAIRRO , CIDADE , COD_UF ,TEL_CLIENTE, "
							+ "CEL_CLIENTE , COD_PESSOA , EMAIL , CPF, RG, CEP)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getBairro());
			ps.setString(4, cliente.getCidade());
			ps.setInt(5, cliente.getUf().getCod_uf());
			ps.setString(6, cliente.getTel_Cliente());
			ps.setString(7, cliente.getCel_Cliente());
			ps.setInt(8, cliente.getPessoa().getCod_pessoa());
			ps.setString(9, cliente.getEmail());
			ps.setString(10, cliente.getCpf());
			ps.setString(11, cliente.getRg());
			ps.setString(12, cliente.getCep());
			
			



			ps.setString(11, cliente.getEmail());
			ps.setInt(12, cliente.getPessoa().getCod_pessoa());
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


	public boolean update (Cliente cliente) {

		try{
			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE CLIENTE SET  NOME = ?, ENDERECO = ?,"
							+ "BAIRRO = ?, CIDADE = ?, RG = ?,TEL_CLIENTE = ?, CEP = ?, "
							+ "CPF = ?, COD_UF = ?,CEL_CLIENTE = ?, EMAIL = ?, COD_PESSOA  = ? WHERE COD_CLIENTE = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getBairro());
			ps.setString(4, cliente.getCidade());
			ps.setString(5, cliente.getRg());
			ps.setString(6, cliente.getTel_Cliente());
			ps.setString(7, cliente.getCep());
			ps.setString(8, cliente.getCpf());
			ps.setInt(9, cliente.getUf().getCod_uf());
			ps.setString(10, cliente.getCel_Cliente());
			ps.setString(11, cliente.getEmail());
			ps.setInt(12, cliente.getPessoa().getCod_pessoa());
			ps.setInt(13, cliente.getCod_Cliente());

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
					"DELETE FROM CLIENTE WHERE COD_CLIENTE= ?")){
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

	public ArrayList<Cliente> select(){
		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		try {

			Connection con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM CLIENTE");
			ResultSet rs = ps.executeQuery();

			//0
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setCod_Cliente(rs.getInt("COD_CLIENTE"));
				c.setNome(rs.getString("NOME"));
				c.setEndereco(rs.getString("ENDERECO"));
				c.setBairro(rs.getString("BAIRRO"));
				c.setCidade(rs.getString("CIDADE"));
				//c.getCod_uf(rs.getInt("COD_UF"));
				c.setCep(rs.getString("CEP"));
				c.setCpf(rs.getString("CPF"));
				c.setRg(rs.getString("RG"));
				c.setTel_Cliente(rs.getString("TEL_CLIENTE"));
				c.setCel_Cliente(rs.getString("CEL_CLIENTE"));
				c.setEmail(rs.getString("EMAIL"));

				Pessoa p = new Pessoa();
				p.setCod_pessoa(rs.getInt("COD_PESSOA"));
			//	p.setDescricao(rs.getString("DESCRICAO"));
			/*	p.setCod_pessoa(Integer.(Cod_pessoa.getInt()));
				//produtosEdicao.setValor_compra(Integer.parseInt(VCtextField.getText()));*/
				
				
				Uf uf = new Uf();
				uf.setCod_uf(rs.getInt("COD_UF"));
			
				c.setPessoa(p);
				c.setUf(uf);
				lista.add(c);		
			}
			return lista;
		}catch (SQLException e){
			e.printStackTrace();
			return lista;	

		}
	}
	public ArrayList<Cliente> buscarFornecedorPorNome(String nome){
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			Connection  con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM CLIENTE WHERE NOME LIKE ?");
			ps.setString(1, nome + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Cliente c = new Cliente();
				c.setCod_Cliente(rs.getInt("COD_CLIENTE"));
				c.setNome(rs.getString("NOME"));
				c.setEndereco(rs.getString("ENDERECO"));
				c.setBairro(rs.getString("BAIRRO"));
				c.setCidade(rs.getString("CIDADE"));
				c.setCep(rs.getString("CEP"));
				c.setCpf(rs.getString("CPF"));
				c.setRg(rs.getString("RG"));
				c.setTel_Cliente(rs.getString("TEL_CLIENTE"));
				c.setCel_Cliente(rs.getString("CEL_CLIENTE"));
				c.setEmail(rs.getString("EMAIL"));


				Pessoa p = new Pessoa();
				p.setCod_pessoa(rs.getInt("COD_PESSOA"));

				/*Uf uf = new Uf();
				uf.setCod_uf(rs.getInt(""));*/

				c.setPessoa(p);
				//c.setUf(uf);
				lista.add(c);		
			}

		} catch (SQLException e) {       	
			e.printStackTrace();
		}
		return lista;

	}

}