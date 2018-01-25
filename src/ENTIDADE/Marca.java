package ENTIDADE;

public class Marca {

	private int cod_marca;
	private String descricao ;
	
	public int getCod_marca() {
		return cod_marca;
	}
	public void setCod_marca(int cod_marca) {
		this.cod_marca = cod_marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_marca;
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
		Marca other = (Marca) obj;
		if (cod_marca != other.cod_marca)
			return false;
		return true;
	}

}
