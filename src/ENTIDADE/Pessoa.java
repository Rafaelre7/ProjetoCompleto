package ENTIDADE;

public class Pessoa {
	
	private int cod_pessoa;
	private String descricao;
	
	
	public int getCod_pessoa() {
		return cod_pessoa;
	}
	public void setCod_pessoa(int cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString(){
		return descricao;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_pessoa;
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
		Pessoa other = (Pessoa) obj;
		if (cod_pessoa != other.cod_pessoa)
			return false;
		return true;
	}
}
