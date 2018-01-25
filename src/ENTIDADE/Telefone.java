package ENTIDADE;

public class Telefone {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Telefone other = (Telefone) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	private int codigo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero_fone() {
		return numero_fone;
	}
	public void setNumero_fone(String numero_fone) {
		this.numero_fone = numero_fone;
	}
	public int getCod_aluno() {
		return cod_aluno;
	}
	public void setCod_aluno(int cod_aluno) {
		this.cod_aluno = cod_aluno;
	}
	private String numero_fone;
	private int cod_aluno;
	

}
