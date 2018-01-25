package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Cliente;
import ENTIDADE.Produtos;

public class ProdutosComboBoxModel implements ComboBoxModel {

	//classe  respónsavel por exibir os dados de um combobox
	
		//Lista de itens que serão exibidos
		private ArrayList<Produtos> dados;
		//Objeto curso que será selecionado
		private Produtos produtos;

		//Construtor que recebe um lista de curso como parâmetro
		public ProdutosComboBoxModel(ArrayList<Produtos>p){
			dados = p;

		}

		@Override
		public Object getElementAt(int indice) {

			return dados.get(indice);
		}

		@Override
		public int getSize() {

			return dados.size();
		}

		@Override
		public Object getSelectedItem() {

			return produtos;
		}

		@Override
		public void setSelectedItem(Object item) {
			produtos = (Produtos)item;

		}
		@Override
		public void addListDataListener(ListDataListener arg0) {
			// TODO Auto-generated method stub

		}
		@Override
		public void removeListDataListener(ListDataListener arg0) {
			// TODO Auto-generated method stub
		}
	}