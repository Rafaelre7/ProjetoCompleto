package MODEL;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ENTIDADE.Itens;

public class ItensTableModel extends AbstractTableModel {
	
	private String[] colunas ={"Descrição","Valor Venda","Quantidade","Total"};
	private ArrayList<Itens> dados ;

	public ItensTableModel(ArrayList<Itens> i){
		dados = i;
		}
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	public int getColumnCount() {
		return colunas.length;
	}

	// retorna a quantidade de linhas para o JTable
	public int getRowCount() {
		return dados.size();
	}

	// retorna um valor para cada celula do JTable
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getProdutos().getDescricao();
		case 1:
			return dados.get(linha).getValor_venda();
		case 2:
			return dados.get(linha).getQuantidade();
		case 3:
			return dados.get(linha).getValor_total();
			
		};

		return null;

	}

	public Itens getItensPorLinha(int linha) {
		return dados.get(linha);
	}
}



