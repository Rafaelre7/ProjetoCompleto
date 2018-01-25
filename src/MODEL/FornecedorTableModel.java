
package MODEL;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ENTIDADE.Fornecedor;


public class FornecedorTableModel extends AbstractTableModel {
   
	private String[] colunas =  {"Código", "Nome", "Telefone", "CNPJ"};
    private ArrayList<Fornecedor> dados = new ArrayList<Fornecedor>();
    
    public FornecedorTableModel(ArrayList<Fornecedor> dados){
    	this.dados = dados;
    }
    
    public String getColumnName(int coluna){
		return colunas[coluna];
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return  dados.size();
	}
	
	public Object getValueAt(int linha, int coluna){
		
		switch(coluna){
		case 0:
			return dados.get(linha).getCod_fornecedor();
		case 1:
			return dados.get(linha).getNome_fornecedor();
		case 2:
			return dados.get(linha).getTel_fornecedor();
		case 3:
			return dados.get(linha).getCnpj();
		}
		return null;
	}
	 public Fornecedor getFornecedorPorLinha(int linha) {
	        return dados.get(linha);
	    }
}

