package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Cliente;
public class ClienteComboBoxModel implements ComboBoxModel {
	//classe  resp�nsavel por exibir os dados de um combobox
	
		//Lista de itens que ser�o exibidos
		private ArrayList<Cliente> dados;
		//Objeto curso que ser� selecionado
		private Cliente cliente;

		//Construtor que recebe um lista de curso como par�metro
		public ClienteComboBoxModel(ArrayList<Cliente>c){
			dados = c;

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

			return cliente;
		}

		@Override
		public void setSelectedItem(Object item) {
			cliente = (Cliente)item;

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