package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Equipamento;
import ENTIDADE.Cor;


	public class CorComboBoxModel implements ComboBoxModel {
		//classe  resp�nsavel por exibir os dados de um combobox
		
			//Lista de itens que ser�o exibidos
			private ArrayList<Cor> dados;
			//Objeto curso que ser� selecionado
			private Cor cor;

			//Construtor que recebe um lista de curso como par�metro
			public CorComboBoxModel(ArrayList<Cor>marca){
				dados = marca;

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

				return cor;
			}

			@Override
			public void setSelectedItem(Object item) {
				cor = (Cor)item;

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
