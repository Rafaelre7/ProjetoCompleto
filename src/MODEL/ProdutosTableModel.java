
package MODEL;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ENTIDADE.Produtos;




public class ProdutosTableModel extends AbstractTableModel {
   
	private String[] colunas =  {"Código", "Descrição", "Fornecedor", "Valor_Compra","Valor_Venda"};
    private ArrayList<Produtos> dados = new ArrayList<Produtos>();
    
    public ProdutosTableModel(ArrayList<Produtos> dados){
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
			return dados.get(linha).getCod_produto();
		case 1:
			return dados.get(linha).getDescricao();
		case 2:
			return dados.get(linha).getFornecedor();
		case 3:
			return dados.get(linha).getValor_compra();
		case 4: 
			return dados.get(linha).getValor_venda();
		}
		return null;
	}
	 public Produtos getProdutoPorLinha(int linha) {
	        return dados.get(linha);
	    }
}

