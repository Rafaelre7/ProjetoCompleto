package ENTIDADE;

public class Perfil {

	private int cod_perfil;
	private String nome_perfil;
	
	
	public int getCod_perfil() {
		return cod_perfil;
	}
	public void setCod_perfil(int cod_perfil) {
		this.cod_perfil = cod_perfil;
	}
	public String getNome_perfil() {
		return nome_perfil;
	}
	public void setNome_perfil(String nome_perfil) {
		this.nome_perfil = nome_perfil;
	}
	//Converte em string o combo box
	public String toString(){
		return nome_perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_perfil;
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
		Perfil other = (Perfil) obj;
		if (cod_perfil != other.cod_perfil)
			return false;
		return true;
	}
}
