package MODEL;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import ENTIDADE.FormaPagamento;


public class FormaPagamentoComboBoxModel implements ComboBoxModel {
	//classe  respónsavel por exibir os dados de um combobox
	
		//Lista de itens que serão exibidos
		private ArrayList<FormaPagamento> dados;
		//Objeto curso que será selecionado
		private FormaPagamento formaPagamento;

		//Construtor que recebe um lista de curso como parâmetro
		public FormaPagamentoComboBoxModel(ArrayList<FormaPagamento>f){
			dados = f;

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

			return formaPagamento;
		}

		@Override
		public void setSelectedItem(Object item) {
			formaPagamento = (FormaPagamento)item;

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