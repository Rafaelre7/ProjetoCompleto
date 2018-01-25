package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.Pessoa;

	public class PessoaComboBoxModel implements ComboBoxModel {
		//classe  respónsavel por exibir os dados de um combobox
		
			//Lista de itens que serão exibidos
			private ArrayList<Pessoa> dados;
			//Objeto curso que será selecionado
			private Pessoa pessoa;

			//Construtor que recebe um lista de curso como parâmetro
			public PessoaComboBoxModel(ArrayList<Pessoa>pessoa){
				dados = pessoa;

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

				return pessoa;
			}

			@Override
			public void setSelectedItem(Object item) {
				pessoa = (Pessoa)item;

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

