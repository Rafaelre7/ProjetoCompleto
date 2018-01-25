package ENTIDADE;

public class Produtos {
	private int cod_produto;
	private String descricao;
	private Fornecedor fornecedor;
	private int valor_compra;
	private int valor_venda;
	private String cod_barras;
	public String getCod_barras() {
		return cod_barras;
	}
	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(int valor_compra) {
		this.valor_compra = valor_compra;
	}
	public int getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(int valor_venda) {
		this.valor_venda = valor_venda;
	}
	public String toString(){
		return descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_produto;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		if (cod_produto != other.cod_produto)
			return false;
		return true;
	}

}
