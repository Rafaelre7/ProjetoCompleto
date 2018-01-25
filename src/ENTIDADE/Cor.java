package ENTIDADE;

public class Cor {
private int cod_cor ;
private String descricao;

public int getCod_cor() {
	return cod_cor;
}
public void setCod_cor(int cod_cor) {
	this.cod_cor = cod_cor;
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
	result = prime * result + cod_cor;
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
	Cor other = (Cor) obj;
	if (cod_cor != other.cod_cor)
		return false;
	return true;
}

}
