package MODEL;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ENTIDADE.Cliente;
import ENTIDADE.Cor;



public class CorTableModel extends AbstractTableModel {

	private String[] colunas ={"Codigo","Descricao"};
	private ArrayList<Cor> dados ;

	public CorTableModel(ArrayList<Cor> m){
		dados = m;
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
		return dados.get(linha).getCod_cor();
		case 1: 
			return dados.get(linha).getDescricao();		
		};

		return null;

	}

	public Cor getCorPorLinha(int linha) {
		return dados.get(linha);
	}
}