package ENTIDADE;

public class Setor {
	private int Cod_setor;
	private String Nome_setor;
	public int getCod_setor() {
		return Cod_setor;
	}
	public void setCod_setor(int cod_setor) {
		Cod_setor = cod_setor;
	}
	public String getNome_setor() {
		return Nome_setor;
	}
	public void setNome_setor(String nome_setor) {
		Nome_setor = nome_setor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Cod_setor;
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
		Setor other = (Setor) obj;
		if (Cod_setor != other.Cod_setor)
			return false;
		return true;
	}

}

