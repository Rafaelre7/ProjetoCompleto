package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Equipamento;
import ENTIDADE.Modelo;


	public class ModeloComboBoxModel implements ComboBoxModel {
		//classe  respónsavel por exibir os dados de um combobox
		
			//Lista de itens que serão exibidos
			private ArrayList<Modelo> dados;
			//Objeto curso que será selecionado
			private Modelo modelo;

			//Construtor que recebe um lista de curso como parâmetro
			public ModeloComboBoxModel(ArrayList<Modelo>modelo){
				dados = modelo;

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

				return modelo;
			}

			@Override
			public void setSelectedItem(Object item) {
				modelo = (Modelo)item;

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
