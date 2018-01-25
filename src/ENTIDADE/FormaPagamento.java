package ENTIDADE;

public class FormaPagamento {
private int Codigo;
private String Descricao;

public int getCodigo() {
	return Codigo;
}
public void setCodigo(int codigo) {
	Codigo = codigo;
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
}
