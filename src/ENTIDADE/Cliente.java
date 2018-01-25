package ENTIDADE;
public class Cliente {
	
	private int Cod_Cliente;
	private String Nome;
	private String Endereco;
	private String Bairro;
	private String Cidade;
	private String Cod_uf;
	private String Tel_Cliente;
	private String Cel_Cliente;
	private Pessoa pessoa;
	private String email;
	private String cpf;
	private String rg;
	private String Cep;
	private Uf uf;
    
	public String getCel_Cliente() {
		return Cel_Cliente;
	}
	public void setCel_Cliente(String cel_Cliente) {
		Cel_Cliente = cel_Cliente;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public int getCod_Cliente() {
		return Cod_Cliente;
	}
	public void setCod_Cliente(int cod_Cliente) {
		Cod_Cliente = cod_Cliente;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getTel_Cliente() {
		return Tel_Cliente;
	}
	public void setTel_Cliente(String tel_Cliente) {
		Tel_Cliente = tel_Cliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getCod_uf() {
		return Cod_uf;
	}
	public void setCod_uf(String cod_uf) {
		Cod_uf = cod_uf;
	}
	public String toString(){
	return Nome;
    }
}
