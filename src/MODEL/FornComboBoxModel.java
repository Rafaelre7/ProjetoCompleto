package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Fornecedor;




	public class FornComboBoxModel implements ComboBoxModel {
		//classe  resp�nsavel por exibir os dados de um combobox
		
			//Lista de itens que ser�o exibidos
			private ArrayList<Fornecedor> dados;
			//Objeto curso que ser� selecionado
			private Fornecedor fornecedor;

			//Construtor que recebe um lista de curso como par�metro
			public FornComboBoxModel(ArrayList<Fornecedor>fornecedor){
				dados = fornecedor;

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

				return fornecedor;
			}

			@Override
			public void setSelectedItem(Object item) {
				fornecedor = (Fornecedor)item;

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

