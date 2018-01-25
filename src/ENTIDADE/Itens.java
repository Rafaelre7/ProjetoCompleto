package ENTIDADE;

public class Itens {

    private int cod_venda, cod_produto, quantidade;
    private Produtos produtos;
    private double valor_venda;
    private double valor_total;
    private String Descricao;
    private double total;
    
	
    
    public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public int getCod_venda() {
		return cod_venda;
	}
	public void setCod_venda(int cod_venda) {
		this.cod_venda = cod_venda;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}


	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}
    
}
