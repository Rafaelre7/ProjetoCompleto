package ENTIDADE;

public class Modelo {
private  int cod_modelo ;
private String descricao;

public int getCod_modelo() {
	return cod_modelo;
}
public void setCod_modelo(int cod_modelo) {
	this.cod_modelo = cod_modelo;
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
	result = prime * result + cod_modelo;
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
	Modelo other = (Modelo) obj;
	if (cod_modelo != other.cod_modelo)
		return false;
	return true;
}

}
