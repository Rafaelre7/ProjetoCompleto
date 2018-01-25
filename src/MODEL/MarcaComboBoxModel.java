package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Equipamento;
import ENTIDADE.Marca;


	public class MarcaComboBoxModel implements ComboBoxModel {
		//classe  respónsavel por exibir os dados de um combobox
		
			//Lista de itens que serão exibidos
			private ArrayList<Marca> dados;
			//Objeto curso que será selecionado
			private Marca marca;

			//Construtor que recebe um lista de curso como parâmetro
			public MarcaComboBoxModel(ArrayList<Marca>marca){
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

				return marca;
			}

			@Override
			public void setSelectedItem(Object item) {
				marca = (Marca)item;

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
