package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConexao() {
		try {
			
			//Nunca esqueça de colocar a lib com o driver de comunicação
			/* Usando sql server 1
			 String url =
			 "jdbc:sqlserver://localhost:49178;databaseName=virtualdc2014;user=java;password=java";
			*/
			
			/*Usando sql server 2	
			String url =
			// "jdbc:sqlserver://localhost:49178;databaseName=virtualdc2014;integratedSecurity=true";
			*/
			
			/*Usano H2 data base 
			// String url =
			// "jdbc:h2:~/ProjetoCompletoSystech;user=java;password=java;AUTO_SERVER=TRUE";
			*/
			
			
			String url = "jdbc:postgresql://localhost/ProjetoCompleto";
			String usuario = "postgres";
			String senha = "java";

			Connection minhaConexao = null;
			minhaConexao = DriverManager.getConnection(url, usuario, senha);

			return minhaConexao;

		} catch (SQLException erro) {
			System.out.println("ACONTECEU UM ERRO");
			erro.printStackTrace();

			return null;
		}
	}
}