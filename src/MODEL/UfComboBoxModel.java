package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Cliente;
import ENTIDADE.Uf;


	public class UfComboBoxModel implements ComboBoxModel {
		//classe  resp�nsavel por exibir os dados de um combobox
		
			//Lista de itens que ser�o exibidos
			private ArrayList<Uf> dados;
			//Objeto curso que ser� selecionado
			private Uf uf;

			//Construtor que recebe um lista de curso como par�metro
			public UfComboBoxModel(ArrayList<Uf>uf){
				dados = uf;

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

				return uf;
			}

			@Override
			public void setSelectedItem(Object item) {
				uf = (Uf)item;

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
