package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Perfil;

public class PerfilComboBoxModel implements ComboBoxModel {
		//classe  resp�nsavel por exibir os dados de um combobox
		
			//Lista de itens que ser�o exibidos
			private ArrayList<Perfil> dados;
			//Objeto curso que ser� selecionado
			private Perfil perfil;

			//Construtor que recebe um lista de curso como par�metro
			public PerfilComboBoxModel(ArrayList<Perfil>perfil){
				dados = perfil;

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

				return perfil;
			}

			@Override
			public void setSelectedItem(Object item) {
				perfil = (Perfil)item;

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

