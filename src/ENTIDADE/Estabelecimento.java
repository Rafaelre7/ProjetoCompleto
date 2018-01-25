package ENTIDADE;

public class Estabelecimento {
	
	
	private int cod_estabelecimento;
	private String nome_estabelecimento, tel_estabelecimento, cnpj, cep, endereco, bairro, cidade, email, insc_es;
	
	
	public String getNome_estabelecimento() {
		return nome_estabelecimento;
	}
	public void setNome_estabelecimento(String nome_estabelecimento) {
		this.nome_estabelecimento = nome_estabelecimento;
	}
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
	
	public int getCod_estabelecimento() {
		return cod_estabelecimento;
	}
	public void setCod_estabelecimento(int cod_estabelecimento) {
		this.cod_estabelecimento = cod_estabelecimento;
	}
	
	public String getTel_estabelecimento() {
		return tel_estabelecimento;
	}
	public void setTel_estabelecimento(String tel_estabelecimento) {
		this.tel_estabelecimento = tel_estabelecimento;
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
		return nome_estabelecimento;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_estabelecimento;
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
		Estabelecimento other = (Estabelecimento) obj;
		if (cod_estabelecimento != other.cod_estabelecimento)
			return false;
		return true;
	}

}
