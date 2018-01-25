package ENTIDADE;

public class Uf {
	private int Cod_uf;
	private String Descricao;

	public int getCod_uf() {
		return Cod_uf;
	}
	public void setCod_uf(int cod_uf) {
		Cod_uf = cod_uf;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public String toString(){
		return Descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Cod_uf;
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
		Uf other = (Uf) obj;
		if (Cod_uf != other.Cod_uf)
			return false;
		return true;
	}

}

