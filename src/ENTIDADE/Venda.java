package ENTIDADE;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
private int Codigo;
private Date Data_Compra;
private Cliente Cliente;
private double Desconto;
private double Total;
private Usuario usuario;
private FormaPagamento formaPagamento;
private ArrayList<Itens>intensList = new ArrayList<Itens>();


public ArrayList<Itens> getIntensList() {
	return intensList;
}
public void setIntensList(ArrayList<Itens> intensList) {
	this.intensList = intensList;
}
public Cliente getCliente() {
	return Cliente;
}
public void setCliente(Cliente cliente) {
	Cliente = cliente;
}


public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public FormaPagamento getFormaPagamento() {
	return formaPagamento;
}
public void setFormaPagamento(FormaPagamento formaPagamento) {
	this.formaPagamento = formaPagamento;
}
public int getCodigo() {
	return Codigo;
}
public void setCodigo(int codigo) {
	Codigo = codigo;
}

public Date getData_Compra() {
	return Data_Compra;
}
public void setData_Compra(Date data_Compra) {
	Data_Compra = data_Compra;
}


public double getDesconto() {
	return Desconto;
}
public void setDesconto(double desconto) {
	Desconto = desconto;
}
public double getTotal() {
	return Total;
}
public void setTotal(double total) {
	Total = total;
}


}
