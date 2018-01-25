package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Estabelecimento;



public class EstabelecimentoComboBoxModel implements ComboBoxModel {

	//classe  resp�nsavel por exibir os dados de um combobox
	
		//Lista de itens que ser�o exibidos
		private ArrayList<Estabelecimento> dados;
		//Objeto curso que ser� selecionado
		private Estabelecimento  estabelecimento;

		//Construtor que recebe um lista de curso como par�metro
		public EstabelecimentoComboBoxModel(ArrayList<Estabelecimento>p){
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

			return estabelecimento;
		}

		@Override
		public void setSelectedItem(Object item) {
			estabelecimento = (Estabelecimento)item;

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