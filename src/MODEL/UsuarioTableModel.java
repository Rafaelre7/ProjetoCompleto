package MODEL;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ENTIDADE.Cliente;
import ENTIDADE.Usuario;


public class UsuarioTableModel extends AbstractTableModel {

	private String[] colunas ={"Codigo","Usuario","Senha"};
	private ArrayList<Usuario> dados ;

	public UsuarioTableModel(ArrayList<Usuario> d){
		dados = d;
	}
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	public int getColumnCount() {
		return colunas.length;
	}

	// retorna a quantidade de linhas para o JTable
	@Override
	public int getRowCount() {
		return dados.size();
	}

	// retorna um valor para cada celula do JTable
	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
		return dados.get(linha).getCod_usuario();
		case 1: 
			return dados.get(linha).getNome_usuario();
		case 2:
			return dados.get(linha).getSenha();
		
		};

		return null;

	}

	public Usuario getUsuarioPorLinha(int linha) {
		return dados.get(linha);
	}
}