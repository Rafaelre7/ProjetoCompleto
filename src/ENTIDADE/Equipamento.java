package ENTIDADE;
import java.util.Date;

public class Equipamento {
private int cod_equipamento, cod_modelo, cod_marca, cod_cor;
private Modelo modelo;
private Cor cor;
private Marca marca;
private String descricao, serie, quantidade ,observacoes, data_compra;


public int getCod_equipamento() {
	return cod_equipamento;
}
public void setCod_equipamento(int cod_equipamento) {
	this.cod_equipamento = cod_equipamento;
}
public int getCod_modelo() {
	return cod_modelo;
}
public void setCod_modelo(int cod_modelo) {
	this.cod_modelo = cod_modelo;
}
public int getCod_marca() {
	return cod_marca;
}
public void setCod_marca(int cod_marca) {
	this.cod_marca = cod_marca;
}
public int getCod_cor() {
	return cod_cor;
}
public void setCod_cor(int cod_cor) {
	this.cod_cor = cod_cor;
}

public String getData_compra() {
	return data_compra;
}
public void setData_compra(String data_compra) {
	this.data_compra = data_compra;
}
public String getQuantidade() {
	return quantidade;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public String getSerie() {
	return serie;
}
public void setSerie(String serie) {
	this.serie = serie;
}
public String getquantidade() {
	return quantidade;
}
public void setQuantidade(String quantidade) {
	this.quantidade = quantidade;
}
public String getObservacoes() {
	return observacoes;
}
public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
}

}


