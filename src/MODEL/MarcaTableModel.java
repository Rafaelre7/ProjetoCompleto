package MODEL;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ENTIDADE.Cliente;
import ENTIDADE.Marca;



public class MarcaTableModel extends AbstractTableModel {

	private String[] colunas ={"Codigo","Descricao"};
	private ArrayList<Marca> dados ;

	public MarcaTableModel(ArrayList<Marca> m){
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
		return dados.get(linha).getCod_marca();
		case 1: 
			return dados.get(linha).getDescricao();		
		};

		return null;

	}

	public Marca getMarcaPorLinha(int linha) {
		return dados.get(linha);
	}
}