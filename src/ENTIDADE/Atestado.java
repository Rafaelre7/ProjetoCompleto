package ENTIDADE;

import java.sql.Date;

public class Atestado {
private int Cod_atestado;
private String local, modelo, Port_imetro, lacreRetidao, lacreColocado,cnpj, serie ;
private String inventario, observacao;
private Date dataEntada;

public String getLocal() {
	return local;
}
public void setLocal(String local) {
	this.local = local;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getPort_imetro() {
	return Port_imetro;
}
public void setPort_imetro(String port_imetro) {
	Port_imetro = port_imetro;
}
public String getLacreRetidao() {
	return lacreRetidao;
}
public void setLacreRetidao(String lacreRetidao) {
	this.lacreRetidao = lacreRetidao;
}
public String getLacreColocado() {
	return lacreColocado;
}
public void setLacreColocado(String lacreColocado) {
	this.lacreColocado = lacreColocado;
}
public String getCnpj() {
	return cnpj;
}
public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
}
public String getSerie() {
	return serie;
}
public void setSerie(String serie) {
	this.serie = serie;
}
public String getInventario() {
	return inventario;
}
public void setInventario(String inventario) {
	this.inventario = inventario;
}
public String getObservacao() {
	return observacao;
}
public void setObservacao(String observacao) {
	this.observacao = observacao;
}
public Date getDataEntada() {
	return dataEntada;
}
public void setDataEntada(Date dataEntada) {
	this.dataEntada = dataEntada;
}


}
