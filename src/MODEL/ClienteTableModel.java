package MODEL;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ENTIDADE.Cliente;


public class ClienteTableModel extends AbstractTableModel {

	private String[] colunas ={"Codigo","Nome","Cidade","Telefone"};
	private ArrayList<Cliente> dados ;

	public ClienteTableModel(ArrayList<Cliente> d){
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
			return dados.get(linha).getCod_Cliente();
		case 1:
			return dados.get(linha).getNome();
		case 2:
			return dados.get(linha).getCidade();
		case 3:
			return dados.get(linha).getTel_Cliente();
		};

		return null;

	}

	public Cliente getClientePorLinha(int linha) {
		return dados.get(linha);
	}
}

