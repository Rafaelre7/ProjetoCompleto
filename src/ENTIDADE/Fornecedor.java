package ENTIDADE;

public class Fornecedor {
	
	
	private int cod_fornecedor;
	private String nome_fornecedor, tel_fornecedor, cnpj, cep, endereco, bairro, cidade, email, insc_es;
	
	
	private Uf uf;
	
	

	
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public int getCod_fornecedor() {
		return cod_fornecedor;
	}
	public void setCod_fornecedor(int cod_fornecedor) {
		this.cod_fornecedor = cod_fornecedor;
	}
	public String getNome_fornecedor() {
		return nome_fornecedor;
	}
	public void setNome_fornecedor(String nome_fornecedor) {
		this.nome_fornecedor = nome_fornecedor;
	}
	public String getTel_fornecedor() {
		return tel_fornecedor;
	}
	public void setTel_fornecedor(String tel_fornecedor) {
		this.tel_fornecedor = tel_fornecedor;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInsc_es() {
		return insc_es;
	}
	public void setInsc_es(String insc_es) {
		this.insc_es = insc_es;
	}
	@Override
	public String toString() {
		return nome_fornecedor;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_fornecedor;
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
		Fornecedor other = (Fornecedor) obj;
		if (cod_fornecedor != other.cod_fornecedor)
			return false;
		return true;
	}

}
