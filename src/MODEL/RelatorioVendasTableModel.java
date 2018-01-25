package MODEL;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import ENTIDADE.Venda;



	public class RelatorioVendasTableModel extends AbstractTableModel {

		private String[] colunas ={"Codigo","Data Compra", "Cliente","Usuario","Total"};
		private ArrayList<Venda> dados ;

		public RelatorioVendasTableModel(ArrayList<Venda> v){
			dados = v;
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
				return dados.get(linha).getCodigo();
			case 1:
				return dados.get(linha).getData_Compra();
			case 2:
				return dados.get(linha).getCliente();
			case 3:
				return dados.get(linha).getUsuario();
			case 4: 
			return dados.get(linha).getTotal();
			};

			return null;

		}

		public Venda getRelatorioVendasPorLinha(int linha) {
			return dados.get(linha);
		}
	}


